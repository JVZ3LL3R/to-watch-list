/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fatec.towatchlist.command;

import com.fatec.towatchlist.fachada.Fachada;
import com.fatec.towatchlist.fachada.IFachada;

/**
 *
 * @author josev
 */
abstract class AbstractCommand implements ICommand {
    
    protected IFachada facade = new Fachada();
    
}
