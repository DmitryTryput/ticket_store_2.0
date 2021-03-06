package by.tryput.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.NotEmpty;


import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
@Entity
@Table(name = "movies")
@ToString(callSuper = true, exclude = "seances")
public class Movie extends IdentifiableEntity {


    @Column(name = "image_address")
    private String imageAddress;

    @Column(name = "title", nullable = false)
    @NotEmpty
    private String title;

    @Column(name = "create_year", nullable = false)
    @NotNull
    private Integer createYear;

    @Enumerated(EnumType.STRING)
    @Column(name = "country", nullable = false)
    private Country country;


    @Enumerated(EnumType.STRING)
    @ElementCollection(targetClass = Genre.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "movies_genres",
            joinColumns = @JoinColumn(name = "movie_id"))
    @Column(name = "genre", unique = true)
    private Set<Genre> genres = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "director_id", nullable = false)
    @NotNull
    private Person director;

    @ManyToMany
    @JoinTable(
            name = "movies_actors",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "person_id"))
    private Set<Person> actors = new HashSet<>();

    @OneToMany(mappedBy = "movie")
    private Set<Message> messages = new HashSet<>();

    @OneToMany(mappedBy = "movie")
    private Set<Seance> seances = new HashSet<>();

}
