<%-- 
    Document   : registerUser
    Created on : 05/06/2018, 21:27:05
    Author     : josev
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file= "/includes/Bootstrap.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="../includes/loginStyle.css">
        <title>To Watch List</title>
        <style>
            body {
                margin: 20px;
                padding: 10px;
                background: url("/ToWatchList/img/pic1.jpg");
                background-size: cover;
                background-position: auto;
                font-family: sans-serif;
            }
        </style>
    </head>
    <body>
        <!-- Page header -->
        <!-- // TODO: Align header to left -->
        <!-- <div class="page-header">
            <h1 class="display-4">Cadastrar Usuário</h1>
            <hr class="my-3"> 
        </div> <!-- Page Header-->
        <form action="/ToWatchList/user/save" method="post">
            <div class="form-group col-md-4">
                <label for="nomeUsr">Nome</label>
                <input type="text" class="form-control" id="nomeUsr"  name="nomeUsr" placeholder="Ex.: José Victor" aria-labelledby="nomeUsr">
            </div>
            <div class="form-group col-md-4">
                <label for="apelidoUsr">Apelido</label>
                <input type="text" class="form-control" id="apelido"  name="apelidoUsr" placeholder="Ex.: Z3LL3R" aria-labelledby="apelidoUsr">
            </div>
            <div class="form-group col-md-4">
                <label for="emailUsr">Email</label>
                <input type="text" class="form-control" id="emailUsr"  name="emailUsr" placeholder="Ex.: zeller@zeller.com" aria-labelledby="emailUsr">
            </div>
            <div class="form-group col-md-4">
                <label for="senhaUsr">Senha</label>
                <input type="text" class="form-control" id="senhaUsr"  name="senhaUsr" placeholder="Ex.: password123" aria-labelledby="senhaUsr">
            </div>
            <div class="form-group col-md-4">
                <label for="senhaUsr2">Confirmar Senha</label>
                <input type="text" class="form-control" id="senhaUsr2"  name="senhaUsr2" placeholder="Ex.: password123" aria-labelledby="senhaUsr2">
            </div>
            <div class="button-group col-md-4">
                <button type="submit" id="operacap" value="salvar" class="btn btn-light">Cadastrar</button>
                <button type="submit" id ="operacaoCancelar" value="cancelar" class="btn btn-light">Cancelar</button>                
            </div>
        </form>
    </body>
</html>
