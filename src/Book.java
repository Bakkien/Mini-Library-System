
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Hazem To string and print statements are intended for debugging only
 */
public class Book {

    private int id;
    private String title;
    private String author;
    private boolean isAvailable;
    private String category;
    private String genre;

    public Book(int id, String title, String author, String category, String genre, boolean isAvailable) throws Exception{
        this.id = id;
        this.title = title;
        this.author = author;
        this.isAvailable = isAvailable;
        this.category = category;
        this.genre = genre;
        add();
    }
    public Book(int id, String title, String author, String category, String genre, boolean isAvailable, Boolean isloading){
        this.id = id;
        this.title = title;
        this.author = author;
        this.isAvailable = isAvailable;
        this.category = category;
        this.genre = genre;

    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    private void add() throws Exception {
        Connection conn = db.connect();
        Statement stmnt = conn.createStatement();
        String ts = "SELECT BookId FROM books WHERE BookId =?";//checks if the object already exists in the table
        PreparedStatement testStatement = conn.prepareStatement(ts);
        testStatement.setInt(1, id);
        ResultSet testset = testStatement.executeQuery();
        if (!testset.next()) {
            String s = "INSERT INTO books Values(?,?,?,?,?,?)";
            PreparedStatement statement = conn.prepareStatement(s);
            statement.setInt(1, id);
            statement.setString(2, title);
            statement.setString(3, author);
            statement.setString(4, category);
            statement.setString(5, genre);
            statement.setBoolean(6, isAvailable);
            System.out.println(isAvailable);
            statement.executeUpdate();
            LibraryManager.books.add(this);
        } else {
            throw new Exception("Duplicate ID");
        }
    }

    public static void delete(int bookID) throws Exception {
        Connection conn = db.connect();
        String deleteFromBook = "DELETE FROM Books WHERE BookId =?";
        PreparedStatement ps = conn.prepareStatement(deleteFromBook);
        ps.setInt(1, bookID);
        ps.executeUpdate();

        for (int i = 0; i < LibraryManager.books.size(); i++) {
            if (LibraryManager.books.get(i).getId() == bookID) {
                LibraryManager.books.remove(i);
            }
        }
    }

    public void borrowBook() {
        try {
            Connection connection = db.connect();
            String sql = "UPDATE books SET IsAvailable = false WHERE BookId = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, this.getId());
            int rowsAffected = preparedStatement.executeUpdate();
            System.out.println("Rows affected Book borrowed: " + rowsAffected);
            this.isAvailable = false;
        } catch (Exception e) {
            System.out.println("Book not successfully borrowed id=" + this.getId());
        }
    }

    public void returnBook() {
        try {
            Connection connection = db.connect();
            String sql = "UPDATE books SET IsAvailable = true WHERE BookId = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, this.getId());
            int rowsAffected = preparedStatement.executeUpdate();
            System.out.println("Rows affected Book borrowed: " + rowsAffected);
            this.isAvailable = true;
        } catch (Exception e) {
            System.out.println("Book not successfully borrowed id=" + this.getId());
        }

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
        final Book other = (Book) obj;
        return this.id == other.id;
    }

    @Override
    public String toString() {
        return "Book{" + "id=" + id + ", title=" + title + ", author=" + author + ", isAvailable=" + isAvailable + ", category=" + category + ", genre=" + genre + '}';
    }

}
