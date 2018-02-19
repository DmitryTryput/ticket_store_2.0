package by.tryput.repositories.custom;

import by.tryput.entity.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class MovieRepositoryImpl implements MovieRepositoryCustom {

    @Autowired
    private EntityManagerFactory entityManagerFactory;


    @Override
    public Map<Long, List<Movie>> findAllWithFilter(Map<String, Object> filter, Map<String, Integer> pagination) {


        Map<Long, List<Movie>> result = new HashMap<>();
        String pageCount = "SELECT count(*) from Movie m";
        String startQuery = "SELECT m from Movie m";
        List<String> stringToJoin = new ArrayList<>();
        filter.forEach((k, v) -> {
            if (v != null) {
                stringToJoin.add("m." + k + " = :" + k);
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
        System.out.println(elements);
        int elementsOnPage = pagination.get("elements");
        System.out.println(elementsOnPage);
        long pages = elements % elementsOnPage == 0 ? elements / elementsOnPage
                : elements / elementsOnPage + 1;
        System.out.println(pages);
        TypedQuery<Movie> query = entityManager.createQuery(startQuery + join, Movie.class);
        TypedQuery<Movie> movieTypedQuery = setParameters(query, filter);
        List<Movie> resultList = movieTypedQuery.setFirstResult((pagination.get("page") - 1) * pagination.get("elements"))
                .setMaxResults(pagination.get("elements")).getResultList();
        result.put(pages, resultList);
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
