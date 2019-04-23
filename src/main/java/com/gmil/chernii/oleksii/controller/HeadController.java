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
import java.util.List;

/**
 * Created by Space on 23.04.2019.
 */
@WebServlet("/list")
public class HeadController extends HttpServlet {
    private static final String USERLIST = "userlist";
    private static final String INDEX = "index.jsp";
    private UserDao userDao = UserDaoImpl.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<User> userList = userDao.getAllUsers();
        req.setAttribute(USERLIST, userList);
        req.getRequestDispatcher(INDEX).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
