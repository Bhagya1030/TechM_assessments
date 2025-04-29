package day6;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

class Movie {
    private String title;
    private String genre;
    private double rating;
    private LocalDate releaseDate;

    // Constructor
    public Movie(String title, String genre, double rating, LocalDate releaseDate) {
        this.title = title;
        this.genre = genre;
        this.rating = rating;
        this.releaseDate = releaseDate;
    }

    // Getters
    public String getTitle() { return title; }
    public String getGenre() { return genre; }
    public double getRating() { return rating; }
    public LocalDate getReleaseDate() { return releaseDate; }

    // Display movie details
    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return "Movie: " + title + " | Genre: " + genre + " | Rating: " + rating +
               " | Release Date: " + releaseDate.format(formatter);
    }
}

class MovieRecommendationSystem {
    private List<Movie> movies;

    public MovieRecommendationSystem(List<Movie> movies) {
        this.movies = movies;
    }

    // Sort movies by rating (descending) and release date (newest first)
    public List<Movie> getSortedMovies() {
        return movies.stream()
                .sorted(Comparator.comparingDouble(Movie::getRating).reversed()
                        .thenComparing(Movie::getReleaseDate, Comparator.reverseOrder()))
                .collect(Collectors.toList());
    }

    // Filter movies by minimum rating and genre
    public List<Movie> filterMovies(double minRating, String genre) {
        return movies.stream()
                .filter(m -> m.getRating() >= minRating && m.getGenre().equalsIgnoreCase(genre))
                .collect(Collectors.toList());
    }

    // Get a random top-rated movie recommendation
    public Optional<Movie> getTopRatedMovieRecommendation() {
        List<Movie> topMovies = movies.stream()
                .filter(m -> m.getRating() >= 8.5)
                .collect(Collectors.toList());

        if (topMovies.isEmpty()) {
            return Optional.empty();
        }
        Random rand = new Random();
        return Optional.of(topMovies.get(rand.nextInt(topMovies.size())));
    }
}

// Main Class
public class MovieStreamApp {
    public static void main(String[] args) {
        List<Movie> movies = Arrays.asList(
            new Movie("Inception", "Sci-Fi", 8.8, LocalDate.of(2010, 7, 16)),
            new Movie("Interstellar", "Sci-Fi", 8.6, LocalDate.of(2014, 11, 7)),
            new Movie("The Dark Knight", "Action", 9.0, LocalDate.of(2008, 7, 18)),
            new Movie("Parasite", "Drama", 8.6, LocalDate.of(2019, 5, 30)),
            new Movie("Avatar", "Sci-Fi", 7.8, LocalDate.of(2009, 12, 18)),
            new Movie("Gladiator", "Action", 8.5, LocalDate.of(2000, 5, 5)),
            new Movie("Joker", "Drama", 8.4, LocalDate.of(2019, 10, 4))
        );

        MovieRecommendationSystem system = new MovieRecommendationSystem(movies);

        // Sorted Movies
        System.out.println("\n📌 Movies sorted by rating (desc) and release date (newest first):");
        system.getSortedMovies().forEach(System.out::println);

        // Filtered Movies (Example: Sci-Fi movies with rating >= 8.0)
        System.out.println("\n🎬 Recommended Sci-Fi movies with rating >= 8.0:");
        system.filterMovies(8.0, "Sci-Fi").forEach(System.out::println);

        // Random Top Rated Movie Recommendation
        Optional<Movie> topMovie = system.getTopRatedMovieRecommendation();
        System.out.println("\n🌟 Random Top Rated Movie Recommendation:");
        System.out.println(topMovie.map(Movie::toString).orElse("No top-rated movie available!"));
    }
}
