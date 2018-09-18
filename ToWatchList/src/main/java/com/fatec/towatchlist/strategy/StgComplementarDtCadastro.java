/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fatec.towatchlist.strategy;

import com.fatec.towatchlist.dominio.EntidadeDominio;
import com.towatchlist.fatec.util.Util;
import java.util.Date;

/**
 *
 * @author josev
 */
public class StgComplementarDtCadastro implements IStrategy {

    @Override
    public String processar(EntidadeDominio entidade) {
        if (null != entidade)
        {
            Date data = new Date();
            entidade.setData(data);
        } else {
            return Util.ENTITY + entidade.getClass().getCanonicalName() + Util.NULL_ENTITY;
        }
        
        return null;
    }
    
}
