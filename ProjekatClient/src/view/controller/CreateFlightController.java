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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.Time;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import view.form.FrmCreateFlight;
import view.form.component.table.AirplaneTableModel;
import view.form.component.table.AirportTableModel;
import view.form.component.table.LineTableModel;

/**
 *
 * @author Marija
 */
public class CreateFlightController {

    private final FrmCreateFlight frm;

    public CreateFlightController(FrmCreateFlight frm) {
        this.frm = frm;
        addActionListeners();
    }

    public void openForm() {
      
        frm.setVisible(true);
          prepareView();
        
    }

    private void addActionListeners() {
        frm.addSaveBtnActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                save();
            }

            private void save() {
                String err = "";
                int row = frm.getTblAirplanes().getSelectedRow();
                Airport airport = new Airport();
                Airplane airplane = new Airplane();
                Line line= new Line();
                if (row >= 0) {
                    airplane = ((AirplaneTableModel) frm.getTblAirplanes().getModel()).getAirplaneAt(row);
                } else {
                    err += "You must select an airplane\n";
                    //  JOptionPane.showMessageDialog(frm,err , "Create Flight", JOptionPane.ERROR_MESSAGE);
                }
                int rowp = frm.getTblAirports().getSelectedRow();
                if (rowp >= 0) {
                    airport = ((AirportTableModel) frm.getTblAirports().getModel()).getAirportAt(rowp);
                } else {
                    err += "You must select an airport\n";
                    // JOptionPane.showMessageDialog(frm,err , "Create Flight", JOptionPane.ERROR_MESSAGE);
                }
                int rowl = frm.getTblLines().getSelectedRow();
                if (rowl >= 0) {
                    line = ((LineTableModel) frm.getTblLines().getModel()).getLineAt(rowl);
                    System.out.println("Line: "+line);
                } else {
                    err += "You must select a line\n";
                    // JOptionPane.showMessageDialog(frm,err , "Create Flight", JOptionPane.ERROR_MESSAGE);
                }
                String airline=null;
                airline= frm.getTxtAirline().getText();
                if (airline == null) {
                    err += "You must enter an airline\n";
                }
                String note=null;
                note= frm.getTxtNote().getText();
                if (note == null) {
                    note = "";
                }
                Date date =null;
                try{
                      date=Date.valueOf(frm.getTxtDate().getText());
                }catch(Exception ex){
                    
                }
                if (date == null) {
                    err += "You must enter a departure date\n";
                }
                Time time =null;
                try{
                    time= Time.valueOf(frm.getTxtTime().getText());
                }catch(Exception ex){
                
                }
                
                if (time == null) {
                    err += "You must enter time of the departure\n";
                }
                    if (err.equals("")) {
                    try {
                        Flight flight = new Flight();
                        flight.setAirline(airline);
                        flight.setAirplane(airplane);
                        flight.setDate(date);
                        flight.setTime(time);
                        flight.setNote(note);
                        flight.setLine(line);
                        Communication.getInstance().addFlight(flight);
                         JOptionPane.showMessageDialog(frm, "Flight created successfully!", "Create Flight", JOptionPane.INFORMATION_MESSAGE);
                    } catch (Exception ex) {
                      JOptionPane.showMessageDialog(frm, "Error saving the flight", "Create Flight", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(frm, err, "Create Flight", JOptionPane.ERROR_MESSAGE);
                }

            }
        });

        frm.addSearchAirplanesBtnActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchAirplanes();
            }

            private void searchAirplanes() {

                String criteria = frm.getTxtAirplaneName().getText();
                if (criteria.isEmpty() || criteria.equals("*")) {
                    try {
                        List<Airplane> airplanes = Communication.getInstance().getAllAirplanes();
                        if (airplanes != null) {
                            JOptionPane.showMessageDialog(frm, "Found results for the airplanes", "Search airplanes", JOptionPane.INFORMATION_MESSAGE);
                            tidyAirplaneTableAfterSearch(airplanes);
                        } else {
                            JOptionPane.showMessageDialog(frm, "Could not find results for the airplanes", "Search airplanes", JOptionPane.INFORMATION_MESSAGE);

                        }
                    } catch (Exception ex) {
                        Logger.getLogger(CreateFlightController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    try {
                        Airplane airplane = new Airplane();
                        airplane.setSearchCriteria(criteria);
                        List<Airplane> airplanes = Communication.getInstance().searchAirplanes(airplane);
                        if (airplanes != null) {
                            JOptionPane.showMessageDialog(frm, "Found results for the airplanes", "Search airplanes", JOptionPane.INFORMATION_MESSAGE);
                            tidyAirplaneTableAfterSearch(airplanes);
                        } else {
                            JOptionPane.showMessageDialog(frm, "Could not find results for the airplanes", "Search airplanes", JOptionPane.INFORMATION_MESSAGE);

                        }
                    } catch (Exception ex) {
                        Logger.getLogger(CreateFlightController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

            }

        });

        frm.addSearchAirportsBtnActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchAirports();
            }

            private void searchAirports() {
                String criteria = frm.getTxtAirportName().getText();
                if (criteria.isEmpty() || criteria.equals("*")) {
                    try {
                        List<Airport> airports = Communication.getInstance().getAllAirports();
                        if (airports != null) {
                            JOptionPane.showMessageDialog(frm, "Found results for the airports", "Search airports", JOptionPane.INFORMATION_MESSAGE);
                            tidyAirportTableAfterSearch(airports);
                        } else {
                            JOptionPane.showMessageDialog(frm, "Could not find results for the airports", "Search airports", JOptionPane.INFORMATION_MESSAGE);

                        }
                    } catch (Exception ex) {
                        Logger.getLogger(CreateFlightController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    try {
                        Airport airport = new Airport();
                        airport.setSearchCriteria(criteria);
                        List<Airport> airports = Communication.getInstance().searchAirports(airport);
                        if (airports != null) {
                            JOptionPane.showMessageDialog(frm, "Found results for the airports", "Search airports", JOptionPane.INFORMATION_MESSAGE);
                            tidyAirportTableAfterSearch(airports);
                        } else {
                            JOptionPane.showMessageDialog(frm, "Could not find results for the airports", "Search airports", JOptionPane.INFORMATION_MESSAGE);

                        }
                    } catch (Exception ex) {
                        Logger.getLogger(CreateFlightController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });

        frm.addSearchLinesBtnActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchLines();
            }

            private void searchLines() {
                String criteria = frm.getTxtLine().getText();
             
                if (criteria.isEmpty() || criteria.equals("*")) {
                    try {
                        List<Line> lines = Communication.getInstance().getAllLines();
                        if (lines != null) {
                            JOptionPane.showMessageDialog(frm, "Found results for the lines", "Search lines", JOptionPane.INFORMATION_MESSAGE);
                            tidyLinesTableAfterSearch(lines);
                        } else {
                            JOptionPane.showMessageDialog(frm, "Could not find results for the lines", "Search airports", JOptionPane.INFORMATION_MESSAGE);

                        }
                    } catch (Exception ex) {
                        Logger.getLogger(CreateFlightController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    try {
                        Line line = new Line();
                        //check for errors
                        String[] parts = criteria.split(",", 2);
                        line.setSearchCriteriaSrc(parts[0]);
                        line.setSearchCriteriaDest(parts[1]);

                        List<Line> lines = Communication.getInstance().searchLines(line);
                        if (lines != null) {
                            JOptionPane.showMessageDialog(frm, "Found results for the lines", "Search lines", JOptionPane.INFORMATION_MESSAGE);
                            tidyLinesTableAfterSearch(lines);
                        } else {
                            JOptionPane.showMessageDialog(frm, "Could not find results for the airports", "Search airports", JOptionPane.INFORMATION_MESSAGE);

                        }
                    } catch (Exception ex) {
                        Logger.getLogger(CreateFlightController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }

        });

    }

    private void prepareView() {
        fillTblAirports();
        fillTblAiplanes();
        fillTblLines();
    }

    private void fillTblAirports() {
        List<Airport> airports = null;
        try {
            airports = Communication.getInstance().getAllAirports();
        } catch (Exception ex) {
            Logger.getLogger(CreateFlightController.class.getName()).log(Level.SEVERE, null, ex);
        }
        AirportTableModel model = new AirportTableModel(airports);
        frm.getTblAirports().setModel(model);
    }

    private void fillTblAiplanes() {
        List<Airplane> airplanes = null;
        try {
            airplanes = Communication.getInstance().getAllAirplanes();
        } catch (Exception ex) {
            Logger.getLogger(CreateFlightController.class.getName()).log(Level.SEVERE, null, ex);
        }
        AirplaneTableModel model = new AirplaneTableModel(airplanes);
        frm.getTblAirplanes().setModel(model);
    }

    private void fillTblLines() {
        List<Line> lines = null;
        try {
            lines = Communication.getInstance().getAllLines();
        } catch (Exception ex) {
            Logger.getLogger(CreateFlightController.class.getName()).log(Level.SEVERE, null, ex);
        }
        LineTableModel model = new LineTableModel(lines);
        frm.getTblLines().setModel(model);
    }

    private void tidyAirportTableAfterSearch(List<Airport> list) {
        AirportTableModel model = (AirportTableModel) frm.getTblAirports().getModel();
        model.clear();
        model.addAirports(list);
    }

    private void tidyLinesTableAfterSearch(List<Line> list) {
        LineTableModel model = (LineTableModel) frm.getTblLines().getModel();
        model.clear();
        model.addLines(list);
    }

    private void tidyAirplaneTableAfterSearch(List<Airplane> list) {
        AirplaneTableModel model = (AirplaneTableModel) frm.getTblAirplanes().getModel();
        model.clear();
        model.addAirplanes(list);
    }

}
