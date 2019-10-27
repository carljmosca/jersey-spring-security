
package com.carljmosca.demo.resource;

import java.util.logging.Logger;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/insecure/hello")
public class HelloResource {

    private static final Logger LOGGER = Logger.getLogger(HelloResource.class.getName());

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getHello(@QueryParam("name") String name) {

        if (name == null || name.isBlank()) {
            name = "someone...add a name parameter to introduce yourself";
        }
        return String.format("Hello %s", name);

    }
}
