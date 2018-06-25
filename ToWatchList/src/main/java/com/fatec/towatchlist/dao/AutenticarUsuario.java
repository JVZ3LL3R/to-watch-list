/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fatec.towatchlist.dao;

import com.fatec.towatchlist.dominio.EntidadeDominio;
import com.towatchlist.fatec.util.Util;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author josev
 */
public class AutenticarUsuario extends AbstractJdbcDAO {

    public AutenticarUsuario () {
        super("user", "usr_id");
    }
    
    public boolean autenticar (String credential, String password) {
        openConnection();
        PreparedStatement statement = null;
        StringBuilder sql = new StringBuilder();
        boolean authentication = false;
        
        try {
            connection.setAutoCommit(Util.SQL_AUTO_COMMIT_FALSE);
            sql.append("SELECT COUNT(*) as count, usr_id, usr_name, ");
            sql.append("usr_nickname, usr_email, usr_password, ");
            sql.append("usr_dt_cad ");
            sql.append("FROM user ");
            sql.append("WHERE usr_email=? ");
            sql.append("AND usr_password=? ");
            sql.append("GROUP BY usr_id");
            
            statement = connection.prepareStatement(sql.toString());
            statement.setString(1, credential);
            statement.setString(2, password);
            
            ResultSet resultSet = statement.executeQuery();
            
            if(resultSet.next()) {
                Integer count = resultSet.getInt(Util.SQL_COUNT);
                
                if(1 == count) 
                    authentication = true;
            }
            
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException esql) {
                esql.printStackTrace();
                throw new UnsupportedOperationException(Util.ERROR_SAVE);
            }
            e.printStackTrace();
            throw new UnsupportedOperationException(Util.ERROR_SAVE);
        } finally {
            try {
                statement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
                throw new UnsupportedOperationException(Util.ERROR_SAVE);
            }
        }
        return authentication;
    }
    @Override
    public void salvar(EntidadeDominio entidade) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<EntidadeDominio> listar(EntidadeDominio entidade) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
