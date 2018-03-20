package by.tryput.repositories.custom;


import by.tryput.entity.Movie;
import by.tryput.entity.Person;

import java.util.List;
import java.util.Map;

public interface MovieRepositoryCustom {

    Map<Long, List<Movie>> findAllWithFilter(Map<String, Object> filter, Map<String, Integer> pagination);

    Movie findById(Long id);
}
