
import java.sql.Connection;
import java.sql.DriverManager;


/**
 *
 * @author Hazem
 */
public class db {
    public static Connection connect(){
        try{
            String url = "jdbc:mysql://localhost:3306/librarydatabase";  // Your database details
            String username = "root";  // Your MySQL username
            String password = "Bakkien0831";  // Your MySQL password
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, username, password);
            return  conn;
        }catch(Exception e){
            System.out.println(e.toString());
            return null;
        }
    }
   
}
