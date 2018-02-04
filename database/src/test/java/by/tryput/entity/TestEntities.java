package by.tryput.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.time.Year;
import java.util.Set;


import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class TestEntities {

    private SessionFactory sessionFactory;

    @Before
    public void initDb() {
        sessionFactory = new Configuration().configure().buildSessionFactory();

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Cinema cinema = new Cinema();
        cinema.setTitle("cinema title");
        session.save(cinema);

        CinemaHall cinemaHall = new CinemaHall();
        cinemaHall.setRows(10);
        cinemaHall.setSeats(10);
        cinemaHall.setCinema(cinema);
        cinemaHall.setTitle("cinemaHall title");
        session.save(cinemaHall);

        Person person = new Person();
        person.setFullName(new FullName());
        person.getFullName().setFirstName("person firstName");
        person.getFullName().setLastName("person lastName");
        person.setDateOfBirth(LocalDate.of(1992, Month.APRIL, 20));
        person.setCountry(Country.BRA);
        person.setImageAddress("person image address");
        session.save(person);

        Movie movie = new Movie();
        movie.setImageAddress("movie image address");
        movie.setTitle("film title");
        movie.setCountry(Country.AUS);
        movie.setCreateDate(LocalDate.of(1992, Month.APRIL, 10));
        movie.setDirector(person);
        movie.getActors().add(person);
        movie.getGenres().add(Genre.ACTION);
        movie.getGenres().add(Genre.COMEDY);
        session.save(movie);

        User user = new User();
        user.setRole(Role.USER);
        user.setEmail("email");
        user.setPassword("password");
        user.setFullName(new FullName());
        user.getFullName().setFirstName("user firstName");
        user.getFullName().setLastName("user lastName");
        user.setValue(BigDecimal.valueOf(100));
        session.save(user);

        Review review = new Review();
        review.setName("review name");
        review.setText("big text");
        review.setMovie(movie);
        review.setUser(user);
        session.save(review);

        Seance seance = new Seance();
        seance.setCinemaHall(cinemaHall);
        seance.setSeanceDate(LocalDate.now());
        seance.setSeanceTime(LocalTime.now());
        seance.setPrice(BigDecimal.valueOf(10));
        seance.setMovie(movie);
        session.save(seance);

        Ticket ticket = new Ticket();
        ticket.setRow(1);
        ticket.setSeance(seance);
        ticket.setSeat(1);
        ticket.setUser(user);
        session.save(ticket);
        user.getTickets().add(ticket);

        Comment comment = new Comment();
        comment.setText("comment");
        comment.setUser(user);
        comment.setMovie(movie);
        session.save(comment);

        transaction.commit();
        session.close();
    }


    @Test
    public void testFindUser() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        User user = session.get(User.class, 1L);
        assertThat(user.getFullName().getFirstName(),
                equalTo("user firstName"));
        session.getTransaction().commit();
        session.close();
    }

    @Test
    public void testFindPerson() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Person person = session.get(Person.class, 1L);
        assertThat(person.getFullName().getFirstName(),
                equalTo("person firstName"));
        System.out.println(person);
        session.getTransaction().commit();
        session.close();
    }

    @Test
    public void testFindCinema() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Cinema cinema = session.get(Cinema.class, 1L);
        assertThat(cinema.getTitle(),
                equalTo("cinema title"));
        System.out.println(cinema);
        session.getTransaction().commit();
        session.close();
    }

    @Test
    public void testFindCinemaHall() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        CinemaHall cinemaHall = session.get(CinemaHall.class, 1L);
        assertThat(cinemaHall.getTitle(),
                equalTo("cinemaHall title"));
        System.out.println(cinemaHall);
        session.getTransaction().commit();
        session.close();
    }

    @Test
    public void testFindMovie() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Movie movie = session.get(Movie.class, 1L);
        assertThat(movie.getTitle(),
                equalTo("film title"));
        System.out.println(movie);
        session.getTransaction().commit();
        session.close();
    }

    @Test
    public void testFindMessages() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        User user = session.get(User.class, 1L);
        Set<Message> messages = user.getMessages();
        assertThat(messages.size(),
                equalTo(2));
        System.out.println(user);
        session.getTransaction().commit();
        session.close();
    }

    @Test
    public void testFindSeance() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Seance seance = session.get(Seance.class, 1L);
        assertThat(seance.getPrice().intValue(),
                equalTo(10));
        System.out.println(seance);
        session.getTransaction().commit();
        session.close();
    }

    @Test
    public void testFindUserTickets() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        User user = session.get(User.class, 1L);
        Set<Ticket> tickets = user.getTickets();
        assertThat(tickets.size(),
                equalTo(1));
        session.getTransaction().commit();
        session.close();
    }

    @After
    public void finish() {
        sessionFactory.close();
    }
}
