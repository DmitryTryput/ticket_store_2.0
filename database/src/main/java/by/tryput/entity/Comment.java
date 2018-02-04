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
@Table(name = "comments")
@PrimaryKeyJoinColumn(name = "message_id")
public class Comment extends Message {

    @Column(name = "text", nullable = false,
            length = 55)
    private String text;

}
