/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fatec.towatchlist.viewhelper;

import com.fatec.towatchlist.dominio.EntidadeDominio;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author josev
 */
public interface IViewHelper {
    
    public EntidadeDominio getEntidade (HttpServletRequest request);
    
    public void setEntidade (EntidadeDominio entidade, HttpServletResponse response);
    
}
