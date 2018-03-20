package by.tryput.repositories.custom;

import by.tryput.entity.Cinema;
import by.tryput.entity.Movie;
import by.tryput.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class PersonRepositoryImpl implements PersonRepositoryCustom {

    @Autowired
    private EntityManagerFactory entityManagerFactory;

    @Override
    public Map<Long, List<Person>> findAllWithFilter(Map<String, Object> filter, Map<String, Integer> pagination) {

        Map<Long, List<Person>> result = new HashMap<>();
        String pageCount = "SELECT count(*) from Person p";
        String startQuery = "SELECT p from Person p";
        List<String> stringToJoin = new ArrayList<>();
        filter.forEach((k, v) -> {
            if (v != null) {
                stringToJoin.add("p." + k + " = :" + k);
            }
        });
        String join = "";
        if (!stringToJoin.isEmpty()) {
            join = " where " + String.join(" and ", stringToJoin);
        }
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        TypedQuery<Long> countElements = entityManager.createQuery(pageCount + join, Long.class);
        TypedQuery<Long> countElementsTypedQuery = setParameters(countElements, filter);
        long elements = countElementsTypedQuery.getSingleResult();
        int elementsOnPage = pagination.get("elements");
        long pages = elements % elementsOnPage == 0 ? elements / elementsOnPage
                : elements / elementsOnPage + 1;
        TypedQuery<Person> query = entityManager.createQuery(startQuery + join, Person.class);
        TypedQuery<Person> movieTypedQuery = setParameters(query, filter);
        List<Person> resultList = movieTypedQuery.setFirstResult((pagination.get("page") - 1) * pagination.get("elements"))
                .setMaxResults(pagination.get("elements")).getResultList();
        result.put(pages, resultList);
        return result;
    }

    @Override
    public Person findById(Long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Person result = entityManager
                .createQuery("SELECT p from Person p where p.id = :id ", Person.class)
                .setParameter("id", id)
                .getResultList().get(0);
        List<Movie> actorMovies = entityManager.createQuery("select m from Movie m join m.actors a where a.id = :id", Movie.class)
                .setParameter("id", id)
                .getResultList();
        List<Movie> movies = entityManager.createQuery("SELECT m from Movie m where m.director.id = :id", Movie.class)
                .setParameter("id", id)
                .getResultList();
        result.getActor().addAll(actorMovies);
        result.getDirector().addAll(movies);

        return result;
    }

    private <T> TypedQuery<T> setParameters(TypedQuery<T> query, Map<String, Object> parameters) {
        parameters.forEach((k, v) -> {
            if (v != null) {
                query.setParameter(k, v);
            }
        });
        return query;
    }

}
