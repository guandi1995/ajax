package com.ajax.controller;

import com.ajax.service.MajorServiceImple;
import com.alibaba.fastjson.JSON;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

@WebServlet(name = "MajorServlet", value = "/usr/fetchMajor")
public class MajorServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        MajorServiceImple majorService = new MajorServiceImple();
        List<Map> maps = majorService.fetchMajor();
        PrintWriter writer = response.getWriter();
        writer.println(JSON.toJSONString(maps));

    }
}
