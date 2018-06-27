<%-- 
    Document   : login
    Created on : 28/05/2018, 15:19:04
    Author     : josev
--%>

<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file= "/includes/Bootstrap.jsp"%>



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
        <div class="fixed-bottom text-center">
        <c:if test="${msgResult != null}">
            <div class="alert alert-warning alert-dismissible align-self-right">
                <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                <strong>${msgResult}</strong> ${Util.USER_LOGIN_ERROR}
            </div> 
        </c:if>
        </div>
        <!-- Scripts -->
        <%@include file= "/includes/userFooter.jsp"%>
    </body>
</html>
