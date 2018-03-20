package by.tryput.services;

import by.tryput.entity.Movie;
import by.tryput.mappers.MovieDto;

import java.util.List;

public interface MovieService {

    List<Movie> getAll();

    void addMovie(MovieDto movie);

    Movie findById(Long id);
}
