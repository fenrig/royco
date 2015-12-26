<%-- 
    Document   : filiaalRenteAanpassen
    Created on : 21-dec-2015, 13:21:22
    Author     : fenrig
--%>

<%@page import="beans.Adres"%>
<%@page import="beans.VariabeleLening"%>
<%@page import="beans.numberFormatClass"%>
<%@page import="java.text.DecimalFormat"%>
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
        
<%
            Lening len = (Lening) request.getAttribute("lening");
            VariabeleLening varlen = null;
            if(len != null)
                varlen = (VariabeleLening) len.getVariabeleLening();
            if(len == null){
%>
<div id="renteAanpassen" class="generalTableForm">
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
</div>
<%
            }else if(varlen == null){
%>
                Lening (lnr: <% out.print(len.getLnr()); %> is geen variabele lening.
<%
            }else{
               // TODO
               numberFormatClass formC = new numberFormatClass();
%>


<table class="leningenTable">
    <thead><tr><th>Type</th><th>Saldo</th><th>Interest</th><th>Max Rente</th><th>Hypotheek adres</th></tr></thead>
    <tr>
        <td>Variabele Lening</td>
        <td><% out.print(formC.formatCurrency(len.getSaldo())); %>&euro; </td>
        <td><% out.print(formC.formatPercentage(len.getInterest())); %></td>
        <td><% out.print(formC.formatPercentage(varlen.getMaxrente())); %></td>
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
    <input type="hidden" name="postOrigin" value="filiaalRenteAanpassen.jsp" />
    <input type="hidden" name="lnr" value="<% out.print(len.getLnr()); %>" />
    <table>
        <tr>
            <td>Rente aanpassen:</td>
            <td><input name="interestvoet" type="number" max="<% out.print(varlen.getMaxrente()*100); %>" min="0" step="0.001" /></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="Veranderen" />
            </td>
        </tr>
    </table>
</form>
</div>
<%
            }
%>
        </div>
    </body>
</html>
