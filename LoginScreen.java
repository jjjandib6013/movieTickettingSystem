import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginScreen extends JFrame {
    private MovieCatalog movieCatalog;
    JTextField userLogin;
    JPasswordField passLogin;


    public LoginScreen() {
        setTitle("Movie Ticketing System");
        setSize(1200, 1000);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setBackground(Color.getHSBColor(195 / 360f, 25 / 100f, 90 / 100f));
        setLocationRelativeTo(null);

        movieCatalog = new MovieCatalog();
        showUI();
    }

    public void showUI() {
        JPanel introPanel = new JPanel();
        introPanel.setLayout(new GridBagLayout());
        introPanel.setBackground(Color.getHSBColor(195 / 360f, 25 / 100f, 90 / 100f));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        JLabel titleLabel = new JLabel("Movie Ticketing System");
        titleLabel.setFont(new Font(Font.SERIF, Font.BOLD, 30));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        introPanel.add(titleLabel, gbc);

        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setFont(new Font(Font.SERIF, Font.PLAIN, 20));
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.EAST;
        introPanel.add(usernameLabel, gbc);

        userLogin = new JTextField(20);
        userLogin.setFont(new Font(Font.SERIF, Font.PLAIN, 20));
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        introPanel.add(userLogin, gbc);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setFont(new Font(Font.SERIF, Font.PLAIN, 20));
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.EAST;
        introPanel.add(passwordLabel, gbc);

        passLogin = new JPasswordField(20);
        passLogin.setFont(new Font(Font.SERIF, Font.PLAIN, 20));
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.WEST;
        introPanel.add(passLogin, gbc);

        JButton loginButton = new JButton("Login");
        loginButton.setFont(new Font(Font.SERIF, Font.BOLD, 20));
        loginButton.setFocusable(false);
        loginButton.addActionListener(new LoginButtonClickListener());
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        introPanel.add(loginButton, gbc);

        getRootPane().setDefaultButton(loginButton);

        add(introPanel);
    }

    private class LoginButtonClickListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String username = userLogin.getText();
            String password = new String(passLogin.getPassword());

            if (("admin".equals(username) && "admin".equals(password)) || ("jandib".equals(username) && "jandib".equals(password))) {
                JOptionPane.showMessageDialog(LoginScreen.this, "Login successful!", "Login Successful", JOptionPane.INFORMATION_MESSAGE);
                getContentPane().removeAll();
                setContentPane(movieCatalog.getContentPane());
                movieCatalog.displayMovies();
                revalidate();
                repaint();
            } else {
                JOptionPane.showMessageDialog(LoginScreen.this, "Invalid username or password!", "Login Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static void main(String[] args) {
        LoginScreen login = new LoginScreen();
        login.setVisible(true);
    }
}
