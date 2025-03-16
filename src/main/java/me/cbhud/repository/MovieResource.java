package me.cbhud.repository;

import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import me.cbhud.model.Movie;

public class MovieResource {
    @Inject
    EntityManager em;


    public Movie addMovie(Movie m) {
        return em.merge(m);
    }


}
