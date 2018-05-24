/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fatec.dominio;

/**
 *
 * @author josev
 */
class Conteudo extends EntidadeDominio {
    
    private boolean assistido;
    private Avaliacao avaliacao;
    private Prioridade prioridade;
    private FicaTecnica fichaTecnica;

    public Conteudo(boolean assistido) {
        this.assistido = assistido;
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

    public Prioridade getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(Prioridade prioridade) {
        this.prioridade = prioridade;
    }

    public FicaTecnica getFichaTecnica() {
        return fichaTecnica;
    }

    public void setFichaTecnica(FicaTecnica fichaTecnica) {
        this.fichaTecnica = fichaTecnica;
    }
    
    
    
    
    
}
