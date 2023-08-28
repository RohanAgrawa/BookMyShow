package com.example.bms.models;

import com.example.bms.models.enums.PaymentMode;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity

@Getter
@Setter

public class Ticket extends BaseModel{

    private double amount;

    @ManyToOne
    private User user;

    @OneToMany(mappedBy = "ticket")
    private List<SeatInShow> seatInShows;


    private Date bookingTime;

    @OneToOne
    private Payment payment;
}
