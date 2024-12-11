import javax.swing.*;
import java.awt.*;

public class SeatSelection extends JFrame {

    private final int rows = 5;
    private final int columns = 8;
    private final JButton[][] seatButtons;
    private int ticketsLeft;

    public SeatSelection(String movieTitle, int totalTickets, String name, String email, String phone, int ticketPrice) {
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
                    if (seatButton.getBackground() == Color.GREEN && ticketsLeft > 0) {
                        // Select the seat
                        seatButton.setBackground(Color.RED);
                        ticketsLeft--;
                    } else if (seatButton.getBackground() == Color.RED) {
                        // Deselect the seat
                        seatButton.setBackground(Color.GREEN);
                        ticketsLeft++;
                    }
                    ticketCounterLabel.setText("Tickets Left: " + ticketsLeft);

                    if (ticketsLeft == 0) {
                        JOptionPane.showMessageDialog(
                                this,
                                "All tickets selected! Proceeding to confirmation.",
                                "Selection Complete",
                                JOptionPane.INFORMATION_MESSAGE
                        );
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

                mainPanel.removeAll();
                mainPanel.add(new PaymentConfirmation(movieTitle, totalTickets, name, email, phone, ticketPrice).getContentPane());
                mainPanel.revalidate();
                mainPanel.repaint();
            }
        });

        mainPanel.add(seatPanel, BorderLayout.CENTER);
        mainPanel.add(confirmButton, BorderLayout.SOUTH);
        add(mainPanel);
        setLocationRelativeTo(null);
    }
}
