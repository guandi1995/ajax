package com.ajax.controller;

import com.ajax.service.StudentServiceImpl;
import com.alibaba.fastjson.JSON;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

/**
 * 异步查询所有student信息
 */
@WebServlet(name = "StudentServlet", value = "/usr/fetchStudent")
public class StudentFetchServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        StudentServiceImpl studentService = new StudentServiceImpl();
        List<Map> maps = studentService.fetchStudent();
        //异步走response响应,不需要跳转页面
        PrintWriter writer = response.getWriter();
        writer.println(JSON.toJSONString(maps));
    }
}
