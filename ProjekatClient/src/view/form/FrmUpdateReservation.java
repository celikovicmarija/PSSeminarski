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
public class FrmUpdateReservation extends javax.swing.JFrame {

    /**
     * Creates new form FrmUpdateReservation
     */
    public FrmUpdateReservation() {
        initComponents();
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

        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtReservationID = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtPrice = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtDiscountedPrice = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtIssueDate = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtValidUntil = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        cbCoupons = new javax.swing.JComboBox<>();
        btnCancel = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        txtPassenger = new javax.swing.JTextField();
        cbFlights = new javax.swing.JComboBox<>();
        btnDelete = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Update Reservation");

        jLabel1.setFont(new java.awt.Font("Calibri Light", 2, 36)); // NOI18N
        jLabel1.setText("Update Reservation");

        jLabel7.setFont(new java.awt.Font("Calibri Light", 2, 18)); // NOI18N
        jLabel7.setText("Reservation ID:");

        jLabel2.setFont(new java.awt.Font("Calibri Light", 2, 18)); // NOI18N
        jLabel2.setText("Price:");

        jLabel3.setFont(new java.awt.Font("Calibri Light", 2, 18)); // NOI18N
        jLabel3.setText("Discounted price:");

        jLabel4.setFont(new java.awt.Font("Calibri Light", 2, 18)); // NOI18N
        jLabel4.setText("Issue Date:");

        jLabel5.setFont(new java.awt.Font("Calibri Light", 2, 18)); // NOI18N
        jLabel5.setText("Flight:");

        jLabel6.setFont(new java.awt.Font("Calibri Light", 2, 18)); // NOI18N
        jLabel6.setText("Valid Until:");

        jLabel8.setFont(new java.awt.Font("Calibri Light", 2, 18)); // NOI18N
        jLabel8.setText("Passenger:");

        jLabel9.setFont(new java.awt.Font("Calibri Light", 2, 18)); // NOI18N
        jLabel9.setText("Coupon:");

        cbCoupons.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnCancel.setFont(new java.awt.Font("Calibri Light", 2, 18)); // NOI18N
        btnCancel.setText("Return");

        btnSave.setFont(new java.awt.Font("Calibri Light", 2, 18)); // NOI18N
        btnSave.setText("Save changes");

        cbFlights.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnDelete.setFont(new java.awt.Font("Calibri Light", 2, 18)); // NOI18N
        btnDelete.setText("Delete");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 226, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5)
                            .addComponent(jLabel9)
                            .addComponent(jLabel8)
                            .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(txtPrice, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtIssueDate)
                            .addComponent(txtDiscountedPrice)
                            .addComponent(txtValidUntil)
                            .addComponent(txtPassenger)
                            .addComponent(cbCoupons, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbFlights, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtReservationID))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtReservationID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19)
                        .addComponent(txtDiscountedPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19)
                        .addComponent(txtIssueDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19)
                        .addComponent(txtValidUntil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25)
                        .addComponent(cbFlights, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtPassenger, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19)
                        .addComponent(cbCoupons, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6)
                        .addGap(24, 24, 24)
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel8)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel9)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancel)
                    .addComponent(btnSave)
                    .addComponent(btnDelete))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox<Object> cbCoupons;
    private javax.swing.JComboBox<Object> cbFlights;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField txtDiscountedPrice;
    private javax.swing.JTextField txtIssueDate;
    private javax.swing.JTextField txtPassenger;
    private javax.swing.JTextField txtPrice;
    private javax.swing.JTextField txtReservationID;
    private javax.swing.JTextField txtValidUntil;
    // End of variables declaration//GEN-END:variables

    public javax.swing.JButton getBtnCancel() {
        return btnCancel;
    }

    public void setBtnCancel(javax.swing.JButton btnCancel) {
        this.btnCancel = btnCancel;
    }

    public javax.swing.JButton getBtnSave() {
        return btnSave;
    }

    public void setBtnSave(javax.swing.JButton btnSave) {
        this.btnSave = btnSave;
    }

    public javax.swing.JComboBox<Object> getCbCoupons() {
        return cbCoupons;
    }

    public void setCbCoupons(javax.swing.JComboBox<Object> cbCoupons) {
        this.cbCoupons = cbCoupons;
    }

    public javax.swing.JComboBox<Object> getCbFlights() {
        return cbFlights;
    }

    public void setCbFlights(javax.swing.JComboBox<Object> cbFlights) {
        this.cbFlights = cbFlights;
    }

    public javax.swing.JTextField getTxtDiscountedPrice() {
        return txtDiscountedPrice;
    }

    public void setTxtDiscountedPrice(javax.swing.JTextField txtDiscountedPrice) {
        this.txtDiscountedPrice = txtDiscountedPrice;
    }

    public javax.swing.JTextField getTxtIssueDate() {
        return txtIssueDate;
    }

    public void setTxtIssueDate(javax.swing.JTextField txtIssueDate) {
        this.txtIssueDate = txtIssueDate;
    }

    public javax.swing.JTextField getTxtPassenger() {
        return txtPassenger;
    }

    public void setTxtPassenger(javax.swing.JTextField txtPassenger) {
        this.txtPassenger = txtPassenger;
    }

    public javax.swing.JTextField getTxtPrice() {
        return txtPrice;
    }

    public void setTxtPrice(javax.swing.JTextField txtPrice) {
        this.txtPrice = txtPrice;
    }

    public javax.swing.JTextField getTxtReservationID() {
        return txtReservationID;
    }

    public void setTxtReservationID(javax.swing.JTextField txtReservationID) {
        this.txtReservationID = txtReservationID;
    }

    public javax.swing.JTextField getTxtValidUntil() {
        return txtValidUntil;
    }

    public void setTxtValidUntil(javax.swing.JTextField txtValidUntil) {
        this.txtValidUntil = txtValidUntil;
    }

    public javax.swing.JButton getBtnDelete() {
        return btnDelete;
    }

    public void setBtnDelete(javax.swing.JButton btnDelete) {
        this.btnDelete = btnDelete;
    }
}
