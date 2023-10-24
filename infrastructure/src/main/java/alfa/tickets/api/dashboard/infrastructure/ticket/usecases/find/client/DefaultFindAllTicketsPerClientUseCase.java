package alfa.tickets.api.dashboard.infrastructure.ticket.usecases.find.client;

import java.util.List;

import alfa.tickets.api.dashboard.infrastructure.ticket.gateway.TicketGateway;

public class DefaultFindAllTicketsPerClientUseCase extends FindAllTicketsPerClientUseCase {

    private final TicketGateway ticketGateway;

    public DefaultFindAllTicketsPerClientUseCase(TicketGateway ticketGateway) {
        this.ticketGateway = ticketGateway;
    }

    @Override
    public List<FindAllTicketsPerClientOutput> execute(Long clientId) {
        final var tickets = ticketGateway.findAllTicketsPerClient(clientId);

        if (tickets.isEmpty()) {
            return null;
        }

        return FindAllTicketsPerClientOutput.from(tickets);
    }
}
