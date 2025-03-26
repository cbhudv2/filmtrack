package me.cbhud.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;

@Entity
@Data
@NamedQuery(name = Review.GET_ALL_REVIEWS_PROFILE, query = "SELECT r from Review r where r.profile.id = :id")
@NamedQuery(name = Review.GET_ALL_REVIEWS_MOVIE, query = "SELECT r from Review r where r.movie.id = :id")
public class Review {
    public static final String GET_ALL_REVIEWS_PROFILE = "Review.findAllUserReviews";
    public static final String GET_ALL_REVIEWS_MOVIE = "Review.findAllMovieReviews";
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "review_seq")
    private Integer id;
    private Integer rating;
    private String reviewText;
    private Date date;
    @ManyToOne
    private Profile profile;
    @ManyToOne
    private Movie movie;
}