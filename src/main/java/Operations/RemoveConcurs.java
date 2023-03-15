package Operations;

public class RemoveConcurs {
    public static void delete(int id) {
        try {
            java.sql.Connection conn = Connection.connect();
            if (conn != null) {
                System.out.println("Connected to the database!");
            }
            assert conn != null;
            java.sql.Statement statement = conn.createStatement();
            statement.executeUpdate("DELETE FROM Concursuri WHERE id = " + id);
        } catch (java.sql.SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
