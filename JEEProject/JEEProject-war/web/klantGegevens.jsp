<%-- 
    Document   : klantGegevens
    Created on : Dec 2, 2015, 9:31:08 PM
    Author     : Roy Scheerens
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/style.css" rel="stylesheet" type="text/css">
        <title>Uw Gegevens</title>
    </head>
    <body>
        <%@ include file="WEB-INF/jspf/header_klant.jspf" %>
        <h1>Uw gegevens</h1>
        <form name="gegevens" action="<c:url value="klantController" />" method="post">
            <table>
                <tr><td><label for="pvoornaam">Voornaam</label></td><td><input type="text" value="${sessionScope.persoon.pvoornaam}" name="pvoornaam" /></td></tr>
                <tr><td><label for="pachternaam">Achternaam</label></td><td><input type="text" value="${sessionScope.persoon.pachternaam}" name="pachternaam" /></td></tr>
                <tr><td><label for="straatnaam">Straat</label></td><td><input type="text" value="${sessionScope.persoon.klant.anr.straatnaam}" name="straatnaam" /></td></tr>
                <tr><td><label for="straatnummer">Straat Nummer</label></td><td><input type="text" value="${sessionScope.persoon.klant.anr.straatnr}" name="straatnummer" /></td></tr>
                <tr><td><label for="postcode">Postcode</label></td><td><input type="text" value="${sessionScope.persoon.klant.anr.postcode}" name="postcode" /></td></tr>
            </table>
            <input type="hidden" value="gegevensAanpassing" name="state" /><input type="submit" value="Wijzig Gegevens" />
        </form>
    </body>
</html>
