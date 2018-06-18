/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fatec.towatchlist.fachada;

import com.fatec.towatchlist.aplicacao.Resultado;
import com.fatec.towatchlist.dominio.EntidadeDominio;

/**
 *
 * @author josev
 */
public interface IFachada {
    
    public Resultado save (EntidadeDominio entidade);
    public Resultado delete (EntidadeDominio entidade);
    public Resultado edit (EntidadeDominio entidade);
    public Resultado consult (EntidadeDominio entidade);
    
}
