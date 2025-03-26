package me.cbhud.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;
@Entity
@NamedQuery(name = Profile.GET_PROFILE, query = "SELECT p FROM Profile p where id = :id")
@Data
public class Profile {
    public static final String GET_PROFILE = "Profile.find";
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "profile_seq")
    private Integer id;
    private String email;
    private String fullName;
    private String username;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "profile_id")
    @JsonIgnore
    private Set<Review> reviews;
    @ManyToMany
    @JsonIgnore
    private Set<Movie> watchedMovies;
}