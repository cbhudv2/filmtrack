package me.cbhud.resource;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import me.cbhud.model.Movie;

@Path("movie")
public class MovieResource {

    @Path("addMovie")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addMovie(Movie m) {

    }



}
