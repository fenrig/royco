<%-- 
    Document   : logout
    Created on : Nov 18, 2015, 7:01:27 PM
    Author     : Roy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/style.css" rel="stylesheet" type="text/css">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            session.invalidate();
        %>
        <%@ include file="WEB-INF/jspf/header.jspf" %>
        <h1>Je bent nu uitgelogd</h1>
        <br />
        <a href="index.jsp">Ga terug naar hoofdpagina</a>
    </body>
</html>
