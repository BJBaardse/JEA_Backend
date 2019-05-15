package resource;

import jwt.Role;
import model.*;


import static javax.ws.rs.core.MediaType.TEXT_PLAIN;

import javax.annotation.security.RolesAllowed;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Path("auto")
@Produces(TEXT_PLAIN)
public class AutoResource {
    //@Inject
    @EJB
    public AutoDao autoDao;

//    @GET
////    @RolesAllowed("a")
//    @Produces("application/json")
//    public List<Auto> all() {
//        return autoDao.getAll();
//    }

    @Path("/all")
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

    @Path("carroserie")
    @GET
    @Produces("application/json")
    public List<Carroserie> Carroserie(){
        List<Carroserie> carroseries = new ArrayList<>(Arrays.asList(Carroserie.Bedrijfswagen,Carroserie.Coupé, Carroserie.Hatchback, Carroserie.MPV, Carroserie.Offroad, Carroserie.PickUp, Carroserie.Stationwagen, Carroserie.Cabrio, Carroserie.Sedan, Carroserie.SUV, Carroserie.Overige));
        return carroseries;

    }
}