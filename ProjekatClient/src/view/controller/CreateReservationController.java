/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.controller;

import communication.Communication;
import domain.Airplane;
import domain.Airport;
import domain.Flight;
import domain.Line;
import domain.Passenger;
import domain.Reservation;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Time;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import view.form.FrmCreateReservation;
import view.form.component.table.AirplaneTableModel;
import view.form.component.table.AirportTableModel;
import view.form.component.table.FlightTableModel;
import view.form.component.table.LineTableModel;
import view.form.component.table.PassengerTableModel;

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
        prepareView();
    }

    private void addActionListeners() {
                frm.addSearchFlightsBtnActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchFlights();
            }

            private void searchFlights() {
           String criteria = frm.getTxtAirline().getText();
                if (criteria.isEmpty() || criteria.equals("*")) {
                    try {
                        List<Flight> flights = Communication.getInstance().getAllFlights();
                        if (flights != null) {
                            JOptionPane.showMessageDialog(frm, "Found results for the flights", "Search flights", JOptionPane.INFORMATION_MESSAGE);
                            tidyFlightTableAfterSearch(flights);
                        } else {
                            JOptionPane.showMessageDialog(frm, "Could not find results for the flights", "Search flights", JOptionPane.INFORMATION_MESSAGE);

                        }
                    } catch (Exception ex) {
                        Logger.getLogger(CreateReservationController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    try {
                        Flight flight= new Flight();
                        flight.setSearchCriteria(criteria);
                        List<Flight> flights = Communication.getInstance().searchFlights(flight);
                        if (flights != null) {
                            JOptionPane.showMessageDialog(frm, "Found results for the flights", "Search flights", JOptionPane.INFORMATION_MESSAGE);
                            tidyFlightTableAfterSearch(flights);
                        } else {
                            JOptionPane.showMessageDialog(frm, "Could not find results for the flights", "Search flights", JOptionPane.INFORMATION_MESSAGE);

                        }
                    } catch (Exception ex) {
                        Logger.getLogger(CreateReservationController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });
                
        frm.addSearchPasengersBtnActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchPassengers();
            }

            private void searchPassengers() {
                                String criteria = frm.getTxtPassenger().getText();
                if (criteria.isEmpty() || criteria.equals("*")) {
                    try {
                        List<Passenger> passengers = Communication.getInstance().getAllPassengers();
                        if (passengers != null) {
                            JOptionPane.showMessageDialog(frm, "Found results for the passengers", "Search passengers", JOptionPane.INFORMATION_MESSAGE);
                            tidyPassengerTableAfterSearch(passengers);
                        } else {
                            JOptionPane.showMessageDialog(frm, "Could not find results for the passengers", "Search passengers", JOptionPane.INFORMATION_MESSAGE);

                        }
                    } catch (Exception ex) {
                        Logger.getLogger(CreateReservationController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    try {
                        Passenger passenger= new Passenger();
                        passenger.setSearchCriteria(criteria);
                        List<Passenger> passengers = Communication.getInstance().searchPassengers(passenger);
                        if (passengers != null) {
                            JOptionPane.showMessageDialog(frm, "Found results for the passengers", "Search passengers", JOptionPane.INFORMATION_MESSAGE);
                            tidyPassengerTableAfterSearch(passengers);
                        } else {
                            JOptionPane.showMessageDialog(frm, "Could not find results for the passengers", "Search passengers", JOptionPane.INFORMATION_MESSAGE);

                        }
                    } catch (Exception ex) {
                        Logger.getLogger(CreateReservationController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });
        frm.addSaveBtnActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveReservation();
            }

            private void saveReservation() {
                                String err = "";
                int row = frm.getTblFlights().getSelectedRow();
                Flight flight = new Flight();
                Passenger passenger= new Passenger();
                
                if (row >= 0) {
                    flight = ((FlightTableModel) frm.getTblFlights().getModel()).getFlightAt(row);
                } else {
                    err += "You must select a flight\n";
                }
                int rowp = frm.getTblPassengers().getSelectedRow();
                if (rowp >= 0) {
                    passenger = ((PassengerTableModel) frm.getTblPassengers().getModel()).getPassengerAt(rowp);
                } else {
                    err += "You must select a passenger\n";
                    // JOptionPane.showMessageDialog(frm,err , "Create Flight", JOptionPane.ERROR_MESSAGE);
                }
            
                String price=null;
                price= frm.getTxtPrice().getText();
                if (price == null) {
                    err += "You must enter the price\n";
                }
                     String discountedPrice=null;
                discountedPrice= frm.getTxtDiscountedPrice().getText();
                if (price == null) {
                    err += "You must enter the  discounted price\n";
                }
 
                Date validUntil =null;
                try{
                      validUntil=Date.valueOf(frm.getTxtValidUntil().getText());
                }catch(Exception ex){
                    
                }
                if (validUntil == null) {
                    err += "You must enter an expiration date\n";
                }
                
                    Date issuedDate =null;
                try{
                      issuedDate=Date.valueOf(frm.getTxtIssueDate().getText());
                }catch(Exception ex){
                    
                }
                if (issuedDate == null) {
                    err += "You must enter a issue date\n";
                }
         
                    if (err.equals("")) {
                    try {
                        Reservation reservation = new Reservation();
                       BigDecimal p=new BigDecimal(price);
                        BigDecimal dp=new BigDecimal(discountedPrice);
                        reservation.setPrice(p);
                        reservation.setDiscountedPrice(dp);
                        reservation.setFlight(flight);
                        reservation.setPassenger(passenger);
                        reservation.setIssueDate(issuedDate);
                        reservation.setValidUntil(validUntil);
                        
 
                        Communication.getInstance().addReservation(reservation);
                         JOptionPane.showMessageDialog(frm, "Reservation created successfully!", "Create Reservation", JOptionPane.INFORMATION_MESSAGE);
                    } catch (Exception ex) {
                      JOptionPane.showMessageDialog(frm, "Error saving the reservation", "Create Reservation", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(frm, err, "Create Flight", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        
    }

    private void prepareView() {
        fillTblFlights();
        fillTblPassengers();
    }

    private void fillTblFlights() {
               List<Flight> flights = null;
        try {
            flights = Communication.getInstance().getAllFlights();
        } catch (Exception ex) {
            Logger.getLogger(CreateFlightController.class.getName()).log(Level.SEVERE, null, ex);
        }
        FlightTableModel model = new FlightTableModel(flights);
        frm.getTblFlights().setModel(model);
    
    }

    private void fillTblPassengers() {
                     List<Passenger> passengers = null;
        try {
            passengers = Communication.getInstance().getAllPassengers();
        } catch (Exception ex) {
            Logger.getLogger(CreateFlightController.class.getName()).log(Level.SEVERE, null, ex);
        }
        PassengerTableModel model = new PassengerTableModel(passengers);
        frm.getTblPassengers().setModel(model);
    
    }
     private void tidyPassengerTableAfterSearch(List<Passenger> list) {
        PassengerTableModel model = (PassengerTableModel) frm.getTblPassengers().getModel();
        model.clear();
        model.addPassengers(list);
    }
          private void tidyFlightTableAfterSearch(List<Flight> list) {
        FlightTableModel model = (FlightTableModel) frm.getTblFlights().getModel();
        model.clear();
        model.addFlights(list);
    }
    
}
