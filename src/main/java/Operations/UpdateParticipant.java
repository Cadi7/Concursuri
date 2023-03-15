package Operations;

public class UpdateParticipant {
    public static void update(int id, String nume, String prenume, String email, String telefon, int idConcurs) {
        try {
            java.sql.Connection conn = Connection.connect();
            if (conn != null) {
                System.out.println("Connected to the database!");
            }
            assert conn != null;
            java.sql.Statement statement = conn.createStatement();
            statement.executeUpdate("UPDATE Participanti SET nume = '" + nume + "', prenume = '" + prenume + "', email = '" + email + "', telefon = '" + telefon + "', id_concurs = " + idConcurs + " WHERE id = " + id);
        } catch (java.sql.SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
