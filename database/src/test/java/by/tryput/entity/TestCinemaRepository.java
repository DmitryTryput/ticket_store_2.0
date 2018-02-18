package by.tryput.entity;

import by.tryput.repositories.CinemaRepository;

import by.tryput.repositories.config.PersistenceConfig;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import javax.transaction.Transactional;

import java.util.concurrent.atomic.AtomicInteger;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;


@Transactional
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = PersistenceConfig.class)
public class TestCinemaRepository {

    @Autowired
    private CinemaRepository cinemaRepository;

    @Before
    public void addCinema(){
        Cinema cinema = new Cinema();
        cinema.setTitle("Cinema");
        cinemaRepository.save(cinema);
    }

    @Test
    public void getCinema() {
        Cinema cinema = cinemaRepository.findByTitle("Cinema");
        assertThat(cinema.getTitle(), equalTo("Cinema"));
    }

    @Test
    public void updateCinema() {
        String title = "New Cinema";
        cinemaRepository.setById(title, 1L);
        Cinema updatedCinema = cinemaRepository.findByTitle("New Cinema");
        System.out.println(updatedCinema);
        assertThat(updatedCinema.getTitle(), equalTo("New Cinema"));
    }

    @Test
    public void getAllCinemas() {
        Cinema cinema2 = new Cinema();
        cinema2.setTitle("Cinema2");
        cinemaRepository.save(cinema2);
        Iterable<Cinema> all = cinemaRepository.findAll();
        AtomicInteger count = new AtomicInteger();
        all.forEach(c -> count.getAndIncrement());
        assertThat(count.addAndGet(0), equalTo(2));
    }

    @Test
    public void deleteCinema() {
        Cinema cinema = new Cinema();
        cinema.setTitle("Cinema To Delete");
        cinemaRepository.save(cinema);
        Cinema deletedCinema = cinemaRepository.findByTitle("Cinema To Delete");
        cinemaRepository.delete(deletedCinema);
        Cinema deleted = cinemaRepository.findOne(1L);
        assertThat(deleted, equalTo(null));
    }
}
