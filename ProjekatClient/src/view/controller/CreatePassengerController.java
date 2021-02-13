package view.controller;

import communication.Communication;
import domain.Passenger;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import view.form.FrmCreatePassenger;


public class CreatePassengerController {

    private final FrmCreatePassenger frm;

    public CreatePassengerController(FrmCreatePassenger frm) {
        this.frm = frm;
        this.frm.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        addActionListeners();
    }

    public void openForm() {
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
                String firstName = null;
                firstName = frm.getTxtFirstName().getText();
                if (firstName == null) {
                    err += "You must enter passenger's name\n";

                }
                String lastName = null;
                lastName = frm.getTxtLastName().getText();
                if (lastName == null) {
                    err += "You must enter passenger's last name\n";

                }
                String passportNumber = null;
                passportNumber = frm.getTxtPassportNumber().getText();
                if (passportNumber == null) {
                    err += "You must enter passenger's passport number\n";

                }
                String mlb = null;
                mlb = frm.getTxtMlb().getText();
                if (mlb == null) {
                    mlb = "";

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
                        frm.dispose();
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(frm, "Error saving the passenger", "Create Passenger", JOptionPane.ERROR_MESSAGE);
                    }

                }
            }
        });
    }

}
