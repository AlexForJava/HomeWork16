package com.gmil.chernii.oleksii.controller;

import com.gmil.chernii.oleksii.dao.UserDao;
import com.gmil.chernii.oleksii.dao.UserDaoImpl;
import com.gmil.chernii.oleksii.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Space on 23.04.2019.
 */
@WebServlet("/create")
public class CreateController extends HttpServlet {
    private UserDao userDao = UserDaoImpl.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/list").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userId = req.getParameter("id");
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        Integer age = Integer.valueOf(req.getParameter("age"));
        User user = new User()
                .setLogin(login)
                .setPassword(password)
                .setAge(age);
        if (userId == null) {
            userDao.insert(user);
        } else {
            user.setId(Long.valueOf(userId));
            userDao.update(user);
        }
        resp.sendRedirect(req.getContextPath() + "/list");
    }
}
