<%-- 
    Document   : klant
    Created on : Nov 17, 2015, 7:33:14 PM
    Author     : Roy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/style.css" rel="stylesheet" type="text/css">
        <title>Klant</title>
    </head>
    <body>
        <%@ include file="WEB-INF/jspf/header_klant.jspf" %>
        <h1>Hello ${sessionScope.klant.persoon.pvoornaam} ${sessionScope.klant.persoon.pachternaam}!</h1>
        <p>Welkom bij ${sessionScope.klant.fnr.fnaam}, uw klantenummer is: ${sessionScope.klant.knr}</p>

        <h2>Uw leningen</h2>
        <table class="leningenTable">
            <thead>
                <tr>
                    <th>Nummer</th>
                    <th>Saldo</th>
                    <th>Interest</th>
                    <th>Max Interest</th>
                    <th>Onderpand</th>
                    <th>Soort</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="lening" items="${sessionScope.klant.leningList}">
                    <tr>
                        <td>${lening.lnr}</td>
                        <td>${lening.saldo}</td>
                        <td>${lening.interest}</td>
                        <c:choose>
                            <c:when test="${!empty lening.variabeleLening}">
                                <td>${lening.variabeleLening.maxrente}</td>
                            </c:when>
                            <c:otherwise>
                                <td>n/a</td>
                            </c:otherwise>
                        </c:choose>
                        <c:choose>
                            <c:when test="${lening.anr.anr != 0}">
                                <td>${lening.anr.straatnaam} ${lening.anr.straatnr}</td>
                            </c:when>
                            <c:otherwise>
                                <td>n/a</td>
                            </c:otherwise>
                        </c:choose>
                        <c:choose>
                            <c:when test="${!empty lening.vasteLening}">
                                <td>Vast</td>
                            </c:when>
                            <c:when test="${!empty lening.variabeleLening}">
                                <td>Variabel</td>
                            </c:when>
                            <c:otherwise>
                                <td>Onbekend - Error</td>
                            </c:otherwise>
                        </c:choose>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>
