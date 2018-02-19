package by.tryput.entity;


import by.tryput.repositories.CinemaHallRepository;
import by.tryput.repositories.CinemaRepository;
import by.tryput.repositories.MovieRepository;
import by.tryput.repositories.PersonRepository;
import by.tryput.repositories.SeanceRepository;
import by.tryput.repositories.config.PersistenceConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;

@Transactional
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = PersistenceConfig.class)
public class TestSeanceRepository {

    @Autowired
    private CinemaRepository cinemaRepository;
    @Autowired
    private CinemaHallRepository cinemaHallRepository;
    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    private SeanceRepository seanceRepository;

    @Test
    public void initDb() {

        Cinema cinema = new Cinema();
        cinema.setTitle("Cinema");
        cinemaRepository.save(cinema);

        CinemaHall cinemaHall = new CinemaHall();
        cinemaHall.setCinema(cinema);
        cinemaHall.setTitle("Cinema aHald1sdza");
        cinemaHall.setSeats(10);
        cinemaHall.setRows(10);

        cinemaHallRepository.save(cinemaHall);
        System.out.println(cinemaHall.getId());


        Person person = new Person();
        person.setFullName(new FullName());
        person.getFullName().setFirstName("zaspexraso2rst2Name");
        person.getFullName().setLastName("zaspexra2t2Name");
        person.setDateOfBirth(LocalDate.of(1992, Month.APRIL, 20));
        person.setCountry(Country.BRA);
        person.setImageAddress("person izmagaresa2112s");
        personRepository.save(person);


        Movie movie = new Movie();
        movie.setImageAddress("Movie imzagxcxead saddr2ess112");
        movie.setTitle("Movie titlse21z2xc dsad1");
        movie.setCountry(Country.AUS);
        movie.setCreateYear(1992);
        movie.getGenres().add(Genre.ACTION);
        movie.getGenres().add(Genre.COMEDY);
        movie.setDirector(person);
        movieRepository.save(movie);

        Seance seance = new Seance();
        seance.setMovie(movie);
        seance.setPrice(BigDecimal.valueOf(10));
        seance.setCinemaHall(cinemaHall);
        seance.setSeanceDate(LocalDate.now());
        seance.setSeanceTime(LocalTime.now());
        seanceRepository.save(seance);
    }
}
