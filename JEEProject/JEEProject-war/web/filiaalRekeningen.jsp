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
            // TODO: view zou niet op bankController moeten steunen, uitzoeken hoe
          DecimalFormat df = new DecimalFormat("###.00");
          DecimalFormat perc = new DecimalFormat("#.##");
          Persoon persI;
          VasteLening vastI;
          VariabeleLening varI;
          Adres adrI;
          List<Klant> kL = (List<Klant>) request.getAttribute("filiaalLeningen");
          for(Klant kI : kL){
              persI = kI.getPnr();
              out.print(persI.getPachternaam() + " " + persI.getPvoornaam());
              out.print("<br />");
              out.print("<table class=\"leningenTable\"><thead><tr><th>Type</th><th>Saldo</th><th>Interest</th><th>Max Rente</th><th>Hypotheek adres</th></tr></thead>");
              for(Lening lI : kI.getLeningList()){
                  vastI = lI.getVasteLening();
                  varI = lI.getVariabeleLening();
                  adrI = lI.getAnr();
                  out.print("<tr>");
                  if( vastI != null){
                      out.print("<td>Vaste Lening</td><td>" +  df.format(lI.getSaldo()) + "&#8364; </td><td>" + perc.format(lI.getInterest() * 100) + "% </td>");
                      out.print("<td>nvt</td>");
                  }else if(varI != null){
                      out.print("<td>Variable Lening</td><td>" +  df.format(lI.getSaldo()) + "&#8364; </td><td>" + perc.format(lI.getInterest() * 100) + "% </td>");
                      out.print("<td>" + perc.format(varI.getMaxrente() * 100) + "% </td>");
                  }
                  if(adrI != null && adrI.getPostcode() != 0){
                      out.print("<td>" + adrI.print() + "</td>");
                  }else{
                      out.print("<td>nvt</td>");
                  }
                  out.print("</tr>");
              }
              out.print("</table>");
              out.print("<hr />");
          }
        %>
    </body>
</html>
