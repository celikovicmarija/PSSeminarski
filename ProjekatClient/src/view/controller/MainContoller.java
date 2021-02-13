package view.controller;

import java.awt.event.ActionEvent;
import domain.User;
import constant.Constants;
import coordinator.MainCoordinator;
import view.form.FrmUserMain;

public class MainContoller {

    private final FrmUserMain frmMain;

    public FrmUserMain getFrmMain() {
        return frmMain;
    }

    public MainContoller(FrmUserMain frmMain) {
        this.frmMain = frmMain;
        addActionListener();
    }

    public void openForm() {
        User user = (User) MainCoordinator.getInstance().getParam(Constants.CURRENT_USER);
        frmMain.getLblLoggedUser().setText(user.getFirstname() + " " + user.getLastname());
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
                throw new UnsupportedOperationException("Not supported yet.");
            }

        });

    }
    /*
    public FrmMain getFrmMain() {
        return frmMain;
    }*/
}
