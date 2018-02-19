package by.tryput.services;

import by.tryput.entity.Country;
import by.tryput.entity.Movie;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Map;


public interface CommonService {

    List<Country> getAllCountries();

    Page<Movie> findAllPageable(int page, int pageElements);

    Map<Long, List<Movie>> findWithFilter(Map<String, Object> filters, Map<String, Integer> pagination);
}
