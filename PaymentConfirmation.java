    import javax.swing.*;
    import java.awt.*;

    public class PaymentConfirmation extends JFrame {

        public PaymentConfirmation(String movieTitle, int totalTickets, String name, String email, String phone, int ticketPrice) {
            setTitle("Payment Confirmation - " + movieTitle);
            setSize(800, 800);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            JPanel mainPanel = new JPanel(new BorderLayout());

            JPanel headerPanel = new JPanel();
            headerPanel.setBackground(Color.getHSBColor(195 / 360f, 25 / 100f, 90 / 100f));
            JLabel systemNameLabel = new JLabel("Movie Ticketing System");
            systemNameLabel.setFont(new Font(Font.SERIF, Font.BOLD, 30));
            systemNameLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 300));
            headerPanel.add(systemNameLabel, BorderLayout.WEST);

            JLabel titleLabel = new JLabel("Payment Confirmation", JLabel.CENTER);
            titleLabel.setFont(new Font(Font.SERIF, Font.BOLD, 30));
            mainPanel.add(titleLabel, BorderLayout.NORTH);

            JPanel infoPanel = new JPanel(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.insets = new Insets(10, 10, 10, 10);
            gbc.anchor = GridBagConstraints.WEST;

            JLabel bookingLabel = new JLabel("Booking Details:");
            bookingLabel.setFont(new Font(Font.SERIF, Font.BOLD, 20));
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.gridwidth = 2;
            infoPanel.add(bookingLabel, gbc);

            JLabel nameLabel = new JLabel("Name: " + name);
            nameLabel.setFont(new Font(Font.SERIF, Font.PLAIN, 18));
            gbc.gridx = 0;
            gbc.gridy = 1;
            infoPanel.add(nameLabel, gbc);

            JLabel emailLabel = new JLabel("Email: " + email);
            emailLabel.setFont(new Font(Font.SERIF, Font.PLAIN, 18));
            gbc.gridx = 0;
            gbc.gridy = 2;
            infoPanel.add(emailLabel, gbc);

            JLabel phoneLabel = new JLabel("Phone: " + phone);
            phoneLabel.setFont(new Font(Font.SERIF, Font.PLAIN, 18));
            gbc.gridx = 0;
            gbc.gridy = 3;
            infoPanel.add(phoneLabel, gbc);

            JLabel ticketsLabel = new JLabel("Tickets: " + totalTickets);
            ticketsLabel.setFont(new Font(Font.SERIF, Font.PLAIN, 18));
            gbc.gridx = 0;
            gbc.gridy = 4;
            infoPanel.add(ticketsLabel, gbc);

            int totalPrice = totalTickets * ticketPrice;
            JLabel priceLabel = new JLabel("Total Price: ₱" + ticketPrice + " x " + totalTickets + " ticket/s " + " = " + "₱" + totalPrice);
            priceLabel.setFont(new Font(Font.SERIF, Font.PLAIN, 18));
            gbc.gridx = 0;
            gbc.gridy = 5;
            infoPanel.add(priceLabel, gbc);

            JLabel paymentLabel = new JLabel("Select Payment Method:");
            paymentLabel.setFont(new Font(Font.SERIF, Font.PLAIN, 20));
            gbc.gridx = 0;
            gbc.gridy = 6;
            infoPanel.add(paymentLabel, gbc);

            String[] paymentMethods = {"Cash", "Credit Card", "PayPal", "Debit Card", "GCash"};
            JComboBox<String> paymentMethodComboBox = new JComboBox<>(paymentMethods);
            paymentMethodComboBox.setFont(new Font(Font.SERIF, Font.PLAIN, 18));
            gbc.gridx = 2;
            infoPanel.add(paymentMethodComboBox, gbc);

            JButton confirmPaymentButton = new JButton("Confirm Payment");
            confirmPaymentButton.setFont(new Font(Font.SERIF, Font.PLAIN, 20));
            confirmPaymentButton.setFocusable(false);
            confirmPaymentButton.addActionListener(e -> {
                String paymentMethod = (String) paymentMethodComboBox.getSelectedItem();
                JOptionPane.showMessageDialog(
                        PaymentConfirmation.this,
                        "Payment Confirmed!\nThank you for your purchase via " + paymentMethod,
                        "Payment Successful",
                        JOptionPane.INFORMATION_MESSAGE
                );

                dispose(); // Dispose the frame after payment
            });

            JPanel buttonPanel = new JPanel();
            buttonPanel.add(confirmPaymentButton);

            mainPanel.add(headerPanel, BorderLayout.NORTH);
            mainPanel.add(infoPanel, BorderLayout.CENTER);
            mainPanel.add(buttonPanel, BorderLayout.SOUTH);
            add(mainPanel);
            setLocationRelativeTo(null);
        }
    }
