package me.cbhud.model;

import java.util.*;

public class User {
    private int id;
    private String name;
    private String email;
    private String password;
    private Set<User> following = new HashSet<>();
    private Set<User> followers = new HashSet<>();
    private Set<Movie> watchedMovies = new HashSet<>();
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

    public Set<User> getFollowing() { return following; }
    public Set<User> getFollowers() { return followers; }

    public void followUser(User user) {
        if (user != null && !following.contains(user)) {
            following.add(user);
            user.followers.add(this); // Add this user to the other user's followers
        }
    }

    public void unfollowUser(User user) {
        if (user != null && following.contains(user)) {
            following.remove(user);
            user.followers.remove(this); // Remove this user from the other user's followers
        }
    }

    public Set<Movie> getWatchedMovies() { return watchedMovies; }
    public void addWatchedMovie(Movie movie) { watchedMovies.add(movie); }

    public List<Review> getReviews() { return reviews; }
    public void addReview(Review review) { reviews.add(review); }

    @Override
    public String toString() {
        return "User{id=" + id + ", name='" + name + "', email='" + email + "', following=" + following.size() + ", followers=" + followers.size() + "}";
    }
}
