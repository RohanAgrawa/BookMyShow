package com.example.bms.models;

import com.example.bms.models.enums.Features;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter

public class Auditorium extends BaseModel{

    private String number;

    private int maxRow;
    private int maxCol;

    @ManyToOne
    private Theater theater;

    @Enumerated(EnumType.ORDINAL)
    @ElementCollection
    private List<Features> features;

    @OneToMany(mappedBy = "auditorium")
    private List<Seat> seats;
}
