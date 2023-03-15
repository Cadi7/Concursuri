package Load;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;

import static Operations.Connection.connect;

public class LoadParticipanti {
    public static void load(JTable table) {
        // Connect to SQLite database and retrieve participants
        DefaultTableModel participantsTableModel = (DefaultTableModel) table.getModel();
        participantsTableModel.setRowCount(0);

        try {
            Connection conn = connect();
            if (conn != null) {
                System.out.println("Connected to the database!");
            }
            assert conn != null;
            Statement statement = conn.createStatement();
            ResultSet participantsResultSet = statement.executeQuery("SELECT * FROM Participanti");

            // Add participants to table
            while (participantsResultSet.next()) {
                int id = participantsResultSet.getInt("id");
                String firstName = participantsResultSet.getString("nume");
                String lastName = participantsResultSet.getString("prenume");
                String email = participantsResultSet.getString("email");
                String phone = participantsResultSet.getString("telefon");
                int competitionId = participantsResultSet.getInt("id_concurs");
                Object[] row = {id, firstName, lastName, email, phone, competitionId};
                participantsTableModel.addRow(row);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

}