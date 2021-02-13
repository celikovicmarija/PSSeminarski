package view.controller;

import communication.Communication;
import constant.Constants;
import coordinator.MainCoordinator;
import domain.Coupon;
import domain.Flight;
import domain.Passenger;
import domain.Reservation;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import view.form.FrmUpdateReservation;

public class UpdateReservationController {

    FrmUpdateReservation frm;
    Reservation reservation;

    public UpdateReservationController(FrmUpdateReservation frm) {
        this.frm = frm;
        this.frm.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        addActionListeners();
    }

    public void openForm() {
        prepareForm();
        frm.setVisible(true);     
    }

    private void prepareForm() {
        try {
            populateForm();
            fillCbCoupons();
            fillCbFlights();
        } catch (Exception ex) {
        }
    }

    private void addActionListeners() {
        frm.addBtnCancelActionListener((ActionEvent e) -> {
            frm.dispose();
        });
        frm.addBtnSaveActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveChanges();
            }

            private void saveChanges() {
                String err = "";
                String discountedPrice = frm.getTxtDiscountedPrice().getText();

                if (discountedPrice.equals("")) {
                    err += "You must enter the discounted price\n";
                }
                String price = frm.getTxtPrice().getText();
                if (price.equals("")) {
                    err += "You must enter the price\n";
                }
                Date issueDate = null;
                try {
                    issueDate = Date.valueOf(frm.getTxtIssueDate().getText());
                } catch (Exception ex) {

                }

                if (issueDate == null) {
                    err += "You must enter an issue date\n";
                }
                Date validUntil = null;
                try {
                    validUntil = Date.valueOf(frm.getTxtValidUntil().getText());
                } catch (Exception ex) {

                }

                if (validUntil == null) {
                    err += "You must enter an expiration date\n";
                }
                String p = frm.getTxtPassenger().getText();

                if (p.equals("")) {
                    err += "You must enter the passenger's passport number \n";
                }
                Flight f = null;
                f = (Flight) frm.getCbFlights().getSelectedItem();

                if (f == null) {
                    err += "You must choose a flight\n";
                }
                Coupon c = null;
                c = (Coupon) frm.getCbCoupons().getSelectedItem();
                if (c == null) {
                    err += "You must choose a coupon\n";
                }
                
                                if (err.equals("")) {
                    try {
                        Reservation reservationEdited = new Reservation();
                        reservationEdited.setReservationID(reservation.getReservationID());
                        reservationEdited.setDiscountedPrice(new BigDecimal(discountedPrice));
                        reservationEdited.setPrice(new BigDecimal(price));
                        reservationEdited.setFlight(f);
                        reservationEdited.setCoupon(c);
                        reservationEdited.setValidUntil(validUntil);
                        reservationEdited.setIssueDate(issueDate);
                        List<Passenger> passengers=Communication.getInstance().getAllPassengers();
                        Passenger putnik= new Passenger();
                        for (Passenger psg : passengers) {
                            if(psg.getPassportNumber().equals(p)){
                                putnik=psg;
                                break;
                            }
                            
                        }
                        if (!putnik.getPassportNumber().equals("")) 
                                    reservationEdited.setPassenger(putnik);

                     
                        Communication.getInstance().editReservation(reservationEdited);
                        JOptionPane.showMessageDialog(frm, "Reservation successfully updated", "Update reservation", JOptionPane.INFORMATION_MESSAGE);
                        frm.dispose();
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(frm, "Cannot update reservation", "Update reservation", JOptionPane.INFORMATION_MESSAGE);

                        Logger.getLogger(UpdateReservationController.class.getName()).log(Level.SEVERE, null, ex);
                    }

                } else {
                    JOptionPane.showMessageDialog(frm, err, "Update reservation", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
    }

    private void fillCbCoupons() throws Exception {
         frm.getCbCoupons().removeAllItems();     
        frm.getCbCoupons().setModel(new DefaultComboBoxModel(Communication.getInstance().getAllCoupons().toArray()));
    }

    private void fillCbFlights() throws Exception {
         frm.getCbFlights().removeAllItems();
        frm.getCbFlights().setModel(new DefaultComboBoxModel(Communication.getInstance().getAllFlights().toArray()));
    }

    private void populateForm() {
            reservation=(Reservation)MainCoordinator.getInstance().getParam(Constants.PARAM_RESERVATION);
            frm.getTxtReservationID().setText(String.valueOf(reservation.getReservationID()));
            frm.getTxtReservationID().setEditable(false);
            frm.getTxtDiscountedPrice().setText(String.valueOf(reservation.getDiscountedPrice()));
            frm.getTxtPrice().setText(String.valueOf(reservation.getPrice()));
            frm.getTxtPassenger().setText(reservation.getPassenger().getPassportNumber());
            frm.getTxtIssueDate().setText(String.valueOf(reservation.getIssueDate()));
            frm.getTxtValidUntil().setText(String.valueOf(reservation.getIssueDate()));
            frm.getCbFlights().setSelectedItem(reservation.getFlight());
            frm.getCbCoupons().setSelectedItem(reservation.getCoupon());
      
    }

}
