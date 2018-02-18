package by.tryput.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "persons")
public class Person extends IdentifiableEntity {

    @Column(name = "image_address")
    private String imageAddress;

    @Embedded
    private FullName fullName;

    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    @Enumerated(EnumType.STRING)
    @Column(name = "country")
    private Country country;

    @ManyToMany(mappedBy = "actors")
    private Set<Movie> actor = new HashSet<>();

    @OneToMany(mappedBy = "director")
    private Set<Movie> director = new HashSet<>();
}
