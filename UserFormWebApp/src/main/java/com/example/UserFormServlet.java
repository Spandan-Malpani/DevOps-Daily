package com.example;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.*;
import java.util.*;

public class UserFormServlet extends HttpServlet {
    private final List<User> users = new ArrayList<>();

    public static class User {
        String name;
        String gender;

        public User(String name, String gender) {
            this.name = name;
            this.gender = gender;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String name = req.getParameter("name");
        String gender = req.getParameter("gender");

        if (name != null && !name.isEmpty()) {
            users.add(new User(name, gender));
        }

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        out.println("<h2>Submitted Users</h2>");
        for (User user : users) {
            out.println("<p>Name: " + user.name + ", Gender: " + user.gender + "</p>");
        }
        out.println("<a href=\"index.jsp\">Back</a>");
    }
}