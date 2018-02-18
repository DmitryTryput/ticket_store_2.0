package by.tryput.entity;


import by.tryput.repositories.CinemaRepository;
import by.tryput.repositories.MovieRepository;
import by.tryput.repositories.PersonRepository;
import by.tryput.repositories.config.PersistenceConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;


@Transactional
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = PersistenceConfig.class)
public class TestMovies {

    @Autowired
    MovieRepository movieRepository;

    @Autowired
    PersonRepository personRepository;

    @Autowired
    CinemaRepository cinemaRepository;

    @Test
    public void testMovies() {
        Movie one = movieRepository.findOne(1L);
        System.out.println(one);

    }

    @Test
    public void testFindAll() {
        Iterable<Movie> all = movieRepository.findAll();
        all.forEach(System.out::println);
    }

    @Test
    public void testFindByGenre() {
        Page<Movie> byGenres = movieRepository.findByGenres(Genre.ACTION, new PageRequest(1, 5));
        byGenres.forEach(System.out:: println);
    }

}
