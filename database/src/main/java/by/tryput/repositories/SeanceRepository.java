package by.tryput.repositories;


import by.tryput.entity.Seance;
import by.tryput.repositories.custom.SeanceRepositoryCustom;
import org.springframework.data.repository.CrudRepository;


public interface SeanceRepository extends CrudRepository<Seance, Long>, SeanceRepositoryCustom {

}

