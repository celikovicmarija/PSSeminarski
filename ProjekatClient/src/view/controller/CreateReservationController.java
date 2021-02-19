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
import view.form.FrmCreateReservation;
import view.form.component.table.FlightTableModel;
import view.form.component.table.PassengerTableModel;
import view.form.util.FormMode;

public class CreateReservationController {

    private final FrmCreateReservation frm;

    public CreateReservationController(FrmCreateReservation frm) {
        this.frm = frm;
        this.frm.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        addActionListeners();
    }

    public void openForm() {
        prepareView();
        frm.setVisible(true);
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
                        JOptionPane.showMessageDialog(frm, "Error while fetching flights", "Search flights", JOptionPane.INFORMATION_MESSAGE);
                        //Logger.getLogger(CreateReservationController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    try {
                        Flight flight = new Flight();
                        flight.setSearchCriteria(criteria);
                        List<Flight> flights = Communication.getInstance().searchFlights(flight);
                        if (flights != null) {
                            JOptionPane.showMessageDialog(frm, "Found results for the flights", "Search flights", JOptionPane.INFORMATION_MESSAGE);
                            tidyFlightTableAfterSearch(flights);
                        } else {
                            JOptionPane.showMessageDialog(frm, "Could not find results for the flights", "Search flights", JOptionPane.INFORMATION_MESSAGE);

                        }
                    } catch (CommunicationException e) {
                        closeProgramOnSocketException();
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(frm, "Error while fetching flights", "Search flights", JOptionPane.INFORMATION_MESSAGE);

                        //Logger.getLogger(CreateReservationController.class.getName()).log(Level.SEVERE, null, ex);
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
                    } catch (CommunicationException e) {
                        closeProgramOnSocketException();
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(frm, "Error while fetching passengers", "Search passengers", JOptionPane.INFORMATION_MESSAGE);

                    }
                } else {
                    try {
                        Passenger passenger = new Passenger();
                        passenger.setSearchCriteria(criteria);
                        List<Passenger> passengers = Communication.getInstance().searchPassengers(passenger);
                        if (passengers != null) {
                            JOptionPane.showMessageDialog(frm, "Found results for the passengers", "Search passengers", JOptionPane.INFORMATION_MESSAGE);
                            tidyPassengerTableAfterSearch(passengers);
                        } else {
                            JOptionPane.showMessageDialog(frm, "Could not find results for the passengers", "Search passengers", JOptionPane.INFORMATION_MESSAGE);

                        }
                    } catch (CommunicationException e) {
                        closeProgramOnSocketException();
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(frm, "Error while fetching passengers", "Search passengers", JOptionPane.INFORMATION_MESSAGE);
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
                Passenger passenger = new Passenger();
                BigDecimal p = BigDecimal.ZERO;
                BigDecimal dp = BigDecimal.ZERO;

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
                }

                String price = null;
                price = frm.getTxtPrice().getText();
                if (price == null) {
                    price = "0";
                } else {
                    try {
                        p = new BigDecimal(price);
                    } catch (Exception eq) {
                        err += "Wrong format for the price";
                    }
                }
                String discountedPrice = null;
                discountedPrice = frm.getTxtDiscountedPrice().getText();
                if (discountedPrice == null) {
                    discountedPrice = "0";
                } else {
                    try {
                        dp = new BigDecimal(discountedPrice);
                    } catch (Exception eq) {
                        err += "Wrong format for the discounted price";
                    }
                }

                Date validUntil = null;
                try {
                    validUntil = Date.valueOf(frm.getTxtValidUntil().getText());
                } catch (Exception ex) {

                }
                if (validUntil == null) {
                    err += "You must enter an expiration date\n";
                }

                Date issuedDate = null;
                try {
                    issuedDate = Date.valueOf(frm.getTxtIssueDate().getText());
                } catch (Exception ex) {

                }
                if (issuedDate == null) {
                    err += "You must enter a issue date\n";
                }
                if (issuedDate != null && validUntil != null) {
                    if (issuedDate.after(validUntil)) {
                        err += " Coupon must be valid after the issueDate\n";
                    }
                }
                Coupon c = null;
                c = (Coupon) frm.getCbCoupons().getSelectedItem();

                if (err.equals("")) {
                    try {
                        Reservation reservation = new Reservation();

                        reservation.setPrice(p);
                        reservation.setDiscountedPrice(dp);
                        reservation.setFlight(flight);
                        reservation.setPassenger(passenger);
                        reservation.setIssueDate(issuedDate);
                        reservation.setValidUntil(validUntil);
                        reservation.setCoupon(c);
                        Communication.getInstance().addReservation(reservation);
                        JOptionPane.showMessageDialog(frm, "Reservation created successfully!", "Create Reservation", JOptionPane.INFORMATION_MESSAGE);
                        MainCoordinator.getInstance().addParam(Constants.PARAM_RESERVATION, reservation);
                        MainCoordinator.getInstance().openUpdateResevationForm(FormMode.FORM_VIEW);

                    } catch (CommunicationException e) {
                        closeProgramOnSocketException();
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
        frm.setLocationRelativeTo(null);
        fillTblFlights();
        fillTblPassengers();
        fillCbCoupons();
    }

    private void fillTblFlights() {
        List<Flight> flights = null;
        try {
            flights = Communication.getInstance().getAllFlights();
        } catch (CommunicationException e) {
            closeProgramOnSocketException();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(frm, "Error while fetching flights", "Fill flights", JOptionPane.INFORMATION_MESSAGE);
        }
        FlightTableModel model = new FlightTableModel(flights);
        frm.getTblFlights().setModel(model);
        frm.getTblFlights().setAutoCreateRowSorter(true); 


    }

    private void fillTblPassengers() {
        List<Passenger> passengers = null;
        try {
            passengers = Communication.getInstance().getAllPassengers();
        } catch (CommunicationException e) {
            closeProgramOnSocketException();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(frm, "Error while fetching passengers", "Fill passengers", JOptionPane.INFORMATION_MESSAGE);

        }
        PassengerTableModel model = new PassengerTableModel(passengers);
        frm.getTblPassengers().setModel(model);
       frm.getTblPassengers().setAutoCreateRowSorter(true); 


    }

    private void tidyPassengerTableAfterSearch(List<Passenger> list) {
        PassengerTableModel model = (PassengerTableModel) frm.getTblPassengers().getModel();
        model.clear();
        model.addPassengers(list);
        frm.getTblPassengers().setAutoCreateRowSorter(true); 

    }

    private void tidyFlightTableAfterSearch(List<Flight> list) {
        FlightTableModel model = (FlightTableModel) frm.getTblFlights().getModel();
        model.clear();
        model.addFlights(list);
        frm.getTblFlights().setAutoCreateRowSorter(true); 

    }

    private void fillCbCoupons() {
        try {
            frm.getCbCoupons().removeAllItems();
            frm.getCbCoupons().setModel(new DefaultComboBoxModel(Communication.getInstance().getAllCoupons().toArray()));
       
        } catch (CommunicationException e) {
            closeProgramOnSocketException();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(frm, "Error while fetching coupons", "Fill flights", JOptionPane.INFORMATION_MESSAGE);
        }

    }

    private void closeProgramOnSocketException() {
        JOptionPane.showMessageDialog(null, "Server closed the connection!\n Program will now exit!", "Error!", JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }
}
