/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fatec.towatchlist.strategy;

import com.fatec.towatchlist.dominio.Conteudo;
import com.fatec.towatchlist.dominio.EntidadeDominio;
import com.fatec.towatchlist.dominio.Genero;
import com.towatchlist.fatec.util.Util;
import javafx.beans.binding.StringBinding;

/**
 *
 * @author josev
 */
public class StgValidarDadosObrigatorios implements IStrategy {

    @Override
    public String processar(EntidadeDominio entidade) {
        if (null != entidade) {
            Conteudo content = (Conteudo) entidade;
            
            String name = content.getFichaTecnica().getNome();
            String review = content.getFichaTecnica().getSinopse();
            String director = content.getFichaTecnica().getDiretor().getNome();
            String duration = content.getFichaTecnica().getDuracao();
            String poster = content.getFichaTecnica().getImgCapa().getPath();
            String trailer = content.getFichaTecnica().getTrailer().getUrl();
            String country = content.getFichaTecnica().getPaisOrigem();
            
            StringBuilder genre = new StringBuilder();
            for(Genero g : content.getFichaTecnica().getGenero()){
                if(null != g.getId()){
                    genre.append(g.getId());
                }
            }
            Integer classification = content.getFichaTecnica().getClassificacao().getId();
            Double rating = content.getAvaliacao().getNota();
            Integer category = content.getCategoria().getId();
            Integer userId = content.getUserID();
            
            if (null == classification || null == rating || null == category) {
                return "Classificação, Avaliação e Categoria são Obrigatórios!!!";
            }
            if (null == userId) {
                return "O usuário não está logado";
            }
            
            if (null == name || null == review || null == director || null == duration || null == poster
                || null == trailer || null == country || null == genre) {
                
                return "Nome, Sinopse, Diretor, Duração, URL do Poster, URL do Trailer e País de Origem são Obrigatórios";
            }
            
            if (name.trim().equals("") || review.trim().equals("") || director.trim().equals("")
                || duration.trim().equals("") || poster.trim().equals("") || trailer.trim().equals("")
                || country.trim().equals("") || genre.equals("")){
                
                return "Nome, Sinopse, Diretor, Duração, URL do Poster, URL do Trailer e País de Origem são Obrigatórios";
            }
        } else if (null == entidade) {
            return Util.ENTITY + entidade.getClass().getCanonicalName() + Util.NULL_ENTITY;
        }
        return null;
    }
    
}
