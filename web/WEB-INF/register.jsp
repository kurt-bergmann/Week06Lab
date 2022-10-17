<%-- 
    Document   : register
    Created on : 16-Oct-2022, 4:33:16 PM
    Author     : Kurt
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register</title>
    </head>
    <body>
        <h1>Shopping List</h1><br>
        <form action ="ShoppingList" method="get">
            Username:<input type ="text" name="username"><input type ="submit" name="submit" value = "Register Name">

        </form>
        
        <p> ${message}</p>
    </body>
</html>
