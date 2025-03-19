package me.cbhud.resource;

import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import me.cbhud.model.Movie;


@Path("/movie")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MovieResource {

    @POST
    @Path("/create")
    @Transactional
    public Response createMovie(Movie movie) {
        return Response.ok(movie).status(Response.Status.CREATED).build();
    }

}