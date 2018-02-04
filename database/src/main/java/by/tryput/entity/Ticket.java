package by.tryput.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "tickets")
public class Ticket extends IdentifiableEntity {

    @Column(name = "row")
    private Integer row;

    @Column(name = "seat")
    private Integer seat;

    @ManyToOne
    @JoinColumn(name = "seance_id", nullable = false)
    private Seance seance;

    @Column(name = "is_purchased")
    private boolean purchased;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

}
