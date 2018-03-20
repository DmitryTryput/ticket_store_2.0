package by.tryput.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "seances")
@ToString(callSuper = true, exclude = "cinemaHall")
public class Seance extends IdentifiableEntity {

    @ManyToOne
    @JoinColumn(name = "movie_id", nullable = false)
    @NotNull
    private Movie movie;

    @ManyToOne
    @JoinColumn(name = "cinema_hall_id", nullable = false)
    @NotNull
    private CinemaHall cinemaHall;

    @Column(name = "seance_date", nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull
    private LocalDate seanceDate;

    @Column(name = "seance_time", nullable = false)
    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    @NotNull
    private LocalTime seanceTime;

    @Column(name = "price", nullable = false)
    @NotNull
    private BigDecimal price;

    @OneToMany(mappedBy = "seance")
    private List<Ticket> rowSeatTickets = new ArrayList<>();
}
