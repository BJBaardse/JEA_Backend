package resource;

import model.Advertentie;
import model.AdvertentieDao;
import model.User;
import model.UserDao;


import static javax.ws.rs.core.MediaType.TEXT_PLAIN;

import javax.annotation.security.RolesAllowed;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;


@Path("advertenties")
@Produces(TEXT_PLAIN)
public class AdvertentieResource {
    //@Inject
    @EJB
    public AdvertentieDao advertentieDao;

    @GET
//    @RolesAllowed("a")
    @Produces("application/json")
    public List<Advertentie> all() {
        return advertentieDao.getAll();
    }

    @POST
//    @RolesAllowed("a")
    @Produces("application/json")
    public void save(Advertentie advertentie) {
        advertentieDao.save(advertentie);
    }

    @PUT
//    @RolesAllowed("a")
    @Consumes("application/json")
    public void update(Advertentie advertentie) {
        advertentieDao.update(advertentie);
    }

    @DELETE
    @Path("/{advertentie_id}")
//    @RolesAllowed("a")
    @Consumes("application/json")
    public void delete(@PathParam("advertentie_id") Long id) {
        Advertentie advertentie = advertentieDao.find(id);
        advertentieDao.delete(advertentie);
    }
}