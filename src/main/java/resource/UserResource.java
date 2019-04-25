package resource;

import model.User;
import model.UserDao;

import jwt.*;
import jwt.Role;


import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.core.MediaType;
import java.util.List;


import static javax.ws.rs.core.MediaType.TEXT_PLAIN;

import javax.annotation.security.RolesAllowed;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;


@Path("user")
@Produces(TEXT_PLAIN)
public class UserResource {
    //@Inject
    @EJB
    public UserDao userDao;

    @GET
//    @RolesAllowed("a")
    @Produces("application/json")
    public List<User> all() {
        return userDao.getAll();
    }

    @POST
//    @RolesAllowed("a")
    @Produces("application/json")
    public void save(User user) {
        userDao.save(user);
    }

    @PUT
//    @RolesAllowed("a")
    @Consumes("application/json")
    public void update(User user) {
        userDao.update(user);
    }

    @DELETE
    @Path("/{GebruikersiD}")
//    @RolesAllowed("a")
    @Consumes("application/json")
    public void delete(@PathParam("GebruikersiD") Long id) {
        User user = userDao.find(id);
        userDao.delete(user);
    }

    @GET
    @Path("/keys")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces("application/json")
    public String generateAuthkey(ContainerRequestContext requestContext){
        return userDao.generateAuthKey(requestContext);
    }
}
