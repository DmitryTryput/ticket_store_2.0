package by.tryput.repositories;

import by.tryput.entity.Genre;
import by.tryput.entity.Movie;
import by.tryput.repositories.custom.MovieRepositoryCustom;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface MovieRepository extends PagingAndSortingRepository<Movie, Long>, MovieRepositoryCustom {


    Page<Movie> findByGenres(Genre genre, Pageable pageable);

    Page<Movie> findByTitle(String title, Pageable pageable);

    Page<Movie> findByCreateYear(int year, Pageable pageable);

    Page<Movie> findByGenresAndCreateYear(Genre genre, int year, Pageable pageable);

    Page<Movie> findByGenresAndTitleContaining(Genre genre, String title, Pageable pageable);

    Page<Movie> findByCreateYearAndTitleContaining(int year, String title, Pageable pageable);

    Page<Movie> findByCreateYearAndGenresAndTitleContaining(int year, Genre genre, String title, Pageable pageable);
}
