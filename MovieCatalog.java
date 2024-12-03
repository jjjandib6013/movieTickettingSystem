import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.awt.event.*;

public class MovieCatalog extends JFrame {
    private JPanel displayMovieAreaPanel;
    private JPanel bottomPanel;
    private MovieManager movieManager;

    public MovieCatalog() {
        movieManager = new MovieManager();

        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(Color.getHSBColor(195 / 360f, 25 / 100f, 90 / 100f));
        JLabel systemNameLabel = new JLabel("Movie Ticketing System");
        systemNameLabel.setFont(new Font(Font.SERIF, Font.BOLD, 30));
        systemNameLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 300));
        headerPanel.add(systemNameLabel, BorderLayout.WEST);

        JPanel searchPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        searchPanel.setBackground(Color.getHSBColor(195 / 360f, 25 / 100f, 90 / 100f));
        JTextField searchField = new JTextField(15);
        searchField.setFont(new Font(Font.SERIF, Font.PLAIN, 18));
        JButton searchButton = new JButton("Search");
        searchButton.setFont(new Font(Font.SERIF, Font.BOLD, 16));
        searchButton.setFocusable(false);
        searchPanel.add(searchField);
        searchPanel.add(searchButton);
        headerPanel.add(searchPanel, BorderLayout.EAST);

        add(headerPanel, BorderLayout.NORTH);

        displayMovieAreaPanel = new JPanel();
        displayMovieAreaPanel.setLayout(new GridLayout(0, 3, 0, 20));
        displayMovieAreaPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 20, 0));
        JScrollPane scrollPane = new JScrollPane(displayMovieAreaPanel);
        scrollPane.getVerticalScrollBar().setUnitIncrement(20); 
        add(scrollPane, BorderLayout.CENTER);

        JButton showMovieCatalogButton = new JButton("Show Catalog");
        showMovieCatalogButton.setFont(new Font(Font.SERIF, Font.BOLD, 20));
        showMovieCatalogButton.setFocusable(false);
        showMovieCatalogButton.addActionListener(e -> displayMovies());

        bottomPanel = new JPanel();
        bottomPanel.setBackground(Color.getHSBColor(195 / 360f, 0.25f, 0.90f));
        bottomPanel.add(showMovieCatalogButton);
        add(bottomPanel, BorderLayout.SOUTH);
    }

    public void displayMovies() {
        displayMovieAreaPanel.removeAll();

        File imageFolder = new File("lib/");

        if (movieManager.getMovies().isEmpty()) {
            JLabel noMoviesLabel = new JLabel("No movies available.");
            noMoviesLabel.setFont(new Font(Font.SERIF, Font.PLAIN, 18));
            displayMovieAreaPanel.add(noMoviesLabel);
        } else {
            for (int i = 0; i < movieManager.getMovies().size(); i++) {
                Movie movie = movieManager.getMovies().get(i);

                JPanel descriptionPanel = new JPanel(new GridLayout(11, 0, 0, 10));
                descriptionPanel.setBorder(BorderFactory.createEmptyBorder(0, 50, 0, 0));
                JPanel picturePanel = new JPanel();
                JLabel pictureLabel = new JLabel();

                Font movieLabelFont = new Font(Font.SERIF, Font.BOLD, 20);
                Font descriptionFont = new Font(Font.SERIF, Font.PLAIN, 20);
                Font tixButtonFont = new Font(Font.SERIF, Font.BOLD, 20);

                JPanel movieDescriptionPanel = new JPanel();

                JLabel movieDescriptionLabel = new JLabel("Description: " + movie.getDescription());
                movieDescriptionLabel.setFont(descriptionFont);
                    
                String expectedFileName = movie.getTitle() + ".jpg";
                File imageFile = new File(imageFolder, expectedFileName);

                if (imageFile.exists()) {
                    pictureLabel.setIcon(new ImageIcon(imageFile.getAbsolutePath()));
                } else {
                    pictureLabel.setText("No Image");
                }

                picturePanel.add(pictureLabel);

                JLabel movieLabel = new JLabel("Movie " + (i + 1));
                movieLabel.setFont(movieLabelFont);

                JLabel titleLabel = new JLabel("Title: " + movie.getTitle());
                titleLabel.setFont(descriptionFont);

                JLabel genreLabel = new JLabel("Genre: " + movie.getGenre());
                genreLabel.setFont(descriptionFont);

                JLabel yearLabel = new JLabel("Year: " + movie.getYear());
                yearLabel.setFont(descriptionFont);

                JLabel durationLabel = new JLabel("Duration: " + movie.getDuration());
                durationLabel.setFont(descriptionFont);

                JLabel directorLabel = new JLabel("Director: " + movie.getDirector());
                directorLabel.setFont(descriptionFont);

                JLabel ratingLabel = new JLabel("Rating: " + movie.getRating() + " stars");
                ratingLabel.setFont(descriptionFont);

                JLabel priceLabel = new JLabel("Price: " + movie.getPrice());
                priceLabel.setFont(descriptionFont);

                JLabel languageLabel = new JLabel("Language: " + movie.getLanguage());
                languageLabel.setFont(descriptionFont);

                JPanel buyTixPanel = new JPanel(new GridBagLayout());
                GridBagConstraints gbc = new GridBagConstraints();

                gbc.insets = new Insets(10, 10, 10, 10);
                gbc.gridx = 0;
                gbc.gridy = 0;
                gbc.fill = GridBagConstraints.WEST;

                JButton buyTixButton = new JButton("Buy Tickets");
                buyTixButton.setFocusable(false);
                buyTixButton.setFont(tixButtonFont);
                buyTixButton.addActionListener(new BuyTicketsButtonClickListener(movie));
                buyTixPanel.add(buyTixButton, gbc);

                //gbc.gridx = 1;
                //JButton bookTixButton = new JButton("Book Tickets");
                //bookTixButton.setFocusable(false);
                //bookTixButton.setFont(tixButtonFont);
                //bookTixButton.addActionListener(new BookTicketsButtonClickListener(movie));
                //buyTixPanel.add(bookTixButton, gbc);

                descriptionPanel.add(movieLabel);
                descriptionPanel.add(titleLabel);
                descriptionPanel.add(genreLabel);
                descriptionPanel.add(yearLabel);
                descriptionPanel.add(durationLabel);
                descriptionPanel.add(directorLabel);
                descriptionPanel.add(ratingLabel);
                descriptionPanel.add(priceLabel);
                descriptionPanel.add(languageLabel);
                descriptionPanel.add(buyTixPanel);

                movieDescriptionPanel.add(movieDescriptionLabel, BorderLayout.NORTH);

                displayMovieAreaPanel.add(picturePanel);
                displayMovieAreaPanel.add(descriptionPanel);
                displayMovieAreaPanel.add(movieDescriptionPanel);
            }
        }

        revalidate();
        repaint();
    }

    private class BuyTicketsButtonClickListener implements ActionListener {
        private Movie movie;

        public BuyTicketsButtonClickListener(Movie movie) {
            this.movie = movie;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            BookingScreen bookingScreen = new BookingScreen(movie.getTitle());
            bookingScreen.setVisible(true);
        }
    }
}