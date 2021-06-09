package com.ajax.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * ajax异步登陆
 */
@WebServlet(name = "LoginServlet", value = "/usr/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println(username + "--" + password);
        if (username.equals("admin") && password.equals("123456")) {
            //获取session，将"admin"存入session域中
            HttpSession session = request.getSession();
            session.setAttribute("accountInfo", "admin");
            //异步直接走响应，不需要重定向或转发
            PrintWriter writer = response.getWriter();
            writer.println("success");
        }
        else
            response.sendRedirect("/WEB03/view/error.html");
    }
}
