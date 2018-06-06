/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fatec.towatchlist.controller;

import com.fatec.towatchlist.command.AlterarCommand;
import com.fatec.towatchlist.command.ConsultarCommand;
import com.fatec.towatchlist.command.ExcluirCommand;
import com.fatec.towatchlist.command.ICommand;
import com.fatec.towatchlist.command.SalvarCommand;
import com.fatec.towatchlist.viewhelper.IViewHelper;
import com.fatec.towatchlist.viewhelper.content.ContentViewHelper;
import com.fatec.towatchlist.viewhelper.user.UserViewHelper;
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

public class toWatchListServlet extends HttpServlet {
    
    private Map<String, ICommand> commands;
    private Map<String, IViewHelper> viewHelpers;
    
    public toWatchListServlet () {
        String basePath = "/ToWatchList/";
        
        // Inicializando mapa de commands
        commands = new HashMap<String, ICommand>();
        commands.put("SALVAR", new SalvarCommand());
        commands.put("ALTERAR", new AlterarCommand());
        commands.put("CONSULTAR", new ConsultarCommand());
        commands.put("EXCLUIR", new ExcluirCommand());
        
        // Inicializando mapa de viewHelpers
        viewHelpers = new HashMap<String, IViewHelper>();
        viewHelpers.put(basePath.concat("user/save"), new UserViewHelper());
        viewHelpers.put(basePath.concat("registerContent/save"), new ContentViewHelper());
        
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
    }
    
}
