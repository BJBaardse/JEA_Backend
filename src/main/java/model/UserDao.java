package model;

import Interceptor.*;

import javax.ejb.Stateless;
import javax.interceptor.Interceptors;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

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
}
