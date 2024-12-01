import javax.swing.*;
import java.awt.*;

public class BookingScreen extends JFrame {
    
    public BookingScreen(String movieTitle) {
        setTitle("Booking Screen - " + movieTitle);
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        
        JLabel bookingLabel = new JLabel("Booking Tickets for: " + movieTitle);
        bookingLabel.setFont(new Font("Serif", Font.BOLD, 24));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        panel.add(bookingLabel, gbc);

        JLabel nameLabel = new JLabel("Enter your name:");
        JTextField nameField = new JTextField(20);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        panel.add(nameLabel, gbc);
        
        gbc.gridx = 1;
        panel.add(nameField, gbc);

        JButton confirmButton = new JButton("Confirm Booking");
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        panel.add(confirmButton, gbc);

        confirmButton.addActionListener(e -> JOptionPane.showMessageDialog(BookingScreen.this, "Booking Confirmed!"));
        
        add(panel);
        setLocationRelativeTo(null);
    }
}
