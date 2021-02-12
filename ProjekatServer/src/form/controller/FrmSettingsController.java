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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Marija
 */
public class FrmSettingsController {
    private final FrmSettings frmSettings;

    public FrmSettingsController(FrmSettings frmSettings) {
        this.frmSettings = frmSettings;
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
                public void saveSettings(){
                    String url = frmSettings.getTxtURL().getText();
                    String user = frmSettings.getTxtUsername().getText();
                    String password = String.copyValueOf(frmSettings.getTxtPassword().getPassword());
                    String port = frmSettings.getTxtPort().getText();
       
                    FileOutputStream out = null;
        
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
       JOptionPane.showMessageDialog(frmSettings, "Changed the values successfully.","Change configuration", JOptionPane.ERROR_MESSAGE);

        } catch (FileNotFoundException ex) {
            Logger.getLogger(FrmSettings.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FrmSettings.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally {
            try {
                out.close();
            } catch (IOException ex) {
                Logger.getLogger(FrmSettings.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
           JOptionPane.showMessageDialog(frmSettings, "Changed the values successfully.","Change configuration", JOptionPane.INFORMATION_MESSAGE);
           frmSettings.dispose();
                
                }
             }
                    );
        
           
    }
}
