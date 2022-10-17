<%-- 
    Document   : shoppingList
    Created on : 16-Oct-2022, 4:33:36 PM
    Author     : Kurt
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shopping List</title>
    </head>
    <body>
        <h1>Shopping List</h1>
        <span>Hello, ${username}</span> <a href="ShoppingList?logout" name="logout" value="TESTER">LOGOUT</a>
   
        <h1>List</h1>
        
        <form action="ShoppingList" method="post">
            Add item:<input type="text" name="item"><input type="submit" name ="action" value="add">
            
        </form>
        
        
        
        <form action="" method="post">
        <table>        
<c:forEach var="item" items="${cart}">

    <tr>
<td><input type="radio" name="list" value="${item}">${item}</td>
<td>
</tr>
</c:forEach>
<input type ="submit" name="action" value="delete">
</table>
   
            
        </form>
   
        <div>${counter}</div>
    
    </body>
    
</html>
