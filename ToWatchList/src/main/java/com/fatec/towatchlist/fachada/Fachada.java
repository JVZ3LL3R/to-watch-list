/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fatec.towatchlist.fachada;

import com.fatec.towatchlist.aplicacao.Resultado;
import com.fatec.towatchlist.dao.CategoryDAO;
import com.fatec.towatchlist.dao.ClassificationDAO;
import com.fatec.towatchlist.dao.ContentDAO;
import com.fatec.towatchlist.dao.GenreDAO;
import com.fatec.towatchlist.dao.IDAO;
import com.fatec.towatchlist.dao.UserDAO;
import com.fatec.towatchlist.dominio.Categoria;
import com.fatec.towatchlist.dominio.Classificacao;
import com.fatec.towatchlist.dominio.Conteudo;
import com.fatec.towatchlist.dominio.EntidadeDominio;
import com.fatec.towatchlist.dominio.Genero;
import com.fatec.towatchlist.dominio.Usuario;
import com.fatec.towatchlist.strategy.IStrategy;
import com.fatec.towatchlist.strategy.StgAutenticarUsuario;
import com.fatec.towatchlist.strategy.StgComplementarDtCadastro;
import com.fatec.towatchlist.strategy.StgValidarCadastroUsuario;
import com.towatchlist.fatec.util.Util;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author josev
 */
public class Fachada implements IFachada {

    /*
    * Mapa de regras de negócio (Strategies) indexado pelo nome da Entidade Domínio
    * cujo valor para cada índice é a lista de regras de negóciO correspondente
    * de cada Entidade.
    */
    private Map< String, Map < String, List < IStrategy > > > regrasNegocio;
    
    /*
    * Mapa de DAOS, indexado pelo nome da Entidade Domínio
    * cujo valor para cada índice é o DAO correspondente
    * de cada Entidade.
    */
    private Map< String, IDAO > daos;
    
    public Fachada () {
        // Inicialização dos Mapas de Regras de Negócio e DAOs
        regrasNegocio = new HashMap< String, Map< String, List< IStrategy > > > ();
        daos = new HashMap< String, IDAO > ();
        
        // Instânciando os DAOs para popular o mapa de DAOs
        //
        // ------------------------- USUÁRIO ----------------------------- //
        UserDAO userDao = new UserDAO();
        ContentDAO contentDao = new ContentDAO();
        CategoryDAO categoryDao = new CategoryDAO();
        GenreDAO genreDao = new GenreDAO();
        ClassificationDAO classificationDao = new ClassificationDAO();
        
        // ------------------------- CONTEÚDO ----------------------------- //
        
        
        // Populando mapa de DAOs para cada Entidade
        //
        // Populando Mapa com DAO do usuário
        daos.put(Usuario.class.getName(), userDao);
        // Populando Mapa com DAO de conteúdo
        daos.put(Conteudo.class.getName(), contentDao);
        // Populando Mapa com DAO de categoria
        daos.put(Categoria.class.getName(), categoryDao);
        // Populando Mapa com DAO de gênero
        daos.put(Genero.class.getName(), genreDao);
        // Populando Mapa com DAO de classificacao
        daos.put(Classificacao.class.getName(), classificationDao);
        
        // Istânciando Strategies para popular o mapa de strategies
        StgComplementarDtCadastro compDtCadastro = new StgComplementarDtCadastro();
        StgValidarCadastroUsuario vrUserRegister = new StgValidarCadastroUsuario();
        StgAutenticarUsuario vrAuthentication = new StgAutenticarUsuario();
        
        // Criando listas de Strategies para adicionar ao mapa de Strategies de acordo com a ação requerida
        //
        // ------------------------- USUÁRIO ----------------------------- //
        // SALVAR 
        List <IStrategy > rnsNegocioSalvarUsuario = new ArrayList<IStrategy>();
        rnsNegocioSalvarUsuario.add(compDtCadastro);
        rnsNegocioSalvarUsuario.add(vrUserRegister);
        
        // Alterar
        List <IStrategy > rnsNegocioAlterarUsuario = new ArrayList<IStrategy>();
        
        // Consultar
        List <IStrategy > rnsNegocioConsultarUsuario = new ArrayList<IStrategy>();
        rnsNegocioConsultarUsuario.add(vrAuthentication);
        
        // Excluir
        List <IStrategy > rnsNegocioExcluirUsuario = new ArrayList<IStrategy>();
        
        // ------------------------- CONTEÚDO ----------------------------- //
        // SALVAR
        List <IStrategy > rnsNegocioSalvarConteudo = new ArrayList<IStrategy>();
        rnsNegocioSalvarConteudo.add(compDtCadastro);
        
        // Alterar
        List <IStrategy > rnsNegocioAlterarConteudo = new ArrayList<IStrategy>();
        
        // Consultar
        List <IStrategy > rnsNegocioConsultarConteudo = new ArrayList<IStrategy>();
        
        // Excluir
        List <IStrategy > rnsNegocioExcluirConteudo = new ArrayList<IStrategy>();
        
        // Criando e populando Mapa para conter as listas com as regras de negócios necessárias
        // para cada entidade dependendo da ação requerida
        //
        // Criando Mapas...
        Map< String, List< IStrategy > > rnsUsuario = new HashMap < String, List< IStrategy > >();
        Map< String, List< IStrategy > > rnsConteudo = new HashMap < String, List< IStrategy > >();
        
        // Populando Mapa do Usuário
        rnsUsuario.put("SALVAR", rnsNegocioSalvarUsuario);
        rnsUsuario.put("ALTERAR", rnsNegocioAlterarUsuario);
        rnsUsuario.put("CONSULTAR", rnsNegocioConsultarUsuario);
        rnsUsuario.put("EXCLUIR", rnsNegocioExcluirUsuario);
        
        // Populando Mapa do Conteudo
        rnsConteudo.put("SALVAR", rnsNegocioSalvarConteudo);
        rnsConteudo.put("ALTERAR", rnsNegocioAlterarConteudo);
        rnsConteudo.put("CONSULTAR", rnsNegocioConsultarConteudo);
        rnsConteudo.put("EXCLUIR", rnsNegocioExcluirConteudo);
        
        // Por fim populando o Mapa geral de Regra de negócios
        // que é indexado pelo nome da entidade e retorna como
        // valor a lista de strategies para validação das entidades
        regrasNegocio.put(Usuario.class.getName(), rnsUsuario);
        regrasNegocio.put(Conteudo.class.getName(), rnsConteudo);
        
    }
    @Override
    public Resultado save(EntidadeDominio entidade) {
        Resultado result = new Resultado();
        String className = entidade.getClass().getName();
        String msgResult = executarRegras(entidade, Util.ACTION_SAVE);
        
        if (null == msgResult) {
            IDAO dao = daos.get(className);
            try {
                dao.salvar(entidade);
                List< EntidadeDominio > entidades = new ArrayList< EntidadeDominio > ();
                entidades.add(entidade);
                result.setEntidadesDominio(entidades);
            } catch (SQLException ex) {
                ex.printStackTrace();
                result.setMsg(Util.ERROR_SAVE);
            }
        } else
            result.setMsg(msgResult);
        
        return result;
    }

    @Override
    public Resultado delete(EntidadeDominio entidade) {
        Resultado result = new Resultado();
        String className = entidade.getClass().getName();
        String msgResult = executarRegras(entidade, Util.ACTION_DELETE);
        
        if (null == msgResult) {
            IDAO dao = daos.get(className);
            try {
                dao.excluir(entidade);
                List< EntidadeDominio > entidades = new ArrayList< EntidadeDominio > ();
                entidades.add(entidade);
                result.setEntidadesDominio(entidades);
            } catch (SQLException ex) {
                ex.printStackTrace();
                result.setMsg(Util.ERROR_DELETE);
            }
        } else
            result.setMsg(msgResult);
        
        return result;
    }

    @Override
    public Resultado edit(EntidadeDominio entidade) {
        Resultado result = new Resultado();
        String className = entidade.getClass().getName();
        String msgResult = executarRegras(entidade, Util.ACTION_EDIT);
        
        if (null == msgResult) {
            IDAO dao = daos.get(className);
            try {
                dao.alterar(entidade);
                List< EntidadeDominio > entidades = new ArrayList< EntidadeDominio > ();
                entidades.add(entidade);
                result.setEntidadesDominio(entidades);
            } catch (SQLException ex) {
                ex.printStackTrace();
                result.setMsg(Util.ERROR_EDIT);
            }
        } else
            result.setMsg(msgResult);
        
        return result;
    }

    @Override
    public Resultado consult(EntidadeDominio entidade) {
        Resultado result = new Resultado();
        String className = entidade.getClass().getName();
        String msgResult = executarRegras(entidade, Util.ACTION_CONSULT);
        
        if (null == msgResult) {
            IDAO dao = daos.get(className);
            try {
                List < EntidadeDominio > entidades = new ArrayList < EntidadeDominio > ();
                entidades = dao.listar(entidade);
                result.setEntidadesDominio(entidades);
            } catch (SQLException ex) {
                ex.printStackTrace();
                result.setMsg(Util.ERROR_LIST);
            }
        } else
            result.setMsg(msgResult);
        
        return result;
    }
    
    private String executarRegras(EntidadeDominio entidade, String action) {
        String className = entidade.getClass().getName();
        StringBuilder sbMsg = new StringBuilder();
        Map<String, List < IStrategy > > validacoesOperacao = regrasNegocio.get(className);
        
        if (null != validacoesOperacao) {
            List< IStrategy > validacoes = validacoesOperacao.get(action);
            
            if (null != validacoes) {
                for(IStrategy strategy : validacoes) {
                    String msgvalidacoes = strategy.processar(entidade);
                    
                    if (null != msgvalidacoes) {
                        sbMsg.append(msgvalidacoes);
                        sbMsg.append("\n");
                    }
                }
            }
        } 
        if (sbMsg.length() > 0)
            return sbMsg.toString();
        else
            return null;
    }
    
}
