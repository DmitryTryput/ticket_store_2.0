package by.tryput.services;

import by.tryput.entity.Movie;
import by.tryput.entity.Person;
import by.tryput.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@Service
@Transactional
public class PersonServiceImpl implements PersonService {

    @Autowired
    PersonRepository personRepository;

    @Override
    public void save(Person person) {
        personRepository.save(person);
    }

    @Override
    public List<Person> getAll() {
        List<Person> result = new ArrayList<>();
        personRepository.findAll().forEach(result::add);
        return result;
    }

    @Override
    public Map<Long, List<Person>> findWithFilter(Map<String, Object> filters , Map<String, Integer> pagination) {
        return  personRepository.findAllWithFilter(filters, pagination);
    }

    @Override
    public Person findById(Long id) {
        return personRepository.findById(id);
    }
}
