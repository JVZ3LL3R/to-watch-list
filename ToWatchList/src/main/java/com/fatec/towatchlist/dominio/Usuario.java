/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fatec.towatchlist.dominio;

import com.towatchlist.fatec.util.Util;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author josev
 */
public class Usuario extends Pessoa {
    
    private String nomeUsuario;
    private String email;
    private String senha;
    private boolean status;
    private List <Categoria> categorias;
    private Favoritos favoritos;

    public Usuario() {
        
        categorias = new ArrayList< Categoria>();
        
        // Add the tree default categories to the each User of the system
        categorias.add(new Categoria(Util.CATEGORY1, Util.CATEGORY_DESCRIPTION1));
        categorias.add(new Categoria(Util.CATEGORY2, Util.CATEGORY_DESCRIPTION2));
        categorias.add(new Categoria(Util.CATEGORY3, Util.CATEGORY_DESCRIPTION3));
    }



    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
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
