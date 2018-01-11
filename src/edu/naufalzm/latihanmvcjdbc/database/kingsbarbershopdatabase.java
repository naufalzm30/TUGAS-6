/*
10116517-NAUFAL ZAYN M-PBO12
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.naufalzm.latihanmvcjdbc.database;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import edu.naufalzm.latihanmvcjdbc.impl.pelanggandaoimpl;
import edu.naufalzm.latihanmvcjdbc.service.pelanggandao;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author Naufal Zayn M
 */
public class kingsbarbershopdatabase {
    
    private static Connection connection;
    private static pelanggandao pelanggandao;
    
    
    public static Connection getConnection() throws SQLException {
        
        if (connection == null) {
            
            MysqlDataSource datasource = new MysqlDataSource();
            datasource.setURL("jdbc:mysql://localhost:3306/kingsbarbershop");
            datasource.setUser("root");
            datasource.setPassword("");
            connection = datasource.getConnection();
        }
        
        return connection;
        
    }
    public static pelanggandao getPelanggandao() throws SQLException{
        if(pelanggandao==null){
            pelanggandao = new pelanggandaoimpl(getConnection());
        }
        return pelanggandao;
        
    }
}
