import java.util.ArrayList;
import java.util.List;

public class MovieManager {
    private List<Movie> movies;

    public MovieManager() {
        movies = new ArrayList<>();
        movies.add(new Movie("Ex Machina", "Sci-Fi", 2010, "120 minutes", "Alex Hander", 4.80, 300, "English"));
        movies.add(new Movie("Ex Machina", "Sci-Fi", 2010, "120 minutes", "Alex Hander", 4.80, 300, "English"));
        movies.add(new Movie("Ex Machina", "Sci-Fi", 2010, "120 minutes", "Alex Hander", 4.80, 300, "English"));
        movies.add(new Movie("Ex Machina", "Sci-Fi", 2010, "120 minutes", "Alex Hander", 4.80, 300, "English"));
        movies.add(new Movie("Ex Machina", "Sci-Fi", 2010, "120 minutes", "Alex Hander", 4.80, 300, "English"));
        movies.add(new Movie("Ex Machina", "Sci-Fi", 2010, "120 minutes", "Alex Hander", 4.80, 300, "English"));
        movies.add(new Movie("Ex Machina", "Sci-Fi", 2010, "120 minutes", "Alex Hander", 4.80, 300, "English"));
        movies.add(new Movie("Ex Machina", "Sci-Fi", 2010, "120 minutes", "Alex Hander", 4.80, 300, "English"));
    }

    public List<Movie> getMovies() {
        return movies;
    }
}
