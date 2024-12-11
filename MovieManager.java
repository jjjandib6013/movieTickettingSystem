import java.util.ArrayList;
import java.util.List;

public class MovieManager {
    private List<Movie> movies;

    public MovieManager() {
        movies = new ArrayList<>();
        movies.add(new Movie("The Notebook", "Drama", 2004, "124 minutes", 4.70, 250, "September 11", "12:00 PM, 3:00 PM, 6:00 PM"));
        movies.add(new Movie("Hereditary", "Horror", 2018, "119 minutes", 4.90, 250, "September 11", "1:00 PM, 4:00 PM, 7:00 PM"));
        movies.add(new Movie("Wrong Turn", "Horror", 2021, "130 minutes", 4.80, 250, "September 11", "2:00 PM, 5:00 PM, 8:00 PM"));
        movies.add(new Movie("Hello, Love, Goodbye", "Drama", 2019, "117 minutes", 4.80, 300, "September 12", "12:00 PM, 3:00 PM, 6:00 PM"));
        movies.add(new Movie("Fifty Shades of Grey", "Drama", 2015, "125 minutes", 4.20, 300, "September 12", "1:00 PM, 4:00 PM, 7:00 PM"));
        movies.add(new Movie("Ex Machina", "Drama", 2014, "108 minutes", 4.30, 250, "September 12", "2:00 PM, 5:00 PM, 8:00 PM"));
        movies.add(new Movie("Five Feet Apart", "Drama", 2019, "116 minutes", 4.80, 300, "September 13", "12:00 PM, 3:00 PM, 6:00 PM"));
        movies.add(new Movie("The Substance", "Horror", 2024, "128 minutes", 4.80, 250, "September 13", "1:00 PM, 4:00 PM, 7:00 PM"));
        movies.add(new Movie("The Cabin in the Woods", "Horror", 2021, "124 minutes", 4.70, 250, "September 13", "2:00 PM, 5:00 PM, 8:00 PM"));
        movies.add(new Movie("A Quiet Place", "Horror", 2018, "122 minutes", 4.40, 250, "September 14", "12:00 PM, 3:00 PM, 6:00 PM"));
    }

    public List<Movie> getMovies() {
        return movies;
    }
}
