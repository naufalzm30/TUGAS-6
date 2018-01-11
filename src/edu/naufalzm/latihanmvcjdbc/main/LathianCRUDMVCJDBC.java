/*
10116517-NAUFAL ZAYN M-PBO12
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.naufalzm.latihanmvcjdbc.main;

import edu.naufalzm.latihanmvcjdbc.database.kingsbarbershopdatabase;
import edu.naufalzm.latihanmvcjdbc.entity.pelanggan;
import edu.naufalzm.latihanmvcjdbc.error.pelangganexception;
import edu.naufalzm.latihanmvcjdbc.service.pelanggandao;
import java.sql.SQLException;

/**
 *
 * @author Naufal Zayn M
 */
public class LathianCRUDMVCJDBC {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException, pelangganexception {
        // TODO code application logic here
        
        pelanggandao dao = kingsbarbershopdatabase.getPelanggandao();
      
        dao.deletepelanggan(3);
       
        
    }
    
}
