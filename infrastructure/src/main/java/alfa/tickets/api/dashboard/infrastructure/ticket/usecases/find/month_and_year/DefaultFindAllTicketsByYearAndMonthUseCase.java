package alfa.tickets.api.dashboard.infrastructure.ticket.usecases.find.month_and_year;

import java.util.ArrayList;

import alfa.tickets.api.dashboard.infrastructure.client.gateway.ClientGateway;
import alfa.tickets.api.dashboard.infrastructure.module.gateway.ModuleGateway;
import alfa.tickets.api.dashboard.infrastructure.ticket.gateway.TicketGateway;

public class DefaultFindAllTicketsByYearAndMonthUseCase extends FindAllTicketsByYearAndMonthUseCase {

	private final TicketGateway ticketGateway;
	private final ClientGateway clientGateway;
	private final ModuleGateway moduleGateway;

	public DefaultFindAllTicketsByYearAndMonthUseCase(TicketGateway ticketGateway, ClientGateway clientGateway,
			ModuleGateway moduleGateway) {
		this.ticketGateway = ticketGateway;
		this.clientGateway = clientGateway;
		this.moduleGateway = moduleGateway;
	}

	@Override
	public FindAllGroupedTicketsByYearAndMonthOutput execute(Integer month, Integer year) {

		final var tickets = this.ticketGateway.findAllTicketsByYearAndMonth(month, year);

		if (tickets.isEmpty()) {
			return null;
		}

		var clientIds = new ArrayList<Long>();
		var moduleIds = new ArrayList<Long>();

		tickets.stream().map(t -> clientIds.add(t.clientId())).toList();
		tickets.stream().map(t -> moduleIds.add(t.moduleId())).toList();

		final var clients = clientGateway.findClientsByIds(clientIds);
		final var modules = moduleGateway.findModulesByIds(moduleIds);

		return FindAllGroupedTicketsByYearAndMonthOutput.from(tickets, clients, modules);

	}
}
