package com.example.Jsp_Forum.servlets;

import com.example.Jsp_Forum.beans.Comment;
import com.example.Jsp_Forum.dbConnection.DBConnection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/writeComment")
public class CommentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username=(String) request.getSession(false).getAttribute("username");

        Comment comment = new Comment();
        comment.setContent(request.getParameter("content"));
        comment.setUsername(username);
        int pId=Integer.parseInt(request.getParameter("pId"));
        comment.setpId(pId);
        int result = DBConnection.createComment(comment);

        response.sendRedirect("/post?pId="+pId);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
