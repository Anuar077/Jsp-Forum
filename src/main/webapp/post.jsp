<%@ page import="com.example.Jsp_Forum.beans.Post" %>
<%@ page import="com.example.Jsp_Forum.dbConnection.PostConnection" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.Jsp_Forum.beans.Comment" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Post post = (Post) request.getAttribute("post");
    int likes = (int) request.getAttribute("likes");
    int dislikes = (int) request.getAttribute("dislikes");
%>
<html>
<head>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="style.css">
        <title><%=post.getTitle()%></title>
    </head>
</head>
<%@ include file="header.jsp" %>
<body>
<div class="post">
    <h4><%=post.getUsername()%></h4>
    <h3><%=post.getTitle()%></h3>
    <p><%=post.getpContent()%></p>
    <p><span><%=likes%> likes</span>/<span><%=dislikes%> dislikes</span></p>
    <%
        List<Comment> comments = (List<Comment>) request.getAttribute("comments");
        if(comments!=null){
            for(Comment comment : comments){
                int clikes = PostConnection.getCommentLikes(comment.getCommentid());
                int cdislikes = PostConnection.getCommentDislikes(comment.getCommentid());
    %>
    <div class="comment">
        <h4><%=comment.getUsername()%></h4>
        <p><%=comment.getContent()%></p>
        <p><span><%=clikes%> likes</span>/<span><%=cdislikes%> dislikes</span></p>
    </div>
    <%
            }
        }
    %>
    <%
        if(session.getAttribute("username")!=null){
    %>
    <form action="/writeComment" method="POST">
        <textarea name="content"></textarea>
        <input type="hidden" name="pId" value="<%=post.getPostId()%>">
        <button>Write</button>
    </form>
    <%
        if(session.getAttribute("username").equals(post.getUsername())){
    %>
    <button><a href="editPost.jsp?pId=<%=post.getPostId()%>">Edit</a></button>
    <%
            }
        }
    %>
</div>
</body>
</html>
