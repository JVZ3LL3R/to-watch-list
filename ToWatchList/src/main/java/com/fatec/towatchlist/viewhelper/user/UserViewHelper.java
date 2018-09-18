/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fatec.towatchlist.viewhelper.user;

import com.fatec.towatchlist.aplicacao.Resultado;
import com.fatec.towatchlist.dao.CategoryDAO;
import com.fatec.towatchlist.dao.ClassificationDAO;
import com.fatec.towatchlist.dao.GenreDAO;
import com.fatec.towatchlist.dao.IDAO;
import com.fatec.towatchlist.dominio.Categoria;
import com.fatec.towatchlist.dominio.Classificacao;
import com.fatec.towatchlist.dominio.EntidadeDominio;
import com.fatec.towatchlist.dominio.Genero;
import com.fatec.towatchlist.dominio.Usuario;
import com.fatec.towatchlist.viewhelper.IViewHelper;
import com.towatchlist.fatec.util.Util;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
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
        if(null != email) {
            usuario.setEmail(email);
        } else {
            usuario.setEmail("");
        }
        if (null!= password) {
            usuario.setSenha(password); 
        } else {
            usuario.setSenha(""); 
        }
        
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
        RequestDispatcher dispatcher = null;
        request.getSession().removeAttribute("msgResult");
        if (null == result.getMsg()) {
            if (action.equals(Util.ACTION_SAVE)) {
                request.getSession().setAttribute("result", result);
                dispatcher = request.getRequestDispatcher("/content/content.jsp");
                //response.sendRedirect("/ToWatchList/content/content.jsp");
                
            } else if (action.equals(Util.ACTION_LOGIN) ) {
                request.getSession().setAttribute("result", result);
                dispatcher = request.getRequestDispatcher("/content/content.jsp");
                //response.sendRedirect("/ToWatchList/content/content.jsp");
            }
        } else {
                request.getSession().setAttribute("result", result);
                if(action == Util.ACTION_SAVE){
                    dispatcher = request.getRequestDispatcher("/user/registerUser.jsp"); 
                } else {
                    request.getSession().setAttribute("msgResult", result.getMsg());
                    dispatcher = request.getRequestDispatcher("/user/login.jsp"); 
                }
            }
        
        dispatcher.forward(request, response);
    }
}
