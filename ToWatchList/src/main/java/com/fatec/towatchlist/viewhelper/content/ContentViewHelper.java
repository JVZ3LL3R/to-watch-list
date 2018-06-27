/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fatec.towatchlist.viewhelper.content;

import com.fatec.towatchlist.aplicacao.Resultado;
import com.fatec.towatchlist.dominio.Avaliacao;
import com.fatec.towatchlist.dominio.Categoria;
import com.fatec.towatchlist.dominio.Classificacao;
import com.fatec.towatchlist.dominio.Conteudo;
import com.fatec.towatchlist.dominio.Diretor;
import com.fatec.towatchlist.dominio.EntidadeDominio;
import com.fatec.towatchlist.dominio.FichaTecnica;
import com.fatec.towatchlist.dominio.Genero;
import com.fatec.towatchlist.dominio.ImagemCapa;
import com.fatec.towatchlist.dominio.Trailer;
import com.fatec.towatchlist.dominio.Usuario;
import com.fatec.towatchlist.viewhelper.IViewHelper;
import com.towatchlist.fatec.util.Util;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author josev
 */
public class ContentViewHelper implements IViewHelper {

    @Override
    public EntidadeDominio getEntidade(HttpServletRequest request) {
        String contentName = request.getParameter("txtNomeConteudo");
        String directorName = request.getParameter("txtNomeDiretor");
        String duration = request.getParameter("doubleDuracao");
        String contentClassification = request.getParameter("txtClassificacaoInd");
        String country = request.getParameter("txtPaisOrigem");
        String contentGenre = request.getParameter("txtGenero");
        String posterUrl = request.getParameter("txtImageUrl");
        String trailerUrl = request.getParameter("trailerUrl");
        String categoryId = request.getParameter("txtCategoria");
        String overview = request.getParameter("txtSinopse");
        String contentRating = request.getParameter("avalicao");
        
        Resultado r = (Resultado) request.getSession().getAttribute("result");
        Usuario user = (Usuario) r.getMapEntidades().get(Util.USER_CLASS).get(0);
        
        FichaTecnica fichaTecnica = new FichaTecnica();
        Avaliacao rating = new Avaliacao();
        Classificacao classification = new Classificacao();
        Diretor director = new Diretor();
        Genero genre = new Genero();
        ImagemCapa poster = new ImagemCapa();
        Trailer trailer = new Trailer();
        Categoria category = new Categoria();
        List < Genero > genres = new ArrayList < Genero > ();
        
        director.setNome(directorName);
        
        rating.setDescAvaliacao(null);
        rating.setNota(Double.parseDouble(contentRating));
        
        poster.setPath(posterUrl);
        
        trailer.setUrl(trailerUrl);
        
        genre.setId(Integer.parseInt(contentGenre));
        genres.add(genre);
        
        classification.setId(Integer.parseInt(contentClassification));
        
        fichaTecnica.setNome(contentName);
        fichaTecnica.setDiretor(director);
        fichaTecnica.setDuracao(duration);
        fichaTecnica.setClassificacao(classification);
        fichaTecnica.setPaisOrigem(country);
        fichaTecnica.setGenero(genres);
        fichaTecnica.setImgCapa(poster);
        fichaTecnica.setTrailer(trailer);
        fichaTecnica.setSinopse(overview);
           
        Conteudo content = new Conteudo();
        content.setFichaTecnica(fichaTecnica);
        content.setAvaliacao(rating);
        content.setAssistido(Util.CONTENT_NOT_WATCHED);
        content.setUserID(user.getId());
        
        category.setId(Integer.parseInt(categoryId));
        content.setCategoria(category);
        
        return content;
        
    }

    @Override
    public void setView(Resultado result, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String action = request.getParameter(Util.ACTION_PARAMETER);
        RequestDispatcher dispatcher = null;
        
        if (null == result.getMsg()) {
            if (action.equals(Util.ACTION_SAVE)) {
                result.setMsg(Util.SUCCESSFULL_CONTENT_SAVE);
                //request.getSession().setAttribute("result", result);
                Resultado r = (Resultado) request.getSession().getAttribute("result");
                Usuario user = (Usuario ) r.getMapEntidades().get(Util.USER_CLASS).get(0);
                for (EntidadeDominio ent : result.getMapEntidades().get(Util.CONTENT_CLASS)){
                    user.getContentsToWacth().add( (Conteudo) ent );
                }
                r.getMapEntidades().get(Util.USER_CLASS).set(0, user);
                request.getSession().setAttribute("result", r);
                dispatcher = request.getRequestDispatcher("/content/content.jsp");
                //response.sendRedirect("/ToWatchList/content/content.jsp");
                
            } else {
                dispatcher = request.getRequestDispatcher("/content/content.jsp");
            }
        }
        
        dispatcher.forward(request, response);
    }
    
    
}
