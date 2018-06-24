/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fatec.towatchlist.dao;

import com.fatec.towatchlist.dominio.EntidadeDominio;
import com.fatec.towatchlist.dominio.Genero;
import com.towatchlist.fatec.util.Util;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author josev
 */
public class GenreDAO extends AbstractJdbcDAO {
    public GenreDAO (){
        super("genre", "gen_id");
    }

    @Override
    public void salvar(EntidadeDominio entidade) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<EntidadeDominio> consultar(EntidadeDominio entidade) throws SQLException {
        PreparedStatement statement = null;
        Genero genre = (Genero) entidade;
        String sql = null;
        
        if(null == genre.getId() && null == genre.getNomeGenero()) {
            sql = "SELECT * FROM genre";
        } else if (null != genre.getId() && genre.getNomeGenero().equals("")){
            sql = "SELECT * FROM genre WHERE gen_id=?";
        } else if (null == genre.getId() && !genre.getNomeGenero().equals("")) {
            sql = "SELECT * FROM genre WHERE gen_name=?";
        }
        
        try {
            openConnection();
            statement = connection.prepareStatement(sql);
            
            if (null != genre.getId() || null != genre.getNomeGenero()) {
                if(null != genre.getId() && genre.getNomeGenero().equals("")){
                    statement.setInt(1, genre.getId());
                } else if (null == genre.getId() && !genre.getNomeGenero().equals("")) {
                    statement.setString(1, genre.getNomeGenero());
                }
            }
            
            ResultSet result = statement.executeQuery();
            List < EntidadeDominio > genres = new ArrayList < EntidadeDominio > ();
            while (result.next()) {                
                Genero g = new Genero();
                g.setId(result.getInt("gen_id"));
                g.setNomeGenero(result.getString("gen_name"));
                genres.add(g);
            }
            return genres;
        } catch (SQLException se) {
            se.printStackTrace();
            throw new UnsupportedOperationException(Util.ERROR_LIST);
        }
    }

    @Override
    public void alterar(EntidadeDominio entidade) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
