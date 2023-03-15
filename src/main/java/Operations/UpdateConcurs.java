package Operations;

public class UpdateConcurs {
    public static void update(int id, String name, String date, String location) {
        try {
            java.sql.Connection conn = Connection.connect();
            if (conn != null) {
                System.out.println("Connected to the database!");
            }
            assert conn != null;
            java.sql.Statement statement = conn.createStatement();
            statement.executeUpdate("UPDATE Concursuri SET name = '" + name + "', date = '" + date + "', location = '" + location + "' WHERE id = " + id);
        } catch (java.sql.SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
