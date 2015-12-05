<%-- 
    Document   : login
    Created on : Nov 17, 2015, 7:26:57 PM
    Author     : Roy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/style.css" rel="stylesheet" type="text/css">
        <title>Login</title>
    </head>
    <body>
        <%@ include file="WEB-INF/jspf/header_common.jspf" %>
        <h1>Welkom</h1>
        <form method=post action="<c:url value="j_security_check" />">
            <table>
                <tr><td>Naam: </td><td><input type="text" name="j_username" /></td></tr>
                <tr><td>Paswoord: </td><td><input type="password" name="j_password" /><input type="hidden" name="state" value="loggedIn"></td></tr>
            </table>
            <input type="submit" />
        </form>
    </body>
</html>
