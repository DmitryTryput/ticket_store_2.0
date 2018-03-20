package by.tryput.controller;

import by.tryput.entity.Cinema;
import by.tryput.entity.IdentifiableEntity;
import by.tryput.entity.Seance;
import by.tryput.entity.Ticket;
import by.tryput.mappers.BuyTicketsDto;
import by.tryput.services.CinemaService;
import by.tryput.services.SeanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Controller
public class SeanceController {

    @Autowired
    private CinemaService cinemaService;

    @Autowired
    private SeanceService seanceService;



    @ModelAttribute("ticketsId")
    public BuyTicketsDto ticketsId() {
        return new BuyTicketsDto();
    }

    @GetMapping("/seances")
    public String seances(Model model) {
        Set<Cinema> allSeances = cinemaService.findAllSeances();
        model.addAttribute("cinemaSeances", allSeances);
        return "seances";
    }

    @GetMapping("/seances/{id}")
    public String seance(@PathVariable Long id, Model model) {
        Seance result = seanceService.findById(id);
        List<Ticket> rowSeatTickets = result.getRowSeatTickets();
        rowSeatTickets.sort(Comparator.comparing(IdentifiableEntity::getId));
        Map<Integer, List<Ticket>> ticket = new HashMap<>();
        for (int i = 1; i <= result.getCinemaHall().getRows(); i++) {
            int row = i;
            List<Ticket> tickets = new ArrayList<>();
            result.getRowSeatTickets().forEach(t -> {
                if(t.getRow() == row) {
                    tickets.add(t);
                }
            });
            ticket.put(row, tickets);
        }
        ticket.forEach((k,v) -> System.out.println(k + " " + v));
        model.addAttribute("tickets", ticket);
        model.addAttribute("seance", result);
        return "seance";
    }

    @PostMapping("/seances/{id}")
    public String buy(@PathVariable Long id, BuyTicketsDto buyTicketsDto, Principal principal) {

        buyTicketsDto.setSeanceId(id);
        buyTicketsDto.setUsername(principal.getName());
        seanceService.buyTickets(buyTicketsDto);


        return "redirect:/seances/" + id;
    }

}
