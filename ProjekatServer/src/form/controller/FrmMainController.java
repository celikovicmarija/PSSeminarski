/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package form.controller;

import controller.Controller;
import coordinator.ServerCoordinator;
import form.FrmMain;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JOptionPane;

/**
 *
 * @author Marija
 */
public class FrmMainController {

    private final FrmMain frmMain;

    public FrmMainController(FrmMain frmMain) {
        this.frmMain = frmMain;
        addActionListeners();
    }

    public void openForm() {
        frmMain.setVisible(true);
        frmMain.getTblActiveUsers().setVisible(true);
        frmMain.getBtnStopServer().setEnabled(false);
        Controller.getInstance().fillTblUsers(frmMain);
        frmMain.getTblActiveUsers().setAutoCreateRowSorter(true); 
    }

    public FrmMain getFrmMain() {
        return frmMain;
    }

    private void addActionListeners() {
        frmMain.getJmiSettings().addActionListener((ActionEvent e) -> {
            openSettings();
        });
        frmMain.getJmiAboutSoftware().addActionListener((ActionEvent e) -> {
            ServerCoordinator.getInstance().openAboutForm();
        });

        frmMain.addBtnStartServerActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startServer();
            }

            private void startServer() {

                frmMain.setRunning(true);
                frmMain.getBtnStartServer().setEnabled(false);
                frmMain.getBtnStopServer().setEnabled(true);
                frmMain.getLblStatus().setText("Server is running.");
                Controller.getInstance().startServer(frmMain);

            }
        });
        frmMain.addWindowListener(new WindowAdapter() {
            
            @Override
            public void windowClosing(WindowEvent e) {
                if(frmMain.isRunning())
                        stopServer();
            }
            
            
});
        

        frmMain.addBtnStopServerActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                stopServer();
            }

        
        });
    }
        private void stopServer() {
                frmMain.setRunning(false);
                frmMain.getBtnStartServer().setEnabled(true);
                frmMain.getBtnStopServer().setEnabled(false);
                frmMain.getLblStatus().setText("Server is not running.");
                Controller.getInstance().stopServer();

            }

    private void openSettings() {
        if (!frmMain.isRunning())
                    ServerCoordinator.getInstance().openSettingsForm();
        else{
            JOptionPane.showMessageDialog(frmMain, "Please stop the server before configuring the parameters");
        }

    }

}
