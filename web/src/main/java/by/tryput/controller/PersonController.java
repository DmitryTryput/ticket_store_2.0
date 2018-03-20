package by.tryput.controller;

import by.tryput.entity.Country;

import by.tryput.entity.Person;
import by.tryput.services.UtilService;
import by.tryput.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class PersonController {

    @Autowired
    UtilService utilService;

    @Autowired
    PersonService personService;

    @ModelAttribute("allCountries")
    public Country[] cinemas() {
        return utilService.getCountries();
    }

    @ModelAttribute("person")
    public Person person() {
        return new Person();
    }

    @PostMapping("/add-person")
    public String savePerson(@Valid Person person, Errors errors) {
        if(errors.hasErrors()) {
            return "redirect:/add-person";
        }
        personService.save(person);
        return "redirect:/persons";
    }

    @GetMapping("/add-person")
    public String addCinema() {
        return "add-person";
    }

    @GetMapping("/persons/{id}")
    public String showEmployeePage(@PathVariable("id") Long id, Model model) {
        Person person = personService.findById(id);
        model.addAttribute("person", person);
        return "person";
    }

}
