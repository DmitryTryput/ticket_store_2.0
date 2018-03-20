package by.tryput.controller;

import by.tryput.entity.Country;
import by.tryput.entity.Genre;
import by.tryput.entity.Person;
import by.tryput.mappers.MovieDto;
import by.tryput.services.MovieService;
import by.tryput.services.PersonService;
import by.tryput.services.UtilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
public class AddMovieController {

    @Autowired
    UtilService utilService;

    @Autowired
    PersonService personService;

    @Autowired
    MovieService movieService;

    @ModelAttribute("allCountries")
    public Country[] cinemas() {
        return utilService.getCountries();
    }

    @ModelAttribute("allGenres")
    public Genre[] genres() {
        return utilService.getGenres();
    }

    @ModelAttribute("allPersons")
    public List<Person> allPersons() {
        return personService.getAll();
    }

    @ModelAttribute("movie")
    public MovieDto movie() {
        return new MovieDto();
    }

    @GetMapping("/add-movie")
    public String addMovie() {
        return "add-movie";
    }

    @PostMapping("/add-movie")
    public String savePerson(@Valid MovieDto movie, Errors errors) {
        if(errors.hasErrors()) {
            return "redirect:/add-movie";
        }
        movieService.addMovie(movie);
        return "redirect:/movies";
    }

}
