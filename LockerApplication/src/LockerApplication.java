import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LockerApplication extends JFrame implements ActionListener {

    // UI components
    private JTextField passcodeField;
    private JButton enterButton;
    private JButton clearButton;
    private JLabel statusLabel;

    // Passcode
    private String passcode;

    public LockerApplication() {
        super("Locker Application");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);
        setLayout(new FlowLayout());

        // Passcode field
        passcodeField = new JTextField(10);
        add(passcodeField);

        // Enter button
        enterButton = new JButton("Enter");
        enterButton.addActionListener(this);
        add(enterButton);

        // Clear button
        clearButton = new JButton("Clear");
        clearButton.addActionListener(this);
        add(clearButton);

        // Status label
        statusLabel = new JLabel("");
        add(statusLabel);

        // Initial status
        statusLabel.setText("Please enter your passcode");

        // Make the frame visible
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == enterButton) {
            // Get the entered passcode
            String enteredPasscode = passcodeField.getText();

            if (passcode == null) {
                // First time setting the passcode
                passcode = enteredPasscode;
                statusLabel.setText("Password Set");
            } else {
                // Verify the entered passcode
                if (enteredPasscode.equals(passcode)) {
                    statusLabel.setText("Correct Password");
                } else {
                    statusLabel.setText("Incorrect Password");
                }
            }
        } else if (e.getSource() == clearButton) {
            // Clear the passcode field
            passcodeField.setText("");
        }
    }

    public static void main(String[] args) {
        new LockerApplication();
    }
}