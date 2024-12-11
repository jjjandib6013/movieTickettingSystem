public class Movie {
    private String title;
    private String genre;
    private String duration;
    private double rating;
    private int price;
    private int year;
    private String dateshowing;
    private String showtimes;

    public Movie(String title, String genre, int year, String duration, double rating, int price, String dateshowing, String showtimes) {
        this.title = title;
        this.genre = genre;
        this.year = year;
        this.duration = duration;
        this.rating = rating;
        this.price = price;
        this.dateshowing = dateshowing;
        this.showtimes = showtimes;
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

    public double getRating() {
        return rating;
    }

    public int getPrice() {
        return price;
    }

    public String getDateshowing() {
        return dateshowing;
    }

    public String getShowtimes() {
        return showtimes;
    }
}
