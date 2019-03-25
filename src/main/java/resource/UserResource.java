package resource;

import model.User;
import model.UserDao;


import static javax.ws.rs.core.MediaType.TEXT_PLAIN;

import javax.annotation.security.RolesAllowed;

import javax.ejb.EJB;
import javax.ws.rs.*;
import java.util.List;


@Path("user")
@Produces(TEXT_PLAIN)
public class UserResource {
    //@Inject
    @EJB
    public UserDao userDao;

    @GET
    @RolesAllowed("a")
    @Produces("application/json")
    public List<User> all() {
        return userDao.getAll();
    }

    @POST
    @RolesAllowed("a")
    @Consumes("application/json")
    public void save(User user) {
        userDao.save(user);
    }

    @PUT
    @RolesAllowed("a")
    @Consumes("application/json")
    public void update(User user) {
        userDao.update(user);
    }

    @DELETE
    @Path("/{GebruikersiD}")
    @RolesAllowed("a")
    @Consumes("application/json")
    public void delete(@PathParam("GebruikersiD") Long id) {
        User user = userDao.find(id);
        userDao.delete(user);
    }
}
