/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ims.view;

import ims.common.ComboSearch;
import ims.controller.CustomerController;
import ims.controller.IssueController;
import ims.controller.ProductController;
import ims.controller.StockProductController;
import ims.model.IssueRegistered;
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
public class IssueInventoryFormRegisteredCustomer extends javax.swing.JInternalFrame {

    private CustomerController customerController;
    private IssueController issueController;
    private ProductController productController;
    private StockProductController stockProductController;
    private DefaultTableModel dtm1 = null;
    private DefaultTableModel dtm2 = null;

    /**
     * Creates new form AddProduct
     */
    public IssueInventoryFormRegisteredCustomer() {
        try {
            initComponents();
            customerController = new CustomerController();
            issueController = new IssueController();
            productController = new ProductController();
            stockProductController = new StockProductController();

            String newId = issueController.getNewId();
            txtSalesOrderId.setText(newId);

            ArrayList<String> allCustomerId = customerController.getAllCustomerId();
            cmbCustomerId.setModel(new DefaultComboBoxModel(allCustomerId.toArray()));
            ArrayList<String> allProductId = productController.getAllProductId();
            cmbProductId.setModel(new DefaultComboBoxModel(allProductId.toArray()));

            ComboSearch comboSearch1 = new ComboSearch();
            comboSearch1.search(cmbCustomerId, true, "No Customer found");
            ComboSearch comboSearch2 = new ComboSearch();
            comboSearch2.search(cmbProductId, true, "No Product found");

            cmbCustomerId.setSelectedIndex(-1);
            cmbProductId.setSelectedIndex(-1);

            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String curDate = sdf.format(date);
            txtSalesOrderDate.setText(curDate);

            btnIssue.setEnabled(false);

        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Exception", JOptionPane.ERROR_MESSAGE);
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
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtCustomerName = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        table2 = new javax.swing.JTable();
        btnIssue = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        txtSalesOrderId = new javax.swing.JTextField();
        txtSalesOrderDate = new javax.swing.JTextField();
        btnRemove = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        btnAdd = new javax.swing.JButton();
        cmbProductId = new javax.swing.JComboBox<>();
        txtQty = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        table1 = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel7 = new javax.swing.JLabel();
        cmbCustomerId = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();

        setClosable(true);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Issue Inventory Form (Registered Customer)");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(302, 302, 302)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
        );

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Sales Order Date :");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Product ID :");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Saled Order ID :");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Quantity :");

        txtCustomerName.setEditable(false);
        txtCustomerName.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        table2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Product ID", "Product Name", "Quantity Issued", "Exp Date", "Total Price (Rs)"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.Float.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(table2);

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

        txtSalesOrderId.setEditable(false);
        txtSalesOrderId.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        txtSalesOrderDate.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        btnRemove.setBackground(new java.awt.Color(102, 102, 255));
        btnRemove.setForeground(new java.awt.Color(255, 255, 255));
        btnRemove.setText("REMOVE");
        btnRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("Customer Name :");

        btnAdd.setBackground(new java.awt.Color(102, 102, 255));
        btnAdd.setForeground(new java.awt.Color(255, 255, 255));
        btnAdd.setText("ADD");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        cmbProductId.setEditable(true);
        cmbProductId.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cmbProductId.setToolTipText("");
        cmbProductId.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbProductIdItemStateChanged(evt);
            }
        });

        txtQty.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Product ID", "Product Name", "Available Quantity", "EXP Date", "Unit Price (Rs)"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.Float.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(table1);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Total ");

        txtTotal.setEditable(false);
        txtTotal.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Customer ID :");

        cmbCustomerId.setEditable(true);
        cmbCustomerId.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cmbCustomerId.setToolTipText("");
        cmbCustomerId.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbCustomerIdItemStateChanged(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel8.setText("RS :");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnIssue, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(609, 609, 609)
                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(106, 106, 106)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(cmbProductId, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(464, 464, 464))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(cmbCustomerId, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtSalesOrderId)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(48, 48, 48)
                                        .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtSalesOrderDate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
                                    .addComponent(txtCustomerName)))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(61, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtQty)
                                .addGap(431, 431, 431)
                                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 947, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 947, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(58, 58, 58))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jSeparator1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7)
                        .addComponent(cmbCustomerId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtCustomerName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel10)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSalesOrderId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSalesOrderDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cmbProductId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(txtQty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnIssue, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnIssueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIssueActionPerformed
        try {
            int count = table2.getRowCount();
            String id = txtSalesOrderId.getText();
            String cid = String.valueOf(cmbCustomerId.getSelectedItem());
            String oDate = txtSalesOrderDate.getText();

            for (int i = 0; i < count; i++) {

                String productId = String.valueOf(table2.getValueAt(i, 0));
                Integer qty = Integer.valueOf(String.valueOf(table2.getValueAt(i, 2)));
                IssueRegistered issueRegistered = new IssueRegistered(id, cid, productId, oDate, qty);
                issueController.addIssueInventryRegistered(issueRegistered);

            }

            dtm1.setRowCount(0);
            dtm2.setRowCount(0);

            txtSalesOrderId.setText(issueController.getNewId());
            txtCustomerName.setText("");
            cmbCustomerId.setSelectedIndex(-1);
            cmbProductId.setSelectedIndex(-1);
            txtQty.setText("");
            txtTotal.setText("");
            JOptionPane.showMessageDialog(this, "Order issued successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(IssueInventoryFormRegisteredCustomer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnIssueActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        if (dtm1 == null || dtm1.getRowCount() == 0) {
            JOptionPane.showMessageDialog(this, "Product table is empty", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (table1.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this, "Select a row first", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (!"".equals(txtQty.getText())) {
            int selectedRow = table1.getSelectedRow();
            String productId = String.valueOf(table1.getValueAt(selectedRow, 0));
            String productName = String.valueOf(table1.getValueAt(selectedRow, 1));
            Integer qtyAvailable = Integer.valueOf(String.valueOf(table1.getValueAt(selectedRow, 2)));
            String expDate = String.valueOf(table1.getValueAt(selectedRow, 3));
            double unitPrice = Double.parseDouble(String.valueOf(table1.getValueAt(selectedRow, 4)));
            int qty = Integer.valueOf(txtQty.getText());

            if (qty > qtyAvailable) {
                JOptionPane.showMessageDialog(this, "Qty should be less than availabale Qty", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                dtm2 = (DefaultTableModel) table2.getModel();
                dtm2.addRow(new Object[]{productId, productName, qty, expDate, unitPrice * qty});
                double total = 0;
                for (int i = 0; i < table2.getRowCount(); i++) {
                    total += Double.parseDouble(String.valueOf(table2.getValueAt(i, 4)));
                }
                txtTotal.setText(String.valueOf(total));
                btnIssue.setEnabled(true);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Add Required qty", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void cmbProductIdItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbProductIdItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            String productId = String.valueOf(evt.getItem());
            try {
                Product product = productController.getProductById(productId);
                dtm1 = (DefaultTableModel) table1.getModel();

                dtm1.setRowCount(0);
                StockProduct stockProducts = stockProductController.getStockProductByPid(productId);

                dtm1.addRow(new Object[]{product.getId(), product.getName(), stockProducts.getQtyAvailable(), stockProducts.getExpDate(), stockProducts.getUnitPrice()});

            } catch (ClassNotFoundException | SQLException ex) {
                JOptionPane.showMessageDialog(this, "please select a item correcly", "Exception", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_cmbProductIdItemStateChanged

    private void cmbCustomerIdItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbCustomerIdItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            String customerId = String.valueOf(evt.getItem());
            try {
                String name = customerController.getNameById(customerId);
                txtCustomerName.setText(name);

            } catch (ClassNotFoundException | SQLException ex) {
                JOptionPane.showMessageDialog(this, "please select a item correcly", "Exception", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_cmbCustomerIdItemStateChanged

    private void btnRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveActionPerformed
        dtm1.setRowCount(0);
    }//GEN-LAST:event_btnRemoveActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnIssue;
    private javax.swing.JButton btnRemove;
    private javax.swing.JComboBox<String> cmbCustomerId;
    private javax.swing.JComboBox<String> cmbProductId;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable table1;
    private javax.swing.JTable table2;
    private javax.swing.JTextField txtCustomerName;
    private javax.swing.JTextField txtQty;
    private javax.swing.JTextField txtSalesOrderDate;
    private javax.swing.JTextField txtSalesOrderId;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables
}
