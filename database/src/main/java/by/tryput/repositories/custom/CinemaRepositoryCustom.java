package by.tryput.repositories.custom;

import by.tryput.entity.Cinema;

import java.util.Set;

public interface CinemaRepositoryCustom {

    Set<Cinema> findAllWithCinemaHalls();

    Set<Cinema> findAllSeances();
}
