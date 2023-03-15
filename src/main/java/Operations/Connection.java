package Operations;

import java.sql.DriverManager;

public class Connection {

    public static final String URL = "jdbc:sqlite:concurs.db";

    public static java.sql.Connection connect() {
        try {
            return DriverManager.getConnection(URL);
        } catch (Exception ex) {
            System.out.println("Error connecting to database: " + ex.getMessage());
        }
        return null;
    }
}
