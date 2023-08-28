package com.example.bms.exceptions;

import org.aspectj.bridge.Message;

public class SeatNotAvailableException extends Exception{

    public SeatNotAvailableException(){
        super("Seat Not Available");
    }
}
