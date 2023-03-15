package Operations;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class CustomDialog {

    public static String[] showCustomParticipanti(Component parentComponent, String title, String[] initial_input) {
        String[] inputs = new String[5];
        JPanel panel = new JPanel(new GridLayout(0, 2));
        JLabel nameLabel = new JLabel("Nume: ");
        JTextField nameField = new JTextField();
        JLabel prenumeLabel = new JLabel("Prenume: ");
        JTextField prenumeField = new JTextField();
        JLabel emailLabel = new JLabel("Email: ");
        JTextField emailField = new JTextField();
        JLabel phoneLabel = new JLabel("Telefon: ");
        JTextField phoneField = new JTextField();
        JLabel competitionLabel = new JLabel("ID Concurs: ");
        JTextField competitionField = new JTextField();

        panel.add(nameLabel);
        panel.add(nameField);
        panel.add(prenumeLabel);
        panel.add(prenumeField);
        panel.add(emailLabel);
        panel.add(emailField);
        panel.add(phoneLabel);
        panel.add(phoneField);
        panel.add(competitionLabel);
        panel.add(competitionField);

        int result = JOptionPane.showConfirmDialog(parentComponent, panel, title, JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (result == JOptionPane.OK_OPTION) {
            inputs[0] = nameField.getText();
            inputs[1] = prenumeField.getText();
            inputs[2] = emailField.getText();
            inputs[3] = phoneField.getText();
            inputs[4] = competitionField.getText();
        } else {
            System.out.println("Cancelled");
        }
        return inputs;
    }

    public static String[] showCustomConcurs(Component parentComponent, String title, String[] initial_input) {
        String[] inputs = new String[3];
        JPanel panel = new JPanel(new GridLayout(0, 2));
        JLabel nameLabel = new JLabel("Nume: ");
        JTextField nameField = new JTextField();
        JLabel dateLabel = new JLabel("Data: ");
        JTextField dateField = new JTextField();
        JLabel locationLabel = new JLabel("Locatie: ");
        JTextField locationField = new JTextField();

        panel.add(nameLabel);
        panel.add(nameField);
        panel.add(dateLabel);
        panel.add(dateField);
        panel.add(locationLabel);
        panel.add(locationField);

        int result = JOptionPane.showConfirmDialog((Component) parentComponent, panel, title, JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (result == JOptionPane.OK_OPTION) {
            inputs[0] = nameField.getText();
            inputs[1] = dateField.getText();
            inputs[2] = locationField.getText();
        } else {
            System.out.println("Cancelled");
        }
        return inputs;
    }



}
