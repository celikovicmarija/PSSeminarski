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
import exception.CommunicationException;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import view.form.component.table.FlightTableModel;
import view.form.util.FormMode;

public class UpdateFlightController {

    FrmUpdateFlight frm;
    Flight flight;
    FormMode mode;

    public UpdateFlightController(FrmUpdateFlight frm, FormMode mode) {
        this.frm = frm;
        this.mode=mode;
        this.frm.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        addActionListeners();
    }

    public void openForm() {
        prepareForm(mode);
        frm.setVisible(true);
        JOptionPane.showMessageDialog(frm, "Showing data for the chosen flight", "Message", JOptionPane.INFORMATION_MESSAGE);

    }

    private void prepareForm(FormMode mode) {
        try {

            fillCbLines();
            fillCbAirplanes();
            populateForm();
            switch(mode){
                case FORM_VIEW:
                    frm.getBtnDelete().setEnabled(false);
                    frm.getBtnSave().setEnabled(false);
                    frm.getBtnCancel().setEnabled(true);
                    frm.setTitle("Flight");
                    frm.getLblTitle().setText("Flight info");
                    break;
                case FORM_EDIT:
                    frm.getBtnDelete().setEnabled(false);
                    frm.getBtnSave().setEnabled(true);
                    frm.getBtnCancel().setEnabled(true); 
                    frm.setTitle("Flight");
                       frm.getLblTitle().setText("Flight info");
                    break;
                case FORM_DELETE:
                    frm.getBtnDelete().setEnabled(true);
                    frm.getBtnSave().setEnabled(false);
                    frm.getBtnCancel().setEnabled(true); 
                  frm.setTitle("Flight");
                        frm.getLblTitle().setText("Delete flight info");
                    break;                    
            }
        } catch(CommunicationException e){
                        closeProgramOnSocketException();
                    }
        catch (Exception ex) {
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
                        List<Flight> flights = Communication.getInstance().getAllFlights();

                        if (!flights.contains(flight)) {
                            JOptionPane.showMessageDialog(frm, "Could not delete the flight", "Delete flight", JOptionPane.INFORMATION_MESSAGE);

                        } else {
                            Communication.getInstance().deleteFlight(flight);
                            JOptionPane.showMessageDialog(frm, "Deleted successfully", "Delete flight", JOptionPane.INFORMATION_MESSAGE);
                            FlightTableModel ftm = (FlightTableModel) MainCoordinator.getInstance().getSearchFlightsController().getFrm().getTblFlights().getModel();
                            ftm.deleteFlight(flight);
                            ftm.refresh();

                        //  frm.dispose();
                        }

                    }

                } catch(CommunicationException e){
                        closeProgramOnSocketException();
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
                        //  frm.dispose();
                    } catch(CommunicationException e){
                        closeProgramOnSocketException();
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
            private void closeProgramOnSocketException() {
        JOptionPane.showMessageDialog(null, "Server closed the connection!\n Program will now exit!", "Error!", JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }
}
