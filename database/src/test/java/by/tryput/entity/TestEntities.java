package by.tryput.entity;

import by.tryput.repositories.CinemaHallRepository;
import by.tryput.repositories.CinemaRepository;
import by.tryput.repositories.CommentRepository;
import by.tryput.repositories.MovieRepository;
import by.tryput.repositories.PersonRepository;
import by.tryput.repositories.ReviewRepository;
import by.tryput.repositories.SeanceRepository;
import by.tryput.repositories.TicketRepository;
import by.tryput.repositories.UserRepository;
import by.tryput.repositories.config.PersistenceConfig;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.util.Set;


import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

@Transactional
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = PersistenceConfig.class)
public class TestEntities {

    @Autowired
    private CinemaRepository cinemaRepository;
    @Autowired
    private CinemaHallRepository cinemaHallRepository;
    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ReviewRepository reviewRepository;
    @Autowired
    private SeanceRepository seanceRepository;
    @Autowired
    private TicketRepository ticketRepository;
    @Autowired
    private CommentRepository commentRepository;


    @Before
    public void initDb() {

        Cinema cinema = new Cinema();
        cinema.setTitle("cinema title");
        cinemaRepository.save(cinema);

        CinemaHall cinemaHall = new CinemaHall();
        cinemaHall.setRows(10);
        cinemaHall.setSeats(10);
        cinemaHall.setCinema(cinema);
        cinemaHall.setTitle("cinemaHall title");
        cinemaHallRepository.save(cinemaHall);

        Person person = new Person();
        person.setFullName(new FullName());
        person.getFullName().setFirstName("person firstName");
        person.getFullName().setLastName("person lastName");
        person.setDateOfBirth(LocalDate.of(1992, Month.APRIL, 20));
        person.setCountry(Country.BRA);
        person.setImageAddress("person image address");
        personRepository.save(person);

        Movie movie = new Movie();
        movie.setImageAddress("movie image address");
        movie.setTitle("film title");
        movie.setCountry(Country.AUS);
        movie.setCreateYear(1992);
        movie.setDirector(person);
        movie.getActors().add(person);
        movie.getGenres().add(Genre.ACTION);
        movie.getGenres().add(Genre.COMEDY);
        movieRepository.save(movie);

        User user = new User();
        user.setRole(Role.USER);
        user.setEmail("email");
        user.setPassword("password");
        user.setFullName(new FullName());
        user.getFullName().setFirstName("user firstName");
        user.getFullName().setLastName("user lastName");
        user.setValue(BigDecimal.valueOf(100));
        userRepository.save(user);

        Review review = new Review();
        review.setName("review name");
        review.setText("big text");
        review.setMovie(movie);
        review.setUser(user);
        reviewRepository.save(review);

        Seance seance = new Seance();
        seance.setCinemaHall(cinemaHall);
        seance.setSeanceDate(LocalDate.now());
        seance.setSeanceTime(LocalTime.now());
        seance.setPrice(BigDecimal.valueOf(10));
        seance.setMovie(movie);
        seanceRepository.save(seance);

        Ticket ticket = new Ticket();
        ticket.setRow(1);
        ticket.setSeance(seance);
        ticket.setSeat(1);
        ticket.setUser(user);
        ticketRepository.save(ticket);
        user.getTickets().add(ticket);

        Comment comment = new Comment();
        comment.setText("comment");
        comment.setUser(user);
        comment.setMovie(movie);
        commentRepository.save(comment);

    }


    @Test
    public void testFindUser() {
        User user = userRepository.findOne(6L);
        assertThat(user.getFullName().getFirstName(),
                equalTo("user firstName"));
    }

    @Test
    public void testFindPerson() {
        Person person = personRepository.findOne(2L);
        assertThat(person.getFullName().getFirstName(),
                equalTo("person firstName"));
    }

    @Test
    public void testFindCinema() {
        Cinema cinema = cinemaRepository.findOne(1L);
        assertThat(cinema.getTitle(),
                equalTo("cinema title"));
    }

    @Test
    public void testFindCinemaHall() {
        CinemaHall cinemaHall = cinemaHallRepository.findOne(5L);
        assertThat(cinemaHall.getTitle(),
                equalTo("cinemaHall title"));
    }

    @Test
    public void testFindMovie() {
        Movie movie = movieRepository.findOne(7L);
        assertThat(movie.getTitle(),
                equalTo("film title"));
    }

    @Test
    public void testFindSeance() {
        Seance seance = seanceRepository.findOne(3L);
        assertThat(seance.getPrice().intValue(),
                equalTo(10));
    }

    @Test
    public void testFindUserTickets() {
        User user = userRepository.findOne(4L);
        Set<Ticket> tickets = user.getTickets();
        assertThat(tickets.size(),
                equalTo(1));
    }
}
