package by.tryput.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@ToString(exclude = {"actor", "director"}, callSuper = true)
@Table(name = "persons")
public class Person extends IdentifiableEntity {

    @Column(name = "image_address")
    private String imageAddress;

    @Embedded
    private FullName fullName;

    @Column(name = "date_of_birth")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull
    private LocalDate dateOfBirth;

    @Enumerated(EnumType.STRING)
    @Column(name = "country")
    private Country country;

    @ManyToMany(mappedBy = "actors")
    private Set<Movie> actor = new HashSet<>();

    @OneToMany(mappedBy = "director")
    private Set<Movie> director = new HashSet<>();
}
