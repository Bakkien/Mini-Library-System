
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author yeeki
 */
public class ManageBorrower extends javax.swing.JFrame {

    private DefaultTableModel tableModel;
    int i = 0;

    public ManageBorrower() {
        initComponents();
        String columnNames[] = new String[LibraryManager.usercolumn.size()]; //get the column from database using metadata
        LibraryManager.usercolumn.forEach(s -> {
            columnNames[i] = s;
            i++;
        });
        //loading should be done from collection not the Db
        tableModel = new DefaultTableModel(columnNames, 0);
        jTable1.setModel(tableModel);
        refresh();
    }
    
    private void refresh() {
        tableModel.setRowCount(0);
        LibraryManager.borrowers.forEach(s -> {
            Object[] row = {s.getId(), s.getName()};
            tableModel.addRow(row);
        });
        jScrollPane1.setViewportView(jTable1);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        SearchText = new javax.swing.JTextField();
        SearchButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        AddBorrower = new javax.swing.JButton();
        cancel = new javax.swing.JButton();
        View = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel1.setText("Borrower Management");

        SearchButton.setText("Search");
        SearchButton.setActionCommand("btnSearch");
        SearchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchButtonActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
            },
            new String [] {
                "ID", "Name"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel2.setText("Borrower List");

        AddBorrower.setText("Add Borrower");
        AddBorrower.setToolTipText("");
        AddBorrower.setActionCommand("btnAdd");
        AddBorrower.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddBorrowerActionPerformed(evt);
            }
        });

        cancel.setText("Cancel");
        cancel.setActionCommand("btnCancel");
        cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelActionPerformed(evt);
            }
        });

        View.setText("View Details");
        View.setActionCommand("btnView");
        View.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ViewActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(AddBorrower)
                        .addGap(18, 18, 18)
                        .addComponent(View)
                        .addGap(18, 18, 18)
                        .addComponent(cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(SearchText, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(SearchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(68, 68, 68))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SearchText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SearchButton))
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(View)
                    .addComponent(cancel)
                    .addComponent(AddBorrower))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelActionPerformed
        setVisible(false);
        MiniLibrarySystem mls = new MiniLibrarySystem();
        mls.setVisible(true);
        mls.setLocationRelativeTo(null);
    }//GEN-LAST:event_cancelActionPerformed

    private void SearchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchButtonActionPerformed
        refresh();
        String query = SearchText.getText();
        try {
            int id = Integer.parseInt(query);
            for (int i = tableModel.getRowCount() - 1; i >= 0; i--) {
                int rowid = Integer.parseInt(tableModel.getValueAt(i, 0).toString());
                if (rowid != id) {
                    tableModel.removeRow(i);
                }
            }

        } catch (NumberFormatException e) {
            for (int i = tableModel.getRowCount() - 1; i >= 0; i--) {
                String columntitle = (String) tableModel.getValueAt(i, 1);

                System.out.println(query);
                util.printLine();
                System.out.println(columntitle);
                columntitle = columntitle.toLowerCase();
                query = query.toLowerCase();
                if (!columntitle.contains(query)) {
                    tableModel.removeRow(i);
                }
            }
        }
    }//GEN-LAST:event_SearchButtonActionPerformed

    private void ViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ViewActionPerformed
        int selectedRow = jTable1.getSelectedRow();
        String id = "";
        String name = "";
        if (selectedRow != -1) { // Check if a row is selected
            id = jTable1.getValueAt(selectedRow, 0).toString();
            name = jTable1.getValueAt(selectedRow, 1).toString();

        // Display the details in a dialog
        } else {
            JOptionPane.showMessageDialog(this, "Please select a borrower to view details.", "No Selection", JOptionPane.WARNING_MESSAGE);
        }
        int idint = Integer.parseInt(id);
        Borrower user = null;
        for (Borrower b : LibraryManager.borrowers) {
            if (b.getId() == idint) {
                user = b;
            }
        }
        StringBuilder ls = new StringBuilder();
        user.getBorrowedBooks().forEach(s -> ls.append("\n").append(s).append(","));
        JOptionPane.showMessageDialog(this, "ID: " + id + "\nName: " + name + "\nBorrowed books:" + ls, "Borrower Details", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_ViewActionPerformed

    private void AddBorrowerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddBorrowerActionPerformed
        String id = JOptionPane.showInputDialog(this, "Enter Borrower ID:");
        String name = JOptionPane.showInputDialog(this, "Enter Borrower Name:");

        if (id != null && name != null && !id.trim().isEmpty() && !name.trim().isEmpty()) {
            try {
                Borrower b = new Borrower(Integer.parseInt(id), name);
            } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Input Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "ID and Name cannot be empty.", "Input Error", JOptionPane.ERROR_MESSAGE);
        }
        refresh();
    }//GEN-LAST:event_AddBorrowerActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddBorrower;
    private javax.swing.JButton SearchButton;
    private javax.swing.JTextField SearchText;
    private javax.swing.JButton View;
    private javax.swing.JButton cancel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
