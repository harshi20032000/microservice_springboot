package com.ms.booking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ms.booking.entity.Ticket;
import com.ms.booking.exception.ARSServiceException;
import com.ms.booking.repo.TicketRepository;

@Service
public class TicketService {

	@Autowired
	private TicketRepository ticketRepository;

	public void createTicket(Ticket ticket) {

		ticketRepository.saveAndFlush(ticket);

	}

	public Ticket getTicket(int pnr) {
		return ticketRepository.findById(pnr).get();

	}

	public void updateTicket(int pnr) throws ARSServiceException {
		Ticket ticket = ticketRepository.findById(pnr).get();

		if (ticket == null) {
			throw new ARSServiceException("No Ticekt for the given pnr");
		} else {

			ticket.setPaid(true);
			ticketRepository.saveAndFlush(ticket);

		}

	}

}
