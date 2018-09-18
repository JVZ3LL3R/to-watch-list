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
    private String confirmaSenha;
    private boolean status;
    private List < Conteudo > contentsToWacth;

    public Usuario() {
        
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

    public String getConfirmaSenha() {
        return confirmaSenha;
    }

    public void setConfirmaSenha(String confirmaSenha) {
        this.confirmaSenha = confirmaSenha;
    }
    
    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public List<Conteudo> getContentsToWacth() {
        return contentsToWacth;
    }

    public void setContentsToWacth(List<Conteudo> contentsToWacth) {
        this.contentsToWacth = contentsToWacth;
    }
}
