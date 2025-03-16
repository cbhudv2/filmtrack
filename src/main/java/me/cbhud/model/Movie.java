package me.cbhud.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Movie {
    @Id
    private long id;
    private String title;
    private int releaseYear;
    private String director;
    private String genre;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Review> reviews = new ArrayList<>();

    public Movie() {}

    public Movie(int id, String title, int releaseYear, String director, String genre) {
        this.id = id;
        this.title = title;
        this.releaseYear = releaseYear;
        this.director = director;
        this.genre = genre;
    }

    public long getId() { return id; }
    public void setId(long id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public int getReleaseYear() { return releaseYear; }
    public void setReleaseYear(int releaseYear) { this.releaseYear = releaseYear; }

    public String getDirector() { return director; }
    public void setDirector(String director) { this.director = director; }

    public String getGenre() { return genre; }
    public void setGenre(String genre) { this.genre = genre; }

    public List<Review> getReviews() { return reviews; }
    public void addReview(Review review) { reviews.add(review); }

    @Override
    public String toString() {
        return "Movie{id=" + id + ", title='" + title + "', releaseYear=" + releaseYear + "}";
    }

}
