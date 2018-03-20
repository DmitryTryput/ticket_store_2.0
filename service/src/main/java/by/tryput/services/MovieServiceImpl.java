package by.tryput.services;

import by.tryput.entity.Movie;
import by.tryput.entity.Person;
import by.tryput.mappers.MovieDto;
import by.tryput.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieRepository movieRepository;

    @Override
    public List<Movie> getAll() {
        List<Movie> result = new ArrayList<>();
        movieRepository.findAll().forEach(result::add);
        return result;
    }

    @Override
    public void addMovie(MovieDto movieDto) {
        Movie movie = new Movie();
        movie.setTitle(movieDto.getTitle());
        Person director = new Person();
        director.setId(movieDto.getDirectorId());
        movie.setDirector(director);
        movie.setCountry(movieDto.getCountry());
        movie.setImageAddress(movieDto.getImageAddress());
        movie.setCreateYear(movieDto.getDate());
        movieDto.getActorsId().forEach(id -> {
            Person actor = new Person();
            actor.setId(id);
            movie.getActors().add(actor);
        });
        movieDto.getGenres().forEach(movie.getGenres()::add);
        movieRepository.save(movie);
    }

    @Override
    public Movie findById(Long id) {
        return movieRepository.findById(id);
    }
}
