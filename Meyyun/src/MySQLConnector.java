
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQLConnector {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/test";
        String user = "your_username";
        String password = "your_password";

        try {
            // Load MySQL JDBC Driver (optional for newer versions)
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish connection
            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the database!");

            // Example query
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM your_table");

            while (rs.next()) {
                System.out.println("Row: " + rs.getString(1)); // Adjust column index
            }

            // Close resources
            rs.close();
            stmt.close();
            conn.close();

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
