package model;

import Interceptor.*;

import javax.ejb.Stateless;
import javax.interceptor.Interceptors;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
@Interceptors(TracingInterceptor.class)
public class AdvertentieDao {

    @PersistenceContext (unitName = "PayaraPool")
    private EntityManager entityManager;

    public List<Advertentie> getAll() {
        return entityManager.createNamedQuery("Advertentie.getAll", Advertentie.class).getResultList();
    }

    public Advertentie find(Long id) {
        return entityManager.createNamedQuery("Advertentie.findOne", Advertentie.class).setParameter("id", id).getSingleResult();
    }

    public void save(Advertentie advertentie) {
        entityManager.persist(advertentie);
    }

    public void update(Advertentie advertentie) {
        entityManager.merge(advertentie);
    }

    public void delete(Advertentie advertentie) {
        entityManager.remove(advertentie);
    }
}