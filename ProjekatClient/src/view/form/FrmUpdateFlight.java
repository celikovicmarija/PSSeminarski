/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.form;

import java.awt.event.ActionListener;

/**
 *
 * @author Marija
 */
public class FrmUpdateFlight extends javax.swing.JDialog {

    /**
     * Creates new form FrmUpdateFlightt
     */
    public FrmUpdateFlight(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(parent);
        setModal(true);
    }
     public void addBtnSaveActionListener(ActionListener actionListener) {
        btnSave.addActionListener(actionListener);
    }
     public void addBtnCancelActionListener(ActionListener actionListener) {
        btnCancel.addActionListener(actionListener);
    }
            public void addBtnDeleteActionListener(ActionListener actionListener) {
        btnDelete.addActionListener(actionListener);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        txtNote = new javax.swing.JTextArea();
        txtAirline = new javax.swing.JTextField();
        lblTitle = new javax.swing.JLabel();
        txtDate = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtTime = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtFlightID = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        btnSave = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        btnCancel = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        cbAirplanes = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        cbLines = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        btnDelete = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        cbPassengers = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Update Flight");
        setPreferredSize(new java.awt.Dimension(700, 554));

        txtNote.setColumns(20);
        txtNote.setRows(5);
        jScrollPane1.setViewportView(txtNote);

        lblTitle.setFont(new java.awt.Font("Calibri Light", 2, 36)); // NOI18N
        lblTitle.setText("Update Flight");

        jLabel1.setFont(new java.awt.Font("Calibri Light", 2, 18)); // NOI18N
        jLabel1.setText("Departure date:");

        jLabel3.setFont(new java.awt.Font("Calibri Light", 2, 18)); // NOI18N
        jLabel3.setText("Departure time:");

        jLabel4.setFont(new java.awt.Font("Calibri Light", 2, 18)); // NOI18N
        jLabel4.setText("Airline:");

        btnSave.setFont(new java.awt.Font("Calibri Light", 2, 18)); // NOI18N
        btnSave.setText("Save changes");

        jLabel5.setFont(new java.awt.Font("Calibri Light", 2, 18)); // NOI18N
        jLabel5.setText("Note:");

        btnCancel.setFont(new java.awt.Font("Calibri Light", 2, 18)); // NOI18N
        btnCancel.setText("Return");

        jLabel6.setFont(new java.awt.Font("Calibri Light", 2, 18)); // NOI18N
        jLabel6.setText("Airplane:");

        cbAirplanes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel7.setFont(new java.awt.Font("Calibri Light", 2, 18)); // NOI18N
        jLabel7.setText("Flight ID:");

        cbLines.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel8.setFont(new java.awt.Font("Calibri Light", 2, 18)); // NOI18N
        jLabel8.setText("Line:");

        btnDelete.setFont(new java.awt.Font("Calibri Light", 2, 18)); // NOI18N
        btnDelete.setText("Delete");

        jLabel9.setFont(new java.awt.Font("Calibri Light", 2, 18)); // NOI18N
        jLabel9.setText("Pasengers:");

        cbPassengers.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel9))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtFlightID, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbLines, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cbAirplanes, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtTime)
                                    .addComponent(txtAirline)
                                    .addComponent(txtDate)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 329, Short.MAX_VALUE)
                                    .addComponent(cbPassengers, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnSave)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                                .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(lblTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtFlightID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtAirline, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cbAirplanes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbLines, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(cbPassengers, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancel)
                    .addComponent(btnSave)
                    .addComponent(btnDelete))
                .addContainerGap(78, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox<Object
    > cbAirplanes;
    private javax.swing.JComboBox<Object> cbLines;
    private javax.swing.JComboBox<Object> cbPassengers;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JTextField txtAirline;
    private javax.swing.JTextField txtDate;
    private javax.swing.JTextField txtFlightID;
    private javax.swing.JTextArea txtNote;
    private javax.swing.JTextField txtTime;
    // End of variables declaration//GEN-END:variables

    public javax.swing.JButton getBtnCancel() {
        return btnCancel;
    }

    public void setBtnCancel(javax.swing.JButton btnCancel) {
        this.btnCancel = btnCancel;
    }

    public javax.swing.JButton getBtnDelete() {
        return btnDelete;
    }

    public void setBtnDelete(javax.swing.JButton btnDelete) {
        this.btnDelete = btnDelete;
    }

    public javax.swing.JButton getBtnSave() {
        return btnSave;
    }

    public void setBtnSave(javax.swing.JButton btnSave) {
        this.btnSave = btnSave;
    }

    public javax.swing.JComboBox<Object
            > getCbAirplanes() {
        return cbAirplanes;
    }

    public void setCbAirplanes(javax.swing.JComboBox<Object
            > cbAirplanes) {
        this.cbAirplanes = cbAirplanes;
    }

    public javax.swing.JComboBox<Object> getCbLines() {
        return cbLines;
    }

    public void setCbLines(javax.swing.JComboBox<Object> cbLines) {
        this.cbLines = cbLines;
    }

    public javax.swing.JLabel getLblTitle() {
        return lblTitle;
    }

    public void setLblTitle(javax.swing.JLabel lblTitle) {
        this.lblTitle = lblTitle;
    }

    public javax.swing.JTextField getTxtAirline() {
        return txtAirline;
    }

    public void setTxtAirline(javax.swing.JTextField txtAirline) {
        this.txtAirline = txtAirline;
    }

    public javax.swing.JTextField getTxtDate() {
        return txtDate;
    }

    public void setTxtDate(javax.swing.JTextField txtDate) {
        this.txtDate = txtDate;
    }

    public javax.swing.JTextField getTxtFlightID() {
        return txtFlightID;
    }

    public void setTxtFlightID(javax.swing.JTextField txtFlightID) {
        this.txtFlightID = txtFlightID;
    }

    public javax.swing.JTextArea getTxtNote() {
        return txtNote;
    }

    public void setTxtNote(javax.swing.JTextArea txtNote) {
        this.txtNote = txtNote;
    }

    public javax.swing.JTextField getTxtTime() {
        return txtTime;
    }

    public void setTxtTime(javax.swing.JTextField txtTime) {
        this.txtTime = txtTime;
    }

    public javax.swing.JComboBox<Object> getCbPassengers() {
        return cbPassengers;
    }

    public void setCbPassengers(javax.swing.JComboBox<Object> cbPassengers) {
        this.cbPassengers = cbPassengers;
    }
}
