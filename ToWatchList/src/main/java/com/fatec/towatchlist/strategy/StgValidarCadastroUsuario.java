/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fatec.towatchlist.strategy;

import com.fatec.towatchlist.dominio.EntidadeDominio;
import com.fatec.towatchlist.dominio.Usuario;
import com.towatchlist.fatec.util.Util;

/**
 *
 * @author josev
 */
public class StgValidarCadastroUsuario implements IStrategy{

    @Override
    public String processar(EntidadeDominio entidade) {
        
        if(entidade instanceof Usuario) {
            
            Usuario usuario = (Usuario) entidade;
            
            if (null == usuario.getNome() )
                return Util.ENTITY + usuario.getClass().getCanonicalName() + Util.NULL_ENTITY;
            if (null == usuario.getNome())
                return Util.USER_NAME_ERROR;
            if (null == usuario.getNomeUsuario() )
                return Util.USER_NICKNAME_ERROR;
            if (null == usuario.getEmail())
                return Util.USER_EMAIL_ERROR;
            if (null == usuario.getSenha() || usuario.getSenha().length() < 5 || usuario.getSenha().length() > 16 )
                return Util.USER_PASSWORD_ERROR;
        }
        return null;
    }
}
