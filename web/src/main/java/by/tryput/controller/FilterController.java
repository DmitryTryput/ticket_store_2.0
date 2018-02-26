package by.tryput.controller;

import by.tryput.entity.Country;
import by.tryput.entity.Movie;
import by.tryput.services.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
public class FilterController {

    private HashMap<String, Object> filterParameters = new HashMap<>();
    private HashMap<String, Integer> paginationParameters = new HashMap<>();

    private final int startPage = 1;
    private final int elementsPerPage = 3;

    @Autowired
    private CommonService commonService;

    @ModelAttribute("countries")
    public List<Country> allCountries() {
        return commonService.getAllCountries();
    }

    @ModelAttribute("movie")
    public Movie movie() {
        return new Movie();
    }

    @GetMapping("/filter")
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
        return "/filter";
    }

    @PostMapping("/filter")
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
        return "/filter";
    }
}
