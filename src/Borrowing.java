
import java.time.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

/**
 *
 * @author Hazem A class intended to store the information for each borrowing
 * operation To string and print statements are intended for debugging only
 */
public class Borrowing {

    private int opId = 0;//store a unique id for each borrrowing, one user can borrow multiple books
    private int bookID;
    private int userId;
    private int noDays; //number of days for the book to be borrowed
    private LocalDate BorrowDate; //LocalDate.of() method is used to construct the object
    private LocalDate returnDate; //LocalDate.of() method is used to construct the object

    public Borrowing(int bookID, int userId, int noDays, LocalDate BorrowDate, LocalDate returnDate) throws SQLException, Exception {
        Connection connection = db.connect();
        String sql = "SELECT COUNT(opid) FROM borrowing";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            System.out.println("Count " + resultSet.getInt(1));
            this.opId = resultSet.getInt(1); // Get the count from the first column
        }
        this.bookID = bookID;

        mloop:
        for (Borrower b : LibraryManager.borrowers) {
            if (this.userId == b.getId()) {
                for (Book bo : LibraryManager.books) {
                    if (this.bookID == bo.getId()) {
                        b.borrowBook(bo);
                        break mloop;
                    }
                }

            }
        }
        this.userId = userId;
        this.noDays = noDays;
        this.BorrowDate = BorrowDate;
        this.returnDate = returnDate;
        try {
            add();
        } catch (SQLException e) {
            System.out.println("Borrowing not added");
        }

    }

    public Borrowing(int opId, int bookID, int userId, int noDays, LocalDate BorrowDate, LocalDate returnDate) throws SQLException, Exception {
        this.opId = opId;
        this.bookID = bookID;
        this.userId = userId;
        this.noDays = noDays;
        this.BorrowDate = BorrowDate;
        this.returnDate = returnDate;
        mloop:
        for (Borrower b : LibraryManager.borrowers) {
            if (this.userId == b.getId()) {
                for (Book bo : LibraryManager.books) {
                    if (this.bookID == bo.getId()) {
                        b.borrowBook(bo);
                        break mloop;
                    }
                }

            }
        }
    }

    public int getOpId() {
        return opId;
    }

    public void setOpId(int opId) {
        this.opId = opId;
    }

    public int getBookID() {
        return bookID;
    }

    public void setBookID(int bookID) {
        this.bookID = bookID;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getNoDays() {
        return noDays;
    }

    public void setNoDays(int noDays) {
        this.noDays = noDays;
    }

    public LocalDate getBorrowDate() {
        return BorrowDate;
    }

    public void setBorrowDate(LocalDate BorrowDate) {
        this.BorrowDate = BorrowDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    private void add() throws SQLException, Exception {
        mloop:
        for (Borrower b : LibraryManager.borrowers) {
            if (this.userId == b.getId()) {
                for (Book bo : LibraryManager.books) {
                    if (this.bookID == bo.getId()) {
                        b.borrowBook(bo);
                        break mloop;
                    }
                }

            }
        }
        Connection conn = db.connect();
        String ts = "SELECT OpId FROM borrowing WHERE OpId =?";//checks if the object already exists in the table
        PreparedStatement testStatement = conn.prepareStatement(ts);
        testStatement.setInt(1, opId);
        ResultSet testset = testStatement.executeQuery();
        if (!testset.next()) {
            System.out.println("");
            String s = "INSERT INTO Borrowing Values(?,?,?,?,?,?)";
            PreparedStatement statement = conn.prepareStatement(s);
            statement.setInt(1, opId);
            statement.setInt(2, bookID);
            statement.setInt(3, userId);
            statement.setInt(4, noDays);
            statement.setString(5, BorrowDate.toString());
            System.out.println(BorrowDate.toString());
            statement.setString(6, returnDate.toString());
            System.out.println(returnDate.toString());
            statement.executeUpdate();
            LibraryManager.borrowings.add(this);
            System.out.println(LibraryManager.borrowings);
        }

    }

    public void returned() throws SQLException {
        Connection connection = db.connect();
        String sql = "DELETE FROM borrowing WHERE opId = ?";
        System.out.println("OPid: " + opId);
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, opId);
        int rowsAffected = preparedStatement.executeUpdate();
        System.out.println("Rows affected returned: " + rowsAffected);
        mloop:
        for (Borrower b : LibraryManager.borrowers) {
            if (this.userId == b.getId()) {
                for (Book bo : LibraryManager.books) {
                    if (this.bookID == bo.getId()) {
                        b.returnBook(bo);
                        break mloop;
                    }
                }

            }
        }

    }

    @Override
    public int hashCode() {
        return Integer.hashCode(opId);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Borrowing other = (Borrowing) obj;
        return this.opId == other.opId;
    }

    @Override
    public String toString() {
        return "Borrowing ID: " + opId + "\nBook ID: " + bookID + "\nBorrower ID: " + userId + "\nBorrow Date: " + BorrowDate + "\nReturn Date: " + returnDate + "\n";
    }

}
