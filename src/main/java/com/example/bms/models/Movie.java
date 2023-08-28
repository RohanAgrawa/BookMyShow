package com.example.bms.models;

import com.example.bms.models.enums.Features;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity

public class Movie extends BaseModel{

    private String name;


    @Enumerated(EnumType.ORDINAL)
    @ElementCollection
    private List<Features> reqFeatures;

    @ManyToMany
    private List<Actor> actors;

    // in minutes
    private int duration;
}
