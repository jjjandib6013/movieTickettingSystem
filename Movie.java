public class Movie {
    private String title;
    private String genre;
    private String duration;
    private String director;
    private double rating;
    private int price;
    private String language;
    private int year;

    public Movie(String title, String genre, int year, String duration, String director, double rating, int price, String language) {
        this.title = title;
        this.genre = genre;
        this.duration = duration;
        this.director = director;
        this.rating = rating;
        this.price = price;
        this.language = language;
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public int getYear() {
        return year;
    }

    public String getDuration() {
        return duration;
    }

    public String getDirector() {
        return director;
    }
    
    public double getRating() {
        return rating;
    }

    public int getPrice() {
        return price;
    }

    public String getLanguage() {
        return language;
    }
}