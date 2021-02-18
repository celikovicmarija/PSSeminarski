package view.controller;

import communication.Communication;
import domain.Flight;
import constant.Constants;
import coordinator.MainCoordinator;
import exception.CommunicationException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import view.form.FrmSearchFlights;
import view.form.component.table.FlightTableModel;
import view.form.util.FormMode;

public class SearchFlightsController {

    private  FrmSearchFlights frm;
    private FormMode mode;

    public SearchFlightsController(FrmSearchFlights frm,FormMode mode) {
        this.frm = frm;
        this.mode=mode;
        this.frm.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        addActionListeners();
    }

    public FrmSearchFlights getFrm() {
        return frm;
    }

    public void setFrm(FrmSearchFlights frm) {
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
                int row = frm.getTblFlights().getSelectedRow();
                if (row < 0) {
                    JOptionPane.showMessageDialog(frm, "Please select a flight to show", "Show flight", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    FlightTableModel ftc = (FlightTableModel) frm.getTblFlights().getModel();
                    List<Flight> flights = ftc.getFlights();
                    Flight flight = flights.get(row);
                    MainCoordinator.getInstance().addParam(Constants.PARAM_FLIGHT, flight);
                    MainCoordinator.getInstance().openUpdateFlightForm(FormMode.FORM_VIEW);
                   // tidyFlightsTableAfterSearch(flights);
                    ftc.refresh();
                }
            }
         });
        frm.addBtnEditActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                editFlight();

            }

            private void editFlight() {
                int row = frm.getTblFlights().getSelectedRow();
                if (row < 0) {
                    JOptionPane.showMessageDialog(frm, "Please select a flight to edit", "Edit flight", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    FlightTableModel ftc = (FlightTableModel) frm.getTblFlights().getModel();
                    List<Flight> flights = ftc.getFlights();
                    Flight flight = flights.get(row);
                    MainCoordinator.getInstance().addParam(Constants.PARAM_FLIGHT, flight);
                    MainCoordinator.getInstance().openUpdateFlightForm(FormMode.FORM_EDIT);
                   // tidyFlightsTableAfterSearch(flights);
                    ftc.refresh();
                }
            }
        });

        frm.addBtnDeleteActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteFlight();
            }

            private void deleteFlight() {
                int row = frm.getTblFlights().getSelectedRow();
                if (row < 0) {
                    JOptionPane.showMessageDialog(frm, "Please select a flight to delete", "Delete flight", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    try {
                        FlightTableModel ftc = (FlightTableModel) frm.getTblFlights().getModel();
                        List<Flight> flights = ftc.getFlights();

                        Flight flight = flights.get(row);
                         MainCoordinator.getInstance().addParam(Constants.PARAM_FLIGHT, flight);
                    MainCoordinator.getInstance().openUpdateFlightForm(FormMode.FORM_DELETE);
                                        
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(frm, "Could not delete selected flight", "Delete flight", JOptionPane.INFORMATION_MESSAGE);
                      //  Logger.getLogger(SearchFlightsController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });

        frm.addBtnSearchActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchFlights();
            }

            private void searchFlights() {
                String criteria = frm.getTxtLine().getText();
                if (criteria.isEmpty() || criteria.equals("*")) {
                    try {
                        List<Flight> flights = Communication.getInstance().getAllFlights();
                        if (flights != null) {
                       
                                     JOptionPane.showMessageDialog(frm, "Found results for the flights", "Search flights", JOptionPane.INFORMATION_MESSAGE);
                            tidyFlightsTableAfterSearch(flights);
                       
                           
                       } else {
                            JOptionPane.showMessageDialog(frm, "Could not find results for the flights", "Search flights", JOptionPane.INFORMATION_MESSAGE);

                        }
                    } catch(CommunicationException e){
                        closeProgramOnSocketException();
                    }catch (Exception ex) {
                  JOptionPane.showMessageDialog(frm, "Error while fetching flights", "Search flights", JOptionPane.INFORMATION_MESSAGE);

                     //   Logger.getLogger(SearchFlightsController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    try {

                        Flight flight = new Flight();
                        flight.setSearchCriteria(criteria);

                        List<Flight> flights = Communication.getInstance().searchFlights(flight);
                        if (flights != null && flights.size() > 0) {
                            JOptionPane.showMessageDialog(frm, "Found results for the flights", "Search flights", JOptionPane.INFORMATION_MESSAGE);
                            tidyFlightsTableAfterSearch(flights);
                        } else {
                            JOptionPane.showMessageDialog(frm, "Could not find results for the flights", "Search flights", JOptionPane.INFORMATION_MESSAGE);

                        }
                    }catch(CommunicationException e){
                        closeProgramOnSocketException();
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(frm, "Error while fetching flights", "Search flights", JOptionPane.INFORMATION_MESSAGE);

                       // Logger.getLogger(SearchFlightsController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }

        });
    }

    private void fillTblFlights() {
        List<Flight> flights = null;
        try {
            flights = Communication.getInstance().getAllFlights();
        }catch(CommunicationException e){
                        closeProgramOnSocketException();
                    } catch (Exception ex) {
         JOptionPane.showMessageDialog(frm, "Error while fetching flights", "Fill flights", JOptionPane.INFORMATION_MESSAGE);

           // Logger.getLogger(SearchFlightsController.class.getName()).log(Level.SEVERE, null, ex);
        }
        FlightTableModel model = new FlightTableModel(flights);
        frm.getTblFlights().setModel(model);
    }

    private void tidyFlightsTableAfterSearch(List<Flight> list) {
        FlightTableModel model = (FlightTableModel) frm.getTblFlights().getModel();
        model.clear();
        model.addFlights(list);
    }

    private void prepareView() {
         fillTblFlights();
        switch (mode){
            case USE_CASE_DELETE:
                frm.getBtnDelete().setEnabled(true);
                frm.getBtnEdit().setEnabled(false);
                frm.getBtnShow().setEnabled(false);
                break;
            case USE_CASE_UPDATE:
                frm.getBtnDelete().setEnabled(false);
                frm.getBtnEdit().setEnabled(true);
                frm.getBtnShow().setEnabled(false);
                break;
            case USE_CASE_SEARCH:
                frm.getBtnEdit().setEnabled(false);
                frm.getBtnDelete().setEnabled(false);
                frm.getBtnShow().setEnabled(true);
                break;
            
            
        }
    
    }
                private void closeProgramOnSocketException() {
        JOptionPane.showMessageDialog(null, "Server closed the connection!\n Program will now exit!", "Error!", JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }

}
