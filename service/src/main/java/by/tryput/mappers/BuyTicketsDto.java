package by.tryput.mappers;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@ToString
public class BuyTicketsDto {

    private Long seanceId;

    private String username;

    private List<Long> ticketsId = new ArrayList<>();
}
