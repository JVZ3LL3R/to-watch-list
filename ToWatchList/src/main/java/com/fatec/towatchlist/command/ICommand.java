/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fatec.towatchlist.command;

import com.fatec.towatchlist.dominio.EntidadeDominio;

/**
 *
 * @author josev
 */
public interface ICommand {
    
    public String executar (EntidadeDominio entidadeDominio);
    
}
