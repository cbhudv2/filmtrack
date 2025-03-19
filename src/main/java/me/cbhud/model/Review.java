package me.cbhud.model;

import jakarta.persistence.*;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;

@Data
@Entity
@Table(name = "review")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer rating;

    @Column(name = "review_text")
    private String reviewText;

    private Date date;

    @ManyToOne()
    @JoinColumn(name = "user_id")private User user;

    @ManyToOne()
    @JoinColumn(name = "movie_id")
    private Movie movie;
}