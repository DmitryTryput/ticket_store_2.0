package by.tryput.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;


@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "users")
@ToString(callSuper = true)
public class User extends IdentifiableEntity {

    @Column(name = "email", nullable = false,
            unique = true)
    @NotEmpty
    @Email
    private String email;

    @Embedded
    private FullName fullName;

    @Column(name = "username", nullable = false, unique = true)
    @NotEmpty
    private String username;

    @Column(name = "user_password", nullable = false)
    @NotEmpty
    private String password;

    @Column(name = "user_value")
    private BigDecimal value;

    @Column(name = "role", nullable = false)
    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToMany(mappedBy = "user")
    private Set<Ticket> tickets = new HashSet<>();

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private Set<Message> messages = new HashSet<>();

}
