<%-- 
    Document   : filiaalRekeningen
    Created on : 5-dec-2015, 19:07:13
    Author     : fenrig
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <title>JSP Page</title>
    </head>
    <body>
        <%@ include file="WEB-INF/jspf/header_common.jspf" %>
        
        <hr />
    <c:forEach var="klant" items="${sessionScope.filiaalLeningen}">
        <hr />
        ${klant.persoon.pvoornaam} 
        <hr />
    </c:forEach>
    </body>
</html>
