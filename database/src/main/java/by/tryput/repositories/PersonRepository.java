package by.tryput.repositories;


import by.tryput.entity.Person;
import by.tryput.repositories.custom.PersonRepositoryCustom;
import org.springframework.data.repository.CrudRepository;


public interface PersonRepository extends CrudRepository<Person, Long>, PersonRepositoryCustom {


}

