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
            <c:if test="${result.msg != null}">
                <div class="alert alert-danger alert-dismissible">
                    <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                    <strong>${result.msg}</strong>
                </div>
            </c:if>
            <c:forEach var="content" items="${result.mapEntidades[Util.USER_CLASS]}">
            <c:forEach items="${content.contentsToWacth}" var="c" varStatus="cont" step="4">                
                <div class="card-deck" style="margin-bottom: 10px;"> <!-- Card Group -->
                    <c:forEach  var="j" begin="${cont.index}" end="${cont.getIndex() + 3}" items="${content.contentsToWacth}" varStatus="i">
                        <c:if test="${j.assistido}" >
                            <div class="card bg-info text-white" style="width: 18rem;">
                                <div class="card-header ml-auto">
                                    <a href="DeleteContent?contId=${j.id}&operacao=EXCLUIR"><i class="fas fa-trash"></i></a>
                                </div>
                        </c:if>
                        <c:if test="${j.assistido != true}" >
                            <div class="card bg-dark text-white" style="width: 18rem;">
                                <div class="card-header ml-auto">
                                    <a href="DeleteContent?contId=${j.id}&operacao=EXCLUIR"><i class="fas fa-trash"></i></a>
                                </div>
                        </c:if>
                            <img class="card-img-top" src="${j.fichaTecnica.imgCapa.path}" alt="Card image cap">
                            <div class="card-body">
                                <h5 class="card-title">${j.fichaTecnica.nome}</h5>
                                <p class="card-text">${j.fichaTecnica.sinopse}</p>
                            </div>
                            <div class="card-footer text-muted">
                                ${j.data}
                          </div>
                        </div>
                    </c:forEach>
                </div> <!-- Card Group -->
                </c:forEach>
                </c:forEach>
        <form enctype="multipart/form-data">
            <div class="form-group">
                <a href="/ToWatchList/content/registerContent.jsp" style="text-decoration: none"><button type="button" class="btn btn-outline-success btn-block" name="operacao" id="operacao" value="CONSULTAR">Adicionar Conteúdo</button></a>
            </div>
        </form> <!-- Form-action -->
        </div> <!-- container-fluid-->
        <!-- Scripts -->
        <%@include file= "/includes/userFooter.jsp"%>
    </body>
</html>
