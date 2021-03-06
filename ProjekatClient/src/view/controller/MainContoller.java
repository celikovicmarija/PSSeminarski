package view.controller;

import communication.Communication;
import java.awt.event.ActionEvent;
import domain.User;
import constant.Constants;
import coordinator.MainCoordinator;
import exception.CommunicationException;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import view.form.FrmUserMain;
import view.form.util.FormMode;

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
        prepareForm();
        frmMain.setVisible(true);

    }
    private void prepareForm(){
        User user = (User) MainCoordinator.getInstance().getParam(Constants.CURRENT_USER);
        frmMain.getLblLoggedUser().setText(user.getFirstName() + " " + user.getLastName());
        frmMain.setLocationRelativeTo(null);
        frmMain.setExtendedState(Frame.MAXIMIZED_BOTH);
    }
        

    private void addActionListener() {
        frmMain.miCreateFlightAddActionListener((ActionEvent e) -> {
            MainCoordinator.getInstance().openCreateFlightForm();
        });
        frmMain.miCreatePassengerAddActionListener((ActionEvent e) -> {
            MainCoordinator.getInstance().openCreatePassengerForm(FormMode.FORM_EDIT);
        });

        frmMain.miCreateReservationAddActionListener((java.awt.event.ActionEvent evt) -> {
            MainCoordinator.getInstance().openCreateReservationForm();
        });
        frmMain.miSearchFlightsAddActionListener((java.awt.event.ActionEvent evt) -> {
            MainCoordinator.getInstance().openSearchFlightsForm(FormMode.USE_CASE_SEARCH);
        });
        frmMain.miSearchReservationsAddActionListener((java.awt.event.ActionEvent evt) -> {
            MainCoordinator.getInstance().openSearchResevationsForm(FormMode.USE_CASE_SEARCH);
        });

        frmMain.miDeleteFlightAddActionListener((java.awt.event.ActionEvent evt) -> {
            MainCoordinator.getInstance().openSearchFlightsForm(FormMode.USE_CASE_DELETE);
        });
        frmMain.miDeleteReservationAddActionListener((java.awt.event.ActionEvent evt) -> {
            MainCoordinator.getInstance().openSearchResevationsForm(FormMode.USE_CASE_DELETE);
        });
        frmMain.miAboutAddActionListener((java.awt.event.ActionEvent evt) -> {
            MainCoordinator.getInstance().openAboutForm();
        });

        frmMain.miUpdateFlightAddActionListener((java.awt.event.ActionEvent evt) -> {
            MainCoordinator.getInstance().openSearchFlightsForm(FormMode.USE_CASE_UPDATE);
        });
        frmMain.miUpdateReservationAddActionListener((java.awt.event.ActionEvent evt) -> {
            MainCoordinator.getInstance().openSearchResevationsForm(FormMode.USE_CASE_UPDATE);
        });

        frmMain.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                logoutUser();
            }

        });
        frmMain.miLogoutAddActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutUser();
                MainCoordinator.getInstance().openLoginForm();

            }

        });

    }

    public void logout() {
        JOptionPane.showMessageDialog(frmMain, "Server stopped working. Bye!", "Logout", JOptionPane.INFORMATION_MESSAGE);
        MainCoordinator.getInstance().removeParam(Constants.CURRENT_USER, MainCoordinator.getInstance().getParam(Constants.CURRENT_USER));
        frmMain.dispose();
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

        } catch (CommunicationException e) {
            closeProgramOnSocketException();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(frmMain, "Error while trying to perform the request op", "Logout ", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void closeProgramOnSocketException() {
        JOptionPane.showMessageDialog(null, "Server closed the connection!\n Program will now exit!", "Error!", JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }
}
