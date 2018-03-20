package by.tryput.repositories;

import by.tryput.entity.Ticket;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


public interface TicketRepository extends CrudRepository<Ticket, Long> {

    @Modifying(clearAutomatically = true)
    @Query("update Ticket t set t.purchased = true, t.user.id  = :userId  where t.id = :id")
    void setByUserId(@Param("id") Long id, @Param("userId") Long userId);


}
