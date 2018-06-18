/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fatec.towatchlist.viewhelper.user;

import com.fatec.towatchlist.aplicacao.Resultado;
import com.fatec.towatchlist.dominio.EntidadeDominio;
import com.fatec.towatchlist.dominio.Usuario;
import com.fatec.towatchlist.viewhelper.IViewHelper;
import com.towatchlist.fatec.util.Util;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author josev
 */
public class UserViewHelper implements IViewHelper {
    
    @Override
    public EntidadeDominio getEntidade(HttpServletRequest request) {
        String name = request.getParameter("nomeUsr");
        String nickname = request.getParameter("apelidoUsr");
        String email = request.getParameter("emailUsr");
        String password = request.getParameter("senhaUsr");
        String id = request.getParameter("txtId");
        
        // Constrói objeto Usuaário
        Usuario usuario = new Usuario();
        usuario.setNome(name);
        usuario.setNomeUsuario(nickname);
        usuario.setEmail(email);
        usuario.setSenha(password);
        
        if (null != id && !id.trim().equals(""))
            usuario.setId(Integer.parseInt(id));
            
        return usuario;
    }

    /**
     *
     * @param result
     * @param request
     * @param response
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void setView(Resultado result, HttpServletRequest request ,HttpServletResponse response) throws IOException, ServletException {
        String action = request.getParameter(Util.ACTION_PARAMETER);
        //RequestDispatcher dispatcher = null;
        
        if (null == result.getMsg()) {
            if (action.equals(Util.ACTION_SAVE)) {
                result.setMsg(Util.SUCCESSFULL_USER_SAVE);
                request.getSession().setAttribute("resultado", result);
                response.sendRedirect("/ToWatchList/content/content.jsp");
                
            } else if (action.equals(Util.ACTION_LOGIN) ) {
                result.setMsg(Util.USER_LOGIN_SUCCESSFULL);
                request.getSession().setAttribute(Util.USER_LOGIN_LOG, result);
                response.sendRedirect("/ToWatchList/content/content.jsp");
            }
            else {
                request.getRequestDispatcher("/login.jsp").forward(request, response);
            }
        }
        
    }
    
    
}
