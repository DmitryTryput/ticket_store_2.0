package by.tryput.repositories.custom;

import by.tryput.entity.Seance;

public interface SeanceRepositoryCustom {

    Seance findByIdWithTickets(Long id);
}
