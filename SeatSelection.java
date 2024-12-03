import javax.swing.*;
import java.awt.*;

public class SeatSelection extends JFrame {

    private final int rows = 5;
    private final int columns = 8;
    private final JButton[][] seatButtons;
    private int ticketsLeft;

    public SeatSelection(String movieTitle, int totalTickets, String name, String email, String phone) {
        this.ticketsLeft = totalTickets;

        setTitle("Seat Selection - " + movieTitle);
        setSize(800, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel(new BorderLayout());

        JLabel screenLabel = new JLabel("Screen Here", SwingConstants.CENTER);
        screenLabel.setFont(new Font(Font.SERIF, Font.BOLD, 24));
        screenLabel.setOpaque(true);
        screenLabel.setBackground(Color.LIGHT_GRAY);
        screenLabel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
        mainPanel.add(screenLabel, BorderLayout.NORTH);

        JPanel seatPanel = new JPanel(new GridLayout(rows, columns, 5, 5));
        seatPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        seatButtons = new JButton[rows][columns];

        JLabel ticketCounterLabel = new JLabel("Tickets Left: " + ticketsLeft, SwingConstants.CENTER);
        ticketCounterLabel.setFont(new Font(Font.SERIF, Font.PLAIN, 20));
        ticketCounterLabel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
        mainPanel.add(ticketCounterLabel, BorderLayout.SOUTH);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                JButton seatButton = new JButton("R" + (i + 1) + "C" + (j + 1));
                seatButton.setFont(new Font(Font.SERIF, Font.PLAIN, 14));
                seatButton.setBackground(Color.GREEN);
                seatButton.setFocusable(false);

                seatButton.addActionListener(e -> {
                    if (ticketsLeft > 0) {
                        if (seatButton.getBackground() == Color.GREEN) {
                            seatButton.setBackground(Color.RED);
                            seatButton.setEnabled(false);
                            ticketsLeft--;
                            ticketCounterLabel.setText("Tickets Left: " + ticketsLeft);

                            if (ticketsLeft == 0) {
                                JOptionPane.showMessageDialog(
                                        this,
                                        "All tickets selected! Proceeding to confirmation.",
                                        "Selection Complete",
                                        JOptionPane.INFORMATION_MESSAGE
                                );
                            }
                        }
                    }
                });

                seatButtons[i][j] = seatButton;
                seatPanel.add(seatButton);
            }
        }

        JButton confirmButton = new JButton("Confirm Selection");
        confirmButton.setFont(new Font(Font.SERIF, Font.PLAIN, 18));
        confirmButton.setFocusable(false);
        confirmButton.addActionListener(e -> {
            if (ticketsLeft > 0) {
                JOptionPane.showMessageDialog(
                        this,
                        "Please select all your tickets before confirming.",
                        "Incomplete Selection",
                        JOptionPane.WARNING_MESSAGE
                );
            } else {
                JOptionPane.showMessageDialog(
                        this,
                        "Seats confirmed! Proceeding to payment...",
                        "Confirmation",
                        JOptionPane.INFORMATION_MESSAGE
                );

                // Clear the current seat selection UI and show the payment confirmation
                mainPanel.removeAll();  // Remove existing components
                mainPanel.add(new PaymentConfirmation(movieTitle, totalTickets, name, email, phone).getContentPane());
                mainPanel.revalidate(); // Revalidate to refresh the layout
                mainPanel.repaint();    // Repaint to update the display
            }
        });

        mainPanel.add(seatPanel, BorderLayout.CENTER);
        mainPanel.add(confirmButton, BorderLayout.SOUTH);
        add(mainPanel);
        setLocationRelativeTo(null);
    }
}
