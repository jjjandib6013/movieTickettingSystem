import java.util.ArrayList;
import java.util.List;

public class MovieManager {
    private List<Movie> movies;

    public MovieManager() {
        movies = new ArrayList<>();
        
        movies.add(new Movie("Inception", "Sci-Fi", 2010));
        movies.add(new Movie("Titanic", "Romance", 1997));
        movies.add(new Movie("The Dark Knight", "Action", 2008));
    }

    public List<Movie> getMovies() {
        return movies;
    }
}