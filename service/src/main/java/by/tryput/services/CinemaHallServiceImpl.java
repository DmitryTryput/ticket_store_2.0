package by.tryput.services;

import by.tryput.entity.CinemaHall;
import by.tryput.entity.Movie;
import by.tryput.repositories.CinemaHallRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class CinemaHallServiceImpl implements CinemaHallService {

    @Autowired
    CinemaHallRepository cinemaHallRepository;

    @Override
    public void save(CinemaHall cinemaHall) {
        cinemaHallRepository.save(cinemaHall);
    }

    @Override
    public List<CinemaHall> getAll() {
        List<CinemaHall> result = new ArrayList<>();
        cinemaHallRepository.findAll().forEach(result::add);
        return result;
    }
}
