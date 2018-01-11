/*
10116517-NAUFAL ZAYN M-PBO12
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.naufalzm.latihanmvcjdbc.service;

import edu.naufalzm.latihanmvcjdbc.entity.pelanggan;
import edu.naufalzm.latihanmvcjdbc.error.pelangganexception;
import java.util.List;

/**
 *
 * @author Naufal Zayn M
 */
public interface pelanggandao {
    
    public void insertpelanggan(pelanggan pelanggan) throws pelangganexception ;
    public void updatepelanggan(pelanggan pelanggan) throws pelangganexception ;
    public void deletepelanggan(Integer ID) throws pelangganexception ;
    public pelanggan getPelanggan(Integer ID) throws pelangganexception ;
    public pelanggan getPelanggan(String email) throws pelangganexception ;
    public List<pelanggan> selectAllPelanggan() throws pelangganexception ;
    
    
}
