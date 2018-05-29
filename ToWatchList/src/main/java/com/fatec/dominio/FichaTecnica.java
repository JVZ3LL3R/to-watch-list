/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fatec.dominio;

import java.time.Duration;
import java.util.List;

/**
 *
 * @author josev
 */
class FichaTecnica {
    
    private Diretor diretor;
    private String nome;
    private String sinopse;
    private String paisOrigem;
    private Duration duracao;
    private ImagemCapa imgCapa;
    private Trailer trailer;
    private Classificacao classificacao;
    private List<Genero> genero;

    public FichaTecnica(Diretor diretor, String nome, String sinopse, String paisOrigem, Duration duracao, ImagemCapa imgCapa, Trailer trailer, Classificacao classificacao, List<Genero> genero) {
        this.diretor = diretor;
        this.nome = nome;
        this.sinopse = sinopse;
        this.paisOrigem = paisOrigem;
        this.duracao = duracao;
        this.imgCapa = imgCapa;
        this.trailer = trailer;
        this.classificacao = classificacao;
        this.genero = genero;
    }

    public Diretor getDiretor() {
        return diretor;
    }

    public void setDiretor(Diretor diretor) {
        this.diretor = diretor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSinopse() {
        return sinopse;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }

    public String getPaisOrigem() {
        return paisOrigem;
    }

    public void setPaisOrigem(String paisOrigem) {
        this.paisOrigem = paisOrigem;
    }

    public Duration getDuracao() {
        return duracao;
    }

    public void setDuracao(Duration duracao) {
        this.duracao = duracao;
    }

    public ImagemCapa getImgCapa() {
        return imgCapa;
    }

    public void setImgCapa(ImagemCapa imgCapa) {
        this.imgCapa = imgCapa;
    }

    public Trailer getTrailer() {
        return trailer;
    }

    public void setTrailer(Trailer trailer) {
        this.trailer = trailer;
    }

    public Classificacao getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(Classificacao classificacao) {
        this.classificacao = classificacao;
    }

    public List<Genero> getGenero() {
        return genero;
    }

    public void setGenero(List<Genero> genero) {
        this.genero = genero;
    }
  
    
    
}
