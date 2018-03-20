package by.tryput.services;


import by.tryput.entity.Cinema;
import by.tryput.repositories.CinemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;

@Service
@Transactional
public class CinemaServiceImpl implements CinemaService {

    @Autowired
    CinemaRepository cinemaRepository;

    @Override
    public Set<Cinema> findAllWithCinemaHalls() {
        return cinemaRepository.findAllWithCinemaHalls();
    }

    @Override
    public void save(Cinema cinema) {
        cinemaRepository.save(cinema);
    }

    @Override
    public Set<Cinema> findAllSeances() {
        return cinemaRepository.findAllSeances();
    }


}
