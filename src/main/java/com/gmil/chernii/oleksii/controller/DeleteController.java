package com.gmil.chernii.oleksii.controller;

import com.gmil.chernii.oleksii.dao.UserDao;
import com.gmil.chernii.oleksii.dao.UserDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Space on 23.04.2019.
 */
@WebServlet("/delete")
public class DeleteController extends HttpServlet {
    private UserDao userDao = UserDaoImpl.getInstance();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userId = req.getParameter("id");
        if (userId == null) {
            req.getRequestDispatcher("/list").forward(req, resp);
        } else {
            Long id = Long.valueOf(userId);
            userDao.deleteById(id);
            resp.sendRedirect(req.getContextPath() + "/list");
        }
    }
}
