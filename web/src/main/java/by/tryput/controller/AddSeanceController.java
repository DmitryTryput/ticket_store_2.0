package by.tryput.controller;

import by.tryput.entity.Cinema;
import by.tryput.entity.CinemaHall;
import by.tryput.entity.Movie;
import by.tryput.entity.Seance;
import by.tryput.services.CinemaHallService;
import by.tryput.services.CinemaService;
import by.tryput.services.MovieService;
import by.tryput.services.SeanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;
import java.util.Set;

@Controller
public class AddSeanceController {

    @Autowired
    CinemaHallService cinemaHallService;

    @Autowired
    SeanceService seanceService;

    @Autowired
    MovieService movieService;

    @ModelAttribute("allCinemaHalls")
    public List<CinemaHall> cinemaHalls() {
        return cinemaHallService.getAll();
    }

    @ModelAttribute("allMovies")
    public List<Movie> movies() {
        return movieService.getAll();
    }

    @ModelAttribute("seance")
    public Seance seance() {
        return new Seance();
    }

    @GetMapping("/add-seance")
    public String addSeance() {
        return "add-seance";
    }

    @PostMapping("/add-seance")
    public String saveSeance(@Valid Seance seance, Errors errors) {
        if(errors.hasErrors()) {
            return "redirect:/add-seance";
        }
        seanceService.addSeance(seance);
        return "redirect:/seances";
    }
}
