/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fatec.towatchlist.dominio;

import java.util.List;

/**
 *
 * @author josev
 */
class Favoritos extends EntidadeDominio{
    
    List <Conteudo> conteudosFavoritos;

    public List<Conteudo> getConteudosFavoritos() {
        return conteudosFavoritos;
    }

    public void setConteudosFavoritos(List<Conteudo> conteudosFavoritos) {
        this.conteudosFavoritos = conteudosFavoritos;
    }
    
}
