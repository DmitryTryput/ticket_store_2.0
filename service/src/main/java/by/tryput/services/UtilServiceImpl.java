package by.tryput.services;

import by.tryput.entity.Country;
import by.tryput.entity.Genre;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class UtilServiceImpl implements UtilService {

    @Override
    public Country[] getCountries() {
        return Country.values();
    }

    @Override
    public Genre[] getGenres() {
        return Genre.values();
    }
}
