package br.com.studiesjavaeeapi.api.application.resource;

import java.io.Serializable;
import java.net.URI;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import br.com.studiesjavaeeapi.api.domain.model.Profile;
import br.com.studiesjavaeeapi.api.domain.service.ProfileService;

/**
 * Class responsible for exposing all REST resources related to the
 * {@link Profile} entity.
 *
 * @author Roberto Amadeu Neto
 * @since 27/11/2017
 */
@Path("profiles")
public class ProfileResource implements Serializable {

    @Inject
    private ProfileService profileService;

    /**
     * Finds all profiles.
     *
     * @return a HTTP {@link Response}.
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() {
        return Response.ok(profileService.findAll()).build();
    }

    /**
     * Finds a {@link Profile} by a given identifier.
     *
     * @param id {@link Profile} identifier.
     * @return a HTTP {@link Response}.
     */
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findById(@PathParam("id") Integer id) {
        return Response.ok(profileService.findById(id)).build();
    }

    /**
     * Creates a new {@link Profile}.
     *
     * @param profile {@link Profile} entity serialized in JSON format.
     * @return a HTTP {@link Response}.
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(Profile profile) {
        profileService.create(profile);
        return Response.created(URI.create("/profile/" + profile.getId())).entity(profile).build();
    }

    /**
     * Updates an existent {@link Profile}.
     *
     * @param profile {@link Profile} entity serialized in JSON format.
     * @return a HTTP {@link Response}.
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response update(Profile profile) {
        profileService.update(profile);
        return Response.noContent().entity(profile).build();
    }

    /**
     * Removes a {@link Profile} by a given identifier.
     *
     * @param id {@link Profile} identifier.
     * @return a HTTP {@link Response}.
     */
    @DELETE
    @Path("{id}")
    public Response remove(@PathParam("id") Integer id) {
        profileService.remove(id);
        return Response.noContent().build();
    }
}
