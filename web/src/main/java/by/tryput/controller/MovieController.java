package by.tryput.controller;

import by.tryput.entity.Country;
import by.tryput.entity.Movie;
import by.tryput.entity.Person;
import by.tryput.services.CommonService;
import by.tryput.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
public class MovieController {

    private HashMap<String, Object> filterParameters = new HashMap<>();
    private HashMap<String, Integer> paginationParameters = new HashMap<>();

    private final int startPage = 1;
    private final int elementsPerPage = 3;

    @Autowired
    private CommonService commonService;

    @Autowired
    private MovieService movieService;

    @ModelAttribute("countries")
    public List<Country> allCountries() {
        return commonService.getAllCountries();
    }

    @ModelAttribute("movie")
    public Movie movie() {
        return new Movie();
    }

    @GetMapping("/movies")
    public String start(Model model, Integer page) {
        paginationParameters.put("page", page == null ? startPage : page);
        paginationParameters.put("elements", elementsPerPage);
        Map<Long, List<Movie>> result = commonService.findWithFilter(filterParameters, paginationParameters);
        result.forEach((k, v) -> {
            model.addAttribute("movies", v);
            model.addAttribute("pages", k);
            System.out.println(v.size());
            System.out.println(k);
        });
        return "movies";
    }

    @PostMapping("/movies")
    public String result(Movie movie, Model model) {
        paginationParameters.put("page", startPage);
        filterParameters.put("title", movie.getTitle().equals("") ? null
                : movie.getTitle());
        filterParameters.put("createYear", movie.getCreateYear());
        filterParameters.put("country", movie.getCountry());
        Map<Long, List<Movie>> result = commonService.findWithFilter(filterParameters, paginationParameters);
        result.forEach((k, v) -> {
            model.addAttribute("movies", v);
            model.addAttribute("pages", k);
        });
        return "movies";
    }

    @GetMapping("/movies/{id}")
    public String showEmployeePage(@PathVariable("id") Long id, Model model) {
        Movie movie = movieService.findById(id);
        model.addAttribute("movie", movie);
        return "movie";
    }
}
