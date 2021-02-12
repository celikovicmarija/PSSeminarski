/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package form;

import java.awt.event.ActionListener;
import javax.swing.JFrame;

/**
 *
 * @author Milos Milic
 */
public class FrmMain extends javax.swing.JFrame {
    private boolean running;
    /**
     * Creates new form FrmMain
     */
    public FrmMain() {
        initComponents();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jlbStudent = new javax.swing.JLabel();
        btnStartServer = new javax.swing.JButton();
        btnStopServer = new javax.swing.JButton();
        jlbProgramName = new javax.swing.JLabel();
        lblStatus = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblActiveUsers = new javax.swing.JTable();
        jmbMain = new javax.swing.JMenuBar();
        jmServer = new javax.swing.JMenu();
        jmiSettings = new javax.swing.JMenuItem();
        jmAbout = new javax.swing.JMenu();
        jmiAboutSoftware = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jlbStudent.setFont(new java.awt.Font("Calibri Light", 2, 18)); // NOI18N
        jlbStudent.setText("Marija Čeliković 2017/0195");

        btnStartServer.setFont(new java.awt.Font("Calibri Light", 2, 18)); // NOI18N
        btnStartServer.setText("Start Server");

        btnStopServer.setFont(new java.awt.Font("Calibri Light", 2, 18)); // NOI18N
        btnStopServer.setText("Stop Server");

        jlbProgramName.setFont(new java.awt.Font("Calibri Light", 2, 24)); // NOI18N
        jlbProgramName.setText("Mirko Perce Travel Agency");

        lblStatus.setFont(new java.awt.Font("Calibri Light", 0, 13)); // NOI18N
        lblStatus.setText("Server is not running.");

        tblActiveUsers.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblActiveUsers);

        jmServer.setText("Server");

        jmiSettings.setText("Settings");
        jmServer.add(jmiSettings);

        jmbMain.add(jmServer);

        jmAbout.setText("About");

        jmiAboutSoftware.setText("About Software");
        jmAbout.add(jmiAboutSoftware);

        jmbMain.add(jmAbout);

        setJMenuBar(jmbMain);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jlbStudent)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(btnStartServer)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnStopServer))
                        .addComponent(jlbProgramName)
                        .addComponent(lblStatus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlbProgramName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlbStudent)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnStartServer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnStopServer, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblStatus)
                .addGap(12, 12, 12)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

  public void jmiSettingsAddActionListener(ActionListener actionListener) {
        jmiSettings.addActionListener(actionListener);
    }

    public void jmiAboutSoftwareAddActionListener(ActionListener actionListener) {
        jmiAboutSoftware.addActionListener(actionListener);
    }
    public void addBtnStartServerActionListener(ActionListener actionListener) {
        btnStartServer.addActionListener(actionListener);
    }
       public void addBtnStopServerActionListener(ActionListener actionListener) {
        btnStopServer.addActionListener(actionListener);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnStartServer;
    private javax.swing.JButton btnStopServer;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jlbProgramName;
    private javax.swing.JLabel jlbStudent;
    private javax.swing.JMenu jmAbout;
    private javax.swing.JMenu jmServer;
    private javax.swing.JMenuBar jmbMain;
    private javax.swing.JMenuItem jmiAboutSoftware;
    private javax.swing.JMenuItem jmiSettings;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JTable tblActiveUsers;
    // End of variables declaration//GEN-END:variables

    public javax.swing.JButton getBtnStartServer() {
        return btnStartServer;
    }

    public void setBtnStartServer(javax.swing.JButton btnStartServer) {
        this.btnStartServer = btnStartServer;
    }

    public javax.swing.JButton getBtnStopServer() {
        return btnStopServer;
    }

    public void setBtnStopServer(javax.swing.JButton btnStopServer) {
        this.btnStopServer = btnStopServer;
    }

    public javax.swing.JLabel getJlbProgramName() {
        return jlbProgramName;
    }

    public void setJlbProgramName(javax.swing.JLabel jlbProgramName) {
        this.jlbProgramName = jlbProgramName;
    }

    public javax.swing.JLabel getJlbStudent() {
        return jlbStudent;
    }

    public void setJlbStudent(javax.swing.JLabel jlbStudent) {
        this.jlbStudent = jlbStudent;
    }

    public javax.swing.JMenu getJmAbout() {
        return jmAbout;
    }

    public void setJmAbout(javax.swing.JMenu jmAbout) {
        this.jmAbout = jmAbout;
    }

    public javax.swing.JMenu getJmServer() {
        return jmServer;
    }

    public void setJmServer(javax.swing.JMenu jmServer) {
        this.jmServer = jmServer;
    }

    public javax.swing.JMenuBar getJmbMain() {
        return jmbMain;
    }

    public void setJmbMain(javax.swing.JMenuBar jmbMain) {
        this.jmbMain = jmbMain;
    }

    public javax.swing.JMenuItem getJmiAboutSoftware() {
        return jmiAboutSoftware;
    }

    public void setJmiAboutSoftware(javax.swing.JMenuItem jmiAboutSoftware) {
        this.jmiAboutSoftware = jmiAboutSoftware;
    }

    public javax.swing.JMenuItem getJmiSettings() {
        return jmiSettings;
    }

    public void setJmiSettings(javax.swing.JMenuItem jmiSettings) {
        this.jmiSettings = jmiSettings;
    }

    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    public javax.swing.JLabel getLblStatus() {
        return lblStatus;
    }

    public void setLblStatus(javax.swing.JLabel lblStaus) {
        this.lblStatus = lblStaus;
    }

    public javax.swing.JTable getTblActiveUsers() {
        return tblActiveUsers;
    }

    public void setTblActiveUsers(javax.swing.JTable tblActiveUsers) {
        this.tblActiveUsers = tblActiveUsers;
    }
    
    
}
