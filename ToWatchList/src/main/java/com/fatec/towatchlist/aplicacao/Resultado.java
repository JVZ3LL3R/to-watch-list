/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fatec.towatchlist.aplicacao;

import com.fatec.towatchlist.dominio.EntidadeDominio;
import java.util.List;

/**
 *
 * @author josev
 */
public class Resultado extends EntidadeAplicacao {
    
    private String msg;
    private List < EntidadeDominio > entidadesDominio;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<EntidadeDominio> getEntidadesDominio() {
        return entidadesDominio;
    }

    public void setEntidadesDominio(List<EntidadeDominio> entidadesDominio) {
        this.entidadesDominio = entidadesDominio;
    }
    
}
