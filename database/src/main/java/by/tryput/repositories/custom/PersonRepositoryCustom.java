package by.tryput.repositories.custom;


import by.tryput.entity.Person;

import java.util.List;
import java.util.Map;

public interface PersonRepositoryCustom {

    Map<Long,List<Person>> findAllWithFilter(Map<String, Object> filter, Map<String, Integer> pagination);

    Person findById(Long id);
}
