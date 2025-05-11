package com.baitap.session05.Service;

import com.baitap.session05.Modal.Student;

import java.util.List;

public interface StudentService {
    List<Student> getStudentsByPage(int page,int size);
    boolean updateStudent(Student student);
    boolean deleteStudent(int id);
    int getTotalStudentCount();
}
