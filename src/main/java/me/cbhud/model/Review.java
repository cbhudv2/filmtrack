package me.cbhud.model;

import java.time.LocalDate;

public class Review {
    private int id;
    private int rating;
    private String text;
    private LocalDate date;
    private User user;
    private Movie movie;

    public Review() {}

    public Review(int id, int rating, String text, LocalDate date, User user, Movie movie) {
        this.id = id;
        this.rating = rating;
        this.text = text;
        this.date = date;
        this.user = user;
        this.movie = movie;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getRating() { return rating; }
    public void setRating(int rating) { this.rating = rating; }

    public String getText() { return text; }
    public void setText(String text) { this.text = text; }

    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }

    public Movie getMovie() { return movie; }
    public void setMovie(Movie movie) { this.movie = movie; }

    @Override
    public String toString() {
        return "Review{id=" + id + ", rating=" + rating + ", user=" + user.getName() + ", movie=" + movie.getTitle() + "}";
    }
}