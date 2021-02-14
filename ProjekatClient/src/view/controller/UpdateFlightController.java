package view.controller;

import communication.Communication;
import domain.Flight;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.Time;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import view.form.FrmUpdateFlight;
import coordinator.MainCoordinator;
import constant.Constants;
import domain.Airplane;
import domain.Line;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import view.form.component.table.FlightTableModel;

public class UpdateFlightController {

    FrmUpdateFlight frm;
    Flight flight;

    public UpdateFlightController(FrmUpdateFlight frm) {
        this.frm = frm;
        this.frm.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        addActionListeners();
    }

    public void openForm() {
        prepareForm();
        frm.setVisible(true);
       JOptionPane.showMessageDialog(frm, "Showing data for the chosen flight", "Message", JOptionPane.INFORMATION_MESSAGE);

        
    }

    private void prepareForm() {
        try {

            fillCbLines();
            fillCbAirplanes();
            populateForm();
        } catch (Exception ex) {
           JOptionPane.showMessageDialog(frm, "Error while fetching data", "Form preparation", JOptionPane.INFORMATION_MESSAGE);

            Logger.getLogger(UpdateFlightController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void addActionListeners() {

        frm.addBtnCancelActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frm.dispose();
            }
        });
        
           frm.addBtnDeleteActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               delete();
            }

            private void delete() {
           
                    try {
 
                        int result = JOptionPane.showConfirmDialog(frm, "Are you sure you want to delete this flight?", "Delete flight",
                            JOptionPane.YES_NO_OPTION,
                            JOptionPane.QUESTION_MESSAGE);
                    if (result == JOptionPane.YES_OPTION) {
                        Communication.getInstance().deleteFlight(flight);
                        JOptionPane.showMessageDialog(frm, "Deleted successfully", "Delete flight", JOptionPane.INFORMATION_MESSAGE);
                     frm.dispose();
                    }
                
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(frm, "Could not delete selected flight", "Delete flight", JOptionPane.INFORMATION_MESSAGE);
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
                String airline = frm.getTxtAirline().getText();
                String note = frm.getTxtNote().getText();
                 if (airline.equals("")) {
                    err += "You must enter an airline\n";
                }
                Date date = null;
                try {
                    date = Date.valueOf(frm.getTxtDate().getText());
                } catch (Exception ex) {

                }

                if (date == null) {
                    err += "You must enter a departure date\n";
                }
                Time time = null;
                try {
                    time = Time.valueOf(frm.getTxtTime().getText());
                } catch (Exception ex) {

                }
                if (time == null) {
                    err += "You must enter a departure time\n";
                }

                Airplane airplane = null;
                airplane = (Airplane) frm.getCbAirplanes().getSelectedItem();
                Line line = null;
                line = (Line) frm.getCbLines().getSelectedItem();
                if (airplane == null) {
                    err += "You must choose an airplane\n";
                }
                if (line == null) {
                    err += "You must choose a line\n";
                }
                if (err.equals("")) {
                    try {
                        Flight flightEdited = new Flight();
                        flightEdited.setFlightID(flight.getFlightID());
                        flightEdited.setNote(note);
                        flightEdited.setDate(date);
                        flightEdited.setTime(time);
                        flightEdited.setLine(line);
                        flightEdited.setAirplane(airplane);
                        flightEdited.setAirline(airline);
                        Communication.getInstance().editFlight(flightEdited);
                        JOptionPane.showMessageDialog(frm, "Flight successfully updated", "Update flight", JOptionPane.INFORMATION_MESSAGE);
                        frm.dispose();
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(frm, "Cannot update flight", "Update flight", JOptionPane.INFORMATION_MESSAGE);

                    //    Logger.getLogger(UpdateFlightController.class.getName()).log(Level.SEVERE, null, ex);
                    }

                } else {
                    JOptionPane.showMessageDialog(frm, err, "Update flight", JOptionPane.INFORMATION_MESSAGE);
                }

            }
        });
    }

    private void fillCbLines() throws Exception {
         frm.getCbLines().removeAllItems();
        frm.getCbLines().setModel(new DefaultComboBoxModel(Communication.getInstance().getAllLines().toArray()));
    }

    private void fillCbAirplanes() throws Exception {
         frm.getCbAirplanes().removeAllItems();
        frm.getCbAirplanes().setModel(new DefaultComboBoxModel(Communication.getInstance().getAllAirplanes().toArray()));
    }

    private void populateForm() {
        flight = (Flight) MainCoordinator.getInstance().getParam(Constants.PARAM_FLIGHT);
        frm.getTxtAirline().setText(flight.getAirline());
        frm.getTxtNote().setText(flight.getNote());
        frm.getTxtFlightID().setEditable(false);
        frm.getTxtDate().setText(String.valueOf(flight.getDate()));
        frm.getTxtTime().setText(String.valueOf(flight.getTime()));
        frm.getTxtFlightID().setText(String.valueOf(flight.getFlightID()));
        frm.getCbAirplanes().setSelectedItem(flight.getAirplane());
        frm.getCbLines().setSelectedItem(flight.getLine());

    }
  

}
