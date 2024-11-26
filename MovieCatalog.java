import javax.swing.*;
import java.awt.*;

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
        systemNameLabel.setHorizontalAlignment(JLabel.CENTER);
        headerPanel.add(systemNameLabel);
        add(headerPanel, BorderLayout.NORTH);

        displayMovieAreaPanel = new JPanel();
        displayMovieAreaPanel.setLayout(new GridLayout(0, 1));
        JScrollPane scrollPane = new JScrollPane(displayMovieAreaPanel);
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
    
        if (movieManager.getMovies().isEmpty()) {
            JLabel noMoviesLabel = new JLabel("No movies available.");
            noMoviesLabel.setFont(new Font(Font.SERIF, Font.PLAIN, 18));
            displayMovieAreaPanel.add(noMoviesLabel);
        } else {
            for (int i = 0; i < movieManager.getMovies().size(); i++) {
                Movie movie = movieManager.getMovies().get(i);
                JLabel movieLabel = new JLabel("Movie " + (i + 1) + "\n" +
                                              "Title: " + movie.getTitle() + "\n" +
                                              "Genre: " + movie.getGenre() + "\n" +
                                              "Year: " + movie.getYear() + "\n");
                movieLabel.setFont(new Font(Font.SERIF, Font.PLAIN, 18));
                displayMovieAreaPanel.add(movieLabel);
            }
        }
    
        revalidate();
        repaint();
    }
    
}
