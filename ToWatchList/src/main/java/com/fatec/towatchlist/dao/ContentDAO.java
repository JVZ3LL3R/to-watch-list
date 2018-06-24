/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fatec.towatchlist.dao;

import com.fatec.towatchlist.dominio.Conteudo;
import com.fatec.towatchlist.dominio.EntidadeDominio;
import com.towatchlist.fatec.util.Util;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
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
    public void salvar(EntidadeDominio entidade) throws SQLException {
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
            sql.append("cont_rating, cont_clf_id, cont_cat_id, ");
            sql.append("cont_watched, cont_dt_cad)");
            sql.append(" VALUES (?,?,?,?,?,?,?,?,?,?,?)");
            
            statement = connection.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, content.getFichaTecnica().getNome());
            statement.setString(2, content.getFichaTecnica().getSinopse());
            statement.setString(3, content.getFichaTecnica().getPaisOrigem());
            statement.setString(4, content.getFichaTecnica().getDuracao());
            statement.setString(5, content.getFichaTecnica().getImgCapa().getPath());
            statement.setString(6, content.getFichaTecnica().getTrailer().getUrl());
            statement.setString(7, String.valueOf(content.getAvaliacao().getNota()));
            statement.setInt(8, content.getFichaTecnica().getClassificacao().getId());
            statement.setInt(9, content.getCategoria().getId() );
            statement.setBoolean(10, content.isAssistido() );
            Timestamp time = new Timestamp(content.getData().getTime());
            statement.setTimestamp(11, time);
            statement.executeUpdate();
            ResultSet resultSet = statement.getGeneratedKeys();
            int id = 0;
            if (resultSet.next())
                id = resultSet.getInt(Util.ENTITY_ID);
            content.setId(id);
            connection.commit();
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
    }

    @Override
    public List<EntidadeDominio> consultar(EntidadeDominio entidade) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void alterar(EntidadeDominio entidade) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
