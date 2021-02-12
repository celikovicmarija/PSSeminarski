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
        Controller.getInstance().fillTblUsers(frmMain);
    } 
        public FrmMain getFrmMain() {
        return frmMain;
    }

    private void addActionListeners() {
        frmMain.getJmiSettings().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                ServerCoordinator.getInstance().openSettingsForm();
            }

        });
        
        frmMain.addBtnStartServerActionListener(new ActionListener(){
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
        
        frmMain.addBtnStopServerActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
               stopServer();
            }

            private void stopServer() { 
                frmMain.setRunning(false);
                frmMain.getBtnStartServer().setEnabled(true);
                frmMain.getBtnStopServer().setEnabled(false);
                frmMain.getLblStatus().setText("Server is not running.");
                Controller.getInstance().stopServer();

            }
        });
    }
    
    
}
