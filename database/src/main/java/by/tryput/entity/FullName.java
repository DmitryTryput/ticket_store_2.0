package by.tryput.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;


@Getter
@Setter
@Embeddable
@NoArgsConstructor
@ToString
public class FullName {

    @Column(name = "first_name",
            nullable = false, unique = true)
    @NotEmpty
    private String firstName;

    @Column(name = "last_name",
            nullable = false, unique = true)
    @NotEmpty
    private String lastName;

    @Transient
    public String getFullName() {
        return firstName + " " + lastName;
    }
}
