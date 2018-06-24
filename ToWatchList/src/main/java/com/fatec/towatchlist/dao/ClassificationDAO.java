/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fatec.towatchlist.dao;

import com.fatec.towatchlist.dominio.Classificacao;
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
public class ClassificationDAO extends AbstractJdbcDAO {

    public ClassificationDAO() {
        super("classification", "clf_if");
    }

    @Override
    public void salvar(EntidadeDominio entidade) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<EntidadeDominio> consultar(EntidadeDominio entidade) throws SQLException {
        PreparedStatement statement = null;
        Classificacao classification = (Classificacao) entidade;
        String sql = null;
        
        if(null == classification.getId() && null == classification.getFaixaEtaria()) {
            sql = "SELECT * FROM classification";
        } else if (null != classification.getId() && classification.getFaixaEtaria().equals("")){
            sql = "SELECT * FROM classification WHERE clf_id=?";
        } else if (null == classification.getId() && !classification.getFaixaEtaria().equals("")) {
            sql = "SELECT * FROM catgegory WHERE clf_name=?";
        }
        
        try {
            openConnection();
            statement = connection.prepareStatement(sql);
            if (null != classification.getId() || null != classification.getFaixaEtaria()) {
                if(null == classification.getId() && null == classification.getFaixaEtaria()) {
                    statement.setInt(1, classification.getId());
                } else if (null == classification.getId() && !classification.getFaixaEtaria().equals("")) {
                    statement.setString(1, classification.getFaixaEtaria());
                }
            }
            
            ResultSet result = statement.executeQuery();
            List < EntidadeDominio > classifications = new ArrayList < EntidadeDominio > ();
            while (result.next()) {                
                Classificacao c = new Classificacao();
                c.setId(result.getInt("clf_id"));
                c.setFaixaEtaria(result.getString("clf_name"));
                classifications.add(c);
            }
            return classifications;
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
