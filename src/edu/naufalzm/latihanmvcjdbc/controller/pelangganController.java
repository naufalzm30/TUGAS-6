/*
10116517-NAUFAL ZAYN M-PBO12
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.naufalzm.latihanmvcjdbc.controller;

import edu.naufalzm.latihanmvcjdbc.model.pelangganmodel;
import edu.naufalzm.latihanmvcjdbc.view.pelangganview;
import javax.swing.JOptionPane;

/**
 *
 * @author Naufal Zayn M
 */
public class pelangganController {
    private pelangganmodel model;

    public void setModel(pelangganmodel model) {
        this.model = model;
    }
    
    public void resetPelanggan(pelangganview view){
        model.resetPelanggan();
    }
    public void insertPelanggan(pelangganview view){
        String nama=view.getNama().getText();
        String alamat=view.getAlamat().getText();
        String telepon=view.getTelepon().getText();
        String email=view.getEmail().getText();
       
        if (nama.trim().equals("")){
            JOptionPane.showMessageDialog(view, "NAMA GA BOLEH KOSONG");
            
        } else if (nama.length()>255){
            JOptionPane.showMessageDialog(view, "NAMA KEPANJANGAN");
        }else if (telepon.length()>12){
            JOptionPane.showMessageDialog(view, "KEPANJANGAN");
        }else if (email.contains("@")|| email.contains(".")){
            JOptionPane.showMessageDialog(view, "GA VALID");
        }
                
    }
    public void updatePelanggan(pelangganview view){
        model.resetPelanggan();
    }
    public void deletePelanggan(pelangganview view){
        model.resetPelanggan();
    }
    
}
