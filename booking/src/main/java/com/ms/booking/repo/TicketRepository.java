package com.ms.booking.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ms.booking.entity.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Integer> {

}
