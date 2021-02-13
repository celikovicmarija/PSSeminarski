package view.controller;

import communication.Communication;
import constant.Constants;
import coordinator.MainCoordinator;
import domain.Reservation;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import view.form.FrmSearchReservations;
import view.form.component.table.ReservationTableModel;

public class SearchReservationsController {

    private final FrmSearchReservations frm;

    public SearchReservationsController(FrmSearchReservations frm) {
        this.frm = frm;
        this.frm.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        addActionListeners();
    }

    public void openForm() {
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
                int row = frm.getTbReservations().getSelectedRow();
                if (row < 0) {
                    JOptionPane.showMessageDialog(frm, "Please select a reservation to delete", "Delete reservation", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    ReservationTableModel rtm = (ReservationTableModel) frm.getTbReservations().getModel();
                    List<Reservation> reservations = rtm.getReservations();
                    Reservation r = reservations.get(row);
                    System.out.println("Added parameter:"+r);
                    MainCoordinator.getInstance().addParam(Constants.PARAM_RESERVATION, r);
                    MainCoordinator.getInstance().openUpdateResevationForm();
                  //  tidyReservationsTableAfterSearch(reservations);
                    rtm.refresh();
                }
            }
        });

        frm.addBtnDeleteActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteReservation();
            }

            private void deleteReservation() {
                int row = frm.getTbReservations().getSelectedRow();
                if (row < 0) {
                    JOptionPane.showMessageDialog(frm, "Please select a reseervation to delete", "Delete reservation", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    try {
                        ReservationTableModel rtm = (ReservationTableModel) frm.getTbReservations().getModel();
                        List<Reservation> reservations = rtm.getReservations();

                        //OVDE TREBA I PREDUSLOVE DA VIDIS
                        Reservation reservation = reservations.get(row);
                        Communication.getInstance().deleteReservation(reservation);
                        JOptionPane.showMessageDialog(frm, "Deleted successfully", "Delete reservation", JOptionPane.INFORMATION_MESSAGE);
                        rtm.deleteFlight(reservation);
                      rtm.refresh();
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(frm, "Could not delete selected reservation", "Delete reservation", JOptionPane.INFORMATION_MESSAGE);
                        Logger.getLogger(SearchReservationsController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });

        frm.addBtnSearchActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchReservations();
            }

            private void searchReservations() {

                String criteria = frm.getTxtSearchTerm().getText();
                if (criteria.isEmpty() || criteria.equals("*")) {
                    try {
                        List<Reservation> reservations = Communication.getInstance().getAllReservations();
                        if (reservations != null && reservations.size()>0) {
                            JOptionPane.showMessageDialog(frm, "Found results for the reservations", "Search reservations", JOptionPane.INFORMATION_MESSAGE);
                            tidyReservationsTableAfterSearch(reservations);
                        } else {
                            JOptionPane.showMessageDialog(frm, "Could not find results for the reservations", "Search reservations", JOptionPane.INFORMATION_MESSAGE);

                        }
                    } catch (Exception ex) {
                        Logger.getLogger(SearchReservationsController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    try {

                        Reservation reservation = new Reservation();
                        reservation.setSearchCriteria(criteria);

                        List<Reservation> reservations = Communication.getInstance().searchReservations(reservation);
                        if (reservations != null && reservations.size()>0) {
                            JOptionPane.showMessageDialog(frm, "Found results for the reservations", "Search reservations", JOptionPane.INFORMATION_MESSAGE);
                            tidyReservationsTableAfterSearch(reservations);
                        } else {
                            JOptionPane.showMessageDialog(frm, "Could not find results for the reservations", "Search reservations", JOptionPane.INFORMATION_MESSAGE);

                        }
                    } catch (Exception ex) {
                        Logger.getLogger(SearchReservationsController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
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
        ReservationTableModel model = new ReservationTableModel(reservations);
        frm.getTbReservations().setModel(model);

    }

    private void tidyReservationsTableAfterSearch(List<Reservation> list) {
        ReservationTableModel model = (ReservationTableModel) frm.getTbReservations().getModel();
        model.clear();
        model.addReservations(list);
    }
}
