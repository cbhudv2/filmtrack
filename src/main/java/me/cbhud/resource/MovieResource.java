package me.cbhud.resource;

import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import me.cbhud.model.Movie;

import java.util.List;

@Path("/movie")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MovieResource {

    @Inject
    EntityManager em;

    @POST
    @Path("/create")
    @Transactional
    public Response createMovie(Movie movie) {
        em.merge(movie);
        return Response.ok(movie).status(Response.Status.CREATED).build();
    }

    @GET
    @Path("/get")
    public List<Movie> getAllMovies() {
        return em.createQuery("SELECT m FROM Movie m", Movie.class).getResultList();
    }
}