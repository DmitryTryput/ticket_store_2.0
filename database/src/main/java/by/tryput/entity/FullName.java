package by.tryput.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Transient;


@Getter
@Setter
@Embeddable
@NoArgsConstructor
public class FullName {

    @Column(name = "first_name",
            nullable = false, unique = true)
    private String firstName;

    @Column(name = "last_name",
            nullable = false, unique = true)
    private String lastName;

    @Transient
    public String getFullName() {
        return firstName + " " + lastName;
    }
}
