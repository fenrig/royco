<%-- 
    Document   : filiaalLeningToevoegen
    Created on : 14-dec-2015, 15:39:35
    Author     : fenrig
--%>

<%@page import="beans.soortRekening"%>
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
        
        <div id="filiaalLeningToevoegen" class="generalTableForm">
            <form method="POST" action="bankController">
                <table>
                    <tr>
                        <td>Klant:</td>
                        <td>
                            <select name="klantnr">
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
                        <option value="<% out.print(knrI); %>" <%if(knr == knrI) out.print("selected"); %>><% out.print(kI.getKnr()); out.print(" : " + persoon.getPachternaam() + persoon.getPvoornaam() ); %></option>         %></option>
                        <%            } %>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td>Te lenen bedrag:</td>
                        <td><input type="number" min="0" step="0.01" /></td>
                    </tr>
                    <tr>
                        <!-- TODO: vragen hoe juist max rente vast te stellen -->
                        <!-- TODO: vragen ofdat een nieuw adres ingeven ook moet kunnen -->
                        <td>Soort rekening:</td>
                        <td>
                            <select name="soort">
<%                                  
                                    for (soortRekening rek : soortRekening.values()) {
                                        out.print("<option value=\"" + rek.hashCode() + "\">" + rek.toString() + "</option>");
                                      }
%>                                 
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td>Hypothecaire lening</td>
                        <td>
                            <input type="checkbox" name="hypothecaireLening" />
                        </td>
                    </tr>
                    <tr>
                        <td />
                        <td>
                            <select name="adres">
                                <option value="0" selected >Woonplaats nemen</option>
                                <option value="1">Nieuw adres ingeven</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td>straatnaam</td>
                        <td><input type="text" name="straatnaam" /></td>
                    </tr>
                    <tr>
                        <td>straatnr</td>
                        <td><input type="text" name="straatnr" /></td>
                    </tr>
                    <tr>
                        <td>postcode</td>
                        <td><input type="number" name="postcode" min="1000" max="9999" step="1" /></td>
                    </tr>
                </table>
            </form>
        </div>
    </body>
</html>
