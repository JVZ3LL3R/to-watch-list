/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fatec.towatchlist.strategy;

import com.fatec.towatchlist.dao.ContentDAO;
import com.fatec.towatchlist.dao.IDAO;
import com.fatec.towatchlist.dominio.EntidadeDominio;
import com.towatchlist.fatec.util.Util;

/**
 *
 * @author josev
 */
public class StgValidarExistenciaConteudo implements IStrategy {

    @Override
    public String processar(EntidadeDominio entidade) {
        if(null != entidade){
            IDAO content = new ContentDAO();
            try {
             EntidadeDominio ed = content.consultar(entidade);
             if (null != ed){
                 return "O Conteúdo já está Cadastrado!!!";
             }
            } catch (Exception e) {
                e.printStackTrace();
                return Util.ERROR_LIST;
            }
        } else if (null == entidade){
            return Util.ENTITY + entidade.getClass().getCanonicalName() + Util.NULL_ENTITY;
        }
        return null;
    }
    
}
