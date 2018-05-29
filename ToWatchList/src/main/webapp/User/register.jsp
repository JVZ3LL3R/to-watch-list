<%-- 
    Document   : createAccount
    Created on : 28/05/2018, 18:27:17
    Author     : josev
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/Includes/Bootstrap.jsp"%>
<%-- 
    Document   : include
    Created on : 28/05/2018, 19:10:22
    Author     : josev
--%>
<!DOCTYPE html>
<html>
    <head>
        <!-- <link rel="stylesheet" href="../Includes/loginStyle.css"> -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"/>
        <style>
            body{
                background: url("/ToWatchList/img/pic1.jpg");
                background-size: cover;
                background-position: auto;
                margin: 15px;
                padding: 20px;
                font-family: sans-serif;
            }
            label{
                color: #e2e6ea;
            }
            .page-header{
                color: #040505;
                padding: 10px;
            }
            input{
                padding-right: 2px;
                margin-bottom: 20px
            }
        </style>
    </head>
    <body>
        <div class="page-header">
           <h1>Create Account</h1>
        </div>
        <div class="form-group col-md-4">
           <label for="txtNome">Nome</label>
           <input required="required" type="text" class="form-control" id="txtNome" name="txtNome" value="" placeholder="Seu Nome" maxlength="30"/>
        </div>
        <div class="form-group col-md-4">
           <label for="txtUsername">Username</label>
           <input required="required" type="text" class="form-control" id="txtUsername" name="txtUsername" value="" placeholder="Ex.: Z3LL3R" maxlength="30"/>
        </div>
        <div class="form-group col-md-4">
           <label for="txtEmail">Email</label>
           <input required="required" type="email" class="form-control" id="txtEmail" name="txtEmail" value="" placeholder="email@email.com"/>
        </div>
        <div class="form-group col-md-4">
           <label for="txtSenha">Password</label>
           <input required="required" type="password" class="form-control" id="txtSenha" name="txtSenha" value="" placeholder="Digite sua Senha"/>
        </div>
        <div class="form-group col-md-4">
           <label for="confirmPassword">Confirmar Password</label>
           <input required="required" type="password" class="form-control" id="confirmPassword" name="confirmPassword" value="" placeholder="Confirme sua Senha"/>
        </div>
        <form class="form-inline">
            <input type="submit" class="form-control ml-3 mr-5" name="salvar" value="salvar">
            <input type="submit" class="form-control mr-5" name="cancelar" value="cancelar">
        </form>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    </body>
</html>
