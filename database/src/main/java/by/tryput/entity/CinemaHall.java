package by.tryput.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "cinema", callSuper = true)
@Entity
@Table(name = "cinema_halls")
public class CinemaHall extends IdentifiableEntity {

    @Column(name = "title",
            nullable = false, unique = true)
    private String title;

    @Column(name = "rows", nullable = false)
    private Integer rows;

    @Column(name = "seats", nullable = false)
    private Integer seats;

    @ManyToOne
    @JoinColumn(name = "cinema_id", nullable = false)
    private Cinema cinema;

    @OneToMany(mappedBy = "cinemaHall")
    private Set<Seance> seances = new HashSet<>();
}
