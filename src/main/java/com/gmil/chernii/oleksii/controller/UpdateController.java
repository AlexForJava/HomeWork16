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
@WebServlet("/update")
public class UpdateController extends HttpServlet {
    private UserDao userDao = UserDaoImpl.getInstance();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userId = req.getParameter("id");
        if (userId == null) {
            req.getRequestDispatcher("/list").forward(req, resp);
        } else {
            Long id = Long.valueOf(userId);
            User user = userDao.getById(id);
            req.setAttribute("user", user);
            req.getRequestDispatcher("/list").forward(req, resp);
        }
    }
}
