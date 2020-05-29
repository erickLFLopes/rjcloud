package com.eldermoraes;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.metrics.annotation.Timed;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@Path("/")
public class RouterResource {

    @Inject
    @RestClient
    TimeService timeService;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Timed
    @Path("/time")
    public Response hello() {
        return Response.ok(timeService.getTime()).build();
    }
}