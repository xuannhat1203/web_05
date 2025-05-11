package com.baitap.session05.Controller;

import com.baitap.session05.Modal.Contact;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "ContactController", value = "/ContactController")
public class ContactController extends HttpServlet {
    public static List<Contact> contactList = new ArrayList<>();

    public void init() {
        contactList.add(new Contact(1, "John", "Doe", "john.doe@example.com", "123-456-7890"));
        contactList.add(new Contact(2, "Jane", "Smith", "jane.smith@example.com", "987-654-3210"));
        contactList.add(new Contact(3, "Alice", "Nguyen", "alice.nguyen@example.com", "098-765-4321"));
        contactList.add(new Contact(4, "Bob", "Tran", "bob.tran@example.com", "012-345-6789"));
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String action = request.getParameter("action");

        if (action != null) {
            if (action.equals("add")) {
                request.getRequestDispatcher("jsp/addContact.jsp").forward(request, response);
                return;
            } else if (action.equals("edit")) {
                int id = Integer.parseInt(request.getParameter("id"));
                Optional<Contact> contactOpt = contactList.stream().filter(c -> c.getId() == id).findFirst();
                if (contactOpt.isPresent()) {
                    request.setAttribute("contact", contactOpt.get());
                    request.getRequestDispatcher("jsp/editContact.jsp").forward(request, response);
                    return;
                }
            }
        }

        request.setAttribute("contacts", contactList);
        request.getRequestDispatcher("jsp/contactList.jsp").forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String action = request.getParameter("action");

        if (action != null) {
            if (action.equals("create")) {
                createContact(request);
            } else if (action.equals("update")) {
                updateContact(request);
            } else if (action.equals("delete")) {
                deleteContact(request);
            }
        }

        request.setAttribute("contacts", contactList);
        request.getRequestDispatcher("jsp/contactList.jsp").forward(request, response);
    }

    private void createContact(HttpServletRequest request) {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        int id = contactList.size() + 1;
        Contact contact = new Contact(id, firstName, lastName, email, phone);
        contactList.add(contact);
    }

    private void updateContact(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");

        for (Contact contact : contactList) {
            if (contact.getId() == id) {
                contact.setFirstName(firstName);
                contact.setLastName(lastName);
                contact.setEmail(email);
                contact.setPhone(phone);
                break;
            }
        }
    }

    private void deleteContact(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        contactList.removeIf(contact -> contact.getId() == id);
    }
}
