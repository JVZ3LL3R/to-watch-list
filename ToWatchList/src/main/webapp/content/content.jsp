<%-- 
    Document   : content
    Created on : 05/06/2018, 22:18:20
    Author     : josev
--%>

<%@page import="java.util.List"%>
<%@page import="com.fatec.towatchlist.dominio.*"%>
<%@page import="com.fatec.towatchlist.aplicacao.Resultado"%>
<%@page import="com.towatchlist.fatec.util.Util"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file= "/includes/Bootstrap.jsp"%>
<%@include file= "/includes/userHeader.jsp"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <div class="container-fluid">
            <c:forEach items="${logado.contentsToWacth}" var="content" varStatus="cont" step="4">
                    <div class="row"> <!-- Row -->
                        <div class="col-lg-auto col-md-auto col-sm-auto"> <!-- Col -->
                            <div class="card-group mx-auto"> <!-- Card Group -->
                                <c:forEach  var="logado" begin="${cont.getIndex()}" end="${cont.getIndex() + 3}" items="${logado.contentsToWacth}">
                                    <div class="card mb-2 bg-dark text-white mr-4" style="width: 22rem;">
                                        <img class="card-img-top" src="${logado.fichaTecnica.imgCapa.path}" alt="Card image cap">
                                        <div class="card-body">
                                            <h5 class="card-title">${logado.fichaTecnica.nome}</h5>
                                            <p class="card-text">${logado.fichaTecnica.sinopse}</p>
                                            <p class="card-text"><small class="text-white">${logado.data}</small></p>
                                        </div>
                                    </div>
                                </c:forEach>
                            </div> <!-- Card Group -->
                        </div> <!-- Col -->
                    </div> <!-- Row -->
                </c:forEach>
        <form enctype="multipart/form-data">
            <div class="form-group">
                <a href="/ToWatchList/content/registerContent.jsp" style="text-decoration: none"><button type="button" class="btn btn-outline-success btn-block" name="operacao" id="operacao" value="CONSULTAR">Adicionar Conteúdo</button></a>
            </div>
        </form> <!-- Form-action -->
        </div> <!-- container-fluid-->
    </body>
</html>
