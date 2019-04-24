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

@WebServlet("/create")
public class CreateController extends HttpServlet {
    private static final String LIST = "/list";
    private static final String ID = "id";
    private static final String LOGIN = "login";
    private static final String PASSWORD = "password";
    private static final String AGE = "age";

    private UserDao userDao = UserDaoImpl.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(LIST).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userId = req.getParameter(ID);
        String login = req.getParameter(LOGIN);
        String password = req.getParameter(PASSWORD);
        Integer age = Integer.valueOf(req.getParameter(AGE));
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
        resp.sendRedirect(req.getContextPath() + LIST);
    }
}
