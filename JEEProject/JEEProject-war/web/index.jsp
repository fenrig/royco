<%-- 
    Document   : intro
    Created on : Nov 17, 2015, 7:17:23 PM
    Author     : Roy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/style.css" rel="stylesheet" type="text/css">
        <title>JSP Page (index)</title>
    </head>
    <body>
        <%@ include file="WEB-INF/jspf/header_common.jspf" %>
        <h1>Welkom by Royco Bank!</h1>

        <div class="flexHorz">
            <div class="loginDiv">
                <form action="<c:url value="controller" />" method="post">
                    <input type="hidden" value="klant" name="state" /><input type="submit" value="klanten" />
                </form>
            </div>
            <div class="loginDiv">
                <form action="<c:url value="controller" />" method="post">
                    <input type="hidden" value="werknemer" name="state" /><input type="submit" value="werknemers" />
                </form>
            </div>
        </div>
    </body>
</html>
