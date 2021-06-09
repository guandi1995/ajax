package com.ajax.service;

import com.ajax.dao.StudentDao;
import com.ajax.dao.StudentDaoImpl;
import com.ajax.pojo.Message;
import com.ajax.pojo.Student;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * @author Di Guan on 6/5/2021 11:26 PM
 */

public class StudentServiceImpl implements StudentService{
    private StudentDao studentDao = new StudentDaoImpl();

    @Override
    public List<Map> fetchStudent() {
        return studentDao.fetchStudent();
    }

    @Override
    public Map fetchStudentById(String id) {
        List<Map> maps = studentDao.fetchStudentById(id);
        if (maps!=null && maps.size()>0)
            return maps.get(0);
        return null;
    }

    @Override
    public Message insertStudent(Student student) {
        try {
            studentDao.insertStudent(student);
            return new Message("insert successfully", true);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return new Message("failed to insert", false);
        }
    }

    @Override
    public Message deleteStudent(String id) {
        try {
            studentDao.deleteStudent(id);
            return new Message("delete successfully", true);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return new Message("fail to delete", false);
        }
    }

    @Override
    public Message updateStudent(Student student) {
        try {
            studentDao.updateStudent(student);
            return new Message("update successfully", true);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return new Message("fail to update", false);
        }
    }
}
