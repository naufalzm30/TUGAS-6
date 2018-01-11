/*
10116517-NAUFAL ZAYN M-PBO12
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.naufalzm.latihanmvcjdbc.model;

import edu.naufalzm.latihanmvcjdbc.entity.pelanggan;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Naufal Zayn M
 */
public class tablepelangganmodel extends AbstractTableModel {

    private List<pelanggan> list = new ArrayList<pelanggan>();

    public void setList(List<pelanggan> list) {
        this.list = list;
    }

    @Override
    public int getRowCount() {
        return list.size();

    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    public boolean add(pelanggan e) {
        try {
            return list.add(e);
        } finally {
            fireTableRowsInserted(getRowCount()-1, getRowCount()-1);
        }
    }

    public pelanggan get(int i) {
        return list.get(i);
    }

    public pelanggan set(int i, pelanggan e) {
        try {
           return list.set(i, e);  
        } finally {
            fireTableRowsUpdated(i, i);
        }
        
       
    }

    public pelanggan remove(int i) {
        try {
            return list.remove(i);
        } finally {
            fireTableRowsDeleted(i, i);
        }

    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "ID";
            case 1:
                return "NAMA";
            case 2:
                return "ALAMAT";
            case 3:
                return "TELEPON";
            case 4:
                return "EMAIL";
            default:
                return null;
        }
    }

    
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return list.get(rowIndex).getID();
            case 1:
                return list.get(rowIndex).getNama();
            case 2:
                return list.get(rowIndex).getAlamat();
            case 3:
                return list.get(rowIndex).getTelepon();
            case 4:
                return list.get(rowIndex).getEmail();
            default:
                return null;

        }
    }

}
