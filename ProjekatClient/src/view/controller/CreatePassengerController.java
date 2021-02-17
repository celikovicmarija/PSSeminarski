package view.controller;

import communication.Communication;
import constant.Constants;
import coordinator.MainCoordinator;
import domain.Passenger;
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

    public CreatePassengerController(FrmCreatePassenger frm,FormMode mode) {
        this.frm = frm;
        this.mode=mode;
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
            }});
            frm.addSaveBtnActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                save();
            }

            private void save() {
                String err = "";
                String firstName  = frm.getTxtFirstName().getText();
                if (firstName.equals("")) {
                    err += "You must enter passenger's name\n";

                }
                String lastName = frm.getTxtLastName().getText();
                if (lastName.equals("")) {
                    err += "You must enter passenger's last name\n";

                }
                String passportNumber = frm.getTxtPassportNumber().getText();
                if (passportNumber.equals("")) {
                    err += "You must enter passenger's passport number\n";

                }
                String mlb = frm.getTxtMlb().getText().trim();

                    if(!mlb.equals("") && mlb.length()!=13){
                        err+="MLB is of wrong length";
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
                     //   frm.dispose();
                        setupForm(FormMode.FORM_VIEW);
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(frm, "Error saving the passenger", "Create Passenger", JOptionPane.ERROR_MESSAGE);
                    }

                }else{
                       JOptionPane.showMessageDialog(frm, err, "Create Passenger", JOptionPane.ERROR_MESSAGE);

                }
            }
        });
    }

    private void setupForm(FormMode mode) {
        newPassenger=(Passenger)MainCoordinator.getInstance().getParam(Constants.PARAM_CREATED_PASSENGER);
         switch(mode){
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

}
