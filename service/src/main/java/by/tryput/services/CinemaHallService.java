package by.tryput.services;

import by.tryput.entity.CinemaHall;

import java.util.List;

public interface CinemaHallService {

    void save(CinemaHall cinemaHall);

    List<CinemaHall> getAll();
}
