package view.controller;

import communication.Communication;
import constant.Constants;
import coordinator.MainCoordinator;
import domain.Airplane;
import domain.Flight;
import domain.Line;
import exception.CommunicationException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.Time;
import java.util.List;
import java.util.regex.PatternSyntaxException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import view.form.FrmCreateFlight;
import view.form.component.table.AirplaneTableModel;
import view.form.component.table.LineTableModel;
import view.form.util.FormMode;


public class CreateFlightController {

    private final FrmCreateFlight frm;
    

    public CreateFlightController(FrmCreateFlight frm) {
        this.frm = frm;
        frm.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        addActionListeners();
    }

    public void openForm() {
         prepareView();
        frm.setVisible(true);
       
        
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
                Airplane airplane = new Airplane();
                Line line= new Line();
                if (row >= 0) {
                    airplane = ((AirplaneTableModel) frm.getTblAirplanes().getModel()).getAirplaneAt(row);
                } else {
                    err += "You must select an airplane\n";
                }
                int rowl = frm.getTblLines().getSelectedRow();
                if (rowl >= 0) {
                    line = ((LineTableModel) frm.getTblLines().getModel()).getLineAt(rowl);
                    System.out.println("Line: "+line);
                } else {
                    err += "You must select a line\n";
                }
                String airline= frm.getTxtAirline().getText();
                if (airline.equals("")) {
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
                     MainCoordinator.getInstance().addParam(Constants.PARAM_FLIGHT,flight );
                     MainCoordinator.getInstance().openUpdateFlightForm(FormMode.FORM_VIEW);
                    
                    }  catch(CommunicationException e){
                        closeProgramOnSocketException();
                    }catch (Exception ex) {
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
                    }catch(CommunicationException e){
                        closeProgramOnSocketException();
                    } catch (Exception ex) {
                         JOptionPane.showMessageDialog(frm, "Error while fetching airplanes", "Search airplanes", JOptionPane.INFORMATION_MESSAGE);
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
                    }catch(CommunicationException e){
                        closeProgramOnSocketException();
                    } catch (Exception ex) {
                          JOptionPane.showMessageDialog(frm, "Error while fetching airplanes", "Search airplanes", JOptionPane.INFORMATION_MESSAGE);

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
                            JOptionPane.showMessageDialog(frm, "Could not find results for the lines", "Search lines", JOptionPane.INFORMATION_MESSAGE);

                        }
                    }catch(CommunicationException e){
                        closeProgramOnSocketException();
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(frm, "Error while fetching lines", "Search lines", JOptionPane.INFORMATION_MESSAGE);
                    }
                } else {
                    try {
                        Line line = new Line();
                         String[] parts=null;
                        try{
                         parts = criteria.split(",", 2);
                        line.setSearchCriteriaSrc(parts[0]);
                        line.setSearchCriteriaDest(parts[1]);
                        } catch (PatternSyntaxException pse){
                            line.setSearchCriteriaDest(criteria);
                            line.setSearchCriteriaSrc(criteria);
                        }

                        List<Line> lines = Communication.getInstance().searchLines(line);
                        if (lines != null) {
                            JOptionPane.showMessageDialog(frm, "Found results for the lines", "Search lines", JOptionPane.INFORMATION_MESSAGE);
                            tidyLinesTableAfterSearch(lines);
                        } else {
                            JOptionPane.showMessageDialog(frm, "Could not find results for the lines", "Search lines", JOptionPane.INFORMATION_MESSAGE);

                        }
                    } catch(CommunicationException e){
                        closeProgramOnSocketException();
                    }catch (Exception ex) {
                        JOptionPane.showMessageDialog(frm, "Error while fetching lines", "Search lines", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            }

        });

    }

    private void prepareView() {
         frm.setLocationRelativeTo(null);
        fillTblAiplanes();
        fillTblLines();
    }

    private void fillTblAiplanes() {
        List<Airplane> airplanes = null;
        try {
            airplanes = Communication.getInstance().getAllAirplanes();
        }catch(CommunicationException e){
                        closeProgramOnSocketException();
                    } catch (Exception ex) {
          JOptionPane.showMessageDialog(frm, "Error while fetching airplanes", "Fill airplanes", JOptionPane.INFORMATION_MESSAGE);
        }
        AirplaneTableModel model = new AirplaneTableModel(airplanes);
        frm.getTblAirplanes().setModel(model);
        frm.getTblAirplanes().setAutoCreateRowSorter(true);
    }

    private void fillTblLines() {
        List<Line> lines = null;
        try {
            lines = Communication.getInstance().getAllLines();
        } catch(CommunicationException e){
                        closeProgramOnSocketException();
                    }catch (Exception ex) {
            JOptionPane.showMessageDialog(frm, "Error while fetching lines", "Search lines", JOptionPane.INFORMATION_MESSAGE);
        }
        LineTableModel model = new LineTableModel(lines);
        frm.getTblLines().setModel(model);
        frm.getTblLines().setAutoCreateRowSorter(true);
    }

    private void tidyLinesTableAfterSearch(List<Line> list) {
        LineTableModel model = (LineTableModel) frm.getTblLines().getModel();
        model.clear();
        model.addLines(list);
       frm.getTblLines().setAutoCreateRowSorter(true);
    }

    private void tidyAirplaneTableAfterSearch(List<Airplane> list) {
        AirplaneTableModel model = (AirplaneTableModel) frm.getTblAirplanes().getModel();
        model.clear();
        model.addAirplanes(list);
        frm.getTblAirplanes().setAutoCreateRowSorter(true);
    }
            private void closeProgramOnSocketException() {
        JOptionPane.showMessageDialog(null, "Server closed the connection!\n Program will now exit!", "Error!", JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }

}
