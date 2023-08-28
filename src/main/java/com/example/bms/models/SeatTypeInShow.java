package com.example.bms.models;

import com.example.bms.models.enums.SeatType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity

public class SeatTypeInShow extends BaseModel{

    @Enumerated(EnumType.ORDINAL)
    private SeatType seatType;

    @ManyToOne
    private MovieShow movieShow;

    private double price;
}
