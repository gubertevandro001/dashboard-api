package alfa.tickets.api.dashboard.infrastructure.ticket.presenters;

import java.util.List;

import alfa.tickets.api.dashboard.infrastructure.client.models.ClientsByIdsResponse;
import alfa.tickets.api.dashboard.infrastructure.client.usecases.find_all_by_ids.FindClientByIdsOutput;
import alfa.tickets.api.dashboard.infrastructure.module.models.ModulesByIdsResponse;
import alfa.tickets.api.dashboard.infrastructure.module.usecases.find_all_by_ids.FindModulesByIdsOutput;
import alfa.tickets.api.dashboard.infrastructure.ticket.models.CreateTicketRequest;
import alfa.tickets.api.dashboard.infrastructure.ticket.models.FindAllGroupedTicketsByYearAndMonthResponse;
import alfa.tickets.api.dashboard.infrastructure.ticket.models.FindAllTicketsByYearAndMonthResponse;
import alfa.tickets.api.dashboard.infrastructure.ticket.models.FindAllTicketsPerClientResponse;
import alfa.tickets.api.dashboard.infrastructure.ticket.models.FindAllTicketsPerModuleResponse;
import alfa.tickets.api.dashboard.infrastructure.ticket.usecases.create.CreateTicketInput;
import alfa.tickets.api.dashboard.infrastructure.ticket.usecases.find.client.FindAllTicketsPerClientOutput;
import alfa.tickets.api.dashboard.infrastructure.ticket.usecases.find.module.FindAllTicketsPerModuleOutput;
import alfa.tickets.api.dashboard.infrastructure.ticket.usecases.find.month_and_year.FindAllTicketsByYearAndMonthOutput;

public interface TicketPresenter {

    static List<FindAllTicketsPerClientResponse> presentPerClient(final List<FindAllTicketsPerClientOutput> output) {
        return output.stream().map(ticket -> new FindAllTicketsPerClientResponse(ticket.id(), ticket.title(), ticket.moduleId(), ticket.openingDate(), ticket.closingDate())).toList();
    }

    static List<FindAllTicketsPerModuleResponse> presentPerModule(final List<FindAllTicketsPerModuleOutput> output) {
        return output.stream().map(ticket -> new FindAllTicketsPerModuleResponse(ticket.id(), ticket.title(), ticket.openingDate(), ticket.closingDate())).toList();
    }

    static CreateTicketInput presentCreate(final CreateTicketRequest createTicketRequest) {
        return new CreateTicketInput(createTicketRequest.title(), createTicketRequest.clientId(), createTicketRequest.moduleId());
    }
    
    static FindAllGroupedTicketsByYearAndMonthResponse presentPerMonthAndYear(List<FindAllTicketsByYearAndMonthOutput> tickets, List<FindClientByIdsOutput> clients, List<FindModulesByIdsOutput> modules) {
		final var ticketsFrom = tickets.stream().map(t -> new FindAllTicketsByYearAndMonthResponse(t.id(), t.title(), t.clientId(), t.moduleId(), t.openingDate(), t.closingDate())).toList();
		final var clientsFrom = clients.stream().map(c -> new ClientsByIdsResponse(c.id(), c.name())).toList();
		final var modulesFrom = modules.stream().map(m -> new ModulesByIdsResponse(m.id(), m.name())).toList();
		return new FindAllGroupedTicketsByYearAndMonthResponse(ticketsFrom, clientsFrom, modulesFrom);
	}
}
