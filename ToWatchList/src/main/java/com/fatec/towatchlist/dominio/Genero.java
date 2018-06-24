/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fatec.towatchlist.dominio;

/**
 *
 * @author josev
 */
public class Genero extends EntidadeDominio {
    
    private String nomeGenero;

    public Genero(String tipo) {
        this.nomeGenero = tipo;
    }
    
    public Genero() {
        
    }

    public String getNomeGenero() {
        return nomeGenero;
    }

    public void setNomeGenero(String nomeGenero) {
        this.nomeGenero = nomeGenero;
    }
    
    
    
}
