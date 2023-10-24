package alfa.tickets.api.dashboard.infrastructure.ticket.usecases.find.module;

import java.util.List;

import alfa.tickets.api.dashboard.infrastructure.ticket.gateway.TicketGateway;

public class DefaultFindAllTicketsPerModuleUseCase extends FindAllTicketsPerModuleUseCase {

    private final TicketGateway ticketGateway;

    public DefaultFindAllTicketsPerModuleUseCase(TicketGateway ticketGateway) {
        this.ticketGateway = ticketGateway;
    }

    @Override
    public List<FindAllTicketsPerModuleOutput> execute(Long moduleId) {
        final var tickets = ticketGateway.findAllTicketsPerModule(moduleId);

        if (tickets.isEmpty()) {
            return null;
        }

        return FindAllTicketsPerModuleOutput.from(tickets);
    }
}
