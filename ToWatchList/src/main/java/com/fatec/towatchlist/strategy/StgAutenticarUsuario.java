/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fatec.towatchlist.strategy;

import com.fatec.towatchlist.dao.AutenticarUsuario;
import com.fatec.towatchlist.dominio.EntidadeDominio;
import com.fatec.towatchlist.dominio.Usuario;
import com.towatchlist.fatec.util.Util;

/**
 *
 * @author josev
 */
public class StgAutenticarUsuario implements IStrategy {

    @Override
    public String processar(EntidadeDominio entidade) {
        Usuario user = (Usuario) entidade;
        AutenticarUsuario auth = new AutenticarUsuario();
        Boolean authentication = auth.autenticar(user.getEmail(), user.getSenha());
        if(!authentication)
            return Util.USER_LOGIN_ERROR;
        
        return null;
        
    }
    
}
