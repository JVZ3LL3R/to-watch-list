/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fatec.dominio;

import com.fatec.util.Util;
import java.util.List;

/**
 *
 * @author josev
 */
public class Usuario extends Pessoa {
    
    private String apelido;
    private String email;
    private String senha;
    private boolean status;
    private List <Categoria> categorias;
    private Favoritos favoritos;

    public Usuario(String apelido, String email, String senha, boolean status, String nome) {
        super(nome);
        this.apelido = apelido;
        this.email = email;
        this.senha = senha;
        this.status = status;
        
        // Add the tree default categories to the each User of the system
        categorias.add(new Categoria(Util.CATEGORIA1, Util.DESCRICAO_CATEGORIA1));
        categorias.add(new Categoria(Util.CATEGORIA2, Util.DESCRICAO_CATEGORIA2));
        categorias.add(new Categoria(Util.CATEGORIA3, Util.DESCRICAO_CATEGORIA3));
    }

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public List<Categoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<Categoria> categorias) {
        this.categorias = categorias;
    }

    public Favoritos getFavoritos() {
        return favoritos;
    }

    public void setFavoritos(Favoritos favoritos) {
        this.favoritos = favoritos;
    }
}
