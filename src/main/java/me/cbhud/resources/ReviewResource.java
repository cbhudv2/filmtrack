package me.cbhud.resources;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import me.cbhud.model.Review;
import me.cbhud.repository.ReviewRepository;

import java.util.List;

@Path("/review")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ReviewResource {

    @Inject
    ReviewRepository reviewRepository;

    @GET
    @Path("/{id}")
    public Review getReviewById(@PathParam("id") Integer id) {
        return reviewRepository.findById(id);
    }

    @POST
    @Path("/create")
    public Response createReview(Review review) {
        reviewRepository.save(review);
        return Response.status(Response.Status.CREATED).entity(review).build();
    }

//    @PUT
//    @Path("/{id}")
//    public Response updateReview(@PathParam("id") Integer id, Review review) {
//        review.setId(id);
//        reviewRepository.save(review);
//        return Response.ok(review).build();
//    }

    @DELETE
    @Path("/delete/{id}")
    public Response deleteReview(@PathParam("id") Integer id) {
        reviewRepository.deleteById(id);
        return Response.noContent().build();
    }

    @GET
    @Path("/user/{userId}")
    public List<Review> getAllReviewsByUserId(@PathParam("userId") Integer userId) {
        return reviewRepository.findAllReviewsByUserId(userId);
    }

    @GET
    @Path("/movie/{movieId}")
    public List<Review> getAllReviewsByMovieId(@PathParam("movieId") Integer movieId) {
        return reviewRepository.findAllReviewsByMovieId(movieId);
    }
}