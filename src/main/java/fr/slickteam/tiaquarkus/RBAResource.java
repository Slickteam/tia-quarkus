package fr.slickteam.tiaquarkus;

import javax.annotation.security.RolesAllowed;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/access-control")
public class RBAResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String freeAccess() {
        return "Free access";
    }

    @GET
    @Path("/user")
    @RolesAllowed("user")
    @Produces(MediaType.TEXT_PLAIN)
    public String userAccess() {
        return "User access";
    }

    @GET
    @Path("/admin")
    @RolesAllowed("admin")
    @Produces(MediaType.TEXT_PLAIN)
    public String adminAccess() {
        return "Admin access";
    }
}