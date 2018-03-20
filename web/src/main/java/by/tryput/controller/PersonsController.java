package by.tryput.controller;

import by.tryput.entity.Country;
import by.tryput.entity.Movie;
import by.tryput.entity.Person;
import by.tryput.services.CommonService;
import by.tryput.services.PersonService;
import by.tryput.services.UtilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class PersonsController {

    private HashMap<String, Object> filterParameters = new HashMap<>();
    private HashMap<String, Integer> paginationParameters = new HashMap<>();

    private final int startPage = 1;
    private final int elementsPerPage = 5;

    @Autowired
    private PersonService personService;

    @ModelAttribute("person")
    public Person person() {
        return new Person();
    }

    @GetMapping("/persons")
    public String start(Model model, Integer page) {
        paginationParameters.put("page", page == null ? startPage : page);
        paginationParameters.put("elements", elementsPerPage);
        Map<Long, List<Person>> result = personService.findWithFilter(filterParameters, paginationParameters);
        result.forEach((k, v) -> {
            model.addAttribute("persons", v);
            model.addAttribute("pages", k);
        });
        return "persons";
    }

}
