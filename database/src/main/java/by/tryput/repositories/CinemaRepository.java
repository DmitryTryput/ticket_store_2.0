package by.tryput.repositories;


import by.tryput.entity.Cinema;
import by.tryput.repositories.custom.CinemaRepositoryCustom;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


public interface CinemaRepository extends CrudRepository<Cinema, Long>, CinemaRepositoryCustom {

    Cinema findByTitle(String title);

    @Modifying(clearAutomatically = true)
    @Query("update Cinema c set c.title = :title where c.id = :id")
    void setById(@Param("title")String title, @Param("id")Long id);

}
