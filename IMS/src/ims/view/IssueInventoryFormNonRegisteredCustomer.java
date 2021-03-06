/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ims.view;

import ims.common.ComboSearch;
import ims.controller.IssueController;
import ims.controller.ProductController;
import ims.controller.StockProductController;
import ims.model.Product;
import ims.model.StockProduct;
import java.awt.event.ItemEvent;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Chamath
 */
public class IssueInventoryFormNonRegisteredCustomer extends javax.swing.JInternalFrame {

    private IssueController issueController;
    private ProductController productController;
    private StockProductController stockProductController;
    private DefaultTableModel dtm = null;
    private String date;

    /**
     * Creates new form AddProduct
     */
    public IssueInventoryFormNonRegisteredCustomer() {
        try {
            initComponents();

            issueController = new IssueController();
            productController = new ProductController();
            stockProductController = new StockProductController();

            dtm = (DefaultTableModel) table.getModel();

            String newId = issueController.getNewBillId();
            txtBillId.setText(newId);

            ArrayList<String> allProductId = productController.getAllProductId();
            cmbPid.setModel(new DefaultComboBoxModel(allProductId.toArray()));

            ComboSearch comboSearch2 = new ComboSearch();
            comboSearch2.search(cmbPid, true, "No Product found");

            cmbPid.setSelectedIndex(-1);

            Date date2 = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String curDate = sdf.format(date2);
            date = curDate;

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(IssueInventoryFormNonRegisteredCustomer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtPName = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
        btnIssue = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        txtUPrice = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        cmbPid = new javax.swing.JComboBox<>();
        txtQty = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        txtPay = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtBalance = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtBillId = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();

        setClosable(true);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Issue Inventory Form (Non Registered Customer)");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(308, 308, 308)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Unit Price :");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Product ID :");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Quantity :");

        txtPName.setEditable(false);
        txtPName.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        btnAdd.setBackground(new java.awt.Color(102, 102, 255));
        btnAdd.setForeground(new java.awt.Color(255, 255, 255));
        btnAdd.setText("ADD");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnIssue.setBackground(new java.awt.Color(102, 102, 255));
        btnIssue.setForeground(new java.awt.Color(255, 255, 255));
        btnIssue.setText("ISSUE");
        btnIssue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIssueActionPerformed(evt);
            }
        });

        btnCancel.setBackground(new java.awt.Color(255, 0, 51));
        btnCancel.setForeground(new java.awt.Color(255, 255, 255));
        btnCancel.setText("CANCEL");
        btnCancel.setActionCommand("CLEAR");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        txtUPrice.setEditable(false);
        txtUPrice.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("Product Name :");

        cmbPid.setEditable(true);
        cmbPid.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cmbPid.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbPidItemStateChanged(evt);
            }
        });

        txtQty.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Bill ID", "Date", "Product Name", "Quantity", "Unit Price (Rs)", "Total Price (Rs)"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Float.class, java.lang.Float.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(table);

        txtPay.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtPay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPayActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Total :");

        txtTotal.setEditable(false);
        txtTotal.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("Pay :");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel11.setText("Balance :");

        txtBalance.setEditable(false);
        txtBalance.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Bill ID :");

        txtBillId.setEditable(false);
        txtBillId.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel7.setText("RS :");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(106, 106, 106)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtQty))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cmbPid, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtBillId))))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(48, 48, 48)
                                .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtUPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtPName, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnIssue, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(37, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtTotal, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
                                    .addComponent(txtPay)
                                    .addComponent(txtBalance, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 947, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(34, 34, 34))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 44, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtPName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtBillId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbPid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtUPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2)
                        .addComponent(jLabel7))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(txtQty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBalance, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnIssue, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(54, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        if (!txtPName.getText().equals("") && !txtQty.getText().equals("")) {
            String pid = String.valueOf(cmbPid.getSelectedItem());
            String id = txtBillId.getText();
            int qty = Integer.parseInt(txtQty.getText());
            String name = txtPName.getText();
            String unitPrice = txtUPrice.getText();
            dtm.addRow(new Object[]{id, date, name, qty, Double.parseDouble(unitPrice), Double.parseDouble(unitPrice) * qty});

            cmbPid.setSelectedIndex(-1);
            txtPName.setText("");
            txtQty.setText("");
            txtUPrice.setText("");

            DefaultTableModel dtm = (DefaultTableModel) table.getModel();
            double total = 0;
            for (int i = 0; i < dtm.getRowCount(); i++) {

                total += Double.parseDouble(String.valueOf(dtm.getValueAt(i, 5)));
                txtTotal.setText(String.valueOf(total));
            }
        } else {
            JOptionPane.showMessageDialog(this, "Fill all the fields first", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnIssueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIssueActionPerformed

        if (!(txtPay.getText().equals("") || txtTotal.getText().equals("") || Double.parseDouble(txtPay.getText()) < Double.parseDouble(txtTotal.getText()))) {
            DefaultTableModel dtm = (DefaultTableModel) table.getModel();
            for (int i = 0; i < dtm.getRowCount(); i++) {

                int qty = Integer.parseInt(String.valueOf(dtm.getValueAt(i, 3)));
                String pName = String.valueOf(dtm.getValueAt(i, 2));

                try {
                    String pid = productController.getIdByName(pName);
                    int result = stockProductController.updateStock(qty, "reduce", pid);

                } catch (ClassNotFoundException | SQLException ex) {
                    Logger.getLogger(IssueInventoryFormNonRegisteredCustomer.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            JOptionPane.showMessageDialog(this, "Inventory issue successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
            dtm.setRowCount(0);
            String billId = txtBillId.getText();
            String index = billId.substring(3);
            String newId = "BIL"+(Integer.parseInt(index)+1);
            txtBillId.setText(newId);
            txtTotal.setText("");
            txtPay.setText("");
        }else{
            JOptionPane.showMessageDialog(this, "Something is wrong", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnIssueActionPerformed

    private void cmbPidItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbPidItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            String productId = String.valueOf(evt.getItem());
            try {
                Product product = productController.getProduct(productId);
                txtPName.setText(product.getName());

                StockProduct stockProduct = stockProductController.getStockProductByPid(productId);
                if (stockProduct == null) {
                    JOptionPane.showMessageDialog(this, "Stock is empty", "Error", JOptionPane.ERROR_MESSAGE);
                    cmbPid.setSelectedIndex(-1);
                    txtPName.setText("");
                } else {
                    txtUPrice.setText(String.valueOf(stockProduct.getUnitPrice()));
                }

            } catch (ClassNotFoundException | SQLException ex) {
                JOptionPane.showMessageDialog(this, "please select a item correcly", "Exception", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_cmbPidItemStateChanged

    private void txtPayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPayActionPerformed
        if (Double.parseDouble(txtTotal.getText()) > Double.parseDouble(txtPay.getText())) {
            JOptionPane.showMessageDialog(this, "Pay should be grater than total", "Error", JOptionPane.ERROR_MESSAGE);
            txtPay.requestFocus();
        } else {
            txtBalance.setText(String.valueOf(Double.parseDouble(txtPay.getText()) - Double.parseDouble(txtTotal.getText())));
        }
    }//GEN-LAST:event_txtPayActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnIssue;
    private javax.swing.JComboBox<String> cmbPid;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable table;
    private javax.swing.JTextField txtBalance;
    private javax.swing.JTextField txtBillId;
    private javax.swing.JTextField txtPName;
    private javax.swing.JTextField txtPay;
    private javax.swing.JTextField txtQty;
    private javax.swing.JTextField txtTotal;
    private javax.swing.JTextField txtUPrice;
    // End of variables declaration//GEN-END:variables
}
