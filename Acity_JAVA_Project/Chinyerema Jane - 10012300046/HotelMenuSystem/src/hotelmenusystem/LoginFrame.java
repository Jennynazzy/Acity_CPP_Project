package hotelmenusystem;

import javax.swing.*;
import java.awt.*;

public class LoginFrame extends JFrame {
    private JTextField emailField;
    private JPasswordField passwordField;

    public LoginFrame() {
        setTitle("Login - My Hotel");
        setSize(450, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Main panel
        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(new Color(75, 0, 130)); // Purple background
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(30, 40, 30, 40));

        // Logo
        JLabel logoLabel = new JLabel("🏨"); // Placeholder logo
        logoLabel.setFont(new Font("SansSerif", Font.PLAIN, 50));
        logoLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel hotelLabel = new JLabel("My Hotel");
        hotelLabel.setFont(new Font("SansSerif", Font.BOLD, 28));
        hotelLabel.setForeground(Color.WHITE);
        hotelLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        mainPanel.add(logoLabel);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        mainPanel.add(hotelLabel);

        // Welcome text
        JLabel welcomeLabel = new JLabel("Welcome");
        welcomeLabel.setFont(new Font("SansSerif", Font.BOLD, 32));
        welcomeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        welcomeLabel.setForeground(Color.WHITE);

        JLabel descLabel = new JLabel("<html><div style='text-align: center;'>Login to continue to My Hotel</div></html>");
        descLabel.setFont(new Font("SansSerif", Font.PLAIN, 14));
        descLabel.setForeground(new Color(200, 200, 200));
        descLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        mainPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        mainPanel.add(welcomeLabel);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 8)));
        mainPanel.add(descLabel);

        // Input fields
        emailField = createTextField("Email Address");
        passwordField = createPasswordField("Password");

        mainPanel.add(Box.createRigidArea(new Dimension(0, 25)));
        mainPanel.add(emailField);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 15)));
        mainPanel.add(passwordField);

        // Forgot Password
        JButton forgotButton = new JButton("Forgot Password?");
        forgotButton.setBackground(new Color(75, 0, 130));
        forgotButton.setForeground(new Color(173, 216, 230));
        forgotButton.setBorderPainted(false);
        forgotButton.setFocusPainted(false);
        forgotButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        forgotButton.setFont(new Font("SansSerif", Font.PLAIN, 12));

        mainPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        mainPanel.add(forgotButton);

        // Login Button
        JButton loginButton = new JButton("LOGIN");
        loginButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        loginButton.setBackground(new Color(255, 105, 180)); // Pink button
        loginButton.setForeground(Color.WHITE);
        loginButton.setFocusPainted(false);
        loginButton.setPreferredSize(new Dimension(200, 45));
        loginButton.setFont(new Font("SansSerif", Font.BOLD, 16));

        mainPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        mainPanel.add(loginButton);

        // OR separator
        JLabel orLabel = new JLabel("— OR —");
        orLabel.setFont(new Font("SansSerif", Font.PLAIN, 16));
        orLabel.setForeground(Color.WHITE);
        orLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        mainPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        mainPanel.add(orLabel);

        // Social Icons (Simple Buttons)
        JPanel socialPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 5));
        socialPanel.setBackground(new Color(75, 0, 130));

        JButton fbButton = new JButton("f"); // Facebook
        JButton twButton = new JButton("t"); // Twitter
        JButton mailButton = new JButton("@"); // Email

        formatSocialButton(fbButton);
        formatSocialButton(twButton);
        formatSocialButton(mailButton);

        socialPanel.add(fbButton);
        socialPanel.add(twButton);
        socialPanel.add(mailButton);

        mainPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        mainPanel.add(socialPanel);

        // --- BIG CHANGE here: Clearly visible Sign Up Button ---
        JPanel signupPanel = new JPanel();
        signupPanel.setBackground(new Color(75, 0, 130));
        signupPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        JLabel noAccountLabel = new JLabel("Don't have an account?");
        noAccountLabel.setForeground(Color.WHITE);
        noAccountLabel.setFont(new Font("SansSerif", Font.PLAIN, 13));

        JButton signupButton = new JButton("Sign Up");
        signupButton.setBackground(new Color(255, 105, 180)); // Pink to match login button
        signupButton.setForeground(Color.WHITE);
        signupButton.setFocusPainted(false);
        signupButton.setFont(new Font("SansSerif", Font.BOLD, 13));
        signupButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

        signupPanel.add(noAccountLabel);
        signupPanel.add(signupButton);

        mainPanel.add(Box.createRigidArea(new Dimension(0, 15)));
        mainPanel.add(signupPanel);

        // Add main panel to Frame
        add(mainPanel, BorderLayout.CENTER);

        // Actions
        loginButton.addActionListener(e -> login());
        signupButton.addActionListener(e -> {
            new SignupFrame().setVisible(true);
            this.dispose();
        });
        forgotButton.addActionListener(e -> JOptionPane.showMessageDialog(this, "Forgot password clicked!"));
    }

    private void login() {
        String user = emailField.getText();
        String pass = String.valueOf(passwordField.getPassword());

        if (user.equals("admin") && pass.equals("admin123")) {
            new MenuManagerFrame().setVisible(true);
            this.dispose();
        } else if (MenuDataManager.validateUser(user, pass)) {
            new MenuFrame(false).setVisible(true);
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Invalid credentials");
        }
    }

    private JTextField createTextField(String placeholder) {
        JTextField field = new JTextField();
        field.setMaximumSize(new Dimension(Integer.MAX_VALUE, 45));
        field.setFont(new Font("SansSerif", Font.PLAIN, 14));
        field.setBorder(BorderFactory.createTitledBorder(placeholder));
        return field;
    }

    private JPasswordField createPasswordField(String placeholder) {
        JPasswordField field = new JPasswordField();
        field.setMaximumSize(new Dimension(Integer.MAX_VALUE, 45));
        field.setFont(new Font("SansSerif", Font.PLAIN, 14));
        field.setBorder(BorderFactory.createTitledBorder(placeholder));
        return field;
    }

    private void formatSocialButton(JButton button) {
        button.setBackground(Color.WHITE);
        button.setForeground(new Color(75, 0, 130));
        button.setFocusPainted(false);
        button.setPreferredSize(new Dimension(40, 40));
        button.setFont(new Font("SansSerif", Font.BOLD, 20));
        button.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
    }
}
