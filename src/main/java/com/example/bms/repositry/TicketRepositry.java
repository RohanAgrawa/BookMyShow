package com.example.bms.repositry;

import com.example.bms.models.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepositry extends JpaRepository<Ticket, Long> {

    @Override
    Ticket save(Ticket entity);
}
