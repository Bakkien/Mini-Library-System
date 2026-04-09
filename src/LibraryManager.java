//
import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import java.time.LocalDate;

/**
 *
 * @author Hazem
 */
public class LibraryManager {

    public static List<Book> books = new ArrayList<>();
    public static List<String> bookColumn = new ArrayList<>();
    public static List<String> usercolumn = new ArrayList<>();
    public static List<String> borrowingColumn = new ArrayList<>();
    public static List<Borrower> borrowers = new ArrayList<>();
    public static List<Borrowing> borrowings = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        Connection connection = db.connect();
        Statement st = connection.createStatement();

        //populate books array
        ResultSet results = st.executeQuery("SELECT * FROM books");
        int count = 0;
        while (results.next()) {
            Book b = new Book(results.getInt("BookId"), results.getString("Title"), results.getString("Author"), results.getString("Category"), results.getString("Genre"), results.getBoolean("IsAvailable"), true);
            books.add(b);
            count++;
        }
        System.out.println(count + " Records added to the books collection");
        System.out.println(books);
        count = 0;

        //populate borrowers table
        results = st.executeQuery("SELECT * FROM borrower");
        while (results.next()) {
            Borrower b = new Borrower(results.getInt("Id"), results.getString("UserName"), true);
            borrowers.add(b);
            count++;
        }
        System.out.println(count + " Records added to the borrowers collection");
        count = 0;

        //populate borrowings table, only with borrowings that are still active (where user haven't returned the book)
        DatabaseMetaData dbMetaData = connection.getMetaData();

        results = st.executeQuery("SELECT * FROM Borrowing");
        while (results.next()) {
            LocalDate from = util.StringTODate(results.getString("BorrowingDate"));
            LocalDate to = util.StringTODate(results.getString("ReturnDate"));
            Borrowing m = new Borrowing(results.getInt("OpId"), results.getInt("BookId"), results.getInt("UserID"), results.getInt("NumOfDays"), from, to);

            borrowings.add(m);
            count++;
        }
        System.out.println(count + " Records added to the Borrowings collection");
        //new Borrowing(1,1,1,);
        try {
            String tableName = "books";
            ResultSet columns = dbMetaData.getColumns(null, null, tableName, "%");//all String parameters
            while (columns.next()) {
                String columnName = columns.getString("COLUMN_NAME");
                bookColumn.add(columnName);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            String tableName = "borrower";
            ResultSet columns = dbMetaData.getColumns(null, null, tableName, "%");//all String parameters
            while (columns.next()) {
                String columnName = columns.getString("COLUMN_NAME");
                usercolumn.add(columnName);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        MiniLibrarySystem mainmenu;
        mainmenu = new MiniLibrarySystem();
        mainmenu.setVisible(true);
        mainmenu.setLocationRelativeTo(null);
    }
}
