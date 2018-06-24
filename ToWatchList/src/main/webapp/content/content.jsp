<%-- 
    Document   : content
    Created on : 05/06/2018, 22:18:20
    Author     : josev
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file= "/includes/Bootstrap.jsp"%>
<%@include file= "/includes/userHeader.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <form enctype="multipart/form-data">
            <div class="form-group">
                <a href="/ToWatchList/content/registerContent.jsp" style="text-decoration: none"><button type="button" class="btn btn-outline-success btn-block" name="operacao" id="operacao" value="CONSULTAR">Adicionar Conteúdo</button></a>
            </div>
        </form> <!-- Form-action -->
    </body>
</html>
