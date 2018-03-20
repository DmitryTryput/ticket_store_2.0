package by.tryput.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
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
    @NotEmpty
    private String title;

    @Column(name = "rows", nullable = false)
    private Integer rows;

    @Column(name = "seats", nullable = false)
    private Integer seats;

    @ManyToOne
    @JoinColumn(name = "cinema_id", nullable = false)
    @NotNull
    private Cinema cinema;

    @OneToMany(mappedBy = "cinemaHall")
    private Set<Seance> seances = new HashSet<>();
}
