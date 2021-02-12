/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.controller;

import communication.Communication;
import domain.Flight;
import domain.Reservation;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import view.form.FrmSearchReservations;
import view.form.component.table.ReservationTableModel;

/**
 *
 * @author Marija
 */
public class SearchReservationsController {
        private final FrmSearchReservations frm;

    public SearchReservationsController(FrmSearchReservations frm) {
        this.frm = frm;
        addActionListeners();
    }
    public void openForm(){
        frm.setVisible(true);
        fillTblReservations();
    }

    private void addActionListeners() {
                frm.addBtnEditActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                     editReservation();
             
            }

            private void editReservation() {
                        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    }
    });
                
    frm.addBtnDeleteActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteReservation();
            }
     private void deleteReservation() {
                        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    }
    });


           frm.addBtnSearchActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchFlights();
            }

                    private void searchFlights() {
                        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    }

   
        });
                   
                }
    private void fillTblReservations() {
                List<Reservation> reservations = null;
        try {
            reservations = Communication.getInstance().getAllReservations();
        } catch (Exception ex) {
            Logger.getLogger(SearchFlightsController.class.getName()).log(Level.SEVERE, null, ex);
        }
        ReservationTableModel model= new ReservationTableModel(reservations);
        frm.getTbReservations().setModel(model);
   
    }
     private void tidyReservationsTableAfterSearch(List<Reservation> list) {
        ReservationTableModel model = (ReservationTableModel) frm.getTbReservations().getModel();
        model.clear();
        model.addReservations(list);
    }
}