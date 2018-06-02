/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fatec.towatchlist.viewhelper.user;

import com.fatec.towatchlist.dominio.Avaliacao;
import com.fatec.towatchlist.dominio.EntidadeDominio;
import com.fatec.towatchlist.viewhelper.IViewHelper;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.fatec.towatchlist.dominio.Conteudo;
import com.fatec.towatchlist.dominio.FichaTecnica;

/**
 *
 * @author josev
 */
public class saveUserViewHelper implements IViewHelper {

    @Override
    public EntidadeDominio getEntidade(HttpServletRequest request) {
        Conteudo conteudo = new Conteudo();
        FichaTecnica fichaTecnica = new FichaTecnica();
        Avaliacao avaliacao = new Avaliacao();
        
        return conteudo;
    }

    @Override
    public void setEntidade(EntidadeDominio entidade, HttpServletResponse response) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
