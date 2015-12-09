<%-- 
    Document   : bankError
    Created on : 9-dec-2015, 15:26:04
    Author     : fenrig
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Er heeft zich een fout voorgedaan</title>
    </head>
    <body>
        <h1>Onze excuses, maar er heeft zich een fout voorgedaan:</h1>
        <div id="stringError">
        <%
            
            String estr = (String) request.getAttribute("errorstring");
            if(estr != null){
                out.print(estr);
            }
            
        %>
        </div>
        <div id="exceptionError">
           <%
            
            Exception e = (Exception) request.getAttribute("exception");
            if(e != null){
                out.print(e.fillInStackTrace());
            }
            
        %> 
        </div>
    </body>
</html>
