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
public class Conteudo extends EntidadeDominio {
    
    private boolean assistido;
    private Avaliacao avaliacao;
    private FichaTecnica fichaTecnica;
    private Categoria categoria;

    public Conteudo() {
        this.assistido = false;
    }

    public boolean isAssistido() {
        return assistido;
    }

    public void setAssistido(boolean assistido) {
        this.assistido = assistido;
    }

    public Avaliacao getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(Avaliacao avaliacao) {
        this.avaliacao = avaliacao;
    }
    
    public FichaTecnica getFichaTecnica() {
        return fichaTecnica;
    }

    public void setFichaTecnica(FichaTecnica fichaTecnica) {
        this.fichaTecnica = fichaTecnica;
    }
    
    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}
