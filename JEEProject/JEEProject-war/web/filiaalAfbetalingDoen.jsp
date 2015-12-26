<%-- 
    Document   : filiaalAfbetalingDoen
    Created on : 26-dec-2015, 16:48:51
    Author     : fenrig
--%>

<%@page import="beans.VasteLening"%>
<%@page import="beans.Adres"%>
<%@page import="beans.numberFormatClass"%>
<%@page import="beans.Klant"%>
<%@page import="java.util.List"%>
<%@page import="beans.Werknemer"%>
<%@page import="beans.Persoon"%>
<%@page import="beans.VariabeleLening"%>
<%@page import="beans.Lening"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/style.css" rel="stylesheet" type="text/css">
        <title>Filiaal: Afbetaling doen</title>
    </head>
        <body>
        <%@ include file="WEB-INF/jspf/header_bank.jspf" %>
        <h1>Afbetaling doen</h1>
        
<%
            Lening len = (Lening) request.getAttribute("lening");
            if(len == null){
%>
<div id="renteAanpassen" class="generalTableForm">
<form method="get" action="bankController">
    <input type="hidden" name="a" value="modSaldo" />
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
                                int lnr = lening.getLnr();
%>
                                <option value="<% out.print(lnr); %>"><% out.print(klaStr); %> <% out.print(lnr); %></option>
<%
                        }
                    }
%>
                </select>
            </td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="Afbetaling doen" /></td>
        </tr>
    </table>
</form>
</div>
<%
            }else{
               // TODO
               numberFormatClass formC = new numberFormatClass();
               Klant klant = len.getKnr();
               VariabeleLening varlen = len.getVariabeleLening();
               VasteLening vaslen = len.getVasteLening();
%>

<a class="name"> <% out.print(klant.getPnr().getPachternaam() + " " + klant.getPnr().getPvoornaam()); %></a>
<table class="leningenTable">
    <thead><tr><th>Type</th><th>Saldo</th><th>Interest</th><th>Max Rente</th><th>Hypotheek adres</th></tr></thead>
    <tr>
        <td><%
if(varlen != null){
    out.print("Variabele Lening");
}else if(vaslen != null){
    out.print("Vaste Lening");
}else{
    out.print("Onbekend");
}
%></td>
        <td><% out.print(formC.formatCurrency(len.getSaldo())); %>&euro; </td>
        <td><% out.print(formC.formatPercentage(len.getInterest())); %></td>
        <td><% if(varlen != null) out.print(formC.formatPercentage(varlen.getMaxrente())); else out.print("nvt"); %></td>
        <td><%
Adres adres = len.getAnr();
if (adres != null && adres.getPostcode() != 0)
{
out.print(adres.toString());
}
else
{
out.print("nvt");
}
        %></td>
    </tr>
</table>
 
<div id="renteAanpassen" class="generalTableForm">
<form method="post" action="bankController">
    <input type="hidden" name="postOrigin" value="filiaalAfbetalingDoen.jsp" />
    <input type="hidden" name="lnr" value="<% out.print(len.getLnr()); %>" />
    <table>
        <tr>
            <td>Saldo dat men wil afbetalen:</td>
            <td><input name="saldo" type="number" max="<% out.print(len.getSaldo()); %>" min="0" step="0.01" /></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="Afbetaling doen" />
            </td>
        </tr>
    </table>
</form>
</div>
<%
            }
%>
    </body>
</html>
