package me.cbhud.model;

import jakarta.persistence.*;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@Data
@Entity
@Table(name = "movie")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String genre;
    private String director;

    @Column(name = "release_year")
    private Integer releaseYear;

    @OneToMany(mappedBy = "movie")
    private List<Review> reviews;

    @ManyToMany(mappedBy = "watchedMovies")
    private List<User> users;
}