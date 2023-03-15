import Load.LoadConcursuri;
import Load.LoadParticipanti;
import Operations.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.Connection;

import static Operations.CustomDialog.showCustomConcurs;
import static Operations.CustomDialog.showCustomParticipanti;
import static Operations.HideColumn.hiddeColumn;

public class Concursuri extends JFrame {

    private JLabel titleLabel;
    private JPanel competitionsPanel;
    private JScrollPane competitionsScrollPane;
    private JTable competitionsTable;
    private DefaultTableModel competitionsTableModel;
    private JButton addCompetitionButton;
    private JButton editCompetitionButton;
    private JButton deleteCompetitionButton;
    private JPanel participantsPanel;
    private JScrollPane participantsScrollPane;
    private JTable participantsTable;
    private DefaultTableModel participantsTableModel;
    private JButton addParticipantButton;
    private JButton editParticipantButton;
    private JButton deleteParticipantButton;

    private Connection connection;

    public Concursuri() {

        // Add UI elements to content pane
        Container contentPane = getContentPane();


        // Add table models for the Concursuri and Participanti tables
        DefaultTableModel concursuriModel = new DefaultTableModel(new String[]{"ID", "Nume", "Data", "Locatie"}, 0);
        DefaultTableModel participantiModel = new DefaultTableModel(new String[]{"ID", "Nume", "Prenume", "Email", "Telefon", "ID Concurs"}, 0);


        // Add the table models to the JTables
        JTable concursuriTable = new JTable(concursuriModel);
        JTable participantiTable = new JTable(participantiModel);
        ;
        LoadConcursuri.load(concursuriTable);
        LoadParticipanti.load(participantiTable);

        hiddeColumn(concursuriTable, 0);
        hiddeColumn(participantiTable, 0);


        // Create scroll panes for the JTables
        JScrollPane concursuriScrollPane = new JScrollPane(concursuriTable);
        JScrollPane participantiScrollPane = new JScrollPane(participantiTable);

        // Add labels for each table
        JLabel concursuriLabel = new JLabel("Concursuri");
        concursuriLabel.setVerticalAlignment(JLabel.CENTER);
        concursuriLabel.setFont(new Font("Arial", Font.BOLD, 15));
        concursuriLabel.setForeground(Color.BLACK);
        JLabel participantiLabel = new JLabel("Participanti");
        participantiLabel.setVerticalAlignment(JLabel.CENTER);
        participantiLabel.setFont(new Font("Arial", Font.BOLD, 15));
        participantiLabel.setForeground(Color.BLACK);

        // Add buttons for adding, updating, and deleting records
        JButton addConcursButton = new JButton("Adauga concurs");
        JButton updateConcursButton = new JButton("Actualizeaza concurs");
        JButton deleteConcursButton = new JButton("Sterge concurs");
        // Add a button for ordering the tables
        JButton orderConcurs = new JButton("Ordoneaza");
        JLabel blankLabel = new JLabel(" ");
        JButton addParticipantButton = new JButton("Adauga participant");
        JButton updateParticipantButton = new JButton("Actualizeaza participant");
        JButton deleteParticipantButton = new JButton("Sterge participant");
        // Add a button for ordering the tables
        JButton orderParticipant = new JButton("Ordoneaza");
        JLabel blankLabel2 = new JLabel(" ");

        // Set background colors for the panels
        Color darkBlue = new Color(22, 50, 80);
        Color lightBlue = new Color(80, 120, 204);
        Color lightGray = new Color(224, 224, 224);

        // Create panel for Concursuri table and buttons
        JPanel concursuriPanel = new JPanel();
        concursuriPanel.setBackground(lightGray);
        concursuriPanel.setLayout(new BoxLayout(concursuriPanel, BoxLayout.Y_AXIS));
        concursuriPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        concursuriPanel.add(concursuriLabel);
        concursuriPanel.add(Box.createRigidArea(new Dimension(2, 2)));
        concursuriPanel.add(concursuriScrollPane);
        JPanel butoane = new JPanel();
        butoane.setLayout(new GridLayout(1, 4));
        butoane.add(addConcursButton);
        butoane.add(updateConcursButton);
        butoane.add(deleteConcursButton);
        butoane.add(orderConcurs);
        concursuriPanel.add(butoane);


        // Create a panel for the Participanti table and buttons
        JPanel participantiPanel = new JPanel();
        participantiPanel.setBackground(lightGray);
        participantiPanel.setLayout(new BoxLayout(participantiPanel, BoxLayout.Y_AXIS));
        participantiPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        participantiPanel.add(participantiLabel);
        participantiPanel.add(Box.createRigidArea(new Dimension(2, 2)));
        participantiPanel.add(participantiScrollPane);
        JPanel butoane2 = new JPanel();
        butoane2.setLayout(new GridLayout(1, 4));
        butoane2.add(addParticipantButton);
        butoane2.add(updateParticipantButton);
        butoane2.add(deleteParticipantButton);
        butoane2.add(orderParticipant);
        participantiPanel.add(butoane2);

        // Create a panel for the Concursuri and Participanti tables
        JPanel tablesPanel = new JPanel();
        tablesPanel.setBackground(darkBlue);
        tablesPanel.setLayout(new BoxLayout(tablesPanel, BoxLayout.X_AXIS));
        tablesPanel.add(concursuriPanel);
        tablesPanel.add(Box.createRigidArea(new Dimension(2, 2)));
        tablesPanel.add(participantiPanel);

        // Create a panel for the title
        JPanel titlePanel = new JPanel();
        titlePanel.setBackground(lightBlue);
        titlePanel.setLayout(new BoxLayout(titlePanel, BoxLayout.Y_AXIS));
        JLabel titleLabel = new JLabel("Concursuri de dans - Pascari Vlad");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 40));
        titleLabel.setForeground(Color.black);
        titlePanel.add(Box.createRigidArea(new Dimension(0, 10)));
        titlePanel.add(titleLabel);

        setSize(1500, 600);
        add(titlePanel, BorderLayout.NORTH);
        add(tablesPanel, BorderLayout.CENTER);

        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);


        addConcursButton.addActionListener(e -> {
            String[] inputs = showCustomConcurs(this, "Adaugă concurs", new String[3]);
            {
                String nume = inputs[0];
                String locatie = inputs[1];
                String data = inputs[2];
                // validation
                if (nume == null || nume.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Numele concursului nu poate fi gol");
                    return;
                }
                if (locatie == null || locatie.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Locatia nu poate fi goala");
                    return;
                }
                if (data == null || data.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Data nu poate fi goala");
                    return;
                }

                AddConcurs.add(nume, locatie, data);
                LoadConcursuri.load(concursuriTable);
            }
        });

        updateConcursButton.addActionListener(e -> {
            int row = concursuriTable.getSelectedRow();
            if (row == -1) {
                JOptionPane.showMessageDialog(null, "Selecteaza un concurs");
                return;
            }


            String[] inputs = showCustomConcurs(this, "Actualizeaza concurs",
                    new String[]{
                            (String) concursuriTable.getValueAt(row, 1),
                            (String) concursuriTable.getValueAt(row, 2),
                            (String) concursuriTable.getValueAt(row, 3)
                    });
            {
                //
                String nume = inputs[0];
                String locatie = inputs[1];
                String data = inputs[2];
                // validation
                if (nume == null || nume.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Numele concursului nu poate fi gol");
                    return;
                }
                if (locatie == null || locatie.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Locatia nu poate fi goala");
                    return;
                }
                if (data == null || data.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Data nu poate fi goala");
                    return;
                }

                UpdateConcurs.update((int) concursuriTable.getValueAt(row, 0), nume, locatie, data);
                LoadConcursuri.load(concursuriTable);
            }
        });

        deleteConcursButton.addActionListener(e -> {
            int row = concursuriTable.getSelectedRow();
            if (row == -1) {
                JOptionPane.showMessageDialog(null, "Selecteaza un concurs");
                return;
            }
            RemoveConcurs.delete((int) concursuriTable.getValueAt(row, 0));
            LoadConcursuri.load(concursuriTable);
        });

        orderConcurs.addActionListener(e -> {
            Ordering.order(concursuriTable, 1);
        });


        addParticipantButton.addActionListener(e -> {
            String[] inputs = showCustomParticipanti(this, "Adaugă participant", new String[4]);
            {
                String nume = inputs[0];
                String prenume = inputs[1];
                String email = inputs[2];
                String telefon = inputs[3];
                int idConcurs = Integer.parseInt(inputs[4]);
                // validation
                if (nume == null || nume.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Numele participantului nu poate fi gol");
                    return;
                }
                if (prenume == null || prenume.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Prenumele nu poate fi gol");
                    return;
                }
                if (email == null || email.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Varsta nu poate fi goala");
                    return;
                }
                if (telefon == null || telefon.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Telefonul nu poate fi gol");
                    return;
                }
                if (idConcurs == 0) {
                    JOptionPane.showMessageDialog(null, "Id-ul concursului nu poate fi gol");
                    return;
                }

                AddParticipant.add(nume, prenume, email, telefon, idConcurs);
                LoadParticipanti.load(participantiTable);
            }
        });

        updateParticipantButton.addActionListener(e -> {
            int row = participantiTable.getSelectedRow();
            if (row == -1) {
                JOptionPane.showMessageDialog(null, "Selecteaza un participant");
                return;
            }

            String[] inputs = showCustomParticipanti(this, "Actualizeaza participant",
                    new String[]{
                            (String) participantiTable.getValueAt(row, 1),
                            (String) participantiTable.getValueAt(row, 2),
                            (String) participantiTable.getValueAt(row, 3),
                            (String) participantiTable.getValueAt(row, 4),
                            String.valueOf((Integer) participantiTable.getValueAt(row, 5))
                    });
            {
                //
                String nume = inputs[0];
                String prenume = inputs[1];
                String email = inputs[2];
                String telefon = inputs[3];
                int idConcurs = Integer.parseInt(inputs[4]);
                // validation
                if (nume == null || nume.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Numele participantului nu poate fi gol");
                    return;
                }
                if (prenume == null || prenume.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Prenumele nu poate fi gol");
                    return;
                }
                if (email == null || email.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Varsta nu poate fi goala");
                    return;
                }
                if (telefon == null || telefon.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Telefonul nu poate fi gol");
                    return;
                }
                if (idConcurs == 0) {
                    JOptionPane.showMessageDialog(null, "Id-ul concursului nu poate fi gol");
                    return;
                }

                UpdateParticipant.update((int) participantiTable.getValueAt(row, 0), nume, prenume, email, telefon, idConcurs);
                LoadParticipanti.load(participantiTable);
            }
        });

        deleteParticipantButton.addActionListener(e -> {
            int row = participantiTable.getSelectedRow();
            if (row == -1) {
                JOptionPane.showMessageDialog(null, "Selecteaza un participant");
                return;
            }
            RemoveParticipant.delete((int) participantiTable.getValueAt(row, 0));
            LoadParticipanti.load(participantiTable);
        });

        orderParticipant.addActionListener(e -> {
            Ordering.order(participantiTable, 1);
        });


    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Concursuri();
            }
        });
    }

}


