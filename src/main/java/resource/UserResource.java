package resource;

import model.User;
import model.UserDao;

import javax.ejb.EJB;
import javax.ws.rs.*;
import java.util.List;


@Path("user")
public class UserResource {
    //@Inject
    @EJB
    public UserDao userDao;

    @GET
    @Produces("application/json")
    public List<User> all() {
        return userDao.getAll();
    }

    @POST
    @Consumes("application/json")
    public void save(User user) {
        userDao.save(user);
    }

    @PUT
    @Consumes("application/json")
    public void update(User user) {
        userDao.update(user);
    }

    @DELETE
    @Path("/{GebruikersiD}")
    @Consumes("application/json")
    public void delete(@PathParam("GebruikersiD") Long id) {
        User user = userDao.find(id);
        userDao.delete(user);
    }
}
