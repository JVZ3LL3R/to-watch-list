/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fatec.towatchlist.dao;

import com.fatec.towatchlist.dominio.Avaliacao;
import com.fatec.towatchlist.dominio.Categoria;
import com.fatec.towatchlist.dominio.Classificacao;
import com.fatec.towatchlist.dominio.Conteudo;
import com.fatec.towatchlist.dominio.Diretor;
import com.fatec.towatchlist.dominio.EntidadeDominio;
import com.fatec.towatchlist.dominio.FichaTecnica;
import com.fatec.towatchlist.dominio.Genero;
import com.fatec.towatchlist.dominio.ImagemCapa;
import com.fatec.towatchlist.dominio.Trailer;
import com.towatchlist.fatec.util.Util;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.text.AbstractDocument.Content;

/**
 *
 * @author josev
 */
public class ContentDAO  extends AbstractJdbcDAO {
    
    public ContentDAO () {
        super("content", "cont_id" );
    }

    @Override
    public void salvar(EntidadeDominio entidade){
        openConnection();
        PreparedStatement statement = null;
        Conteudo content = (Conteudo) entidade;
        
        try {
            connection.setAutoCommit(Util.SQL_AUTO_COMMIT_FALSE);
            StringBuilder sql = new StringBuilder();
            sql.append("INSERT INTO ");
            sql.append(super.table);
            sql.append(" (cont_name, cont_overview, cont_country, ");
            sql.append("cont_duration, cont_poster, cont_trailer, ");
            sql.append("cont_rating, cont_dir, cont_watched, ");
            sql.append("cont_dt_cad, cont_clf_id, cont_cat_id)");
            sql.append(" VALUES (?,?,?,?,?,?,?,?,?,?,?,?)");
            
            statement = connection.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, content.getFichaTecnica().getNome());
            statement.setString(2, content.getFichaTecnica().getSinopse());
            statement.setString(3, content.getFichaTecnica().getPaisOrigem());
            statement.setString(4, content.getFichaTecnica().getDuracao());
            statement.setString(5, content.getFichaTecnica().getImgCapa().getPath());
            statement.setString(6, content.getFichaTecnica().getTrailer().getUrl());
            statement.setString(7, String.valueOf(content.getAvaliacao().getNota()));
            statement.setString(8, content.getFichaTecnica().getDiretor().getNome());
            statement.setBoolean(9, content.isAssistido() );
            Timestamp time = new Timestamp(content.getData().getTime());
            statement.setTimestamp(10, time);
            statement.setInt(11, content.getFichaTecnica().getClassificacao().getId());
            statement.setInt(12, content.getCategoria().getId() );
            
            statement.executeUpdate();
            ResultSet resultSet = statement.getGeneratedKeys();
            
            int id = 0;
            if (resultSet.next())
                id = resultSet.getInt(Util.ENTITY_ID);
            content.setId(id);
            
            for(Genero genres : content.getFichaTecnica().getGenero() ) {
                String genreSql = "INSERT INTO genre_content (gcont_gen_id, gcont_cont_id) VALUES(?,?)";
                statement = connection.prepareStatement(genreSql);
                statement.setInt(1, genres.getId());
                statement.setInt(2, content.getId());
                statement.executeUpdate();
            }
            
            String userList = "INSERT INTO user_list (usrl_usr_id, usrl_cont_id) VALUES (?,?)";
            statement = connection.prepareStatement(userList);
            statement.setInt(1, content.getUserID());
            statement.setInt(2, content.getId());
            statement.executeUpdate();
            
            connection.commit();
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException esql) {
                esql.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            try {
                statement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public List<EntidadeDominio> listar(EntidadeDominio entidade){
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void alterar(EntidadeDominio entidade){
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public EntidadeDominio consultar(EntidadeDominio entidade){
        PreparedStatement statement = null;
        openConnection();
        Conteudo content = ( Conteudo ) entidade;
        String sql = null;
        
        if (null != content.getId()) {
            sql  = "SELECT * FROM content WHERE cont_id=?";
        } else if (null != content.getFichaTecnica().getNome()){
            sql = "SELECT * FROM content WHERE cont_name=?";
        } 
        
           // TODO:
          // implemt other methods to list the contents ....
          
        try {
            connection.setAutoCommit(Util.SQL_AUTO_COMMIT_FALSE);
            statement = connection.prepareStatement(sql);
            
            if(null != content.getId()) {
                statement.setInt(1, content.getId());
            } else if (null != content.getFichaTecnica().getNome()) {
                statement.setString(1, content.getFichaTecnica().getNome());
            }
            
            ResultSet resultSet = statement.executeQuery();
            Conteudo cont = null;
            while(resultSet.next()) {
                Conteudo c = new Conteudo();
                FichaTecnica fichaTecnica = new FichaTecnica();
                Avaliacao rating = new Avaliacao();
                Classificacao classification = new Classificacao();
                Diretor director = new Diretor();
                ImagemCapa poster = new ImagemCapa();
                Trailer trailer = new Trailer();
                Categoria category = new Categoria();

                c.setId(resultSet.getInt(Util.ENTITY_ID));
                fichaTecnica.setNome(resultSet.getString(2));
                fichaTecnica.setSinopse(resultSet.getString(3));
                fichaTecnica.setPaisOrigem(resultSet.getString(4));
                fichaTecnica.setDuracao(resultSet.getString(5));

                poster.setPath(resultSet.getString(6));

                trailer.setUrl(resultSet.getString(7));

                rating.setDescAvaliacao("");
                rating.setNota(Double.parseDouble( resultSet.getString(8) ) );

                director.setNome(resultSet.getString(9));

                c.setAssistido(resultSet.getBoolean(10));
                java.sql.Date dtSql = resultSet.getDate(11);
                Date dtCad = new Date(dtSql.getTime());
                c.setData(dtCad);

                classification.setId(resultSet.getInt(12));

                category.setId(resultSet.getInt(13));

                fichaTecnica.setDiretor(director);
                fichaTecnica.setImgCapa(poster);
                fichaTecnica.setTrailer(trailer);
                fichaTecnica.setClassificacao(classification);

                c.setAvaliacao(rating);
                c.setCategoria(category);
                c.setFichaTecnica(fichaTecnica);
                c.setAvaliacao(rating);
                c.setUserID(content.getUserID());

                sql = "SELECT * FROM genre_content WHERE gcont_cont_id=?";
                statement = connection.prepareStatement(sql);
                if (null != c.getId()) {
                    statement.setInt(1, c.getId());

                    ResultSet resultSetGenre = statement.executeQuery();
                    List < Genero > genres = new ArrayList < Genero > ();
                    while(resultSetGenre.next()) {
                        Genero g = new Genero();
                        g.setId(resultSetGenre.getInt(1));
                        genres.add(g);
                    }
                    c.getFichaTecnica().setGenero(genres);
                }

                cont = c;
            }
            return cont;
        } catch (SQLException se) {
            se.printStackTrace();
        }
        return null;
    }
    
    @Override
    public void excluir (EntidadeDominio entidade) {
        openConnection();
            PreparedStatement statement = null;		
            String sqlCont = "DELETE FROM content WHERE cont_id=?";
            String sqlGenre = "DELETE FROM genre_content WHERE gcont_cont_id=?";
            String sqlList = "DELETE FROM user_list WHERE usrl_cont_id=?";
            
            try {
                connection.setAutoCommit(false);
                statement = connection.prepareStatement(sqlList);
                statement.setInt(1, entidade.getId());
                statement.executeUpdate();
                
                statement = connection.prepareStatement(sqlGenre);
                statement.setInt(1, entidade.getId());
                statement.executeUpdate();
                
                statement = connection.prepareStatement(sqlCont);
                statement.setInt(1, entidade.getId());
                statement.executeUpdate();
                
                connection.commit();
            } catch (SQLException e) {
                try {
                        connection.rollback();
                } catch (SQLException e1) {
                        e1.printStackTrace();
                }
                e.printStackTrace();			
            }finally{
                try {
                    statement.close();
                    if(controlTransaction)
                        connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }		
    }
}
