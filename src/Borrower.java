
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Hazem To string and print statements are intended for debugging only
 */
public class Borrower {

    private int id;
    private String name;
    List<Book> borrowedBooks = new ArrayList<>();

    public Borrower(int id, String name) throws Exception {
        this.id = id;
        this.name = name;
        
        add();
    }
    public Borrower(int id, String name, Boolean isloading) throws Exception {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    private void add() throws Exception {
        Connection conn = db.connect();
        String ts = "SELECT Id FROM Borrower WHERE Id =?";//checks if the object already exists in the table
        PreparedStatement testStatement = conn.prepareStatement(ts);
        testStatement.setInt(1, id);
        ResultSet testset = testStatement.executeQuery();
        if (!testset.next()) {
            System.out.println("");
            String s = "INSERT INTO Borrower Values(?,?)";
            PreparedStatement statement = conn.prepareStatement(s);
            statement.setInt(1, id);
            statement.setString(2, name);
            statement.executeUpdate();
            LibraryManager.borrowers.add(this);
        }else{
            throw new Exception("Duplicate Id");
        }
    }

    public void delete() throws Exception {
        Connection conn = db.connect();
        String ts = "DELETE FROM borrower WHERE Id =?";//checks if the object already exists in the table
        PreparedStatement Statement = conn.prepareStatement(ts);
        Statement.setInt(1, id);
        Statement.executeUpdate();
        LibraryManager.borrowers.remove(this);
    }

    public void borrowBook(Book book) throws Exception{
        System.out.println(book.toString());
        System.out.println("User: " + this.id);
        util.printLine();
        System.out.println(borrowedBooks.size());
        if(borrowedBooks.size() >= 5){
            throw new Exception("You have reached the limit of books to borrow.");
        }
        borrowedBooks.add(book);
        book.borrowBook();
    }

    public void returnBook(Book book) {
        System.out.println(book.toString());
        System.out.println("User: " + this.id);
        util.printLine();
        borrowedBooks.remove(book);
        book.returnBook();
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(id);
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
        final Borrower other = (Borrower) obj;
        return this.id == other.id;
    }

    @Override
    public String toString() {
        return "Borrower{" + "id=" + id + ", name=" + name + '}';
    }

}
