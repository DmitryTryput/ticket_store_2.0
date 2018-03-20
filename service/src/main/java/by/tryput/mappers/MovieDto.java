package by.tryput.mappers;

import by.tryput.entity.Country;
import by.tryput.entity.Genre;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class MovieDto {

    @NotEmpty
    private String title;

    @NotNull
    private Integer date;

    @NotEmpty
    private String imageAddress;

    @NotNull
    private Long directorId;

    @NotNull
    private Country country;

    @NotEmpty
    private List<Genre> genres;

    @NotEmpty
    private List<Long> actorsId;
}
