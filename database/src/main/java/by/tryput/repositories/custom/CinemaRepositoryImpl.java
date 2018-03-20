package by.tryput.repositories.custom;

import by.tryput.entity.Cinema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.HashSet;
import java.util.Set;


public class CinemaRepositoryImpl implements CinemaRepositoryCustom {

    @Autowired
    private EntityManagerFactory entityManagerFactory;

    @Cacheable(cacheNames = "cinemas")
    @Override
    public Set<Cinema> findAllWithCinemaHalls() {

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        return new HashSet<>(entityManager
                .createQuery("SELECT c from Cinema c left join fetch c.halls as halls ", Cinema.class).getResultList());

    }

    @Override
    public Set<Cinema> findAllSeances() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        return new HashSet<>(entityManager.createQuery(
                "select c from Cinema c join c.halls as h join h.seances as s", Cinema.class)
                .getResultList());
    }
}
