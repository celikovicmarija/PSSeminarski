package view.controller;

import communication.Communication;
import constant.Constants;
import coordinator.MainCoordinator;
import domain.Passenger;
import exception.CommunicationException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import view.form.FrmCreatePassenger;
import view.form.util.FormMode;

public class CreatePassengerController {

    private final FrmCreatePassenger frm;
    FormMode mode;
    Passenger newPassenger;

    public CreatePassengerController(FrmCreatePassenger frm, FormMode mode) {
        this.frm = frm;
        this.mode = mode;
        this.frm.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        addActionListeners();
    }

    public void openForm() {
        setupForm(mode);
        frm.setVisible(true);

    }

    private void addActionListeners() {
        frm.addCancelBtnActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frm.dispose();
            }
        });
        frm.addSaveBtnActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                save();
            }

            private void save() {
                String err = "";
                String firstName = frm.getTxtFirstName().getText();
                if (firstName.equals("")) {
                    err += "You must enter passenger's name\n";
                    frm.getLblFirstNameError().setText("Passenger's first name cannot be empty");

                }
                String lastName = frm.getTxtLastName().getText();
                if (lastName.equals("")) {
                    err += "You must enter passenger's last name\n";
                     frm.getLblLastNameError().setText("Passenger's last name cannot be empty");

                }
                String passportNumber = frm.getTxtPassportNumber().getText();
                if (passportNumber.equals("")) {
                    err += "You must enter passenger's passport number\n";
                    frm.getLblPassportError().setText("Passenger's passport number cannot be empty");

                }
                String mlb = frm.getTxtMlb().getText().trim();
                if(!mlb.equals("")){
                    if (mlb.length()!=13){
                          err += "MLB is of wrong length";
                          frm.getLblMLBError().setText("MLB must be the length of 13");
                    }
                }
                if (err.equals("")) {
                    try {
                        Passenger passenger = new Passenger();
                        passenger.setFirstName(firstName);
                        passenger.setLastName(lastName);
                        passenger.setPassportNumber(passportNumber);
                        passenger.setMlb(mlb);
                        Communication.getInstance().addPassenger(passenger);
                        JOptionPane.showMessageDialog(frm, "Passenger created successfully!", "Create Passenger", JOptionPane.INFORMATION_MESSAGE);
                        passenger.setSearchCriteria(passportNumber);
                        Passenger addedPassenger=Communication.getInstance().searchPassengers(passenger).get(0);
                        MainCoordinator.getInstance().addParam(Constants.PARAM_CREATED_PASSENGER, addedPassenger);
                       JOptionPane.showMessageDialog(frm, "Showing new passenger's data", "Create Passenger", JOptionPane.INFORMATION_MESSAGE);
                        setupForm(FormMode.FORM_VIEW);
                    } catch (CommunicationException e) {
                        closeProgramOnSocketException();
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(frm, "Error saving the passenger", "Create Passenger", JOptionPane.ERROR_MESSAGE);
                    }

                } else {
                    JOptionPane.showMessageDialog(frm, err, "Create Passenger", JOptionPane.ERROR_MESSAGE);

                }
            }
        });
    }

    private void setupForm(FormMode mode) {
         frm.setLocationRelativeTo(null);
        newPassenger = (Passenger) MainCoordinator.getInstance().getParam(Constants.PARAM_CREATED_PASSENGER);
        switch (mode) {
            case FORM_VIEW:
                frm.getBtnSave().setEnabled(false);
                frm.getBtnCancel().setEnabled(true);
                frm.setTitle("Passenger");
                frm.getLblTitle().setText("Passenger info");
                break;
            case FORM_EDIT:
                frm.getBtnSave().setEnabled(true);
                frm.getBtnCancel().setEnabled(true);
                frm.setTitle("Passenger");
                frm.getLblTitle().setText("Passenger info");
                break;

        }
    }

    private void closeProgramOnSocketException() {
        JOptionPane.showMessageDialog(null, "Server closed the connection!\n Program will now exit!", "Error!", JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }

}
