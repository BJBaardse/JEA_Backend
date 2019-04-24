package jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import model.User;
import model.UserDao;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Date;

@Path("authentication")
public class AuthenticationEndpoint {
    @EJB
    private UserDao userDao;

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response authenticateUser(@FormParam("username") String username,
                                     @FormParam("password") String password) {

        try {
            // Authenticate the user using the credentials provided
            User user = authenticate(username, password);

            // Issue a token for the user
            String token = issueToken(user);

            // Return the token on the response
            return Response.ok(token).build();

        } catch (Exception e) {
            return Response.status(Response.Status.FORBIDDEN).build();
        }
    }

    private User authenticate(String username, String password) throws Exception {
        return userDao.checkCreds(username, password);

        // Authenticate against a database, LDAP, file or whatever
        // Throw an Exception if the credentials are invalid
    }

    private String issueToken(User user) {
        // Issue a token (can be a random String persisted to a database or a JWT token)
        // The issued token must be associated to a user
        // Return the issued token
        try {
            Algorithm algorithm = Algorithm.HMAC256("front-endGeeftMijStoring");
            String token = JWT.create()
                    .withIssuer(user.getUserName())
                    .withClaim("username",user.getUserName())
                    .withClaim("ID",user.getGebruikersiD())
                    .withClaim("Roles" , String.valueOf(user.getRole()))
                    .withExpiresAt(new Date(System.currentTimeMillis() + (5 * 60 * 1000)))
                    .sign(algorithm);
            return token;


        }catch (Exception e){
            return "";
        }
    }
}