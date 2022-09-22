<%-- 
    Document   : agecalculator
    Created on : 22-Sep-2022, 8:54:19 AM
    Author     : 1drag
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Age Calculator</title>
    </head>
    <body>
        <h1>Age Calculator</h1>
        <form method="post" action="AgeCalculator">
            Enter your Age: <input type="text" name="age" value="${age}"><br>
            <input type="submit" value="Age next birthday"
        </form>         
            <p>${message}</p>
            <p><a href="/arithmeticcalculator" Arithmetic Calculator</a></p>
            
    </body>
</html>
