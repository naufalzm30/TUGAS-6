/*
10116517-NAUFAL ZAYN M-PBO12
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.naufalzm.latihanmvcjdbc.impl;

import edu.naufalzm.latihanmvcjdbc.entity.pelanggan;
import edu.naufalzm.latihanmvcjdbc.error.pelangganexception;
import edu.naufalzm.latihanmvcjdbc.service.pelanggandao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Naufal Zayn M
 */
public class pelanggandaoimpl implements pelanggandao {

    private Connection connection;

    private final String insertPelanggan = "INSERT INTO PELANGGAN (NAMA,ALAMAT,TELEPON,EMAIL) VALUES (?,?,?,?)";
    private final String updatePelanggan = "UPDATE PELANGGAN SET NAMA=?, ALAMAT=?, TELEPON=?,  EMAIL=? WHERE ID=?";
    private final String deletePelanggan = "DELETE FROM PELANGGAN WHERE ID=?";
    private final String getbyid = "SELECT * from PELANGGAN WHERE ID=?";
    private final String getbyemail = "SELECT * from PELANGGAN WHERE email=?";
    private final String selectAll = "SELECT * FROM PELANGGAN";

    public pelanggandaoimpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void insertpelanggan(pelanggan pelanggan) throws pelangganexception {
        PreparedStatement statement = null;
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(insertPelanggan);
            statement.setString(1, pelanggan.getNama());
            statement.setString(2, pelanggan.getAlamat());
            statement.setString(3, pelanggan.getTelepon());
            statement.setString(4, pelanggan.getEmail());
            statement.executeUpdate();
            
            connection.commit();

        } catch (SQLException e) {
            
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }
            
            throw new pelangganexception(e.getMessage());

        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                }
            }

        }

    }

    @Override
    public void updatepelanggan(pelanggan pelanggan) throws pelangganexception {
        PreparedStatement statement = null;
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(updatePelanggan);
            statement.setString(1, pelanggan.getNama());
            statement.setString(2, pelanggan.getAlamat());
            statement.setString(3, pelanggan.getTelepon());
            statement.setString(4, pelanggan.getEmail());
            statement.setInt(5, pelanggan.getID());
            statement.executeUpdate();
            connection.commit();

        } catch (SQLException e) {
            
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }
            
            throw new pelangganexception(e.getMessage());

        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                }
            }

        }
    }

    @Override
    public void deletepelanggan(Integer ID) throws pelangganexception {
        PreparedStatement statement = null;
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(deletePelanggan);
            statement.setInt(1, ID);

            statement.executeUpdate();
            connection.commit();

        } catch (SQLException e) {
            
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }
            
            throw new pelangganexception(e.getMessage());

        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                }
            }

        }
    }

    @Override
    public pelanggan getPelanggan(Integer ID) throws pelangganexception {
        PreparedStatement statement = null;
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(getbyid);
            statement.setInt(1, ID);

            ResultSet result = statement.executeQuery();
            pelanggan pelanggan = null;
            if (result.next()) {
                pelanggan = new pelanggan();
                pelanggan.setID(result.getInt("ID"));
                pelanggan.setNama(result.getString("nama"));
                pelanggan.setAlamat(result.getString("alamat"));
                pelanggan.setTelepon(result.getString("telepon"));
                pelanggan.setEmail(result.getString("email"));

            } else {
                throw new pelangganexception("Pelanggan dengan ID " + ID + "Tidak ditemukan");

            }
            connection.commit();
            return pelanggan;
        } catch (SQLException e) {
            
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }
            
            throw new pelangganexception(e.getMessage());

        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                }
            }

        }
    }

    @Override
    public pelanggan getPelanggan(String email) throws pelangganexception {
        PreparedStatement statement = null;
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(getbyemail);
            statement.setString(1, email);

            ResultSet result = statement.executeQuery();
            pelanggan pelanggan = null;
            if (result.next()) {
                pelanggan = new pelanggan();
                pelanggan.setID(result.getInt("ID"));
                pelanggan.setNama(result.getString("nama"));
                pelanggan.setAlamat(result.getString("alamat"));
                pelanggan.setTelepon(result.getString("telepon"));
                pelanggan.setEmail(result.getString("email"));

            } else {
                throw new pelangganexception("Pelanggan dengan Email " + email + "Tidak ditemukan");

            }
            connection.commit();
            return pelanggan;
        } catch (SQLException e) {
            
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }
            
            throw new pelangganexception(e.getMessage());

        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                }
            }

        }
    }

    @Override
    public List<pelanggan> selectAllPelanggan() throws pelangganexception {
        
        Statement statement = null;
        List <pelanggan> list = new ArrayList<pelanggan>();
        
        try {
            connection.setAutoCommit(false);
            statement = connection.createStatement();
           

            ResultSet result = statement.executeQuery(selectAll);
            pelanggan pelanggan = null;
            while (result.next()) {
                pelanggan = new pelanggan();
                pelanggan.setID(result.getInt("ID"));
                pelanggan.setNama(result.getString("nama"));
                pelanggan.setAlamat(result.getString("alamat"));
                pelanggan.setTelepon(result.getString("telepon"));
                pelanggan.setEmail(result.getString("email"));
                list.add(pelanggan);
            } 
            connection.commit();
            return list;
        } catch (SQLException e) {
            
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }
            
            throw new pelangganexception(e.getMessage());

        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                }
            }

        }
    }

}
