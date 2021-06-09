package com.ajax.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * session代码演示
 * 创建和存储session
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
            //登陆成功后，重定向到/usr/fetchStudent
            response.sendRedirect("/WEB03/usr/fetchStudent");
        }
        else
            response.sendRedirect("/WEB03/view/error.html");
    }
}
