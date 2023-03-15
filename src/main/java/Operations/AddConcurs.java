package Operations;

import java.sql.SQLException;
import java.sql.Statement;

public class AddConcurs {


    public static void add(String name, String date, String location) {
        try {
            java.sql.Connection conn = Connection.connect();
            if (conn != null) {
                System.out.println("Connected to the database!");
            }
            assert conn != null;
            Statement statement = conn.createStatement();
            statement.executeUpdate("INSERT INTO Concursuri (name, date, location) VALUES ('" + name + "', '" + date + "', '" + location + "')");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
