/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package form.controller;

import form.FrmSettings;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class FrmSettingsController {

    private final FrmSettings frmSettings;

    public FrmSettingsController(FrmSettings frmSettings) {
        this.frmSettings = frmSettings;
        this.frmSettings.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    }

    public void openForm() {

        frmSettings.setVisible(true);
        addActionListeners();
    }

    private void addActionListeners() {

        frmSettings.btnSaveSettingsAddActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                saveSettings();
            }

            public void saveSettings() {
                String err="";
                String url = frmSettings.getTxtURL().getText();
                if (url.equals(""))err+="You have to enter URL\n";
                String user = frmSettings.getTxtUsername().getText();
                 if (url.equals(""))err+="You have to enter username\n";
                String password = String.copyValueOf(frmSettings.getTxtPassword().getPassword());
                String port = frmSettings.getTxtPort().getText();
                FileOutputStream out = null;
                if(err.equals("")){

                try {
                    out = new FileOutputStream("config/dbconfig.properties");
                    FileInputStream in = new FileInputStream("config/dbconfig.properties");
                    Properties props = new Properties();
                    props.load(in);
                    in.close();

                    props.setProperty("url", url);
                    props.setProperty("username", user);
                    props.setProperty("password", password);
                    props.setProperty("port", port);
                    props.store(out, null);
                    out.close();

                } catch (FileNotFoundException ex) {
                    JOptionPane.showMessageDialog(frmSettings, "Cannot find the file.", "Change configuration", JOptionPane.ERROR_MESSAGE);
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(frmSettings, "Error while writing to the file.", "Change configuration", JOptionPane.ERROR_MESSAGE);

                } finally {
                    try {
                        out.close();
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(frmSettings, "Error while closing the file.", "Change configuration", JOptionPane.ERROR_MESSAGE);
                    }
                }
                JOptionPane.showMessageDialog(frmSettings, "Changed the values successfully.", "Change configuration", JOptionPane.INFORMATION_MESSAGE);
                frmSettings.dispose();
            }else{
                 JOptionPane.showMessageDialog(frmSettings, err, "Change configuration", JOptionPane.ERROR_MESSAGE);

                }
            }
        }
        );

    }
}
