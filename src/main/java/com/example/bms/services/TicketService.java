package com.example.bms.services;

import com.example.bms.exceptions.SeatNotAvailableException;
import com.example.bms.exceptions.UserNotFoundException;
import com.example.bms.models.SeatInShow;
import com.example.bms.models.SeatTypeInShow;
import com.example.bms.models.Ticket;
import com.example.bms.models.User;
import com.example.bms.models.enums.SeatStatus;
import com.example.bms.repositry.SeatInShowRepositry;
import com.example.bms.repositry.TicketRepositry;
import com.example.bms.repositry.UserRepositry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class TicketService {

    private TicketRepositry ticketRepositry;

    private UserRepositry userRepositry;

    private SeatInShowRepositry seatInShowRepositry;

    @Autowired
    public TicketService(TicketRepositry ticketRepositry, UserRepositry userRepositry, SeatInShowRepositry seatInShowRepositry){

        this.seatInShowRepositry = seatInShowRepositry;
        this.ticketRepositry = ticketRepositry;
        this.userRepositry = userRepositry;
    }

    public Ticket bookTicket(List<Long> seatId, Long userId) throws SeatNotAvailableException, UserNotFoundException {

        List<SeatInShow> seats = seatInShowRepositry.findAllById(seatId);

        for(SeatInShow seat : seats){

            if(!isAvailable(seat)){

                throw new SeatNotAvailableException();
            }
        }

        Optional<User> user = userRepositry.findById(userId);

        if(user.isEmpty()){

            throw new UserNotFoundException();
        }

        User bookedBy = user.get();

        Date currentTime = new Date();

        List<SeatInShow> updatedSeat = new ArrayList<>();

        for(SeatInShow seat : seats){

            seat.setSeatStatus(SeatStatus.Locked);
            seat.setLockingTime(currentTime);
            seat = seatInShowRepositry.save(seat);
            updatedSeat.add(seat);
        }

        Ticket ticket = new Ticket();

        ticket.setAmount(0);
        ticket.setUser(bookedBy);
        ticket.setSeatInShows(updatedSeat);
        ticket.setBookingTime(currentTime);

        Ticket savedTicket = ticketRepositry.save(ticket);

        return savedTicket;
    }

    public boolean isAvailable(SeatInShow seat){

        if(seat.getSeatStatus().equals(SeatStatus.Available)){
            return true;
        }

        else if(seat.getSeatStatus().equals(SeatStatus.Locked)) {

            long lockedAt = seat.getLockingTime().getTime();
            long currentTime = System.currentTimeMillis();

            long duration = currentTime - lockedAt;

            long durationInSeconds = duration / 1000;

            long durationInMinutes = durationInSeconds / 60;

            return durationInMinutes >= 10;
        }

        return false;
    }
}
