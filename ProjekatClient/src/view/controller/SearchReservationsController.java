package view.controller;

import communication.Communication;
import constant.Constants;
import coordinator.MainCoordinator;
import domain.Reservation;
import exception.CommunicationException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import view.form.FrmSearchReservations;
import view.form.component.table.ReservationTableModel;
import view.form.util.FormMode;

public class SearchReservationsController {

    private FrmSearchReservations frm;
    private FormMode mode;

    public SearchReservationsController(FrmSearchReservations frm,FormMode mode) {
        this.frm = frm;
        this.mode=mode;
        this.frm.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        addActionListeners();
    }

    public FrmSearchReservations getFrm() {
        return frm;
    }

    public void setFrm(FrmSearchReservations frm) {
        this.frm = frm;
    }

    public void openForm() {
        prepareView();
        frm.setVisible(true);
       
    }

    private void addActionListeners() {
        
                 frm.addBtnShowActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                show();
            }
             private void show() {
                int row = frm.getTbReservations().getSelectedRow();
                if (row < 0) {
                    JOptionPane.showMessageDialog(frm, "Please select a reservation to show", "Show reservation", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    ReservationTableModel rtm = (ReservationTableModel) frm.getTbReservations().getModel();
                    List<Reservation> reservations = rtm.getReservations();
                    Reservation r = reservations.get(row);
                    System.out.println("Added parameter:" + r);
                    MainCoordinator.getInstance().addParam(Constants.PARAM_RESERVATION, r);
                    MainCoordinator.getInstance().openUpdateResevationForm(FormMode.FORM_VIEW);
                    //  tidyReservationsTableAfterSearch(reservations);
                    rtm.refresh();
                }
            }
         });
        frm.addBtnEditActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                editReservation();

            }

            private void editReservation() {
                int row = frm.getTbReservations().getSelectedRow();
                if (row < 0) {
                    JOptionPane.showMessageDialog(frm, "Please select a reservation to change", "Delete reservation", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    ReservationTableModel rtm = (ReservationTableModel) frm.getTbReservations().getModel();
                    List<Reservation> reservations = rtm.getReservations();
                    Reservation r = reservations.get(row);
                    System.out.println("Added parameter:" + r);
                    MainCoordinator.getInstance().addParam(Constants.PARAM_RESERVATION, r);
                    MainCoordinator.getInstance().openUpdateResevationForm(FormMode.FORM_EDIT);
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

                        Reservation reservation = reservations.get(row);
                    MainCoordinator.getInstance().addParam(Constants.PARAM_RESERVATION,reservation );
                    MainCoordinator.getInstance().openUpdateResevationForm(FormMode.FORM_DELETE);


                                           } catch (Exception ex) {
                        JOptionPane.showMessageDialog(frm, "Could not delete selected reservation", "Delete reservation", JOptionPane.INFORMATION_MESSAGE);
                       // Logger.getLogger(SearchReservationsController.class.getName()).log(Level.SEVERE, null, ex);
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
                        if (reservations != null ) {
                      
                            JOptionPane.showMessageDialog(frm, "Found results for the reservations", "Search reservations", JOptionPane.INFORMATION_MESSAGE);
                            tidyReservationsTableAfterSearch(reservations);
                        } else {
                            JOptionPane.showMessageDialog(frm, "Could not find results for the reservations", "Search reservations", JOptionPane.INFORMATION_MESSAGE);

                        }
                    }  catch(CommunicationException e){
                        closeProgramOnSocketException();
                    }catch (Exception ex) {
                       JOptionPane.showMessageDialog(frm, "Error while fetching reservations", "Search reservations", JOptionPane.INFORMATION_MESSAGE);
                       // Logger.getLogger(SearchReservationsController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    try {

                        Reservation reservation = new Reservation();
                        reservation.setSearchCriteria(criteria);

                        List<Reservation> reservations = Communication.getInstance().searchReservations(reservation);
                        if (reservations != null && reservations.size() > 0) {
                            JOptionPane.showMessageDialog(frm, "Found results for the reservations", "Search reservations", JOptionPane.INFORMATION_MESSAGE);
                            tidyReservationsTableAfterSearch(reservations);
                        } else {
                            JOptionPane.showMessageDialog(frm, "Could not find results for the reservations", "Search reservations", JOptionPane.INFORMATION_MESSAGE);

                        }
                    } catch(CommunicationException e){
                        closeProgramOnSocketException();
                    } catch (Exception ex) {
             JOptionPane.showMessageDialog(frm, "Error while fetching reservations", "Search reservations", JOptionPane.INFORMATION_MESSAGE);

                    //    Logger.getLogger(SearchReservationsController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }

        });

    }

    private void fillTblReservations() {
        List<Reservation> reservations = null;
        try {
            reservations = Communication.getInstance().getAllReservations();
        } catch(CommunicationException e){
                        closeProgramOnSocketException();
                    } catch (Exception ex) {
         JOptionPane.showMessageDialog(frm, "Error while fetching reservations", "Fill reservations", JOptionPane.INFORMATION_MESSAGE);

          //  Logger.getLogger(SearchFlightsController.class.getName()).log(Level.SEVERE, null, ex);
        }
        ReservationTableModel model = new ReservationTableModel(reservations);
        frm.getTbReservations().setModel(model);

    }

    private void tidyReservationsTableAfterSearch(List<Reservation> list) {
        ReservationTableModel model = (ReservationTableModel) frm.getTbReservations().getModel();
        model.clear();
        model.addReservations(list);
    }
       private void prepareView() {
         fillTblReservations();

           switch (mode){
            case USE_CASE_DELETE:
                frm.getBtnDelete().setEnabled(true);
                frm.getBtnEdit().setEnabled(false);
                frm.getBtnShow().setEnabled(false);
                break;
            case USE_CASE_UPDATE:
                frm.getBtnEdit().setEnabled(true);
                frm.getBtnDelete().setEnabled(false);
                frm.getBtnShow().setEnabled(false);
                break;
            case USE_CASE_SEARCH:
                frm.getBtnShow().setEnabled(true);
                frm.getBtnDelete().setEnabled(false);
                frm.getBtnEdit().setEnabled(false);

                break;  
            
        }
       }
                   private void closeProgramOnSocketException() {
        JOptionPane.showMessageDialog(null, "Server closed the connection!\n Program will now exit!", "Error!", JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }
}
