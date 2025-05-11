package com.baitap.session05.Dao;

import com.baitap.session05.Modal.Student;
import com.baitap.session05.Utils.ConnectionDB;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoImp implements StudentInterface {
    @Override
    public List<Student> getStudentsByPage(int page,int size) {
        Connection conn = null;
        CallableStatement cs = null;
        List<Student> students = new ArrayList<Student>();
        try {
            conn = ConnectionDB.openConnection();
            cs = conn.prepareCall("{call get_student_by_page(?,?)}");
            page = (page - 1) * size;
            cs.setInt(1, page);
            cs.setInt(2, size);
            ResultSet rs = cs.executeQuery();
            while (rs.next()) {
                Student s = new Student();
                s.setId(rs.getInt("id"));
                s.setName(rs.getString("name"));
                s.setAge(rs.getInt("age"));
                s.setAddress(rs.getString("address"));
                students.add(s);
            }
            return students;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean updateStudent(Student student) {
        Connection conn = null;
        CallableStatement cs = null;
        try {
            conn = ConnectionDB.openConnection();
            cs = conn.prepareCall("{call update_student_by_id(?,?,?,?)}");
            cs.setInt(1, student.getId());
            cs.setString(2, student.getName());
            cs.setInt(3, student.getAge());
            cs.setString(4, student.getAddress());
            int rs = cs.executeUpdate();
            return rs > 0;
        } catch (Exception e) {
            e.fillInStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteStudent(int id) {
        Connection conn = null;
        CallableStatement cs = null;
        try {
            conn = ConnectionDB.openConnection();
            cs = conn.prepareCall("{call delete_student_by_id(?)}");
            cs.setInt(1, id);
            int rs = cs.executeUpdate();
            return rs > 0;
        } catch (Exception e) {
            e.fillInStackTrace();
        }
        return false;
    }

    @Override
    public int getTotalStudentCount() {
        Connection conn = null;
        CallableStatement cs = null;
        ResultSet rs = null;
        int count = 0;
        try {
            conn = ConnectionDB.openConnection();
            cs = conn.prepareCall("{call get_all_student()}");
            rs = cs.executeQuery();
            if (rs.next()) {
                count = rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (cs != null) cs.close();
                if (conn != null) conn.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return count;
    }

}
