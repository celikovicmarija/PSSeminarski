/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.controller;

import communication.Communication;
import domain.Flight;
import domain.Line;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import view.form.FrmSearchFlights;
import view.form.component.table.FlightTableModel;

/**
 *
 * @author Marija
 */
public class SearchFlightsController {
    private final FrmSearchFlights frm;

    public SearchFlightsController(FrmSearchFlights frm) {
        this.frm = frm;
        addActionListeners();
    }
    public void openForm(){
        frm.setVisible(true);
        fillTblFlights();
    }

    private void addActionListeners() {
        frm.addBtnEditActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                editFlight();
            }

            private void editFlight() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
        
        
      
        
           frm.addBtnSearchActionListener(new ActionListener() {
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
                       //     tidyFlightsTableAfterSearch(lines);
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
                           // tidyFlightsTableAfterSearch(lines);
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

    private void fillTblFlights() {
        List<Flight> flights = null;
        try {
            flights = Communication.getInstance().getAllFlights();
        } catch (Exception ex) {
            Logger.getLogger(SearchFlightsController.class.getName()).log(Level.SEVERE, null, ex);
        }
        FlightTableModel model= new FlightTableModel(flights);
        frm.getTblFlights().setModel(model);
    }
      private void tidyFlightsTableAfterSearch(List<Flight> list) {
        FlightTableModel model = (FlightTableModel) frm.getTblFlights().getModel();
        model.clear();
        model.addFlights(list);
    }
    
}
