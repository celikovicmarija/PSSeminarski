/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.controller;

import view.form.FrmUpdateReservation;

/**
 *
 * @author Marija
 */
public class UpdateReservationController {
        FrmUpdateReservation frm;

    public UpdateReservationController(FrmUpdateReservation frm) {
        this.frm = frm;
    }
    public void openForm(){
        prepareForm();
        frm.setVisible(true);
        addActionListeners();
    }

    private void prepareForm() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void addActionListeners() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
