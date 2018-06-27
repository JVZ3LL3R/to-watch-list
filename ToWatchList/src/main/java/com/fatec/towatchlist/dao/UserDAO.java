/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fatec.towatchlist.dao;

import com.fatec.towatchlist.dominio.Conteudo;
import com.fatec.towatchlist.dominio.EntidadeDominio;
import com.fatec.towatchlist.dominio.Usuario;
import com.towatchlist.fatec.util.Util;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author josev
 */
public class UserDAO extends AbstractJdbcDAO {

    public UserDAO () {
        super("USER", "USR_ID");
    }
    @Override
    public void salvar(EntidadeDominio entidade) {
        openConnection();
        PreparedStatement statement = null;
        Usuario usuario = (Usuario) entidade;
        
        try {
            connection.setAutoCommit(Util.SQL_AUTO_COMMIT_FALSE);
            StringBuilder sql = new StringBuilder();
            sql.append("INSERT INTO user (");
            sql.append("usr_name, usr_nickname, usr_email, ");
            sql.append("usr_password, usr_dt_cad)");
            sql.append(" VALUES (?,?,?,?,?)");
            
            statement = connection.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, usuario.getNome());
            statement.setString(2, usuario.getNomeUsuario());
            statement.setString(3, usuario.getEmail());
            statement.setString(4, usuario.getSenha());
            Timestamp time = new Timestamp(usuario.getData().getTime());
            statement.setTimestamp(5, time);
            statement.executeUpdate();
            ResultSet resultSet = statement.getGeneratedKeys();
            int id = 0;
            if (resultSet.next())
                id = resultSet.getInt(Util.ENTITY_ID);
            usuario.setId(id);
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
    public List<EntidadeDominio> listar(EntidadeDominio entidade) throws SQLException {
        PreparedStatement statement = null;
        Usuario usuario = (Usuario) entidade;
        String sql = null;
        
        if (null == usuario.getEmail())
            usuario.setEmail("");
        
        if (null == usuario.getId() && usuario.getEmail().equals("")) {
            sql = "SELECT * FROM user";
        } else if (null != usuario.getId() && usuario.getEmail().equals("")) {
            sql = "SELECT * FROM user WHERE usr_id=?";
        } else if (null == usuario.getId() && !usuario.getEmail().equals("")) {
            sql = "SELECT * FROM user WHERE usr_email LIKE ?";
        }
        
        try {
            openConnection();
            statement = connection.prepareStatement(sql);
            
            if(null != usuario.getId() && usuario.getEmail().equals("")){
                statement.setInt(1, usuario.getId());
            } else if (null == usuario.getId() && !usuario.getEmail().equals("")) {
                statement.setString(1, "%" + usuario.getEmail() + "%");
            }
            
            ResultSet resultSet = statement.executeQuery();
            List < EntidadeDominio > usuarios = new ArrayList < EntidadeDominio > ();
            while (resultSet.next()) {                
                Usuario usr = new Usuario();
                usr.setId(resultSet.getInt(Util.ENTITY_ID));
                usr.setNome(resultSet.getString(Util.USER_SQL_NAME));
                usr.setNomeUsuario(resultSet.getString(Util.USER_SQL_NICKNAME));
                usr.setEmail(resultSet.getString(Util.USER_SQL_EMAIL));
                java.sql.Date dtCadLong = resultSet.getDate(Util.USER_SQL_DATE);
                Date dtCad = new Date(dtCadLong.getTime());
                usr.setData(dtCad);
                List < Conteudo > userContents = new ArrayList < Conteudo > ();
                if(null == usuario.getContentsToWacth()) {
                    sql = "SELECT usrl_cont_id FROM user_list WHERE usrl_usr_id=?";
                    statement = connection.prepareStatement(sql);
                    statement.setInt(1, usr.getId());
                    resultSet = statement.executeQuery();
                    IDAO contentDao = new ContentDAO();
                    List < EntidadeDominio > contents = new ArrayList < EntidadeDominio > ();

                    while(resultSet.next()){
                        Conteudo contentList = new Conteudo();
                        contentList.setId(resultSet.getInt("usrl_cont_id"));
                        contentList.setUserID(usr.getId());
                        contents.add( contentDao.consultar(contentList) ); 
                    }
                    
                    for(EntidadeDominio ent: contents) {
                        userContents.add ((Conteudo) ent);
                    }
                }
                usr.setContentsToWacth(userContents);
                usuarios.add(usr);
            }
           
            return usuarios;
        } catch (SQLException se) {
            se.printStackTrace();
        }
        return null;
    }

    @Override
    public void alterar(EntidadeDominio entidade) throws SQLException {
        openConnection();
        PreparedStatement statement = null;
        Usuario usuario = (Usuario) entidade;
        
        try {
            connection.setAutoCommit(Util.SQL_AUTO_COMMIT_FALSE);
            
            StringBuilder sql = new StringBuilder();
            sql.append("UPDATE user SET usr_name=?, usr_nickname=?, ");
            sql.append("usr_email=? ");
            sql.append("WHERE usr_id=?");
            
            statement = connection.prepareStatement(sql.toString());
            statement.setString(1, usuario.getNome());
            statement.setString(2, usuario.getNomeUsuario());
            statement.setString(3, usuario.getEmail());
            
            connection.commit();
        } catch (SQLException se) {
            try {
                connection.rollback();
            } catch (SQLException sql) {
                sql.printStackTrace();
            }
            se.printStackTrace();
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
    public EntidadeDominio consultar(EntidadeDominio entidade) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
