package org.glassfish.test;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/")
public class RootResource {
    @GET
    public Response simpleTest() {
        return Response.ok().build();
    }
}
