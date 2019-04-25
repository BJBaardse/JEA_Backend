package resource;

import jwt.Role;
import model.Auto;
import model.AutoDao;
import model.User;
import model.UserDao;


import static javax.ws.rs.core.MediaType.TEXT_PLAIN;

import javax.annotation.security.RolesAllowed;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;


@Path("auto")
@Produces(TEXT_PLAIN)
public class AutoResource {
    //@Inject
    @EJB
    public AutoDao autoDao;

    @GET
//    @RolesAllowed("a")
    @Produces("application/json")
    public List<Auto> all() {
        return autoDao.getAll();
    }

    @POST
//    @RolesAllowed("a")
    @Produces("application/json")
    public void save(Auto auto) {
        autoDao.save(auto);
    }

    @PUT
//    @RolesAllowed("a")
    @Consumes("application/json")
    public void update(Auto auto) {
        autoDao.update(auto);
    }

    @DELETE
    @Path("/{auto_id}")
//    @RolesAllowed("a")
    @Consumes("application/json")
    public void delete(@PathParam("auto_id") Long id) {
        Auto auto = autoDao.find(id);
        autoDao.delete(auto);
    }
}