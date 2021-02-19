/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package form;

import java.awt.event.ActionListener;
import javax.swing.JFrame;


public class FrmMain extends javax.swing.JFrame {
    private boolean running;

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
        lblStatus = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblActiveUsers = new javax.swing.JTable();
        lblProgramName = new javax.swing.JLabel();
        lblUsers = new javax.swing.JLabel();
        jmbMain = new javax.swing.JMenuBar();
        jmServer = new javax.swing.JMenu();
        jmiSettings = new javax.swing.JMenuItem();
        jmAbout = new javax.swing.JMenu();
        jmiAboutSoftware = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Main Server Form");
        setBackground(new java.awt.Color(204, 255, 204));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jlbStudent.setFont(new java.awt.Font("Calibri Light", 2, 18)); // NOI18N
        jlbStudent.setText("Marija Čeliković 2017/0195");

        btnStartServer.setFont(new java.awt.Font("Calibri Light", 2, 18)); // NOI18N
        btnStartServer.setText("Start Server");

        btnStopServer.setFont(new java.awt.Font("Calibri Light", 2, 18)); // NOI18N
        btnStopServer.setText("Stop Server");

        lblStatus.setFont(new java.awt.Font("Calibri Light", 2, 13)); // NOI18N
        lblStatus.setForeground(new java.awt.Color(255, 0, 0));
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

        lblProgramName.setFont(new java.awt.Font("Vivaldi", 2, 36)); // NOI18N
        lblProgramName.setText("Mirko Perce & Co Travel Agency");

        lblUsers.setFont(new java.awt.Font("Calibri Light", 2, 18)); // NOI18N
        lblUsers.setText("All System Users:");

        jmServer.setText("Server");
        jmServer.setFont(new java.awt.Font("Calibri Light", 2, 20)); // NOI18N

        jmiSettings.setFont(new java.awt.Font("Calibri Light", 2, 18)); // NOI18N
        jmiSettings.setText("Settings");
        jmServer.add(jmiSettings);

        jmbMain.add(jmServer);

        jmAbout.setText("About");
        jmAbout.setFont(new java.awt.Font("Calibri Light", 2, 20)); // NOI18N

        jmiAboutSoftware.setFont(new java.awt.Font("Calibri Light", 2, 18)); // NOI18N
        jmiAboutSoftware.setText("About Software");
        jmAbout.add(jmiAboutSoftware);

        jmbMain.add(jmAbout);

        setJMenuBar(jmbMain);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jlbStudent)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(lblProgramName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblUsers)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnStartServer, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnStopServer, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(98, 98, 98))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lblProgramName)
                .addGap(3, 3, 3)
                .addComponent(jlbStudent)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnStopServer, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnStartServer, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(lblStatus)
                .addGap(10, 10, 10)
                .addComponent(lblUsers)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(37, Short.MAX_VALUE))
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
    private javax.swing.JLabel jlbStudent;
    private javax.swing.JMenu jmAbout;
    private javax.swing.JMenu jmServer;
    private javax.swing.JMenuBar jmbMain;
    private javax.swing.JMenuItem jmiAboutSoftware;
    private javax.swing.JMenuItem jmiSettings;
    private javax.swing.JLabel lblProgramName;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JLabel lblUsers;
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

    public javax.swing.JLabel getLblProgramName() {
        return lblProgramName;
    }

    public void setLblProgramName(javax.swing.JLabel lblProgramName) {
        this.lblProgramName = lblProgramName;
    }

    public javax.swing.JLabel getLblUsers() {
        return lblUsers;
    }

    public void setLblUsers(javax.swing.JLabel lblUsers) {
        this.lblUsers = lblUsers;
    }
    
    
}
