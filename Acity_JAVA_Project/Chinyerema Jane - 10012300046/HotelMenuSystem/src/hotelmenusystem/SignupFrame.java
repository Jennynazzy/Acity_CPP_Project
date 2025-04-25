package hotelmenusystem;

import javax.swing.*;
import java.awt.*;

public class SignupFrame extends JFrame {
    private JTextField emailField;
    private JPasswordField passwordField;
    private JTextField phoneField;
    private JCheckBox termsCheckBox;

    public SignupFrame() {
        setTitle("Sign Up - My Hotel");
        setSize(400, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        // Main Panel
        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(Color.WHITE);
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 30, 20, 30));

        // Logo
        JLabel logoLabel = new JLabel(new ImageIcon("src/hotelmenusystem/your-logo.png")); // Replace with your logo path
        logoLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel titleLabel = new JLabel("My Hotel");
        titleLabel.setFont(new Font("SansSerif", Font.BOLD, 24));
        titleLabel.setForeground(new Color(90, 0, 200));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        mainPanel.add(logoLabel);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        mainPanel.add(titleLabel);

        // Fields
        emailField = createTextField("Email Address");
        passwordField = createPasswordField("Password");
        phoneField = createTextField("Phone Number");

        mainPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        mainPanel.add(emailField);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        mainPanel.add(passwordField);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        mainPanel.add(phoneField);

        // Terms Checkbox
        termsCheckBox = new JCheckBox("I agree to the Terms & Conditions");
        termsCheckBox.setBackground(Color.WHITE);
        termsCheckBox.setForeground(Color.GRAY);
        termsCheckBox.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        mainPanel.add(termsCheckBox);

        // Signup Button
        JButton signupButton = new JButton("SIGN UP");
        signupButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        signupButton.setBackground(new Color(0, 153, 0));
        signupButton.setForeground(Color.WHITE);
        signupButton.setFocusPainted(false);
        signupButton.setPreferredSize(new Dimension(200, 40));

        mainPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        mainPanel.add(signupButton);

        // Already have an account?
        JButton alreadyButton = new JButton("Already have an account? Log in");
        alreadyButton.setBackground(Color.WHITE);
        alreadyButton.setForeground(new Color(0, 102, 204));
        alreadyButton.setBorderPainted(false);
        alreadyButton.setFocusPainted(false);
        alreadyButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        mainPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        mainPanel.add(alreadyButton);

        // Social icons
        JPanel socialPanel = new JPanel();
        socialPanel.setBackground(Color.WHITE);
        socialPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        socialPanel.add(new JLabel(new ImageIcon("src/hotelmenusystem/facebook-icon.png"))); // Replace with icon path
        socialPanel.add(new JLabel(new ImageIcon("src/hotelmenusystem/twitter-icon.png"))); // Replace with icon path
        socialPanel.add(new JLabel(new ImageIcon("src/hotelmenusystem/email-icon.png"))); // Replace with icon path

        mainPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        mainPanel.add(socialPanel);

        // Add to Frame
        add(mainPanel, BorderLayout.CENTER);

        // Button actions
        signupButton.addActionListener(e -> signup());
        alreadyButton.addActionListener(e -> {
            new LoginFrame().setVisible(true);
            this.dispose();
        });
    }

    private void signup() {
        String email = emailField.getText();
        String password = String.valueOf(passwordField.getPassword());
        String phone = phoneField.getText();

        if (email.isEmpty() || password.isEmpty() || phone.isEmpty() || !termsCheckBox.isSelected()) {
            JOptionPane.showMessageDialog(this, "Please fill all fields and accept Terms & Conditions.");
            return;
        }

        if (MenuDataManager.addUser(email, password, phone)) {
            JOptionPane.showMessageDialog(this, "Signup successful!");
            this.dispose();
            new LoginFrame().setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "User already exists!");
        }
    }

    private JTextField createTextField(String placeholder) {
        JTextField field = new JTextField();
        field.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40));
        field.setBorder(BorderFactory.createTitledBorder(placeholder));
        return field;
    }

    private JPasswordField createPasswordField(String placeholder) {
        JPasswordField field = new JPasswordField();
        field.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40));
        field.setBorder(BorderFactory.createTitledBorder(placeholder));
        return field;
    }
}
