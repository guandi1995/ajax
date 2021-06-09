package com.ajax.controller;

import com.CRUD.pojo.Message;
import com.CRUD.service.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * delete student by id
 * 删除student的row后，转发到/usr/fetchStudent刷新studentlist
 */
@WebServlet(name = "StudentDeleteServlet", value = "/usr/deleteStudent")
public class StudentDeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String stuid = request.getParameter("stuid");
        StudentServiceImpl studentService = new StudentServiceImpl();
        Message message = studentService.deleteStudent(stuid);
        request.setAttribute("message", message);
        request.getRequestDispatcher("/usr/fetchStudent").forward(request, response);
    }
}
