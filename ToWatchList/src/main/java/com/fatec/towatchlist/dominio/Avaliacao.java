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
class Avaliacao {
    
    private String descAvaliacao;
    private double nota;

    public Avaliacao(String descAvaliacao, double nota) {
        this.descAvaliacao = descAvaliacao;
        this.nota = nota;
    }

    public String getDescAvaliacao() {
        return descAvaliacao;
    }

    public void setDescAvaliacao(String descAvaliacao) {
        this.descAvaliacao = descAvaliacao;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }
    
    
    
    
}
