package com.example.bms.dto;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
public class BookTicketRequestDTO {

    private List<Long> seatInShowID;

    private Long userId;
}
