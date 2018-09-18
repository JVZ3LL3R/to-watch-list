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
public class Classificacao extends EntidadeDominio {
    
      private String faixaEtaria;

    public Classificacao(String faixaEtaria) {
        this.faixaEtaria = faixaEtaria;
    }
    
    public Classificacao () {
        
    }

    public String getFaixaEtaria() {
        return faixaEtaria;
    }

    public void setFaixaEtaria(String faixaEtaria) {
        this.faixaEtaria = faixaEtaria;
    }
    
}
