package com.baitap.session05.Service;

import com.baitap.session05.Dao.StudentDaoImp;
import com.baitap.session05.Dao.StudentInterface;
import com.baitap.session05.Modal.Student;

import java.util.List;

public class StudentServiceImp implements StudentService {
    public final StudentInterface studentDao;
    public StudentServiceImp() {
        studentDao = new StudentDaoImp();
    }

    @Override
    public List<Student> getStudentsByPage(int page,int size) {
        return studentDao.getStudentsByPage(page,size);
    }

    @Override
    public boolean updateStudent(Student student) {
        return studentDao.updateStudent(student);
    }

    @Override
    public boolean deleteStudent(int id) {
        return studentDao.deleteStudent(id);
    }

    @Override
    public int getTotalStudentCount() {
        return studentDao.getTotalStudentCount();
    }
}
