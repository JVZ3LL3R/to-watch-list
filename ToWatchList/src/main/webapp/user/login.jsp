<%-- 
    Document   : login
    Created on : 28/05/2018, 15:19:04
    Author     : josev
--%>

<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>



<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="../includes/loginStyle.css">
        <title>To Wtach List</title>
    </head>
    <body>
        <div class="loginbox">
        <img src="/ToWatchList/img/avatar.png" class="avatar">
        <h1>Login</h1>
        <form action="Login" method="post">
            <p>Email</p>
            <input type="text" name="emailUsr" placeholder="meu@email.com">
            <p>Password</p>
            <input type="password" name="senhaUsr" placeholder="MyPassword">
            <input type="submit" name="operacao" value="LOGIN">
            <input type="button" name="operacao" value="TESTAR">
            <a href="/ToWatchList/user/registerUser.jsp">Don't have an account?</a>
        </form>
    </div>
    </body>
</html>
