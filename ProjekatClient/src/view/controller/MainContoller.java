package view.controller;

import communication.Communication;
import java.awt.event.ActionEvent;
import domain.User;
import constant.Constants;
import coordinator.MainCoordinator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import view.form.FrmUserMain;

public class MainContoller {

    private final FrmUserMain frmMain;

    public FrmUserMain getFrmMain() {
        return frmMain;
    }

    public MainContoller(FrmUserMain frmMain) {
        this.frmMain = frmMain;
        this.frmMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addActionListener();
    }

    public void openForm() {
        User user = (User) MainCoordinator.getInstance().getParam(Constants.CURRENT_USER);
        frmMain.getLblLoggedUser().setText(user.getFirstName() + " " + user.getLastName());
        frmMain.setVisible(true);
    }

    private void addActionListener() {
        frmMain.miCreateFlightAddActionListener((ActionEvent e) -> {
            MainCoordinator.getInstance().openCreateFlightForm();
        });
        frmMain.miCreatePassengerAddActionListener((ActionEvent e) -> {
            MainCoordinator.getInstance().openCreatePassengerForm();
        });

        frmMain.miCreateReservationAddActionListener((java.awt.event.ActionEvent evt) -> {
            MainCoordinator.getInstance().openCreateReservationForm();
        });
        frmMain.miSearchFlightsAddActionListener((java.awt.event.ActionEvent evt) -> {
            MainCoordinator.getInstance().openSearchFlightsForm();
        });
        frmMain.miSearchReservationsAddActionListener((java.awt.event.ActionEvent evt) -> {
            MainCoordinator.getInstance().openSearchResevationsForm();
        });

        frmMain.miDeleteFlightAddActionListener((java.awt.event.ActionEvent evt) -> {
            //check to see how are you going to implement disabled buttons
            MainCoordinator.getInstance().openSearchFlightsForm();
        });
        frmMain.miDeleteReservationAddActionListener((java.awt.event.ActionEvent evt) -> {
            MainCoordinator.getInstance().openSearchResevationsForm();
        });
        frmMain.miAboutAddActionListener((java.awt.event.ActionEvent evt) -> {
            MainCoordinator.getInstance().openAboutForm();
        });
        frmMain.miLogoutAddActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutUser();
            }

            private void logoutUser() {
                try {
                    int result = JOptionPane.showConfirmDialog(frmMain, "Are you sure you want to exit?", "Log out",
                            JOptionPane.YES_NO_OPTION,
                            JOptionPane.QUESTION_MESSAGE);
                    if (result == JOptionPane.YES_OPTION) {
                        Communication.getInstance().logout((User) MainCoordinator.getInstance().getParam(Constants.CURRENT_USER));
                        JOptionPane.showMessageDialog(frmMain, "Goodbye!", "Logout", JOptionPane.INFORMATION_MESSAGE);
                        frmMain.dispose();
                    }

                } catch (Exception ex) {
                  JOptionPane.showMessageDialog(frmMain, "Error while trying to perform the request op", "Logout ", JOptionPane.INFORMATION_MESSAGE);

                   // Logger.getLogger(MainContoller.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        });

    }
    /*
    public FrmMain getFrmMain() {
        return frmMain;
    }*/
}
