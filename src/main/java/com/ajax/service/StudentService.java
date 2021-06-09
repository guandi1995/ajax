package com.ajax.service;

import com.ajax.pojo.Message;
import com.ajax.pojo.Student;

import java.util.List;
import java.util.Map;

public interface StudentService {
    List<Map> fetchStudent();
    Map fetchStudentById(String id);
    Message insertStudent(Student student);
    Message deleteStudent(String id);
    Message updateStudent(Student student);
}
