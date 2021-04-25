<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<nav>
    <a href="index.jsp">Main</a>
    <%if(session.getAttribute("username")!=null){ %>
    <a href="logout">Log out</a>
    <%}
    else{%>
    <a href="login.jsp">LogIn</a>
    <a href="Registration.jsp">Register</a>
    <%}%>


</nav>