/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.towatchlist.fatec.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author josev
 */
public class Conexao {
	
    public static Connection getConnection() 
                    throws ClassNotFoundException, 
            SQLException{
            String driver = "com.mysql.cj.jdbc.Driver";
            String url = "jdbc:mysql://localhost:3306/to_watch?useTimezone=true&serverTimezone=UTC&useSSL=false";
            String user = "root";
            String password = "#Victormysql";
            Class.forName( driver );
            Connection conn = 
                            DriverManager.getConnection( url, user, password);

            return conn;



    }

}
