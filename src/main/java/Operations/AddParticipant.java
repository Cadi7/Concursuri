package Operations;

import java.sql.SQLException;
import java.sql.Statement;

public class AddParticipant {

    public static void add(String firstName, String lastName, String email, String phone, int competitionId) {
        try {
            java.sql.Connection conn = Connection.connect();
            if (conn != null) {
                System.out.println("Connected to the database!");
            }
            assert conn != null;
            Statement statement = conn.createStatement();
            statement.executeUpdate("INSERT INTO Participanti (nume, prenume, email, telefon, id_concurs) VALUES ('" + firstName + "', '" + lastName + "', '" + email + "', '" + phone + "', '" + competitionId + "')");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
