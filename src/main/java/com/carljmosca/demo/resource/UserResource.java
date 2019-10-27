
package com.carljmosca.demo.resource;

import java.util.logging.Logger;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.springframework.security.access.annotation.Secured;

@Path("user")
public class UserResource {

    private static final Logger LOGGER = Logger.getLogger(UserResource.class.getName());

    public UserResource() {
        LOGGER.fine("HelloResource()");
    }

    @Secured("ROLE_USER")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getUser() {
        String person = "some user";
        return String.format("Hello %s", person);

    }
}
