
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import javax.swing.JOptionPane;

/**
 *
 * @author yeeki
 */
public class BookReturnForm extends javax.swing.JFrame {

    long days;
    double overdueFees;
    Borrower user = null;
    Borrowing transaction = null;

    public BookReturnForm(String id) {
        initComponents();
        this.lblBookID.setText(id);
        
        for (Borrowing t : LibraryManager.borrowings) {
            if (t.getBookID() == Integer.parseInt(id)) {
                transaction = t;

            }
        }

        for (Borrower e : LibraryManager.borrowers) {
            if (transaction.getUserId() == e.getId()) {
                user = e;
            }
        }

        lblBorrowerName.setText(user.getName());
        dotr.setText(transaction.getReturnDate().toString());
        dobr.setText(LocalDate.now().toString());
        LocalDate returnDate = util.StringTODate(dotr.getText());
        LocalDate currentReturnDate = util.StringTODate(dobr.getText());

        double normalFees = transaction.getNoDays() * 1;
        if (currentReturnDate.isAfter(returnDate)) {
            days = ChronoUnit.DAYS.between(returnDate, currentReturnDate);
            overdueFees = 2 * days;
        }

        overduec.setText(String.valueOf(overdueFees));
        lblTotalCharge.setText("RM" + (normalFees + overdueFees));
    }

    private void backToMain() {
        setVisible(false);
        MiniLibrarySystem mls = new MiniLibrarySystem();
        mls.setLocationRelativeTo(null);
        mls.setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        dotr = new javax.swing.JLabel();
        overduec = new javax.swing.JLabel();
        lblBookID = new javax.swing.JLabel();
        lblBorrowerName = new javax.swing.JLabel();
        dobr = new javax.swing.JLabel();
        lblTotalCharge = new javax.swing.JLabel();
        btnReturnBook = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel1.setText("Book Return Form");

        jLabel2.setText("Book ID:");

        jLabel3.setText("Borrower Name:");

        jLabel4.setText("Date of Booked Return:");

        jLabel5.setText("Date of Return:");

        jLabel6.setText("Overdue charge:");

        jLabel7.setText("Total Charge:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGap(90, 90, 90)
                            .addComponent(jLabel2))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGap(10, 10, 10)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel5)
                                .addComponent(jLabel4)
                                .addComponent(jLabel6)
                                .addComponent(jLabel7)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        dotr.setText("lblDateOfReturn");

        overduec.setText("lblOverdueCharge");

        lblBookID.setText("lblBookID");

        lblBorrowerName.setText("lblBorrowerName");

        dobr.setText("lblDateOfBookedReturn");

        lblTotalCharge.setText("lblTotalCharge");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblBookID)
                    .addComponent(lblBorrowerName)
                    .addComponent(dobr)
                    .addComponent(dotr)
                    .addComponent(overduec)
                    .addComponent(lblTotalCharge))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(lblBookID)
                .addGap(18, 18, 18)
                .addComponent(lblBorrowerName)
                .addGap(18, 18, 18)
                .addComponent(dobr)
                .addGap(18, 18, 18)
                .addComponent(dotr)
                .addGap(18, 18, 18)
                .addComponent(overduec)
                .addGap(18, 18, 18)
                .addComponent(lblTotalCharge)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnReturnBook.setText("Return");
        btnReturnBook.setActionCommand("btnReturn");
        btnReturnBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReturnBookActionPerformed(evt);
            }
        });

        btnCancel.setText("Cancel");
        btnCancel.setActionCommand("btnCancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(btnReturnBook, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(59, 59, 59))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnReturnBook)
                    .addComponent(btnCancel))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnReturnBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReturnBookActionPerformed
        try {
            transaction.returned();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Return book unsuccessful", "Return book", JOptionPane.ERROR_MESSAGE);
        }

        JOptionPane.showMessageDialog(this, "Returned book successfully", "Return book", JOptionPane.PLAIN_MESSAGE);
        backToMain();

    }//GEN-LAST:event_btnReturnBookActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        backToMain();
    }//GEN-LAST:event_btnCancelActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnReturnBook;
    private javax.swing.JLabel dobr;
    private javax.swing.JLabel dotr;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lblBookID;
    private javax.swing.JLabel lblBorrowerName;
    private javax.swing.JLabel lblTotalCharge;
    private javax.swing.JLabel overduec;
    // End of variables declaration//GEN-END:variables
}
