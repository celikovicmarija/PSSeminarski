/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package form;

import javax.swing.JFrame;

/**
 *
 * @author Marija
 */
public class FrmAbout extends javax.swing.JDialog {

    /**
     * Creates new form FrmAbout
     */
    public FrmAbout(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setModal(true);
        pack();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                setLocationRelativeTo(parent);


    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnUnderstood = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jlbStudent = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("About software");

        btnUnderstood.setFont(new java.awt.Font("Calibri Light", 2, 18)); // NOI18N
        btnUnderstood.setText("Understood!");
        btnUnderstood.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUnderstoodActionPerformed(evt);
            }
        });

        jTextArea1.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.background"));
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Calibri Light", 2, 18)); // NOI18N
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(5);
        jTextArea1.setText("This piece of software was created as \na project assignment \nfor the Software Design Course at\n the Faculty of organisational sciences,\n University of Belgrade");
        jTextArea1.setBorder(null);
        jScrollPane1.setViewportView(jTextArea1);

        jLabel1.setFont(new java.awt.Font("Vivaldi", 2, 36)); // NOI18N
        jLabel1.setText("About Software");

        jlbStudent.setFont(new java.awt.Font("Calibri Light", 2, 14)); // NOI18N
        jlbStudent.setText("Belgrade, February 2021");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(88, 88, 88))
            .addGroup(layout.createSequentialGroup()
                .addGap(108, 108, 108)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jlbStudent)
                    .addComponent(btnUnderstood))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(41, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addComponent(btnUnderstood)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlbStudent)
                .addGap(24, 24, 24))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnUnderstoodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUnderstoodActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnUnderstoodActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnUnderstood;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel jlbStudent;
    // End of variables declaration//GEN-END:variables
}
