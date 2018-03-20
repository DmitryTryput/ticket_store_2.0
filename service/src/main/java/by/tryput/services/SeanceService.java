package by.tryput.services;

import by.tryput.entity.Seance;
import by.tryput.mappers.BuyTicketsDto;



public interface SeanceService {

    void addSeance(Seance seance);

    Seance findById(Long id);

    void buyTickets(BuyTicketsDto buyTicketsDto);
}
