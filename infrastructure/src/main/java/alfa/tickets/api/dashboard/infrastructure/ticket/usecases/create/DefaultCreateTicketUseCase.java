package alfa.tickets.api.dashboard.infrastructure.ticket.usecases.create;

import alfa.tickets.api.dashboard.infrastructure.client.gateway.ClientGateway;
import alfa.tickets.api.dashboard.infrastructure.module.gateway.ModuleGateway;
import alfa.tickets.api.dashboard.infrastructure.ticket.gateway.TicketGateway;
import alfa.tickets.api.dashboard.infrastructure.ticket.persistence.Ticket;

public class DefaultCreateTicketUseCase extends CreateTicketUseCase {

    private final TicketGateway ticketGateway;
    private final ClientGateway clientGateway;
    private final ModuleGateway moduleGateway;


    public DefaultCreateTicketUseCase(TicketGateway ticketGateway, ClientGateway clientGateway, ModuleGateway moduleGateway) {
        this.ticketGateway = ticketGateway;
        this.clientGateway = clientGateway;
        this.moduleGateway = moduleGateway;
    }

    @Override
    public CreateTicketOutput execute(CreateTicketInput createTicketInput) {

        final var client = this.clientGateway.findById(createTicketInput.clientId()).get();
        final var module = this.moduleGateway.findById(createTicketInput.moduleId()).get();
        final var title = createTicketInput.title();

        final var ticket = this.ticketGateway.create(Ticket.newTicket(title, client, module));

        return new CreateTicketOutput(ticket.id(), ticket.title(), ticket.clientId(), ticket.moduleId(), ticket.openingDate());
    }

}
