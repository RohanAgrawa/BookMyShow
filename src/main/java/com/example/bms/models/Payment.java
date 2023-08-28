package com.example.bms.models;

import com.example.bms.models.enums.PaymentMode;
import com.example.bms.models.enums.PaymentStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter

public class Payment extends BaseModel{

    @Enumerated(EnumType.ORDINAL)
    private PaymentMode paymentMode;

    @Enumerated(EnumType.ORDINAL)
    private PaymentStatus paymentStatus;

    @OneToOne
    private Ticket ticket;

    private double amount;

    private Date paymentTime;


}
