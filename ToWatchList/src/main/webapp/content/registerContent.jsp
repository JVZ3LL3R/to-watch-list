<%-- 
    Document   : registerContent
    Created on : 01/06/2018, 19:19:14
    Author     : josev
--%>


<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ page 
    import="com.fatec.towatchlist.aplicacao.Resultado, com.fatec.towatchlist.dominio.*, java.util.*"%>
<%@page import="java.util.List"%>
<%@page import="com.fatec.towatchlist.dominio.*"%>
<%@page import="com.fatec.towatchlist.aplicacao.Resultado"%>
<%@page import="com.towatchlist.fatec.util.Util"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<%@include file= "/includes/Bootstrap.jsp"%>
<%@include file= "/includes/userHeader.jsp"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <style>
            #classIndSelect, #generoSelect, #categorySelect{
                height: 46px;
            }
            .star-rating {
                line-height:32px;
                font-size:1.25em;
                cursor: pointer;
            }
        </style>
    </head>
    <body>
        <main class="div">
            <div class="container-fluid">
                <!-- Page header -->
                <div class="page-header">
                    <h1 class="display-7">Cadastrar Conteúdo</h1>
                    <hr class="my-3"> 
                </div> <!-- Page Header-->
                <c:if test="${msgResult != null}">
                    <div class="alert alert-danger alert-dismissible" style="zIndex: 1000;">
                        <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                        <strong>${msgResult}</strong>
                    </div> 
                </c:if>
                <form action="SaveContent" method="post">
                    <div class="row">
                        <div class="form-group col-md-4">
                            <label for="nome">Nome</label>
                            <div class="input-group mb-3">
                                <div class="input-group-prepend">
                                    <span class="input-group-text" id="name-addon"><i class="fas fa-film fa-2x"></i></span>
                                </div>
                                <input type="text" class="form-control" id="txtNomeConteudo"  name="txtNomeConteudo" placeholder="Ex.: The Avengers" aria-labelledby="nome" aria-describedby="name-addon">
                            </div>  
                        </div> <!-- form-group -->
                        <div class="form-group col-md-4">
                            <label for="diretor">Diretor</label>
                                <div class="input-group mb-3">
                                    <div class="input-group-prepend">
                                        <span class="input-group-text" id="diretor-addon"><i class="fab fa-pied-piper-hat fa-2x"></i></span>
                                    </div>
                                    <input type="text" class="form-control" id="txtNomeDiretor" name="txtNomeDiretor" placeholder="Stan Lee" aria-labelledby="diretor" aria-describedby="diretor-addon">
                                </div>  
                        </div> <!-- form-group -->
                        <div class="form-group col-md-4">
                            <label for="duracao">Duração</label>
                                <div class="input-group mb-3">
                                    <div class="input-group-prepend">
                                        <span class="input-group-text" id="duracao-addon"><i class="fas fa-hourglass fa-2x"></i></span>
                                    </div>
                                    <input type="time" class="form-control" id="doubleDuracao" name="doubleDuracao" placeholder="120mn" aria-labelledby="duracao" aria-describedby="duracao-addon">
                                </div> 
                        </div> <!-- form-group -->
                    </div> <!-- row 1-->
                    <div class="row">
                        <div class="form-group col-md-4">
                            <label for="classIndicativa">Classificação Indicativa</label>
                             <div class="input-group mb-3">
                                 <div class="input-group-prepend">
                                    <span class="input-group-text" id="rating-addon"><i class="fas fa-smile fa-2x"></i></span>
                                </div>
                                 <select class="custom-select form-control" id="txtClassificacaoInd" name="txtClassificacaoInd" style="width: 46px">
                                    <c:forEach items="${result.mapEntidades[Util.CLASSIFICATION_CLASS]}" var="classification">
                                        <option value="${classification.id}">${classification.faixaEtaria}</option>
                                    </c:forEach>
                                </select>
                            </div>  
                        </div> <!-- form-group -->
                        <div class="form-group col-md-4">
                            <label for="paisOrigem">País de Origem</label>
                            <div class="input-group mb-3">
                                <div class="input-group-prepend">
                                    <span class="input-group-text" id="marker-addon"><i class="fas fa-map-marker-alt fa-2x"></i></span>
                                </div>
                                <input type="text" class="form-control" id="txtPaisOrigem" name="txtPaisOrigem" placeholder="Estados Unidos da América "aria-labelledby="paisOrigem" aria-describedby="pais-addon">
                            </div>  
                        </div> <!-- form-group -->
                         <div class="form-group col-md-4">
                            <label for="genero">Gênero</label>
                             <div class="input-group mb-3">
                                 <div class="input-group-prepend">
                                    <span class="input-group-text" id="genre-addon"><i class="fab fa-napster fa-2x"></i></span>
                                </div>
                                <select class="custom-select" id="txtGenero" name="txtGenero" style="width: 48px !important">
                                    <c:forEach items="${result.mapEntidades[Util.GENRE_CLASS]}" var="genre">
                                        <option value="${genre.id}">${genre.nomeGenero}</option>
                                    </c:forEach>
                                </select>
                            </div>  
                        </div> <!-- form-group -->
                    </div> <!-- row 2 -->
                    <div class="row">
                        <div class="form-group col-md-4">
                            <label for="image">Poster URL</label>
                            <div class="input-group mb-3">
                                <div class="input-group-prepend">
                                    <span class="input-group-text" id="camera-addon"><i class="fas fa-camera-retro fa-2x"></i></span>
                                </div>
                                <input type="text" class="form-control" id="txtImageUrl" name="txtImageUrl" placeholder="http://www.image.com/avengers.jpg" aria-labelledby="image" aria-describedby="image-addon">
                            </div>  
                        </div> <!-- form-group -->
                        <div class="form-group col-md-4">
                            <label for="trailer">Trailer URL</label>
                            <div class="input-group mb-3">
                                <div class="input-group-prepend">
                                    <span class="input-group-text" id="youtube-addon"><i class="fab fa-youtube fa-2x"></i></span>
                                </div>
                                <input type="text" class="form-control" id="trailerUrl" name="trailerUrl" placeholder="https://www.youtube.com/watch?v=QwievZ1Tx-8" aria-labelledby="trailer" aria-describedby="trailer-addon">
                            </div> 
                        </div> <!-- form-group -->
                        <div class="form-group col-md-4">
                            <label for="categoria">Categoria</label>
                             <div class="input-group mb-3">
                                 <div class="input-group-prepend">
                                    <span class="input-group-text" id="list-addon"><i class="far fa-list-alt fa-2x"></i></span>
                                </div>
                                <select class="custom-select" id="txtCategoria" name="txtCategoria" style="width: 48px">
                                    <c:forEach items="${result.mapEntidades[Util.CATEGORY_CLASS]}" var="category">
                                        <option value="${category.id}">${category.nome}</option>
                                    </c:forEach>
                                </select>
                            </div>  
                        </div> <!-- form-group -->
                    </div> <!-- row 3 -->
                    <div class="row">
                        <div class="form-group col-lg">
                            <label for="sinopse">Sinopse</label>
                             <div class="input-group mb-3">
                                 <div class="input-group-prepend">
                                    <span class="input-group-text" id="sinopse-addon"><i class="fas fa-sticky-note fa-2x"></i></span>
                                </div>
                                 <textarea rows="3" cols="177" id="txtSinopse" name="txtSinopse" placeholder="Iron Man, Thor, the Hulk and the rest of the Avengers unite to battle their most powerful enemy yet -- the evil Thanos. On a mission to collect all six Infinity Stones, Thanos plans to use the artifacts to inflict his twisted will on reality. The fate of the planet and existence itself has never been more uncertain as everything the Avengers have fought for has led up to this moment."></textarea>
                            </div>  
                        </div> <!-- form-group -->
                    </div> <!-- row 4 -->
                    <div class="row">
                        <div class="form-group col-lg-auto">
                            <label for="avaliacao">Avaliação</label>
                            <div class="input-group-prepend mb-3">
                                <div class="input-group-prepend text-center">
                                    <span class="input-group-text" id="rating-addon"><i class="fas fas fa-star fa-2x"></i></span>
                                </div>
                                <input type="number" id ="avaliacao" name="avalicao" value="5" placeholder="5">
                            </div>
                        </div>
                    </div> <!-- row 5 -->
                    <form method="POST" action="#" enctype="multipart/form-data">
                        <div class="form-group">
                            <button type="submit" class="btn btn-primary btn-block" id="operacao" name="operacao" value="SALVAR">Salvar</button>
                            <button type="submit" class="btn btn-danger btn-block" id="operacao" name="operacao" value="cancelar">Cancelar</button>
                        </div>
                </form> <!-- Form-action -->
            </div> <!-- container-fluid-->
        </main> <!-- main -->
    </body>
    <!-- Scripts -->
    <%@include file= "/includes/userFooter.jsp"%>
    <script>
            var SetRatingStar = function() {
            return $star_rating.each(function() {
              if (parseInt($star_rating.siblings('input.rating-value').val()) >= parseInt($(this).data('rating'))) {
                  console.log(document.querySelectorAll(".star-rating").value);
                return $(this).removeClass('fa-star-o').addClass('fa-star');
              } else {
                  console.log(document.querySelectorAll(".star-rating").value);
                return $(this).removeClass('fa-star').addClass('fa-star-o');
              }
            });
          };
        </script>
</html>