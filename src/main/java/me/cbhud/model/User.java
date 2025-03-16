package me.cbhud.model;

import jakarta.persistence.*;

import java.util.*;

@Entity
public class User {
    @SequenceGenerator(name = "movie_sequence", sequenceName = "movie_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "movie_sequence")
    @Id
    private int id;
    private String name;
    private String email;
    private String password;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Movie> watchedMovies = new HashSet<>();
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Review> reviews = new ArrayList<>();

    public User() {}

    public User(int id, String name, String email, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public Set<Movie> getWatchedMovies() { return watchedMovies; }
    public void addWatchedMovie(Movie movie) { watchedMovies.add(movie); }

    public List<Review> getReviews() { return reviews; }
    public void addReview(Review review) { reviews.add(review); }

    @Override
    public String toString() {
        return "User{id=" + id + ", name='" + name + "', email='" + email + "}";
    }
}