package model;

import Interceptor.*;

import javax.ejb.Stateless;
import javax.interceptor.Interceptors;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
@Interceptors(TracingInterceptor.class)
public class AutoDao {

    @PersistenceContext (unitName = "PayaraPool")
    private EntityManager entityManager;

    public List<Auto> getAll() {
        return entityManager.createNamedQuery("Auto.getAll", Auto.class).getResultList();
    }

    public Auto find(Long id) {
        return entityManager.createNamedQuery("Auto.findOne", Auto.class).setParameter("id", id).getSingleResult();
    }

    public void save(Auto auto) {
        entityManager.persist(auto);
    }

    public void update(Auto auto) {
        entityManager.merge(auto);
    }

    public void delete(Auto auto) {
        entityManager.remove(auto);
    }
}