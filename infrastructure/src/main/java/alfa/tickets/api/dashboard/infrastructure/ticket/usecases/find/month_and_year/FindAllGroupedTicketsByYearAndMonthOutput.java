package alfa.tickets.api.dashboard.infrastructure.ticket.usecases.find.month_and_year;

import java.util.List;

import alfa.tickets.api.dashboard.infrastructure.client.persistence.Client;
import alfa.tickets.api.dashboard.infrastructure.client.usecases.find_all_by_ids.FindClientByIdsOutput;
import alfa.tickets.api.dashboard.infrastructure.module.persistence.Module;
import alfa.tickets.api.dashboard.infrastructure.module.usecases.find_all_by_ids.FindModulesByIdsOutput;
import alfa.tickets.api.dashboard.infrastructure.ticket.models.FindAllTicketsByYearAndMonthResponse;

public record FindAllGroupedTicketsByYearAndMonthOutput( 
		List<FindAllTicketsByYearAndMonthOutput> tickets,
		List<FindClientByIdsOutput> clients,
		List<FindModulesByIdsOutput> modules
) {
	
	public static FindAllGroupedTicketsByYearAndMonthOutput from(List<FindAllTicketsByYearAndMonthResponse> tickets, List<Client> clients, List<Module> modules) {
		return new FindAllGroupedTicketsByYearAndMonthOutput(convertToTicket(tickets), convertToClient(clients), convertToModule(modules));
	}
	
	private static List<FindClientByIdsOutput> convertToClient(List<Client> client) {
		return client.stream().map(c -> new FindClientByIdsOutput(c.getId(), c.getName())).toList();
	}
	
	private static List<FindModulesByIdsOutput> convertToModule(List<Module> modules) {
		return modules.stream().map(m -> new FindModulesByIdsOutput(m.getId(), m.getName())).toList();
	}
	
	private static List<FindAllTicketsByYearAndMonthOutput> convertToTicket(List<FindAllTicketsByYearAndMonthResponse> tickets) {
		return tickets.stream().map(ticket -> new FindAllTicketsByYearAndMonthOutput(ticket.id(), ticket.title(), ticket.clientId(), ticket.moduleId(), ticket.openingDate(), ticket.closingDate())).toList();
	}
	
}
