package by.tryput.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;



@Getter
@Setter
@NoArgsConstructor
@Entity
@ToString(callSuper = true)
@Table(name = "reviews")
@PrimaryKeyJoinColumn(name = "message_id")
public class Review extends Message {

    @Column(name = "name",
            nullable = false, length = 55)
    private String name;

    @Column(name = "text",
            nullable = false, length = 1000)
    private String text;

}
