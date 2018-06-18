/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fatec.towatchlist.command;

import com.fatec.towatchlist.aplicacao.Resultado;
import com.fatec.towatchlist.dominio.EntidadeDominio;

/**
 *
 * @author josev
 */
public class ConsultarCommand extends AbstractCommand {

    @Override
    public Resultado execute(EntidadeDominio entidade) {
        return facade.consult(entidade);
    }
    
}
