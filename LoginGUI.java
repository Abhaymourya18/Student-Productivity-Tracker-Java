import javax.swing.*;
import java.awt.*;

public class LoginGUI {

    public LoginGUI() {

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {}

        JFrame frame = new JFrame("Productivity Tracker - Login");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        panel.setBackground(new Color(245, 245, 245));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        JLabel title = new JLabel("Login", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 20));

        JLabel userLabel = new JLabel("Username:");
        JTextField userField = new JTextField(15);

        JLabel passLabel = new JLabel("Password:");
        JPasswordField passField = new JPasswordField(15);
        userField.setFont(new Font("Arial", Font.PLAIN, 14));
passField.setFont(new Font("Arial", Font.PLAIN, 14));

        JButton loginButton = new JButton("Login");
        JButton signupButton = new JButton("Signup");

        loginButton.setBackground(new Color(70, 130, 180));
        loginButton.setForeground(Color.BLACK);

        signupButton.setBackground(new Color(100, 180, 100));
        signupButton.setForeground(Color.BLACK);
        loginButton.setFocusPainted(false);
signupButton.setFocusPainted(false);

// Hover effect for login
loginButton.addMouseListener(new java.awt.event.MouseAdapter() {
    public void mouseEntered(java.awt.event.MouseEvent evt) {
        loginButton.setBackground(new Color(50, 110, 160));
    }

    public void mouseExited(java.awt.event.MouseEvent evt) {
        loginButton.setBackground(new Color(70, 130, 180));
    }
});

// Hover effect for signup
signupButton.addMouseListener(new java.awt.event.MouseAdapter() {
    public void mouseEntered(java.awt.event.MouseEvent evt) {
        signupButton.setBackground(new Color(80, 160, 80));
    }

    public void mouseExited(java.awt.event.MouseEvent evt) {
        signupButton.setBackground(new Color(100, 180, 100));
    }
});

        gbc.gridx = 0; gbc.gridy = 0; gbc.gridwidth = 2;
        panel.add(title, gbc);

        gbc.gridwidth = 1;
        gbc.gridx = 0; gbc.gridy = 1;
        panel.add(userLabel, gbc);

        gbc.gridx = 1;
        panel.add(userField, gbc);

        gbc.gridx = 0; gbc.gridy = 2;
        panel.add(passLabel, gbc);

        gbc.gridx = 1;
        panel.add(passField, gbc);

        gbc.gridx = 0; gbc.gridy = 3;
        panel.add(loginButton, gbc);

        gbc.gridx = 1;
        panel.add(signupButton, gbc);

        UserManager userManager = new UserManager();

        // Login
        loginButton.addActionListener(e -> {
            String username = userField.getText();
            String password = new String(passField.getPassword());

            if (userManager.loginUser(username, password)) {
                JOptionPane.showMessageDialog(frame, "Login successful!");
                frame.dispose();
                new TaskGUI(username);
            } else {
                JOptionPane.showMessageDialog(frame, "Invalid credentials!");
            }
        });

        // Signup
        signupButton.addActionListener(e -> {
            String username = userField.getText();
            String password = new String(passField.getPassword());

            boolean success = userManager.registerUser(username, password);

            if (success) {
                JOptionPane.showMessageDialog(frame, "Signup successful!");
            } else {
                JOptionPane.showMessageDialog(frame, "Signup failed!");
            }
        });

        frame.add(panel);
        frame.setVisible(true);
    }
}