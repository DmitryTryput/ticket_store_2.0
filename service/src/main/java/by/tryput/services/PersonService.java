package by.tryput.services;

import by.tryput.entity.Movie;
import by.tryput.entity.Person;

import java.util.List;
import java.util.Map;

public interface PersonService {

    void save(Person person);

    List<Person> getAll();

    Map<Long, List<Person>> findWithFilter(Map<String, Object> filters, Map<String, Integer> pagination);

    Person findById(Long id);
}
