<%-- 
    Document   : filiaalRekeningen
    Created on : 5-dec-2015, 19:07:13
    Author     : fenrig
--%>

<%@page import="java.text.DecimalFormat"%>
<%@page import="beans.Adres"%>
<%@page import="beans.VariabeleLening"%>
<%@page import="beans.VasteLening"%>
<%@page import="beans.Lening"%>
<%@page import="beans.Persoon"%>
<%@page import="java.util.List"%>
<%@page import="beans.Klant"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <link href="css/style.css" rel="stylesheet" type="text/css">
        <title>Filiaal rekeningen</title>
    </head>
    <body>
        <%@ include file="WEB-INF/jspf/header_bank.jspf" %>
        <hr />
        <%
            DecimalFormat df = new DecimalFormat("#,###.00");
            DecimalFormat perc = new DecimalFormat("#.##");

            Persoon persoon = (Persoon)session.getAttribute("persoon");
            Werknemer werknemer = persoon.getWerknemer();

            List<Klant> klanten = werknemer.getFnr().getKlantList();
  
            for (Klant klant : klanten)
            {
                out.print("<div class=\"filiaalRekening\"><div class=\"rekeningOverzicht\">");
                out.print("<a class=\"name\">" + klant.getPnr().getPachternaam() + " " + klant.getPnr().getPvoornaam() + "</a>");
                out.print("<br />");
                List<Lening> leningList = klant.getLeningList();
                if(leningList.isEmpty()){
                    out.print("&#8608  Heeft geen leningen");
                }else{
%>
<table class="leningenTable"><thead><tr><th>Type</th><th>Saldo</th><th>Interest</th><th>Max Rente</th><th>Hypotheek adres</th><th>Rente aanpassen</th><th>Afbetaling</th></tr></thead>
<%
                        for (Lening lening : leningList)
                    {
                        VasteLening vasteLening = lening.getVasteLening();
                        VariabeleLening varLening = lening.getVariabeleLening();
                        Adres adres = lening.getAnr();
                        int lnr = lening.getLnr();
                        out.print("<tr>");

                        if (vasteLening != null)
                        {
                            out.print("<td>Vaste Lening</td><td>" + df.format(lening.getSaldo()) + "&euro; </td><td>" + perc.format(lening.getInterest() * 100) + "% </td>");
                            out.print("<td>nvt</td>");
                        }
                        else if (varLening != null)
                        {
                            out.print("<td>Variable Lening</td><td>" + df.format(lening.getSaldo()) + "&euro; </td><td>" + perc.format(lening.getInterest() * 100) + "% </td>");
                            out.print("<td>" + perc.format(varLening.getMaxrente() * 100) + "% </td>");
                        }
                        else
                        {
                            out.print("<td>Onbekende Lening</td><td>" + df.format(lening.getSaldo()) + "&euro; </td><td>" + perc.format(lening.getInterest() * 100) + "% </td>");
                            out.print("<td>???</td>");
                        }

                        if (adres != null && adres.getPostcode() != 0)
                        {
                            out.print("<td>" + adres.toString() + "</td>");
                        }
                        else
                        {
                            out.print("<td>nvt</td>");
                        }
                        if (varLening != null){
%>
                            <td><a href="bankController?a=modRente&lnr=<% out.print(lnr); %>">Rente aanpassen</a></td>
<%                       }else{
%>
                            <td>nvt</td>
<%
                            
                         }
%>
                        <td><a href="">Afbetaling</a></td>
                        </tr>
<%
                    }

                    out.print("</table>");
                }
%>
                    </div>
                    <div class="filiaalActions">
                        <% int knr = klant.getKnr(); %>
                        <a href="filiaalLeningToevoegen.jsp?knr=<% out.print(knr); %>">Lening Toevoegen</a> <br />
                        <a href="bankController?a=delUser&knr=<% out.print(knr); %>">Klant verwijderen</a> <br />
                    </div>
                    <hr style="clear: left" />
                </div>
                
                
         <%
            }
        %>
    </body>
</html>
