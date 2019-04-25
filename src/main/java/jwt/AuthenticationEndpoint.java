package jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.warrenstrange.googleauth.GoogleAuthenticator;
import model.User;
import model.UserDao;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Calendar;
import java.util.Date;

@Path("authentication")
public class AuthenticationEndpoint {
    @EJB
    private UserDao userDao;

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response authenticateUser(@FormParam("username") String username,
                                     @FormParam("password") String password,
                                     @FormParam("factor2") String factor2) {

        try {

            // Authenticate the user using the credentials provided
            User user = authenticate(username, password);

            // Issue a token for the user
            String token = issueToken(user);
            if (user.getAuthenticationKey() == null) {
                return Response.ok(token).build();
            } else {
                if(decodeAuth(factor2, user) == true){
                    return Response.ok(token).build();
                }
                else{
                    return Response.status(Response.Status.FORBIDDEN).build();
                }
            }

        } catch (Exception e) {
            return Response.status(Response.Status.FORBIDDEN).build();
        }
    }

    private User authenticate(String username, String password) throws Exception {
        return userDao.checkCreds(username, password);

        // Authenticate against a database, LDAP, file or whatever
        // Throw an Exception if the credentials are invalid
    }

    private boolean decodeAuth(String fa2, User user) {
        GoogleAuthenticator gAuth = new GoogleAuthenticator();
        return gAuth.authorize(user.getAuthenticationKey(), Integer.valueOf(fa2)); //returns if valid

    }

    private String issueToken(User user) {
        // Issue a token (can be a random String persisted to a database or a JWT token)
        // The issued token must be associated to a user
        // Return the issued token

        try {
            Algorithm algorithm = Algorithm.HMAC256("frontendgeeftmijstoring");
            String token = JWT.create()
                    .withIssuer(user.getUserName())
                    .withClaim("ID",user.getGebruikersiD())
                    .withClaim("username",user.getUserName())
                    .withClaim("Roles" , String.valueOf(user.getRole()))
                    .withExpiresAt(new Date(System.currentTimeMillis() + (5 * 60 * 1000)))
                    .sign(algorithm);
            return token;


        }catch (Exception e){
            return "";
        }
    }
}