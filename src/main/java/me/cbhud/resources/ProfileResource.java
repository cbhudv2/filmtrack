package me.cbhud.resources;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import me.cbhud.model.Profile;
import me.cbhud.repository.ProfileRepository;


@Path("/profile")
public class ProfileResource {

    @Inject
    private ProfileRepository profileRepository;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/create")
    public Response createStudent(Profile profile) {
        Profile p = profileRepository.createProfile(profile);
        return Response.ok().entity(p).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Response getProfileById(
        @PathParam("id") Integer id) {
        Profile p = profileRepository.getProfileById(id);
        return Response.ok().entity(p).build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/update/email/{id}")
    public Response updateEmail(@PathParam("id") Integer id, Profile profile) {
        profile.setId(id);
        Profile updatedProfile = profileRepository.updateProfile(profile, "email");
        return Response.ok().entity(updatedProfile).build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/update/fullName/{id}")
    public Response updateFullName(@PathParam("id") Integer id, Profile profile) {
        profile.setId(id);
        Profile updatedProfile = profileRepository.updateProfile(profile, "fullName");
        return Response.ok().entity(updatedProfile).build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/update/username/{id}")
    public Response updateUsername(@PathParam("id") Integer id, Profile profile) {
        profile.setId(id);
        Profile updatedProfile = profileRepository.updateProfile(profile, "username");
        return Response.ok().entity(updatedProfile).build();
    }

    @DELETE
    @Path("/delete/{id}")
    public Response deleteProfile(@PathParam("id") Integer id) {
        Profile p = profileRepository.getProfileById(id);
        if (p == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        profileRepository.deleteProfile(p);
        return Response.ok().build();
    }

}
