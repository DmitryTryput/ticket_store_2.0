package by.tryput.controller;

import by.tryput.entity.Cinema;

import by.tryput.entity.CinemaHall;
import by.tryput.services.CinemaHallService;
import by.tryput.services.CinemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.Set;


@Controller
public class CinemaController {

    @Autowired
    private CinemaService cinemaService;

    @Autowired
    private CinemaHallService cinemaHallService;

    @ModelAttribute("cinema")
    public Cinema cinema() {
        return new Cinema();
    }

    @ModelAttribute("cinemaHall")
    public CinemaHall cinemaHall() {
        return new CinemaHall();
    }

    @ModelAttribute("allCinemas")
    public Set<Cinema> cinemas() {
        return cinemaService.findAllWithCinemaHalls();
    }

    @GetMapping("/cinemas")
    public String allCinemas() {
        return "cinemas";
    }


    @GetMapping("/add-cinema")
    public String addCinema() {
        return "add-cinema";
    }

    @PostMapping("/add-cinema")
    public String saveCinema(@Valid Cinema cinema, Errors errors) {
        if(errors.hasErrors()) {
           return "redirect:/add-cinema";
        }
        cinemaService.save(cinema);
        return "redirect:/cinemas";
    }

    @GetMapping("/add-cinemahall")
    public String addCinemahall() {
        return "add-cinemahall";
    }

    @PostMapping("/add-cinemahall")
    public String saveCinemaHall(@Valid CinemaHall cinemaHall, Errors errors) {
        if(errors.hasErrors()) {
            return "redirect:/add-cinemahall";
        }
        cinemaHallService.save(cinemaHall);
        return "redirect:/cinemas";
    }
}
