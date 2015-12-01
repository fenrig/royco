<%-- 
    Document   : klant
    Created on : Nov 17, 2015, 7:33:14 PM
    Author     : Roy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="css/style.css" rel="stylesheet" type="text/css">
        <title>Klant</title>
    </head>
    <body>
        <%@ include file="WEB-INF/jspf/header.jspf" %>
        <h1>Hello ${sessionScope.persoon.pvoornaam} ${sessionScope.persoon.pachternaam}!</h1>
        <p>Welkom bij ${sessionScope.filiaal.fnaam}, uw klantenummer is: ${sessionScope.klant.knr}</p>
        
        <h2>Uw leningen</h2>
        <table>
            <thead>
                
            </thead>
            <tbody>
                
            </tbody>
        </table>
    </body>
</html>
