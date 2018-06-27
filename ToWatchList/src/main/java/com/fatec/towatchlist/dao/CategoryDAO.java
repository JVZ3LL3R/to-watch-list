/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fatec.towatchlist.dao;

import com.fatec.towatchlist.dominio.Categoria;
import com.fatec.towatchlist.dominio.EntidadeDominio;
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
public class CategoryDAO extends AbstractJdbcDAO {

    public CategoryDAO() {
        super("category", "cat_name");
    }

    @Override
    public void salvar(EntidadeDominio entidade) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<EntidadeDominio> listar(EntidadeDominio entidade) throws SQLException {
        PreparedStatement statement = null;
        Categoria category = (Categoria) entidade;
        String sql = null;
        
        if(null == category.getId() && null == category.getNome()) {
            sql = "SELECT * FROM category";
        } else if (null != category.getId() && category.getNome().equals("")){
            sql = "SELECT * FROM category WHERE cat_id=?";
        } else if (null == category.getId() && !category.getNome().equals("")) {
            sql = "SELECT * FROM catgegory WHERE cat_name=?";
        }
        
        try {
            openConnection();
            statement = connection.prepareStatement(sql);
            
            if (null != category.getId() && null != category.getNome()) {
                if(null != category.getId() && category.getNome().equals("")){
                    statement.setInt(1, category.getId());
                } else if (null == category.getId() && null == category.getNome()) {
                    statement.setString(1, category.getNome());
                }
            }
                
            
            ResultSet result = statement.executeQuery();
            List < EntidadeDominio > categories = new ArrayList < EntidadeDominio > ();
            while (result.next()) {                
                Categoria c = new Categoria();
                c.setId(result.getInt("cat_id"));
                c.setNome(result.getString("cat_name"));
                categories.add(c);
            }
            return categories;
        } catch (SQLException se) {
            se.printStackTrace();
        }
        return null;
    }

    @Override
    public void alterar(EntidadeDominio entidade) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public EntidadeDominio consultar(EntidadeDominio entidade) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
