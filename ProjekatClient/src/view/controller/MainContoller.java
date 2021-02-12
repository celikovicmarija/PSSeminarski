/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import domain.User;
import constant.Constants;
import coordinator.MainCordinator;
import view.form.FrmUserMain;

public class MainContoller {

    private final FrmUserMain frmMain;

    public MainContoller(FrmUserMain frmMain) {
        this.frmMain = frmMain;
        addActionListener();
    }

    public void openForm() {
        User user = (User) MainCordinator.getInstance().getParam(Constants.CURRENT_USER);
        //frmMain.getLblCurrentUser().setText(user.getFirstname() + ", " + user.getLastname());
        frmMain.setVisible(true);
    }

    private void addActionListener() {
        frmMain.miCreateFlightAddActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainCordinator.getInstance().openCreateFlightForm();
            }
        });
        frmMain.miSearchFlightsAddActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MainCordinator.getInstance().openSearchFlightsForm();
            }

        });

        frmMain.miCreateReservationAddActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MainCordinator.getInstance().openCreateReservationForm();
            }

        });

        /*  frmMain.jmiProductShowAllActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiProductShowAllActionPerformed(evt);
            }

            private void jmiProductShowAllActionPerformed(java.awt.event.ActionEvent evt) {
                MainCordinator.getInstance().openViewAllProductForm();
            }
        });*/
    }
    /*
    public FrmMain getFrmMain() {
        return frmMain;
    }*/
}
