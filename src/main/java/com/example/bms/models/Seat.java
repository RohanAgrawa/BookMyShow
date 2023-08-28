package com.example.bms.models;

import com.example.bms.models.enums.SeatType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity

public class Seat extends BaseModel{

    private String number;

    private int rowNo;
    private int colNo;

    @ManyToOne
    private Auditorium auditorium;

    @Enumerated(EnumType.ORDINAL)
    private SeatType seatType;
}
