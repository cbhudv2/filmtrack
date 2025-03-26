package me.cbhud.resources;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import me.cbhud.model.Movie;
import me.cbhud.repository.MovieRepository;

import java.util.List;

@Path("/movie")
public class MovieResource {
    @Inject
    private MovieRepository movieRepository;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/create")
    public Response createMovie(Movie movie) {
        Movie m = movieRepository.createMovie(movie);
        return Response.ok().entity(m).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Response getMovieById(@PathParam("id") Integer id) {
        Movie m = movieRepository.getMovieById(id);
        return Response.ok().entity(m).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/getAll")
    public Response getAllMovies() {
        List<Movie> m = movieRepository.getMovies();
        return Response.ok().entity(m).build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/update/title/{id}")
    public Response updateTitle(@PathParam("id") Integer id, Movie movie) {
        movie.setId(id);
        Movie updatedMovie = movieRepository.updateMovie(movie, "title");
        return Response.ok().entity(updatedMovie).build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/update/genre/{id}")
    public Response updateGenre(@PathParam("id") Integer id, Movie movie) {
        movie.setId(id);
        Movie updatedMovie = movieRepository.updateMovie(movie, "genre");
        return Response.ok().entity(updatedMovie).build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/update/director/{id}")
    public Response updateDirector(@PathParam("id") Integer id, Movie movie) {
        movie.setId(id);
        Movie updatedMovie = movieRepository.updateMovie(movie, "director");
        return Response.ok().entity(updatedMovie).build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/update/releaseYear/{id}")
    public Response updateReleaseYear(@PathParam("id") Integer id, Movie movie) {
        movie.setId(id);
        Movie updatedMovie = movieRepository.updateMovie(movie, "releaseYear");
        return Response.ok().entity(updatedMovie).build();
    }

    @DELETE
    @Path("/delete/{id}")
    public Response deleteMovie(@PathParam("id") Integer id) {
        Movie m = movieRepository.getMovieById(id);
        if (m == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        movieRepository.deleteMovie(m);
        return Response.ok().build();
    }


}
