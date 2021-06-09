package com.ajax.controller;

import com.ajax.pojo.Message;
import com.ajax.pojo.User;
import com.ajax.service.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "UserServlet", value = "/usr/login")
public class UserLoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        UserServiceImpl userService = new UserServiceImpl();
        Message message = userService.fetchUser(user);
        //如果登陆成功
        if (message.isStatus()){
            HttpSession session = request.getSession();
            session.setAttribute("accountInfo", message.getObj());
        }
        //异步的回参（如果是text的dataType）
        PrintWriter writer = response.getWriter();
        writer.println(message.getMessage());
    }
}
