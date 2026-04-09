
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.function.Consumer;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author yeeki
 */
public class MiniLibrarySystem extends javax.swing.JFrame {

    private DefaultTableModel tableModel;
    int i = 0;

    public MiniLibrarySystem() {
        initComponents();
        String columnNames[] = new String[LibraryManager.bookColumn.size()]; //get the column from database using metadata
        LibraryManager.bookColumn.forEach(s -> {
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
        LibraryManager.books.forEach(s -> {
            Object[] row = {s.getId(), s.getTitle(), s.getAuthor(), s.getCategory(), s.getGenre(), s.isAvailable()};
            tableModel.addRow(row);
        });
        jScrollPane1.setViewportView(jTable1);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialog1 = new javax.swing.JDialog();
        jLabel1 = new javax.swing.JLabel();
        SearchText = new javax.swing.JTextField();
        Search = new javax.swing.JButton();
        AddBook = new javax.swing.JButton();
        BorrowBook = new javax.swing.JButton();
        ReturnBook = new javax.swing.JButton();
        ManageBorrower = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        filterBox = new javax.swing.JComboBox<>();
        DeleteBook = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        sortBox = new javax.swing.JComboBox<>();
        btnSort = new javax.swing.JButton();
        descending = new javax.swing.JCheckBox();
        btnExit = new javax.swing.JButton();

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Mini Library System");

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Mini Library System");

        Search.setText("Search");
        Search.setActionCommand("btnSearch");
        Search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchActionPerformed(evt);
            }
        });

        AddBook.setText("Add Book");
        AddBook.setActionCommand("btnAdd");
        AddBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddBookActionPerformed(evt);
            }
        });

        BorrowBook.setText("Borrow Book");
        BorrowBook.setActionCommand("btnBorrow");
        BorrowBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BorrowBookActionPerformed(evt);
            }
        });

        ReturnBook.setText("Return Book");
        ReturnBook.setToolTipText("");
        ReturnBook.setActionCommand("btnReturn");
        ReturnBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReturnBookActionPerformed(evt);
            }
        });

        ManageBorrower.setText("Manage Borrower");
        ManageBorrower.setActionCommand("btnManage");
        ManageBorrower.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ManageBorrowerActionPerformed(evt);
            }
        });

        jLabel2.setText("Book List");

        filterBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Title", "Author" }));
        filterBox.setSelectedItem("Title");
        filterBox.setToolTipText("");

        DeleteBook.setText("Delete Book");
        DeleteBook.setActionCommand("btnDelete");
        DeleteBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteBookActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTable1);

        sortBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "BookId", "Title", "Author", "Category", "Genre", "IsAvailable" }));

        btnSort.setText("Sort");
        btnSort.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSortActionPerformed(evt);
            }
        });

        descending.setText("Descending");

        btnExit.setText("Exit");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(157, 157, 157)
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel2)
                                .addGap(9, 9, 9)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(SearchText, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(sortBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(8, 8, 8)))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(filterBox, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(descending))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnSort, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Search, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 6, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(AddBook, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(BorrowBook, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(DeleteBook, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ManageBorrower, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(ReturnBook, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                            .addComponent(btnExit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(SearchText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(filterBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Search))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sortBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(descending)
                    .addComponent(btnSort)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AddBook)
                    .addComponent(BorrowBook))
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ReturnBook)
                    .addComponent(DeleteBook))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(ManageBorrower)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(btnExit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ManageBorrowerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ManageBorrowerActionPerformed
        ManageBorrower mb = new ManageBorrower();
        mb.setVisible(true);
        mb.setLocationRelativeTo(null);
        setVisible(false);
    }//GEN-LAST:event_ManageBorrowerActionPerformed

    private void AddBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddBookActionPerformed
        JDialog dialog = new JDialog();
        dialog.setTitle("Add Book");
        dialog.setSize(200, 300);
        dialog.setLayout(new FlowLayout(FlowLayout.CENTER));

        JPanel p1 = new JPanel(new FlowLayout());
        JPanel p2 = new JPanel(new FlowLayout());
        JPanel p3 = new JPanel(new FlowLayout());
        JPanel p4 = new JPanel(new FlowLayout());
        JPanel p5 = new JPanel(new FlowLayout());
        JPanel p6 = new JPanel(new FlowLayout());

        JTextField idf = new JTextField(10);
        JTextField titlef = new JTextField(10);
        JTextField authorf = new JTextField(10);
        JComboBox cbxCategory = new JComboBox();
        cbxCategory.addItem("Fiction");
        cbxCategory.addItem("Non Fiction");
        cbxCategory.setPreferredSize(new Dimension(100, 20));
        JComboBox cbxGenre = new JComboBox();
        String[] fiction = {"Fantasy", "Mystery", "Science Fiction"};
        for (String genre : fiction) {
            cbxGenre.addItem(genre);
        }
        cbxCategory.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                cbxGenre.removeAllItems();
                if (cbxCategory.getSelectedItem().toString().equalsIgnoreCase("Fiction")) {
                    for (String genre : fiction) {
                        cbxGenre.addItem(genre);
                    }
                } else {
                    String[] nonFiction = {"History", "Science", "Technology"};
                    for (String genre : nonFiction) {
                        cbxGenre.addItem(genre);
                    }
                }
            }
        });
        cbxGenre.setPreferredSize(new Dimension(100, 20));
        JCheckBox availablebox = new JCheckBox("Available", true);
        availablebox.setEnabled(false);

        p1.add(new JLabel("ID"));
        p1.add(idf);
        p2.add(new JLabel("Title"));
        p2.add(titlef);
        p3.add(new JLabel("Author"));
        p3.add(authorf);
        p4.add(new JLabel("Category"));
        p4.add(cbxCategory);
        p5.add(new JLabel("genre"));
        p5.add(cbxGenre);
        p6.add(availablebox);

        dialog.add(p1);
        dialog.add(p2);
        dialog.add(p3);
        dialog.add(p4);
        dialog.add(p5);
        dialog.add(p6);
        JButton save = new JButton("Save");
        dialog.add(save);
        dialog.setVisible(true);
        dialog.setLocationRelativeTo(null);
        save.addActionListener(e -> {
            try {
                if (!titlef.getText().isEmpty() && !authorf.getText().isEmpty()) {
                    Book b = new Book(Integer.parseInt(idf.getText()), titlef.getText(), authorf.getText(), cbxCategory.getSelectedItem().toString(), cbxGenre.getSelectedItem().toString(), availablebox.isSelected());
                    dialog.setVisible(false);
                    refresh();
                }else{
                    JOptionPane.showMessageDialog(null, "Enter all the field", "Error Message", JOptionPane.ERROR_MESSAGE);
                    refresh();
                }

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "ID IS NOT INTEGER", "Error Message", JOptionPane.ERROR_MESSAGE);
                refresh();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Error Message", JOptionPane.ERROR_MESSAGE);
                refresh();
            }
        });


    }//GEN-LAST:event_AddBookActionPerformed

    private void BorrowBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BorrowBookActionPerformed
        BorrowForm bf = new BorrowForm();
        int selectedRow = jTable1.getSelectedRow();

        String id = "";
        String name = "";
        String author = "";
        if (selectedRow != -1) { // Check if a row is selected
            
            Boolean available = (Boolean) jTable1.getValueAt(selectedRow, 5);
            if(available){
                bf.setVisible(true);
                bf.setLocationRelativeTo(null);
                setVisible(false);
                id = jTable1.getValueAt(selectedRow, 0).toString();
                name = jTable1.getValueAt(selectedRow, 1).toString();
                author = jTable1.getValueAt(selectedRow, 2).toString();
                bf.setBookID(id);
                bf.setTitle(name);
                bf.setAuthor(author);
                for (Borrower e : LibraryManager.borrowers) {
                    javax.swing.JComboBox<String> cmb = bf.getBorrower();
                    cmb.addItem(e.getName());
                }
                // Display the details in a dialog
            }else{
                JOptionPane.showMessageDialog(this, "Book Already Borrowed", "Error", JOptionPane.WARNING_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please select a book", "No Selection", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_BorrowBookActionPerformed

    private void ReturnBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReturnBookActionPerformed
        int selectedRow = jTable1.getSelectedRow();
        if (selectedRow != -1) {
            if (jTable1.getValueAt(selectedRow, 5).toString().equalsIgnoreCase("false")) {
                BookReturnForm rb = new BookReturnForm(jTable1.getValueAt(selectedRow, 0).toString());
                rb.setVisible(true);
                rb.setLocationRelativeTo(null);
                setVisible(false);
            } else {
                JOptionPane.showMessageDialog(this, "The book is not borrowed", "No Selection", JOptionPane.WARNING_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please select a book", "No Selection", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_ReturnBookActionPerformed

    private void SearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchActionPerformed
        //get the search term
        String queryType = filterBox.getSelectedItem().toString();
        switch (queryType) {
            case "id":
                search(SearchById, queryType);
            default:
                search(SearchByString, queryType);
        }
    }//GEN-LAST:event_SearchActionPerformed

    private void DeleteBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteBookActionPerformed
        int selectedRow = jTable1.getSelectedRow();

        if (selectedRow != -1) { // Check if a row is selected
            try {
                int id = Integer.parseInt(jTable1.getValueAt(selectedRow, 0).toString());
                System.out.println("");
                if (jTable1.getValueAt(selectedRow, 5).toString().equalsIgnoreCase("true")) {
                    Book.delete(id);
                    refresh();
                } else {
                    JOptionPane.showMessageDialog(this, "The book is borrowed can't be deleted", "Error", HEIGHT);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "The book can't be deleted"+e.toString(), "Error", HEIGHT);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please select a book", "No Selection", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_DeleteBookActionPerformed

    private void btnSortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSortActionPerformed
        LibraryManager.books.sort((b1, b2) -> {
            String selectedSort = sortBox.getSelectedItem().toString();
            boolean descendingOrder = descending.isSelected();

            int result = 0;

            switch (selectedSort.toLowerCase()) {
                case "bookid":
                    result = Integer.compare(b1.getId(), b2.getId());
                    break;
                case "title":
                    result = b1.getTitle().compareTo(b2.getTitle());
                    break;
                case "author":
                    result = b1.getAuthor().compareTo(b2.getAuthor());
                    break;
                case "category":
                    result = b1.getCategory().compareTo(b2.getCategory());
                    break;
                case "genre":
                    result = b1.getGenre().compareTo(b2.getGenre());
                    break;
                case "isavailable":
                    result = Boolean.compare(b1.isAvailable(), b2.isAvailable());
                    break;
                default:
                    throw new IllegalArgumentException("Unknown sort field: " + selectedSort);
            }

            if (descendingOrder) {
                return -result;
            }
            return result;
        });

        refresh();
    }//GEN-LAST:event_btnSortActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnExitActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddBook;
    private javax.swing.JButton BorrowBook;
    private javax.swing.JButton DeleteBook;
    private javax.swing.JButton ManageBorrower;
    private javax.swing.JButton ReturnBook;
    private javax.swing.JButton Search;
    private javax.swing.JTextField SearchText;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnSort;
    private javax.swing.JCheckBox descending;
    private javax.swing.JComboBox<String> filterBox;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JComboBox<String> sortBox;
    // End of variables declaration//GEN-END:variables
    public void search(Consumer s, String q) {
        s.accept(q);
    }

    Consumer SearchById = (q) -> {
        refresh();
        int query = Integer.parseInt(SearchText.getText().toLowerCase());
        int columnIndex = 0;

        for (int i = tableModel.getRowCount() - 1; i >= 0; i--) {
            int rowid = Integer.parseInt((String) tableModel.getValueAt(i, columnIndex));
            if (query != rowid) {
                tableModel.removeRow(i);
            }
        }
    };

    Consumer SearchByString = (q) -> {
        String qs = (String) q;
        refresh();
        String query = SearchText.getText().toLowerCase();
        int columnIndex = 0;
        for (int k = 0; k < tableModel.getColumnCount(); k++) {
            if (tableModel.getColumnName(k).equalsIgnoreCase(qs)) {
                columnIndex = k;
            }
        }
        for (int i = tableModel.getRowCount() - 1; i >= 0; i--) {
            String columntitle = tableModel.getValueAt(i, columnIndex).toString().toLowerCase();
            if (!columntitle.contains(query)) {
                tableModel.removeRow(i);
            }
        }
    };
}
