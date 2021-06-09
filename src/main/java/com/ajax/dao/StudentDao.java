package com.ajax.dao;

import com.ajax.pojo.Student;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface StudentDao {
    List<Map> fetchStudent();
    List<Map> fetchStudentById(String id);
    int insertStudent(Student student) throws SQLException;
    int deleteStudent(String id) throws SQLException;
    int updateStudent(Student student) throws SQLException;
}
