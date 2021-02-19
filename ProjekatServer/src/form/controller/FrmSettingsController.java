/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package form.controller;

import form.FrmSettings;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class FrmSettingsController {

    private final FrmSettings frmSettings;

    public FrmSettingsController(FrmSettings frmSettings) {
        this.frmSettings = frmSettings;
        this.frmSettings.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        addActionListeners();
    }

    public void openForm() {
        prepareView();
        frmSettings.setVisible(true);

    }

    private void addActionListeners() {

        frmSettings.btnSaveSettingsDatabaseAddActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                saveSettingsDb();
            }

            public void saveSettingsDb() {
                String err = "";
                String url = frmSettings.getTxtURLDatabase().getText();
                if (url.equals("")) {
                    err += "You have to enter URL\n";
                    frmSettings.getLblErrorUrlD().setText("Database URL cannot be empty");

                }
                String user = frmSettings.getTxtUsername().getText();
                if (user.equals("")) {
                    err += "You have to enter username\n";
                    frmSettings.getLblErrorUrlD().setText("Username cannot be empty");

                }
                String password = String.copyValueOf(frmSettings.getTxtPassword().getPassword());

                if (err.equals("")) {
                    saveDbSettingsToFile(url, user, password);
                } else {
                    JOptionPane.showMessageDialog(frmSettings, "Could not change the values", "Change DB configuration", JOptionPane.INFORMATION_MESSAGE);

                }
            }
        }
        );
        frmSettings.btnSaveSettingsServerAddActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                saveSettingsServer();
            }

            public void saveSettingsServer() {
                String err = "";
                int port = 0;
                String url = frmSettings.getTxtURLServer().getText();
                if (url.equals("")) {
                    err += "URL cannot be empty\n";
                    frmSettings.getLblErrorUrlS().setText("Server's URL cannot be empty");

                }
                String portStr = frmSettings.getTxtPort().getText();
                if (portStr.equals("")) {
                    System.out.println("Port empty");
                    err += "Port number cannot be empty\n";
                    frmSettings.getLblErrorPort().setText("Port number cannot be empty");
                } else {

                    try {
                        port = Integer.parseInt(portStr);
                        if (port < 0 || port > 65535) {
                            err += "Port number has tu be an integer between 0 and 65535\n";
                            frmSettings.getLblErrorPort().setText("Port number has to be an integer between 0 and 65535");
                        }
                    } catch (NumberFormatException ex) {
                        err += "Port number has tu be an integer\n";
                        frmSettings.getLblErrorPort().setText("Port number has to be an integer");

                    }
                }

                if (err.equals("")) {
                    saveServerSettingsToFile(url, port);
                } else {
                    JOptionPane.showMessageDialog(frmSettings, "Could not change the values", "Change Server configuration", JOptionPane.INFORMATION_MESSAGE);

                }

            }
        }
        );

    }

    private void saveDbSettingsToFile(String url, String user, String password) {
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
                JOptionPane.showMessageDialog(frmSettings, "Error while closing the file.", "Change DB configuration", JOptionPane.ERROR_MESSAGE);
            }
        }
        JOptionPane.showMessageDialog(frmSettings, "Changed the values successfully.", "Change DB configuration", JOptionPane.INFORMATION_MESSAGE);
        frmSettings.dispose();
    }

    private void saveServerSettingsToFile(String url, int port) {
        FileOutputStream out = null;
        try {
            out = new FileOutputStream("config/serverconfig.properties");
            FileInputStream in = new FileInputStream("config/serverconfig.properties");
            Properties props = new Properties();
            props.load(in);
            in.close();

            props.setProperty("url", url);
            props.setProperty("port", String.valueOf(port));
            props.store(out, null);
            out.close();

        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(frmSettings, "Cannot find the file.", "Change Server configuration", JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(frmSettings, "Error while writing to the file.", "Change Server configuration", JOptionPane.ERROR_MESSAGE);

        } finally {
            try {
                out.close();
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(frmSettings, "Error while closing the file.", "Change Server configuration", JOptionPane.ERROR_MESSAGE);
            }
        }
        JOptionPane.showMessageDialog(frmSettings, "Changed the values successfully.", "Change Server configuration", JOptionPane.INFORMATION_MESSAGE);
        frmSettings.dispose();
        String dest="C:\\Users\\Marija\\Desktop\\PS seminarski\\PSSeminarski\\ProjekatClient\\config\\serverconfig.properties";
        String source="C:\\Users\\Marija\\Desktop\\PS seminarski\\PSSeminarski\\ProjekatServer\\config\\serverconfig.properties";
        try {
            copy(source, dest);
        } catch (IOException ex) {
          //  System.out.println("Error while copying the file to users location");
           // Logger.getLogger(FrmSettingsController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static void copy(String src, String dest) throws IOException {
        InputStream is = null;
        OutputStream os = null;
        try {
            is = new FileInputStream(src);
            os = new FileOutputStream(dest);
            byte[] buf = new byte[1024];
            int bytesRead;
            while ((bytesRead = is.read(buf)) > 0) {
                os.write(buf, 0, bytesRead);
            }
        } finally {
            is.close();
            os.close();
        }
    }

    private void prepareView() {
                 frmSettings.setLocationRelativeTo(null);

        FileInputStream fileInputStream = null;
        try {
            Properties properties = new Properties();
            String propertiesFileNameServer = "config/serverconfig.properties";
            fileInputStream = new FileInputStream(propertiesFileNameServer);
            properties.load(fileInputStream);
            frmSettings.getTxtPort().setText(properties.getProperty("port"));
            frmSettings.getTxtURLServer().setText(properties.getProperty("url"));
            fileInputStream.close();
            String propertiesFileNameDb = "config/dbconfig.properties";
            fileInputStream = new FileInputStream(propertiesFileNameDb);
            properties.load(fileInputStream);
            frmSettings.getTxtURLDatabase().setText(properties.getProperty("url"));
            frmSettings.getTxtUsername().setText(properties.getProperty("username"));
            frmSettings.getTxtPassword().setText(properties.getProperty("password"));
            fileInputStream.close();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(frmSettings, ex.getMessage(), "Error while loading the properties", JOptionPane.ERROR_MESSAGE);
        }
    }
}
