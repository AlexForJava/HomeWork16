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

@WebServlet("/update")
public class UpdateController extends HttpServlet {
    private static final String LIST = "/list";
    private static final String ID = "id";
    private static final String USER = "user";
    private UserDao userDao = UserDaoImpl.getInstance();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userId = req.getParameter(ID);
        if (userId == null) {
            req.getRequestDispatcher(LIST).forward(req, resp);
        } else {
            Long id = Long.valueOf(userId);
            User user = userDao.getById(id).get();
            req.setAttribute(USER, user);
            req.getRequestDispatcher(LIST).forward(req, resp);
        }
    }
}
