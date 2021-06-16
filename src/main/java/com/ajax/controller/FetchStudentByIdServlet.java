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
import java.util.Map;

/**
 * update修改的业务
 * 查询student根据id
 * 接受前台的parameter stuid
 * 根据id查询student的信息，并回显到/view/studentUpdate.jsp页面中
 */
@WebServlet(name = "FetchStudentByIdServlet", value = "/usr/fetchStudentById")
public class FetchStudentByIdServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String stuid = request.getParameter("stuid");
        StudentServiceImpl studentService = new StudentServiceImpl();
        Map map = studentService.fetchStudentById(stuid);
        //将map结合以json的格式返回前台
        PrintWriter writer = response.getWriter();
        writer.println(JSON.toJSONString(map));
    }
}
