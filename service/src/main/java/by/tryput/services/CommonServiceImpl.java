package by.tryput.services;

import by.tryput.entity.Country;
import by.tryput.entity.Genre;
import by.tryput.entity.Movie;
import by.tryput.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;
import java.util.Map;


@Service
@Transactional
public class CommonServiceImpl implements CommonService {

    @Autowired
    private MovieRepository movieRepository;

    public Iterable<Movie> findAll() {
        return movieRepository.findAll();
    }

    @Override
    public List<Country> getAllCountries() {
        return Arrays.asList(Country.values());
    }

    @Override
    public Page<Movie> findAllPageable(int page, int pageElements) {
        return movieRepository.findAll(new PageRequest(page, pageElements));
    }

    @Override
    public Map<Long, List<Movie>> findWithFilter(Map<String, Object> filters , Map<String, Integer> pagination) {
        return  movieRepository.findAllWithFilter(filters, pagination);
    }


}