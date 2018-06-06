<%-- 
    Document   : registerContent
    Created on : 01/06/2018, 19:19:14
    Author     : josev
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
                <form action="/ToWatchList/registerContent/save" method="post">
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
                                    <input type="text" class="form-control" id="txtDiretor" placeholder="Stan Lee" aria-labelledby="diretor" aria-describedby="diretor-addon">
                                </div>  
                        </div> <!-- form-group -->
                        <div class="form-group col-md-4">
                            <label for="duracao">Duração</label>
                                <div class="input-group mb-3">
                                    <div class="input-group-prepend">
                                        <span class="input-group-text" id="duracao-addon"><i class="fas fa-hourglass fa-2x"></i></span>
                                    </div>
                                    <input type="time" class="form-control" id="floatDuracao" placeholder="120mn" aria-labelledby="duracao" aria-describedby="duracao-addon">
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
                                <select class="custom-select form-control" id="classIndSelect">
                                    <option selected>Livre para todos os Públicos</option>
                                    <option value="1">Não recomendado para menores de 10 anos</option>
                                    <option value="2">Não recomendado para menores de 12 anos</option>
                                    <option value="3">Não recomendado para menores de 14 anos</option>
                                    <option value="4">Não recomendado para menores de 16 anos</option>
                                    <option value="5">Não recomendado para menores de 18 anos</option>
                                </select>
                            </div>  
                        </div> <!-- form-group -->
                        <div class="form-group col-md-4">
                            <label for="paisOrigem">País de Origem</label>
                            <div class="input-group mb-3">
                                <div class="input-group-prepend">
                                    <span class="input-group-text" id="calendar-addon"><i class="fas fa-map-marker-alt fa-2x"></i></span>
                                </div>
                                <input type="text" class="form-control" id="txtPaisOrigem" placeholder="Estados Unidos da América "aria-labelledby="paisOrigem" aria-describedby="pais-addon">
                            </div>  
                        </div> <!-- form-group -->
                         <div class="form-group col-md-4">
                            <label for="genero">Gênero</label>
                             <div class="input-group mb-3">
                                 <div class="input-group-prepend">
                                    <span class="input-group-text" id="genre-addon"><i class="fab fa-napster fa-2x"></i></span>
                                </div>
                                <select class="custom-select" id="generoSelect">
                                    <option selected>Ação</option>
                                    <option value="1">Aventura</option>
                                    <option value="2">Comédia</option>
                                    <option value="3">Drama</option>
                                    <option value="4">Terror</option>
                                </select>
                            </div>  
                        </div> <!-- form-group -->
                    </div> <!-- row 2 -->
                    <div class="row">
                        <div class="form-group col-md-4">
                            <label for="image">Poster URL</label>
                            <div class="input-group mb-3">
                                <div class="input-group-prepend">
                                    <span class="input-group-text" id="image-addon"><i class="fas fa-camera-retro fa-2x"></i></span>
                                </div>
                                <input type="text" class="form-control" id="txtImageUrl" placeholder="http://www.image.com/avengers.jpg" aria-labelledby="image" aria-describedby="image-addon">
                            </div>  
                        </div> <!-- form-group -->
                        <div class="form-group col-md-4">
                            <label for="trailer">Trailer URL</label>
                            <div class="input-group mb-3">
                                <div class="input-group-prepend">
                                    <span class="input-group-text" id="stickyNote-addon"><i class="fab fa-youtube fa-2x"></i></span>
                                </div>
                                <input type="text" class="form-control" id="trailerUrl" placeholder="https://www.youtube.com/watch?v=QwievZ1Tx-8" aria-labelledby="trailer" aria-describedby="trailer-addon">
                            </div> 
                        </div> <!-- form-group -->
                        <div class="form-group col-md-4">
                            <label for="categoria">Categoria</label>
                             <div class="input-group mb-3">
                                 <div class="input-group-prepend">
                                    <span class="input-group-text" id="list-addon"><i class="far fa-list-alt fa-2x"></i></span>
                                </div>
                                <select class="custom-select" id="categorySelect">
                                    <option selected>Animes</option>
                                    <option value="1">Filmes</option>
                                    <option value="2">Séries</option>
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
                                 <textarea rows="3" cols="177" placeholder="Iron Man, Thor, the Hulk and the rest of the Avengers unite to battle their most powerful enemy yet -- the evil Thanos. On a mission to collect all six Infinity Stones, Thanos plans to use the artifacts to inflict his twisted will on reality. The fate of the planet and existence itself has never been more uncertain as everything the Avengers have fought for has led up to this moment."></textarea>
                            </div>  
                        </div> <!-- form-group -->
                    </div> <!-- row 4 -->
                    <div class="row">
                        <div class="form-group col-lg-auto">
                            <label for="avaliacao">Avaliação</label>
                            <div class="star-rating"> 
                                 <span class="fas fa-star fa-2x" data-rating="1"></span>
                                 <span class="fas fa-star fa-2x" data-rating="2"></span>
                                 <span class="fas fa-star fa-2x" data-rating="3"></span>
                                 <span class="fas fa-star fa-2x" data-rating="4"></span>
                                 <span class="fas fa-star fa-2x" data-rating="5"></span>
                                 <input type="hidden" id ="avaliacao" name="avalicao" class="rating-value" value="avaliacao">
                           </div>
                        </div>
                    </div> <!-- row 5 -->
                    <form method="POST" action="#" enctype="multipart/form-data">
                        <div class="form-group">
                            <button type="submit" class="btn btn-primary btn-block" id="operacao" value="salvar">Salvar</button>
                            <button type="submit" class="btn btn-danger btn-block" id="operacaoCancelar" value="cancelar">Cancelar</button>
                        </div>
                </form> <!-- Form-action -->
            </div> <!-- container-fluid-->
        </main> <!-- main -->
    </body>
    <script>
            var SetRatingStar = function() {
            return $star_rating.each(function() {
              if (parseInt($star_rating.siblings('input.rating-value').val()) >= parseInt($(this).data('rating'))) {
                return $(this).removeClass('fa-star-o').addClass('fa-star');
              } else {
                return $(this).removeClass('fa-star').addClass('fa-star-o');
              }
            });
          };
        </script>
</html>