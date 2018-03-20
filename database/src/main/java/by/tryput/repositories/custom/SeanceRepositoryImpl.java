package by.tryput.repositories.custom;

import by.tryput.entity.Seance;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;


public class SeanceRepositoryImpl implements SeanceRepositoryCustom {

    @Autowired
    private EntityManagerFactory entityManagerFactory;

    @Override
    public Seance findByIdWithTickets(Long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        return entityManager.createQuery("select s from Seance s join s.rowSeatTickets t join s.cinemaHall c where s.id =:id" ,Seance.class)
                .setParameter("id", id)
                .getResultList()
                .get(0);
    }
}
