package by.tryput.services;

import by.tryput.entity.Country;
import by.tryput.entity.Genre;

public interface UtilService {

    Country[] getCountries();

    Genre[] getGenres();
}
