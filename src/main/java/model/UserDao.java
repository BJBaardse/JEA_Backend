package model;

import Interceptor.*;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

import javax.ejb.Stateless;
import javax.interceptor.Interceptors;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.core.HttpHeaders;
import java.io.UnsupportedEncodingException;
import java.util.List;

import com.warrenstrange.googleauth.GoogleAuthenticator;
import com.warrenstrange.googleauth.GoogleAuthenticatorKey;

@Stateless
@Interceptors(TracingInterceptor.class)
public class UserDao {

    @PersistenceContext (unitName = "PayaraPool")
    private EntityManager entityManager;

    public List<User> getAll() {
        return entityManager.createNamedQuery("User.getAll", User.class).getResultList();
    }

    public User find(Long id) {
        return entityManager.createNamedQuery("User.findOne", User.class).setParameter("id", id).getSingleResult();
    }

    public User checkCreds(String username, String password){
        return entityManager.createNamedQuery("User.checkcreds", User.class).setParameter("username", username).setParameter("password",password).getSingleResult(); //throwt exception als meer dan 1 row
    }

    public void save(User user) {
        entityManager.persist(user);
    }

    public void update(User user) {
        entityManager.merge(user);
    }

    public void delete(User user) {
        entityManager.remove(user);
    }

    public String generateAuthKey(ContainerRequestContext requestContext){
        Claims claims = null;
        try {
            String authorizationHeader = requestContext.getHeaderString(HttpHeaders.AUTHORIZATION);
            String token = authorizationHeader.substring("Bearer".length()).trim();
            claims = Jwts.parser().setSigningKey("frontendgeeftmijstoring".getBytes("UTF-8")).parseClaimsJws(token).getBody();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        int user = claims.get("ID", Integer.class);
        GoogleAuthenticator gAuth = new GoogleAuthenticator();
        final GoogleAuthenticatorKey key = gAuth.createCredentials();
        User userkey =  find((long) user);
        userkey.setAuthenticationKey(key.getKey());
        entityManager.merge(userkey);
        return key.getKey();
    }
}
