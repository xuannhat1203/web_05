package com.baitap.session05.Dao;

import com.baitap.session05.Modal.Student;

import java.util.List;

public interface StudentInterface {
    List<Student> getStudentsByPage(int page,int size);
    boolean updateStudent(Student student);
    boolean deleteStudent(int id);
    int getTotalStudentCount();
}
