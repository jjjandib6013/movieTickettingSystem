import java.util.ArrayList;
import java.util.List;

public class MovieManager {
    private List<Movie> movies;

    public MovieManager() {
        movies = new ArrayList<>();
        movies.add(new Movie("The Notebook", "Drama", 2004, "124 minutes", "Nick Cassavetes", 4.70, 250, "English"));
        movies.add(new Movie("Fifty Shades of Grey", "Drama", 2015, "125 minutes", "Sam Taylor-Johnson", 4.20, 300, "English")); 
        movies.add(new Movie("Ex Machina", "Drama", 2014, "108 minutes", "Alex Garland", 4.30, 250, "English")); 
        movies.add(new Movie("Five Feet Apart", "Drama", 2019, "116 minutes", "Justin Baldoni", 4.80, 300, "English")); 
        movies.add(new Movie("Hello, Love, Goodbye", "Drama", 2019, "117 minutes", "Cathy Garcia-Molina", 4.80, 300, "Filipino"));
        movies.add(new Movie("The Substance", "Horror", 2024, "128 minutes", "Coralie Fargeat", 4.80, 250, "English"));
        movies.add(new Movie("Wrong Turn", "Horror", 2021, "130 minutes", "Rob Schmidt", 4.80, 250, "English"));
        movies.add(new Movie("The Cabin in the Woods", "Horror", 2021, "124 minutes", "Drew Goddard",  4.70, 250, "English"));
        movies.add(new Movie("Hereditary", "Horror", 2018, "119 minutes", "Ari Aster", 4.90, 250, "English"));
        movies.add(new Movie("A Quiet Place", "Horror", 2018, "122 minutes", "John Krasinski", 4.40, 250,"English"));
        
    }

    public List<Movie> getMovies() {
        return movies;
    }
}
