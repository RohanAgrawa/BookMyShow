package com.example.bms.models;

import com.example.bms.models.enums.SeatStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity

public class SeatInShow extends BaseModel{

    @ManyToOne
    private Seat seat;

    @ManyToOne
    private MovieShow movieShow;

    @Enumerated(EnumType.ORDINAL)
    private SeatStatus seatStatus;

    @ManyToOne
    private Ticket ticket;

    private Date lockingTime;
}
