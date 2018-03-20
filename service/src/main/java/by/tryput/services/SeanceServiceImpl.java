package by.tryput.services;

import by.tryput.entity.CinemaHall;
import by.tryput.entity.Seance;
import by.tryput.entity.Ticket;
import by.tryput.entity.User;
import by.tryput.mappers.BuyTicketsDto;
import by.tryput.repositories.CinemaHallRepository;
import by.tryput.repositories.SeanceRepository;
import by.tryput.repositories.TicketRepository;
import by.tryput.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;

import javax.transaction.Transactional;


@Service
@Transactional
public class SeanceServiceImpl implements SeanceService {

    @Autowired
    private SeanceRepository seanceRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CinemaHallRepository cinemaHallRepository;

    @Autowired
    private TicketRepository ticketRepository;

    @Override
    public void addSeance(Seance seance) {
        seanceRepository.save(seance);
        CinemaHall cinemaHall = cinemaHallRepository.findOne(seance.getCinemaHall().getId());
        for (int row = 1; row <= cinemaHall.getRows(); row++) {
            for (int seat = 1; seat <= cinemaHall.getSeats(); seat++) {
                Ticket ticket = new Ticket();
                ticket.setSeance(seance);
                ticket.setRow(row);
                ticket.setSeat(seat);
                ticketRepository.save(ticket);
            }
        }
    }

    @Override
    public Seance findById(Long id) {
        return seanceRepository.findByIdWithTickets(id);
    }

    @Override
    public void buyTickets(BuyTicketsDto buyTicketsDto) {
        User user = userRepository.findByUsername(buyTicketsDto.getUsername());
        buyTicketsDto.getTicketsId().forEach(id -> ticketRepository.setByUserId(id, user.getId()));
    }
}
