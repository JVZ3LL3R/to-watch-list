/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fatec.towatchlist.controller;

import com.fatec.towatchlist.aplicacao.Resultado;
import com.fatec.towatchlist.command.AlterarCommand;
import com.fatec.towatchlist.command.ConsultarCommand;
import com.fatec.towatchlist.command.ExcluirCommand;
import com.fatec.towatchlist.command.ICommand;
import com.fatec.towatchlist.command.SalvarCommand;
import com.fatec.towatchlist.dominio.EntidadeDominio;
import com.fatec.towatchlist.viewhelper.IViewHelper;
import com.fatec.towatchlist.viewhelper.content.ContentViewHelper;
import com.fatec.towatchlist.viewhelper.user.UserViewHelper;
import com.towatchlist.fatec.util.Util;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author josev
 */

@WebServlet(
        name = "Servlet",
        urlPatterns = {"/SaveUser",
                       "/Login",
                       "/SaveContent",
                       "/LoadContent",
                       "/DeleteContent"}
        )
    

public class Servlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private Map<String, ICommand> commands;
    private Map<String, IViewHelper> viewHelpers;
    
    public Servlet () {
        String basePath = "/ToWatchList/";
        
        // Inicializando mapa de commands
        commands = new HashMap<String, ICommand>();
        commands.put("SALVAR", new SalvarCommand());
        commands.put("ALTERAR", new AlterarCommand());
        commands.put("CONSULTAR", new ConsultarCommand());
        commands.put("EXCLUIR", new ExcluirCommand());
        
        // Inicializando mapa de viewHelpers
        viewHelpers = new HashMap<String, IViewHelper>();
        viewHelpers.put(basePath.concat("user/SaveUser"), new UserViewHelper());
        viewHelpers.put(basePath.concat("user/Login"), new UserViewHelper());
        viewHelpers.put(basePath.concat("content/SaveContent"), new ContentViewHelper());
        viewHelpers.put(basePath.concat("user/DeleteContent"),new ContentViewHelper());
        viewHelpers.put(basePath.concat("content/DeleteContent"),new ContentViewHelper());
        
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,
    		IOException {
    	doProcessRequest(request, response);
    }

    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

            doProcessRequest(request, response);
    }
    
    protected void doProcessRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        // Obtém a URI que invocou a servlet
        String uri = req.getRequestURI();
        
        // Obtém o viewHelper de acordo com a uri no mapa de viewHelpers
        IViewHelper vh = viewHelpers.get(uri);
        
        // ViewHelper retorna a entidade após monta-la com os dados que chegou pela requisição
        EntidadeDominio entidade = vh.getEntidade(req);
        
        // Obtém qual é a operação a ser executada
        String action = req.getParameter(Util.ACTION_PARAMETER);
        if(action.equals("LOGIN"))
            action = Util.ACTION_CONSULT;
        
        // Obtém o command para a operação requisitada
        ICommand command = commands.get(action);
        
        // Executa o método "execute" do command que retorna um Resultado que pode ou não conter erros,
        // Além da lista de entidades envolvidas na operação
        Resultado result = command.execute(entidade);
        
        // Executa o método "setView" para apresentar devidamente o retorno para o usuário
        vh.setView(result, req, resp);
        
    }
    
}
