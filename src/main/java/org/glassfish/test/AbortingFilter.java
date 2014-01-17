package org.glassfish.test;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.ext.Provider;

@Provider
public class AbortingFilter implements ContainerRequestFilter {

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        final ResponseBuilder builder = Response.status(Response.Status.UNAUTHORIZED);
        // builder.header("WWW-Authenticate", "OAuth oauth_problem=token_rejected");
        builder.header("WWW-Authenticate", "oauth_problem=token_rejected");
        requestContext.abortWith(builder.build());
    }

}
