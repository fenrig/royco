<%-- 
    Document   : filiaalRenteAanpassen
    Created on : 21-dec-2015, 13:21:22
    Author     : fenrig
--%>

<%@page import="beans.Lening"%>
<%@page import="beans.Klant"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/style.css" rel="stylesheet" type="text/css">
        <title>Filiaal: Rente aanpassen</title>
    </head>
    <body>
        <%@ include file="WEB-INF/jspf/header_bank.jspf" %>
        <h1>Rente aanpassen</h1>
        
        <div id="renteAanpassen" class="generalTableForm">
<%
            Lening len = (Lening) request.getAttribute("lening");
            if(len == null){
%>
<form method="get" action="bankController">
    <input type="hidden" name="a" value="modRente" />
    <table>
        <tr>
            <td>Kies een lening</td>
            <td>
                <select name="lnr">
<%
                    Persoon persoon = (Persoon)session.getAttribute("persoon");
                    Werknemer werknemer = persoon.getWerknemer();

                    List<Klant> klanten = werknemer.getFnr().getKlantList();
                    List<Lening> leningen;
                    for (Klant klant : klanten)
                    {
                        List<Lening> leningList = klant.getLeningList();
                        Persoon persI = klant.getPnr();
                        String klaStr = persI.getPachternaam() + " " + persI.getPvoornaam() + ": ";
                        for(Lening lening : leningList){
                            if(lening.getVariabeleLening() != null){
                                int lnr = lening.getLnr();
%>
                                <option value="<% out.print(lnr); %>"><% out.print(klaStr); %> <% out.print(lnr); %></option>
<%
                            }
                        }
                    }
%>
                </select>
            </td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="Rente aanpassen" /></td>
        </tr>
    </table>
</form>
<%
            }else{
               out.print("TODO");
               
            }
%>
        </div>
    </body>
</html>
