/*
10116517-NAUFAL ZAYN M-PBO12
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.naufalzm.latihanmvcjdbc.model;


import edu.naufalzm.latihanmvcjdbc.database.kingsbarbershopdatabase;
import edu.naufalzm.latihanmvcjdbc.entity.pelanggan;
import edu.naufalzm.latihanmvcjdbc.error.pelangganexception;
import edu.naufalzm.latihanmvcjdbc.event.pelangganlistener;
import edu.naufalzm.latihanmvcjdbc.service.pelanggandao;
import java.sql.SQLException;

/**
 *
 * @author Naufal Zayn M
 */
public class pelangganmodel {

    private int ID;
    private String nama;
    private String alamat;
    private String telepon;
    private String email;
    private pelangganlistener listener;

    public pelangganlistener getListener() {
        return listener;
    }

    
    
    public void setListener(pelangganlistener listener) {
        this.listener = listener;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
        fireOnChange();
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
        fireOnChange();
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
        fireOnChange();
    }

    public String getTelepon() {
        return telepon;
    }

    public void setTelepon(String telepon) {
        this.telepon = telepon;
        fireOnChange();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
        fireOnChange();
    }

    protected void fireOnChange(){
        if(listener!=null){
            listener.onChange(this);
        }
    }
    
    protected void fireOnInsert(pelanggan pelanggan){
        if(listener!=null){
            listener.onInsert(pelanggan);
        }
    }
    
    protected void fireOnUpdate(pelanggan pelanggan){
        if(listener!=null){
            listener.onUpdate(pelanggan);
        }
    }
    
    protected void fireOnDelete(){
        
    }
    
    public void InsertPelanggan() throws SQLException, pelangganexception{
        pelanggandao dao = kingsbarbershopdatabase.getPelanggandao();
        pelanggan pelanggan= new pelanggan();
        pelanggan.setNama(nama);
        pelanggan.setAlamat(alamat);
        pelanggan.setTelepon(telepon);
        pelanggan.setEmail(email);
        
        dao.insertpelanggan(pelanggan);
        fireOnInsert(pelanggan);
        
    }
    
     public void updatePelanggan() throws SQLException, pelangganexception{
        pelanggandao dao = kingsbarbershopdatabase.getPelanggandao();
        pelanggan pelanggan= new pelanggan();
        pelanggan.setNama(nama);
        pelanggan.setAlamat(alamat);
        pelanggan.setTelepon(telepon);
        pelanggan.setEmail(email);
        pelanggan.setID(ID);
                        
        dao.updatepelanggan(pelanggan);
        fireOnUpdate(pelanggan);
        
    }
     
     public void deletePelanggan() throws SQLException, pelangganexception{
        pelanggandao dao = kingsbarbershopdatabase.getPelanggandao();
                               
        dao.deletepelanggan(ID);
        fireOnDelete();
        
    }
    
    public void resetPelanggan(){
        setID(0);
        setNama("");
        setAlamat("");
        setTelepon("");
        setEmail("");
    }
    
}
