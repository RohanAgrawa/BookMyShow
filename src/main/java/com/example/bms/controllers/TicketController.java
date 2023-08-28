package com.example.bms.controllers;

import com.example.bms.dto.BookTicketRequestDTO;
import com.example.bms.dto.BookTicketResponseDTO;
import com.example.bms.dto.ResponseStatus;
import com.example.bms.models.Ticket;
import com.example.bms.services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class TicketController {

    private TicketService ticketService;

    @Autowired
    public TicketController(TicketService ticketService){

        this.ticketService = ticketService;
    }

    public BookTicketResponseDTO bookTicket(BookTicketRequestDTO bookTicketRequestDTO){

        BookTicketResponseDTO bookTicketResponseDTO = new BookTicketResponseDTO();

        try {

            Ticket ticket = ticketService.bookTicket(bookTicketRequestDTO.getSeatInShowID(), bookTicketRequestDTO.getUserId());

            bookTicketResponseDTO.setDummyTicketId(ticket.getId());
            bookTicketResponseDTO.setResponseStatus(ResponseStatus.SUCCESS);
            bookTicketResponseDTO.setMessage("Dummy Ticket generated successfully, Go to Payment gateway and finish the Booking");
        }

        catch (Exception ignored){

            bookTicketResponseDTO.setMessage("Something wrong happened, couldn't book the ticket");
            bookTicketResponseDTO.setResponseStatus(ResponseStatus.FAILURE);
        }


        return bookTicketResponseDTO;
    }
}
