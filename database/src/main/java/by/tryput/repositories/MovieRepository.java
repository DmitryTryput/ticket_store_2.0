package by.tryput.repositories;

import by.tryput.entity.Genre;
import by.tryput.entity.Movie;
import by.tryput.repositories.custom.MovieRepositoryCustom;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface MovieRepository extends PagingAndSortingRepository<Movie, Long>, MovieRepositoryCustom {


    Page<Movie> findByGenres(Genre genre, Pageable pageable);

}
