package Load;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;

import static Operations.Connection.URL;
import static Operations.Connection.connect;

public class LoadConcursuri {
    public static void load(JTable table) {
        // Connect to SQLite database and retrieve competitions
        DefaultTableModel competitionsTableModel = (DefaultTableModel) table.getModel();
        competitionsTableModel.setRowCount(0);

        try {
            Connection conn = connect();
            if (conn != null) {
                System.out.println("Connected to the database!");
            }
            assert conn != null;
            Statement statement = conn.createStatement();
            ResultSet competitionsResultSet = statement.executeQuery("SELECT * FROM Concursuri");

            // Add competitions to table
            while (competitionsResultSet.next()) {
                int id = competitionsResultSet.getInt("id");
                String name = competitionsResultSet.getString("name");
                String date = competitionsResultSet.getString("date");
                String location = competitionsResultSet.getString("location");
                Object[] row = {id, name, date, location};
                competitionsTableModel.addRow(row);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

}