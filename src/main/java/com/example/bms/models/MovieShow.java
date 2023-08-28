package com.example.bms.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter

public class MovieShow extends BaseModel{

    @ManyToOne
    private Auditorium auditorium;

    @ManyToOne
    private Movie movie;

    private Date startTime;

    private Date endTime;

    private int maxTickets;

    // in Minutes
    private int lockingTime;
}
