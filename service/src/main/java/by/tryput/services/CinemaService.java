package by.tryput.services;

import by.tryput.entity.Cinema;

import java.util.List;
import java.util.Set;

public interface CinemaService {

    Set<Cinema> findAllWithCinemaHalls();

    void save(Cinema cinema);

    Set<Cinema> findAllSeances();
}
