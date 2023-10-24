package alfa.tickets.api.dashboard.infrastructure.ticket;

import java.util.List;
import java.util.Objects;

import org.springframework.stereotype.Component;

import alfa.tickets.api.dashboard.infrastructure.ticket.gateway.TicketGateway;
import alfa.tickets.api.dashboard.infrastructure.ticket.models.CreateTicketResponse;
import alfa.tickets.api.dashboard.infrastructure.ticket.models.FindAllTicketsByYearAndMonthResponse;
import alfa.tickets.api.dashboard.infrastructure.ticket.models.FindAllTicketsPerClientResponse;
import alfa.tickets.api.dashboard.infrastructure.ticket.models.FindAllTicketsPerModuleResponse;
import alfa.tickets.api.dashboard.infrastructure.ticket.persistence.Ticket;
import alfa.tickets.api.dashboard.infrastructure.ticket.persistence.TicketRepository;

@Component
public class TicketH2Gateway implements TicketGateway {

	private final TicketRepository ticketRepository;

	public TicketH2Gateway(TicketRepository ticketRepository) {
		this.ticketRepository = ticketRepository;
	}

	@Override
	public List<FindAllTicketsByYearAndMonthResponse> findAllTicketsByYearAndMonth(Integer year, Integer month) {
		final var tickets = this.ticketRepository.findAllTicketsByYearAndMonth(month, year);
		return tickets.stream().map(t -> new FindAllTicketsByYearAndMonthResponse(t.getId(), t.getTitle(), t.getClient().getId(), t.getModule().getId(), t.getOpeningDate(), t.getClosingDate())).toList();
	}

	@Override
	public List<FindAllTicketsPerClientResponse> findAllTicketsPerClient(Long clientId) {
		final var tickets = this.ticketRepository.findAll();
		return tickets.stream().filter(t -> Objects.equals(t.getClient().getId(), clientId))
				.map(ticket -> new FindAllTicketsPerClientResponse(ticket.getId(), ticket.getTitle(),
						ticket.getModule().getId(), ticket.getOpeningDate(), ticket.getClosingDate()))
				.toList();
	}

	@Override
	public List<FindAllTicketsPerModuleResponse> findAllTicketsPerModule(Long moduleId) {
		final var tickets = this.ticketRepository.findAll();
		return tickets.stream().filter(t -> Objects.equals(t.getModule().getId(), moduleId))
				.map(ticket -> new FindAllTicketsPerModuleResponse(ticket.getId(), ticket.getTitle(),
						ticket.getOpeningDate(), ticket.getClosingDate()))
				.toList();
	}

	@Override
	public CreateTicketResponse create(Ticket ticket) {
		final var newTicket = this.ticketRepository.save(ticket);
		return new CreateTicketResponse(newTicket.getId(), newTicket.getTitle(), newTicket.getClient().getId(),
				newTicket.getModule().getId(), newTicket.getOpeningDate());
	}
}
