<%-- 
    Document   : klantToevoegen
    Created on : 7-dec-2015, 2:33:55
    Author     : fenrig
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/style.css" rel="stylesheet" type="text/css">
        <title>Klant toevoegen</title>
    </head>
    <body>
        <%@ include file="WEB-INF/jspf/header_bank.jspf" %>
        <h1>Klant toevoegen</h1>
        <div id="klantToevoegen" class="generalTableForm">
            <form method="POST" action="bankController">
                <table>
                    <tr>
                        <td>Straat:</td>
                        <td><input type="text" name="straatnaam" /></td>
                    </tr>
                    <tr>
                        <td>Straatnr:</td>
                        <td><input type="text" name="straatnr" /></td>
                    </tr>
                    <tr>
                        <td>Postcode:</td>
                        <td><input type="text" name="postcode" /></td>
                    </tr>
                    <tr>
                        <td>Voornaam:</td>
                        <td><input type="text" name="pvoornaam" /></td>
                    </tr>
                    <tr>
                        <td>Achternaam:</td>
                        <td><input type="text" name="pachternaam" /></td>
                    </tr>
                    <tr>
                        <td>Username:</td>
                        <td><input type="text" name="username" /></td>
                    </tr>
                    <tr>
                        <td>Password:</td>
                        <td>DEFAULT PASS POLICY</td>
                    </tr>
                    <tr>
                        <td></td>
                        <td><input type="submit" style="width: 100%;" value="Toevoegen"/></td>
                    </tr>
                </table>
                <input type="hidden" name="postOrigin" value="klantToevoegen.jsp" />
            </form>
        </div>
    </body>
</html>
