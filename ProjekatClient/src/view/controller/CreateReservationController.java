/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.controller;

import view.form.FrmCreateReservation;

/**
 *
 * @author Marija
 */
public class CreateReservationController {
    private final FrmCreateReservation frm;

    public CreateReservationController(FrmCreateReservation frm) {
        this.frm = frm;
        addActionListeners();
    }
    public void openForm(){
        frm.setVisible(true);
    }

    private void addActionListeners() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
