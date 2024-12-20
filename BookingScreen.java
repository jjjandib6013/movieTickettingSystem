import javax.swing.*;
import java.awt.*;
import java.io.File;

public class BookingScreen extends JFrame {

    public BookingScreen(String movieTitle, int moviePrice) {
        try {
            setTitle("Booking Screen - " + movieTitle);
            setSize(800, 800);
            setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

            File imageFolder = new File("lib/");
            if (!imageFolder.exists() || !imageFolder.isDirectory()) {
                throw new Exception("Image folder 'lib/' does not exist or is not a directory.");
            }

            JPanel headerPanel = new JPanel();
            headerPanel.setBackground(Color.getHSBColor(195 / 360f, 25 / 100f, 90 / 100f));
            JLabel systemNameLabel = new JLabel("Movie Ticketing System");
            systemNameLabel.setFont(new Font(Font.SERIF, Font.BOLD, 30));
            systemNameLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 300));
            headerPanel.add(systemNameLabel, BorderLayout.WEST);

            JPanel centerPanel = new JPanel(new GridLayout(2, 0, 0, 10));

            JPanel picturePanel = new JPanel();
            picturePanel.setBorder(BorderFactory.createEmptyBorder(30, 0, 0, 0));
            JLabel pictureLabel = new JLabel();

            String expectedFileName = movieTitle + ".jpg";
            File imageFile = new File(imageFolder, expectedFileName);

            if (imageFile.exists()) {
                pictureLabel.setIcon(new ImageIcon(imageFile.getAbsolutePath()));
            } else {
                pictureLabel.setText("No Image");
            }

            picturePanel.add(pictureLabel);

            JPanel infoPanel = new JPanel(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.insets = new Insets(10, 10, 10, 10);

            JLabel bookingLabel = new JLabel("Buying tickets for: " + movieTitle);
            bookingLabel.setFont(new Font(Font.SERIF, Font.BOLD, 24));
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.gridwidth = 2;
            infoPanel.add(bookingLabel, gbc);

            JLabel nameLabel = new JLabel("Enter your name:");
            nameLabel.setFont(new Font(Font.SERIF, Font.PLAIN, 20));
            JTextField nameField = new JTextField(30);
            nameField.setFont(new Font(Font.SERIF, Font.PLAIN, 20));
            gbc.gridx = 0;
            gbc.gridy = 1;
            gbc.gridwidth = 1;
            infoPanel.add(nameLabel, gbc);

            gbc.gridx = 1;
            infoPanel.add(nameField, gbc);

            JLabel emailLabel = new JLabel("Enter your email:");
            emailLabel.setFont(new Font(Font.SERIF, Font.PLAIN, 20));
            JTextField emailField = new JTextField(30);
            emailField.setFont(new Font(Font.SERIF, Font.PLAIN, 20));
            gbc.gridx = 0;
            gbc.gridy = 2;
            infoPanel.add(emailLabel, gbc);

            gbc.gridx = 1;
            infoPanel.add(emailField, gbc);

            JLabel phoneLabel = new JLabel("Enter your phone number:");
            phoneLabel.setFont(new Font(Font.SERIF, Font.PLAIN, 20));
            JTextField phoneField = new JTextField(30);
            phoneField.setFont(new Font(Font.SERIF, Font.PLAIN, 20));
            gbc.gridx = 0;
            gbc.gridy = 3;
            infoPanel.add(phoneLabel, gbc);

            gbc.gridx = 1;
            infoPanel.add(phoneField, gbc);

            JLabel ticketsLabel = new JLabel("Number of tickets:");
            ticketsLabel.setFont(new Font(Font.SERIF, Font.PLAIN, 20));
            JSpinner ticketsSpinner = new JSpinner(new SpinnerNumberModel(1, 1, 10, 1));
            ticketsSpinner.setFont(new Font(Font.SERIF, Font.PLAIN, 20));
            gbc.gridx = 0;
            gbc.gridy = 4;
            infoPanel.add(ticketsLabel, gbc);

            gbc.gridx = 1;
            infoPanel.add(ticketsSpinner, gbc);

            JLabel priceLabel = new JLabel("Price per ticket: " + moviePrice + " units");
            priceLabel.setFont(new Font(Font.SERIF, Font.BOLD, 20));
            gbc.gridx = 0;
            gbc.gridy = 5;
            infoPanel.add(priceLabel, gbc);

            JButton confirmButton = new JButton("Confirm Booking");
            confirmButton.setFont(new Font(Font.SERIF, Font.PLAIN, 20));
            confirmButton.setFocusable(false);
            gbc.gridx = 0;
            gbc.gridy = 5;
            gbc.gridwidth = 2;
            infoPanel.add(confirmButton, gbc);

            confirmButton.addActionListener(e -> {
                try {
                    String name = nameField.getText().trim();
                    String email = emailField.getText().trim();
                    String phone = phoneField.getText().trim();
                    int tickets = (int) ticketsSpinner.getValue();

                    if (name.isEmpty() || email.isEmpty() || phone.isEmpty()) {
                        throw new Exception("All fields are required.");
                    }

                    if (!email.contains("@") || !email.contains(".")) {
                        throw new Exception("Invalid email format.");
                    }

                    if (!phone.matches("\\d{10,15}")) {
                        throw new Exception("Phone number must contain 10 to 15 digits.");
                    }

                    JOptionPane.showMessageDialog(
                            BookingScreen.this,
                            "Booking Confirmed!\n" +
                                    "Name: " + name + "\n" +
                                    "Email: " + email + "\n" +
                                    "Phone: " + phone + "\n" +
                                    "Tickets: " + tickets,
                            "Success",
                            JOptionPane.INFORMATION_MESSAGE
                    );

                    getContentPane().removeAll();
                    setContentPane(new SeatSelection(movieTitle, tickets, name, email, phone, moviePrice).getContentPane());
                    revalidate();
                    repaint();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(
                            BookingScreen.this,
                            ex.getMessage(),
                            "Error",
                            JOptionPane.ERROR_MESSAGE
                    );
                }
            });

            centerPanel.add(picturePanel);
            centerPanel.add(infoPanel);

            add(headerPanel, BorderLayout.NORTH);
            add(centerPanel);
            setLocationRelativeTo(null);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(
                    this,
                    ex.getMessage(),
                    "Initialization Error",
                    JOptionPane.ERROR_MESSAGE
            );
            dispose();
        }
    }
}
