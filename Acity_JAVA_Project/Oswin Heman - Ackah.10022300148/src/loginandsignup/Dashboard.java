/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */


package loginandsignup;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.SwingUtilities;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableRowSorter;



/**
 *
 * @author Oswin
 */






public class Dashboard extends javax.swing.JPanel {
    private DefaultTableModel model;
    private int userId;
    
    
    
// Applies styling and hover effect to buttons
private void styleButton(javax.swing.JButton button) {
    // Base style
    button.setBackground(new Color(166, 0, 0));  // Deep red
    button.setForeground(Color.WHITE);
    button.setBorder(new javax.swing.border.LineBorder(new Color(255, 180, 0), 2, true)); // Gold border
    button.setFont(new java.awt.Font("SansSerif", java.awt.Font.BOLD, 14));

    // Hover effect
    button.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseEntered(java.awt.event.MouseEvent evt) {
            button.setBackground(new Color(255, 180, 0)); // Gold on hover
        }

        public void mouseExited(java.awt.event.MouseEvent evt) {
            button.setBackground(new Color(166, 0, 0)); // Deep red default
        }
    });
}
    
    
    
    
    
    
    
    
    
    
    /**
     * Creates new form Dashboard
     */
    public Dashboard() {
        initComponents();

         this.userId = userId;
         typeWriterEffect(ad, "ACKAHMANNS DASHBOARD", 100);
        model = (DefaultTableModel) itemTable.getModel();
        btnAdd.setBackground(new Color(166, 0, 0));  // Deep red  
        btnAdd.setForeground(Color.WHITE);  // Text color
        btnAdd.setBorder(new LineBorder(new Color(255, 180, 0), 2, true));  // Gold border, rounded
        btnAdd.setFont(new Font("SansSerif", Font.BOLD, 14));
        
        
        
        styleButton(btnAdd);
        styleButton(btnRemove);
        styleButton(btnUpdate);
        styleButton(BtnTotal);
        styleButton(btnCheckout);
        styleButton(LogoutBtn);
        styleButton(ViewCartbtn);
        
        
        itemTable.setBackground(new Color(48, 48, 48)); // Dark grey
        itemTable.setForeground(Color.WHITE);  // Text
        itemTable.setGridColor(new Color(255, 180, 0));  // Gold lines
        itemTable.setRowHeight(30);  // More breathing space
        itemTable.setFont(new Font("SansSerif", Font.PLAIN, 14));
        
        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer() {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value,
                boolean isSelected, boolean hasFocus, int row, int column) {
            Component comp = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

            // Zebra striping for elegance
            if (isSelected) {
                comp.setBackground(new Color(200, 160, 50));  // Light gold for selection
            } else {
                comp.setBackground(row % 2 == 0 ? new Color(64, 64, 64) : new Color(54, 54, 54));  // Dark stripes
            }
            comp.setForeground(Color.WHITE);
            return comp;
        }
    };

    // Apply to all columns
    for (int i = 0; i < itemTable.getColumnCount(); i++) {
        itemTable.getColumnModel().getColumn(i).setCellRenderer(renderer);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        itemTable = new javax.swing.JTable();
        btnCheckout = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        btnRemove = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        BtnTotal = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        ad = new javax.swing.JLabel();
        LogoutBtn = new javax.swing.JButton();
        ViewCartbtn = new javax.swing.JButton();
        btnsearch = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();

        setBackground(new java.awt.Color(255, 255, 255));

        itemTable.setForeground(new java.awt.Color(150, 0, 24));
        itemTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Item Name", "Quantity", "Price"
            }
        ));
        jScrollPane1.setViewportView(itemTable);

        btnCheckout.setBackground(new java.awt.Color(242, 200, 121));
        btnCheckout.setForeground(new java.awt.Color(150, 0, 24));
        btnCheckout.setText("CheckOut");
        btnCheckout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCheckoutActionPerformed(evt);
            }
        });

        btnAdd.setBackground(new java.awt.Color(150, 0, 24));
        btnAdd.setForeground(new java.awt.Color(255, 255, 255));
        btnAdd.setText("Add To Cart");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnRemove.setBackground(new java.awt.Color(150, 0, 24));
        btnRemove.setForeground(new java.awt.Color(255, 255, 255));
        btnRemove.setText("Remove from Cart");
        btnRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveActionPerformed(evt);
            }
        });

        btnUpdate.setBackground(new java.awt.Color(150, 0, 24));
        btnUpdate.setForeground(new java.awt.Color(255, 255, 255));
        btnUpdate.setText(" Update Cart");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        BtnTotal.setBackground(new java.awt.Color(150, 0, 24));
        BtnTotal.setForeground(new java.awt.Color(255, 255, 255));
        BtnTotal.setText("Total");
        BtnTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnTotalActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(150, 0, 24));

        ad.setFont(new java.awt.Font("Distrela SemiBold", 0, 36)); // NOI18N
        ad.setForeground(new java.awt.Color(242, 200, 121));
        ad.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ad.setText("ACKAHMANNS DASHBOARD");
        ad.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(144, Short.MAX_VALUE)
                .addComponent(ad, javax.swing.GroupLayout.PREFERRED_SIZE, 549, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(109, 109, 109))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ad, javax.swing.GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)
                .addGap(16, 16, 16))
        );

        LogoutBtn.setBackground(new java.awt.Color(242, 200, 121));
        LogoutBtn.setForeground(new java.awt.Color(150, 0, 24));
        LogoutBtn.setText("Logout");
        LogoutBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogoutBtnActionPerformed(evt);
            }
        });

        ViewCartbtn.setBackground(new java.awt.Color(150, 0, 24));
        ViewCartbtn.setText("ViewCart");
        ViewCartbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ViewCartbtnActionPerformed(evt);
            }
        });

        btnsearch.setBackground(new java.awt.Color(255, 255, 255));
        btnsearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/search.png"))); // NOI18N
        btnsearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsearchActionPerformed(evt);
            }
        });

        jTextField1.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BtnTotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnRemove, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
                    .addComponent(btnCheckout, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
                    .addComponent(LogoutBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnsearch, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(110, 110, 110)
                        .addComponent(ViewCartbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(36, 36, 36))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 463, Short.MAX_VALUE)
                        .addGap(33, 33, 33))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(BtnTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCheckout, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ViewCartbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LogoutBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnsearch))
                .addGap(39, 39, 39))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        String itemName = JOptionPane.showInputDialog(this, "Enter item name:");
        String quantityStr = JOptionPane.showInputDialog(this, "Enter quantity:");
        String priceStr = JOptionPane.showInputDialog(this, "Enter price:");

try {
    int quantity = Integer.parseInt(quantityStr);
    double price = Double.parseDouble(priceStr);

    model.addRow(new Object[]{itemName, quantity, price});
} catch (NumberFormatException e) {
    JOptionPane.showMessageDialog(this, "Please enter valid numbers for quantity and price.");
}

    }//GEN-LAST:event_btnAddActionPerformed

    private void btnRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveActionPerformed
        // TODO add your handling code here:
        int selectedRow = itemTable.getSelectedRow();

    if (selectedRow != -1) {
    model.removeRow(selectedRow);
} else {
    JOptionPane.showMessageDialog(this, "Please select an item to remove.");
}

    }//GEN-LAST:event_btnRemoveActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        int selectedRow = itemTable.getSelectedRow();

if (selectedRow != -1) {
    String newName = JOptionPane.showInputDialog(this, "Enter new item name:", model.getValueAt(selectedRow, 0));
    String newQuantityStr = JOptionPane.showInputDialog(this, "Enter new quantity:", model.getValueAt(selectedRow, 1));
    String newPriceStr = JOptionPane.showInputDialog(this, "Enter new price:", model.getValueAt(selectedRow, 2));

    try {
        int newQuantity = Integer.parseInt(newQuantityStr);
        double newPrice = Double.parseDouble(newPriceStr);

        model.setValueAt(newName, selectedRow, 0);
        model.setValueAt(newQuantity, selectedRow, 1);
       model.setValueAt(newPrice, selectedRow, 2); // no need to cast to int

    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Enter valid numbers for quantity and price.");
    }
} else {
    JOptionPane.showMessageDialog(this, "Please select an item to update.");
}

    }//GEN-LAST:event_btnUpdateActionPerformed

    private void BtnTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnTotalActionPerformed
        // TODO add your handling code here:
        double total = 0.0;

    for (int i = 0; i < model.getRowCount(); i++) {
    int quantity = Integer.parseInt(model.getValueAt(i, 1).toString());
    double price = Double.parseDouble(model.getValueAt(i, 2).toString());
    total += quantity * price;
}

JOptionPane.showMessageDialog(this, "Total amount: $" + String.format("%.2f", total));

    }//GEN-LAST:event_BtnTotalActionPerformed

    private void btnCheckoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCheckoutActionPerformed
        // TODO add your handling code here:
        Connection con = getConnection();
    if (con != null) {
        try {
            String sql = "INSERT INTO cart (item_name, quantity, price, user_id) VALUES (?, ?, ?, ?)";
            PreparedStatement pst = con.prepareStatement(sql);

            for (int i = 0; i < model.getRowCount(); i++) {
                Object itemObj = model.getValueAt(i, 0);
                Object qtyObj = model.getValueAt(i, 1);
                Object priceObj = model.getValueAt(i, 2);

                // Skip this row if any value is null
                if (itemObj == null || qtyObj == null || priceObj == null) {
                    continue;
                }

                String itemName = itemObj.toString();
                int quantity = Integer.parseInt(qtyObj.toString());
                double price = Double.parseDouble(priceObj.toString());

                pst.setString(1, itemName);
                pst.setInt(2, quantity);
                pst.setDouble(3, price);

                int user_id = 1; // replace this with the actual logged-in user's ID
                pst.setInt(4, user_id);

                pst.addBatch();
            }

            pst.executeBatch();
            JOptionPane.showMessageDialog(this, "Checkout successful!");

            model.setRowCount(0); // clear the table
            con.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Checkout error: " + e.getMessage());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid number format in one of the rows.");
        }
    }
    

    }//GEN-LAST:event_btnCheckoutActionPerformed

    
    
    private void LogoutBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogoutBtnActionPerformed
        // TODO add your handling code here:                                          
    int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to logout?", "Logout", JOptionPane.YES_NO_OPTION);
    if (confirm == JOptionPane.YES_OPTION) {
        // Get the top-level JFrame and dispose it
        javax.swing.SwingUtilities.getWindowAncestor(this).dispose();

        // Open Login window
        Login loginPage = new Login(); // This should be a JFrame
        loginPage.setVisible(true);
        loginPage.setLocationRelativeTo(null); // center the login window
    }


    }//GEN-LAST:event_LogoutBtnActionPerformed

    private void ViewCartbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ViewCartbtnActionPerformed
        // TODO add your handling code here:
    int user_id = 1; // replace with actual logged-in user ID
    Connection con = getConnection();

    if (con != null) {
        try {
            String sql = "SELECT item_name, quantity, price FROM cart WHERE user_id = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, user_id);
            ResultSet rs = pst.executeQuery();

            // Create a table model for displaying the cart
            DefaultTableModel cartModel = new DefaultTableModel();
            cartModel.addColumn("Item Name");
            cartModel.addColumn("Quantity");
            cartModel.addColumn("Price");

            while (rs.next()) {
                String item = rs.getString("item_name");
                int qty = rs.getInt("quantity");
                double price = rs.getDouble("price");
                cartModel.addRow(new Object[]{item, qty, price});
            }

            JTable cartTable = new JTable(cartModel);
            JScrollPane scrollPane = new JScrollPane(cartTable);
            scrollPane.setPreferredSize(new Dimension(400, 200));

            JOptionPane.showMessageDialog(this, scrollPane, "Your Cart", JOptionPane.INFORMATION_MESSAGE);

            rs.close();
            pst.close();
            con.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error viewing cart: " + e.getMessage());
        }
}

    
    }//GEN-LAST:event_ViewCartbtnActionPerformed

    private void btnsearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsearchActionPerformed
        // TODO add your handling code here:                                                                                  
    String searchText = text.getText();

    DefaultTableModel model = (DefaultTableModel) itemTable.getModel();
    TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
    itemTable.setRowSorter(sorter);

    if (searchText.trim().length() == 0) {
        sorter.setRowFilter(null);
    } else {
        sorter.setRowFilter(RowFilter.regexFilter("(?i)" + searchText, 0)); 
    }


    }//GEN-LAST:event_btnsearchActionPerformed
   
    private void typeWriterEffect(javax.swing.JLabel label, String text, int delay) {
    new Thread(() -> {
        try {
            for (int i = 0; i <= text.length(); i++) {
                final String partialText = text.substring(0, i);
                SwingUtilities.invokeLater(() -> label.setText(partialText));
                Thread.sleep(delay);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
 }).start();
}
    
    
    
    public Connection getConnection() {
    try {
        return DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/java_user_database", "root", ""
        );
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Connection failed: " + e.getMessage());
        return null;
    }
}


    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnTotal;
    private javax.swing.JButton LogoutBtn;
    private javax.swing.JButton ViewCartbtn;
    private javax.swing.JLabel ad;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnCheckout;
    private javax.swing.JButton btnRemove;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JButton btnsearch;
    private javax.swing.JTable itemTable;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables

    private static class model {

        private static void addRow(Object[] object) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        private static void removeRow(int selectedRow) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        private static Object getValueAt(int selectedRow, int i) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        private static void setValueAt(String newName, int selectedRow, int i) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        private static void setValueAt(int newQuantity, int selectedRow, int i) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        private static int getRowCount() {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        private static void setRowCount(int i) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        public model() {
        }
    }

    private static class text {

        private static String getText() {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        public text() {
        }
    }
}
