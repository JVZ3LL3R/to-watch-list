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
public class Pessoa extends EntidadeDominio {
    
    public Pessoa () {
        
    }
    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Pessoa(String nome) {
        this.nome = nome;
    }
    
}
