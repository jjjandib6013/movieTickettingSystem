import java.util.ArrayList;
import java.util.List;

public class MovieManager {
    private List<Movie> movies;

    public MovieManager() {
        movies = new ArrayList<>();
        movies.add(new Movie("Ex Machina", "Sci-Fi", 2010));
        movies.add(new Movie("The Notebook", "Romance", 1997));
        movies.add(new Movie("Five Feet Apart", "Action", 2008));
        movies.add(new Movie("Five Feet Apart", "Action", 2008));
        movies.add(new Movie("Five Feet Apart", "Action", 2008));
        movies.add(new Movie("Five Feet Apart", "Action", 2008));
        movies.add(new Movie("Five Feet Apart", "Action", 2008));
        movies.add(new Movie("Five Feet Apart", "Action", 2008));
        movies.add(new Movie("Ex Machina", "Sci-Fi", 2010));
        movies.add(new Movie("The Notebook", "Romance", 1997));
        movies.add(new Movie("Five Feet Apart", "Action", 2008));
        movies.add(new Movie("Five Feet Apart", "Action", 2008));
        movies.add(new Movie("Five Feet Apart", "Action", 2008));
        movies.add(new Movie("Five Feet Apart", "Action", 2008));
        movies.add(new Movie("Five Feet Apart", "Action", 2008));
        movies.add(new Movie("Five Feet Apart", "Action", 2008));
        movies.add(new Movie("Ex Machina", "Sci-Fi", 2010));
        movies.add(new Movie("The Notebook", "Romance", 1997));
        movies.add(new Movie("Five Feet Apart", "Action", 2008));
        movies.add(new Movie("Five Feet Apart", "Action", 2008));
        movies.add(new Movie("Five Feet Apart", "Action", 2008));
        movies.add(new Movie("Five Feet Apart", "Action", 2008));
        movies.add(new Movie("Five Feet Apart", "Action", 2008));
        movies.add(new Movie("Five Feet Apart", "Action", 2008));

    }

    public List<Movie> getMovies() {
        return movies;
    }
}
