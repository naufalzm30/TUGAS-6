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

    public void resetPelanggan(pelangganview view) {
        model.resetPelanggan();
    }

    public void insertPelanggan(pelangganview view) {
        String nama = view.getNama().getText();
        String alamat = view.getAlamat().getText();
        String telepon = view.getTelepon().getText();
        String email = view.getEmail().getText();

        if (nama.trim().equals("")) {
            JOptionPane.showMessageDialog(view, "NAMA GA BOLEH KOSONG");

        } else if (nama.length() > 255) {
            JOptionPane.showMessageDialog(view, "NAMA ANDA TERLALU PANJANG");
        } else if (telepon.length() > 12) {
            JOptionPane.showMessageDialog(view, "KEPANJANGAN");
        } else {
            model.setNama(nama);
            model.setAlamat(alamat);
            model.setTelepon(telepon);
            model.setEmail(email);

            try {
                model.InsertPelanggan();
                JOptionPane.showMessageDialog(view, "Pelanggan berhasil ditambahkan");
                model.resetPelanggan();
            } catch (Throwable e) {
                JOptionPane.showMessageDialog(view, new Object[]{"terjadi error di database dengan pesan", e.getMessage()});

            }
        }

    }

    public void updatePelanggan(pelangganview view) {
        
        if (view.getPelanggan().getSelectedRowCount()==0){
            JOptionPane.showMessageDialog(view, "silahkan pilih data yang ingin diubah");
            return;
        }
        
        Integer ID = Integer.parseInt(view.getId().getText());
        String nama = view.getNama().getText();
        String alamat = view.getAlamat().getText();
        String telepon = view.getTelepon().getText();
        String email = view.getEmail().getText();

        if (nama.trim().equals("")) {
            JOptionPane.showMessageDialog(view, "NAMA GA BOLEH KOSONG");

        } else if (nama.length() > 255) {
            JOptionPane.showMessageDialog(view, "NAMA ANDA TERLALU PANJANG");
        } else if (telepon.length() > 12) {
            JOptionPane.showMessageDialog(view, "KEPANJANGAN");
        } else {
            model.setID(ID);
            model.setNama(nama);
            model.setAlamat(alamat);
            model.setTelepon(telepon);
            model.setEmail(email);

            try {
                model.updatePelanggan();
                JOptionPane.showMessageDialog(view, "Pelanggan berhasil diubah");
                model.resetPelanggan();
            } catch (Throwable e) {
                JOptionPane.showMessageDialog(view, new Object[]{"terjadi error di database dengan pesan", e.getMessage()});

            }
        }

    }

    public void deletePelanggan(pelangganview view) {
       if (view.getPelanggan().getSelectedRowCount()==0){
            JOptionPane.showMessageDialog(view, "silahkan pilih data yang ingin diubah");
            return;
        }
       if (JOptionPane.showConfirmDialog(view,"anda yakin akan menghapus?")==JOptionPane.OK_OPTION){
           Integer ID = Integer.parseInt(view.getId().getText());
      
           try {
               model.deletePelanggan();
               JOptionPane.showMessageDialog(view, "pelanggan berhasil dihapus");
               model.resetPelanggan();
           } catch (Throwable e) {
             JOptionPane.showMessageDialog(view, new Object[]{"terjadi error di database dengan pesan", e.getMessage()});  
           }
           
       }
       
    }

}
