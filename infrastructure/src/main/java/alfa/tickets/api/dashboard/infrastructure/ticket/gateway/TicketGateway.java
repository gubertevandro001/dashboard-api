package alfa.tickets.api.dashboard.infrastructure.ticket.gateway;

import java.util.List;

import alfa.tickets.api.dashboard.infrastructure.ticket.models.CreateTicketResponse;
import alfa.tickets.api.dashboard.infrastructure.ticket.models.FindAllTicketsByYearAndMonthResponse;
import alfa.tickets.api.dashboard.infrastructure.ticket.models.FindAllTicketsPerClientResponse;
import alfa.tickets.api.dashboard.infrastructure.ticket.models.FindAllTicketsPerModuleResponse;
import alfa.tickets.api.dashboard.infrastructure.ticket.persistence.Ticket;

public interface TicketGateway {

	List<FindAllTicketsByYearAndMonthResponse> findAllTicketsByYearAndMonth(final Integer month, final Integer year);

	List<FindAllTicketsPerClientResponse> findAllTicketsPerClient(final Long clientId);

	List<FindAllTicketsPerModuleResponse> findAllTicketsPerModule(final Long moduleId);

	CreateTicketResponse create(final Ticket ticket);
}
