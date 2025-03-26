package me.cbhud.repository;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import me.cbhud.model.Movie;

import java.util.List;

@Dependent
public class MovieRepository {

    @Inject
    EntityManager em;

    @Transactional
    public Movie createMovie(Movie movie) {
        em.merge(movie);
        return movie;
    }

    @Transactional
    public Movie getMovieById(Integer id) {
        return em.find(Movie.class, id);
    }

    @Transactional
    public List<Movie> getMovies() {
        return em.createQuery("SELECT m FROM Movie m", Movie.class).getResultList();
    }

    @Transactional
    public Movie updateMovie(Movie movie, String updateType) {
        Movie existingMovie = em.find(Movie.class, movie.getId());
        if (existingMovie == null) {
            throw new IllegalArgumentException("Movie not found");
        }

        switch (updateType) {
            case "title":
                existingMovie.setTitle(movie.getTitle());
                break;
            case "genre":
                existingMovie.setGenre(movie.getGenre());
                break;
            case "director":
                existingMovie.setDirector(movie.getDirector());
                break;
            case "releaseYear":
                existingMovie.setReleaseYear(movie.getReleaseYear());
                break;
            default:
                throw new IllegalArgumentException("Invalid update type");
        }

        em.merge(existingMovie);
        return existingMovie;
    }

    @Transactional
    public void deleteMovie(Movie movie) {
        em.remove(em.contains(movie) ? movie : em.merge(movie));
    }


}
