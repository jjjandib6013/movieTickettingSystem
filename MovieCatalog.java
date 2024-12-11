import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.*;

public class MovieCatalog extends JFrame {
    private JPanel displayMovieAreaPanel;
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
        searchButton.addActionListener(e -> {
            String searchText = searchField.getText().trim().toLowerCase();
            if (searchText.isEmpty()) {
                displayMovies();
                return;
            }

            List<Movie> filteredMovies = new ArrayList<>();
            for (Movie movie : movieManager.getMovies()) {
                if (movie.getTitle().toLowerCase().contains(searchText) ||
                    movie.getGenre().toLowerCase().contains(searchText) ||
                    movie.getDateshowing().toLowerCase().contains(searchText)) {
                    filteredMovies.add(movie);
                }
            }

            displayFilteredMovies(filteredMovies);
        });
        searchPanel.add(searchField);
        searchPanel.add(searchButton);
        headerPanel.add(searchPanel, BorderLayout.EAST);

        add(headerPanel, BorderLayout.NORTH);

        displayMovieAreaPanel = new JPanel();
        displayMovieAreaPanel.setLayout(new GridLayout(0, 2, 0, 20));
        displayMovieAreaPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 20, 0));
        JScrollPane scrollPane = new JScrollPane(displayMovieAreaPanel);
        scrollPane.getVerticalScrollBar().setUnitIncrement(20); 
        add(scrollPane, BorderLayout.CENTER);
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

                JPanel descriptionPanel = new JPanel(new GridLayout(12, 0, 0, 0));
                descriptionPanel.setBorder(BorderFactory.createEmptyBorder(0, 50, 0, 0));
                JPanel picturePanel = new JPanel();
                JLabel pictureLabel = new JLabel();

                Font movieLabelFont = new Font(Font.SERIF, Font.BOLD, 20);
                Font descriptionFont = new Font(Font.SERIF, Font.PLAIN, 20);
                Font tixButtonFont = new Font(Font.SERIF, Font.BOLD, 20);

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

                JLabel ratingLabel = new JLabel("Rating: " + movie.getRating() + " stars");
                ratingLabel.setFont(descriptionFont);

                JLabel priceLabel = new JLabel("Price: " + movie.getPrice());
                priceLabel.setFont(descriptionFont);

                JLabel dateShowingLabel = new JLabel("Date Showing: " + movie.getDateshowing());
                dateShowingLabel.setFont(descriptionFont);

                JLabel showtimesLabel = new JLabel("Showtimes: " + movie.getShowtimes());
                showtimesLabel.setFont(descriptionFont);

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
                descriptionPanel.add(ratingLabel);
                descriptionPanel.add(priceLabel);
                descriptionPanel.add(dateShowingLabel);
                descriptionPanel.add(showtimesLabel);
                descriptionPanel.add(buyTixPanel);


                displayMovieAreaPanel.add(picturePanel);
                displayMovieAreaPanel.add(descriptionPanel);
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
            BookingScreen bookingScreen = new BookingScreen(movie.getTitle(), movie.getPrice());
            bookingScreen.setVisible(true);
        }
    }

    private void displayFilteredMovies(List<Movie> filteredMovies) {
        displayMovieAreaPanel.removeAll();
    
        if (filteredMovies.isEmpty()) {
            JLabel noResultsLabel = new JLabel("No movies found matching your search.");
            noResultsLabel.setFont(new Font(Font.SERIF, Font.PLAIN, 18));
            displayMovieAreaPanel.add(noResultsLabel);
        } else {
            for (int i = 0; i < filteredMovies.size(); i++) {
                Movie movie = filteredMovies.get(i);
    
                JPanel descriptionPanel = new JPanel(new GridLayout(10, 0, 0, 0));
                descriptionPanel.setBorder(BorderFactory.createEmptyBorder(0, 50, 0, 0));
                JPanel picturePanel = new JPanel();
                JLabel pictureLabel = new JLabel();
    
                Font movieLabelFont = new Font(Font.SERIF, Font.BOLD, 20);
                Font descriptionFont = new Font(Font.SERIF, Font.PLAIN, 20);
                Font tixButtonFont = new Font(Font.SERIF, Font.BOLD, 20);
    
                File imageFolder = new File("lib/");
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
    
                JLabel ratingLabel = new JLabel("Rating: " + movie.getRating() + " stars");
                ratingLabel.setFont(descriptionFont);
    
                JLabel priceLabel = new JLabel("Price: " + movie.getPrice());
                priceLabel.setFont(descriptionFont);
    
                JLabel dateshowingLabel = new JLabel("Date Showing: " + movie.getDateshowing());
                dateshowingLabel.setFont(descriptionFont);
    
                JLabel showtimesLabel = new JLabel("Showtimes: " + movie.getShowtimes());
                showtimesLabel.setFont(descriptionFont);
    
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
    
                descriptionPanel.add(movieLabel);
                descriptionPanel.add(titleLabel);
                descriptionPanel.add(genreLabel);
                descriptionPanel.add(yearLabel);
                descriptionPanel.add(durationLabel);
                descriptionPanel.add(ratingLabel);
                descriptionPanel.add(priceLabel);
                descriptionPanel.add(dateshowingLabel);
                descriptionPanel.add(showtimesLabel);
                descriptionPanel.add(buyTixPanel);
    
                displayMovieAreaPanel.add(picturePanel);
                displayMovieAreaPanel.add(descriptionPanel);
            }
        }
    
        revalidate();
        repaint();
    }
}