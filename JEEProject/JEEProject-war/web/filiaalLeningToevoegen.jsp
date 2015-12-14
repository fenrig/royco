<%-- 
    Document   : filiaalLeningToevoegen
    Created on : 14-dec-2015, 15:39:35
    Author     : fenrig
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/style.css" rel="stylesheet" type="text/css">
        <title>Filiaal: Lening Toevoegen</title>
    </head>
    <body>
        <%@ include file="WEB-INF/jspf/header_bank.jspf" %>
        <h1>Lening Toevoegen</h1>
        
        <select>
<%
            Werknemer werknemer = ((Persoon) request.getSession().getAttribute("persoon")).getWerknemer();
            Filiaal filiaal = werknemer.getFnr();
            int knr;
            try{
                String hulp = request.getParameter("knr");
                if(hulp != null)
                    knr = Integer.decode(hulp);
                else
                    knr = -1;
            }catch(NumberFormatException e){
                knr = -1;
            }
            for(Klant kI: filiaal.getKlantList()){
                Persoon persoon = kI.getPnr();
                int knrI = kI.getKnr();
%>
<option value="<% out.print(knrI); %>" <%if(knr == knrI) out.print("selected"); %>><% out.print(kI.getKnr()); out.print(" : " + persoon.getPachternaam() + persoon.getPachternaam() ); %></option>         %></option>
<%            } %>
        </select>
    </body>
</html>
