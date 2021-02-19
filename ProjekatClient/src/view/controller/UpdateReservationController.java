package view.controller;

import communication.Communication;
import constant.Constants;
import coordinator.MainCoordinator;
import domain.Coupon;
import domain.Flight;
import domain.Passenger;
import domain.Reservation;
import exception.CommunicationException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import view.form.FrmUpdateReservation;
import view.form.component.table.ReservationTableModel;
import view.form.util.FormMode;

public class UpdateReservationController {

    FrmUpdateReservation frm;
    Reservation reservation;
    FormMode mode;

    public UpdateReservationController(FrmUpdateReservation frm, FormMode mode) {
        this.frm = frm;
        this.mode = mode;
        this.frm.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        addActionListeners();
    }

    public void openForm() {
        prepareForm(mode);
      JOptionPane.showMessageDialog(frm, "Showing data for the chosen reservation", "Message", JOptionPane.INFORMATION_MESSAGE);
        frm.setVisible(true);

    }

    public FrmUpdateReservation getFrm() {
        return frm;
    }

    public void setFrm(FrmUpdateReservation frm) {
        this.frm = frm;
    }

    private void prepareForm(FormMode mode) {
        frm.setLocationRelativeTo(null);

        try {
            populateForm();
            fillCbCoupons();
            fillCbFlights();
            switch (mode) {
                case FORM_VIEW:
                    frm.getBtnDelete().setEnabled(false);
                    frm.getBtnSave().setEnabled(false);
                    frm.getBtnCancel().setEnabled(true);
                    frm.setTitle("Reservation");
                    frm.getLblTitle().setText("Reservation info");
                    break;
                case FORM_EDIT:
                    frm.getBtnDelete().setEnabled(false);
                    frm.getBtnSave().setEnabled(true);
                    frm.getBtnCancel().setEnabled(true);
                    frm.setTitle("Reservation");
                    frm.getLblTitle().setText("Reservation info");
                    break;
                case FORM_DELETE:
                    frm.getBtnDelete().setEnabled(true);
                    frm.getBtnSave().setEnabled(false);
                    frm.getBtnCancel().setEnabled(true);
                    frm.setTitle("Reservation");
                    frm.getLblTitle().setText("Delete reservation info");
                    break;
            }
        } catch (CommunicationException e) {
            closeProgramOnSocketException();
        } catch (Exception ex) {
        }
    }

    private void addActionListeners() {
        frm.addBtnCancelActionListener((ActionEvent e) -> {
            frm.dispose();
        });
        frm.addBtnDeleteActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                delete();
            }

            private void delete() {
                try {

                    int result = JOptionPane.showConfirmDialog(frm, "Are you sure you want to delete this reservation?", "Delete reservation",
                            JOptionPane.YES_NO_OPTION,
                            JOptionPane.QUESTION_MESSAGE);
                    if (result == JOptionPane.YES_OPTION) {
                        List<Reservation> reservations = Communication.getInstance().getAllReservations();
                        if (!reservations.contains(reservation)) {
                            JOptionPane.showMessageDialog(frm, "Could not delete the reservation", "Delete reservation", JOptionPane.INFORMATION_MESSAGE);

                        } else {
                            Communication.getInstance().deleteReservation(reservation);
                            JOptionPane.showMessageDialog(frm, "Deleted successfully", "Delete reservation", JOptionPane.INFORMATION_MESSAGE);
                            ReservationTableModel rtm = (ReservationTableModel) MainCoordinator.getInstance().getSearchReservationsController().getFrm().getTbReservations().getModel();
                            rtm.deleteReservation(reservation);
                            rtm.refresh();
                        }

                    }

                } catch (CommunicationException e) {
                    closeProgramOnSocketException();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(frm, "Could not delete selected reservation", "Delete reservation", JOptionPane.INFORMATION_MESSAGE);
                }
            }
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
                        List<Passenger> passengers = Communication.getInstance().getAllPassengers();
                        Passenger putnik = new Passenger();
                        for (Passenger psg : passengers) {
                            if (psg.getPassportNumber().equals(p)) {
                                putnik = psg;
                                break;
                            }

                        }
                        if (!putnik.getPassportNumber().equals("")) {
                            reservationEdited.setPassenger(putnik);
                        }

                        Communication.getInstance().editReservation(reservationEdited);
                        JOptionPane.showMessageDialog(frm, "Reservation successfully updated", "Update reservation", JOptionPane.INFORMATION_MESSAGE);
                    } catch (CommunicationException e) {
                        closeProgramOnSocketException();
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(frm, "Cannot update reservation", "Update reservation", JOptionPane.INFORMATION_MESSAGE);

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
        reservation = (Reservation) MainCoordinator.getInstance().getParam(Constants.PARAM_RESERVATION);
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

    private void closeProgramOnSocketException() {
        JOptionPane.showMessageDialog(null, "Server closed the connection!\n Program will now exit!", "Error!", JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }
}
