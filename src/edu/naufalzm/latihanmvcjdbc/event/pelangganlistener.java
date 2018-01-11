/*
10116517-NAUFAL ZAYN M-PBO12
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.naufalzm.latihanmvcjdbc.event;

import edu.naufalzm.latihanmvcjdbc.entity.pelanggan;
import edu.naufalzm.latihanmvcjdbc.model.pelangganmodel;

/**
 *
 * @author Naufal Zayn M
 */
public interface pelangganlistener {

    public void onChange(pelangganmodel model);

    public void onInsert(pelanggan pelanggan);

    public void onDelete();

    public void onUpdate(pelanggan pelanggan);

}
