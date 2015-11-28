<%-- 
    Document   : loginError
    Created on : Nov 17, 2015, 7:27:05 PM
    Author     : Roy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="stylesheets/general.css">
        <link rel="icon" type="image/png" href="images/error.png">
        <title>JSP Page</title>
    </head>
    <body>
        <%@ include file="WEB-INF/jspf/header.jspf" %>
        <h1>Error!</h1>
        <p>De ingevoerde gegevens zijn incorrect</p>
        <a href="login.jsp">Probeer nog eens</a>
    </body>
</html>
