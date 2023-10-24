package alfa.tickets.api.dashboard.infrastructure.api.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import alfa.tickets.api.dashboard.infrastructure.api.TicketAPI;
import alfa.tickets.api.dashboard.infrastructure.ticket.models.CreateTicketRequest;
import alfa.tickets.api.dashboard.infrastructure.ticket.models.CreateTicketResponse;
import alfa.tickets.api.dashboard.infrastructure.ticket.models.FindAllGroupedTicketsByYearAndMonthResponse;
import alfa.tickets.api.dashboard.infrastructure.ticket.models.FindAllTicketsPerClientResponse;
import alfa.tickets.api.dashboard.infrastructure.ticket.models.FindAllTicketsPerModuleResponse;
import alfa.tickets.api.dashboard.infrastructure.ticket.presenters.TicketPresenter;
import alfa.tickets.api.dashboard.infrastructure.ticket.usecases.create.CreateTicketUseCase;
import alfa.tickets.api.dashboard.infrastructure.ticket.usecases.find.client.FindAllTicketsPerClientUseCase;
import alfa.tickets.api.dashboard.infrastructure.ticket.usecases.find.module.FindAllTicketsPerModuleUseCase;
import alfa.tickets.api.dashboard.infrastructure.ticket.usecases.find.month_and_year.FindAllTicketsByYearAndMonthUseCase;

@RestController
public class TicketController implements TicketAPI {

	private final CreateTicketUseCase createTicketUseCase;
	private final FindAllTicketsPerClientUseCase findAllTicketsPerClientUseCase;
	private final FindAllTicketsPerModuleUseCase findAllTicketsPerModuleUseCase;
	private final FindAllTicketsByYearAndMonthUseCase findAllTicketsByYearAndMonthUseCase;

	public TicketController(CreateTicketUseCase createTicketUseCase,
			FindAllTicketsPerClientUseCase findAllTicketsPerClientUseCase,
			FindAllTicketsPerModuleUseCase findAllTicketsPerModuleUseCase,
			FindAllTicketsByYearAndMonthUseCase findAllTicketsByYearAndMonthUseCase) {
		this.createTicketUseCase = createTicketUseCase;
		this.findAllTicketsPerClientUseCase = findAllTicketsPerClientUseCase;
		this.findAllTicketsPerModuleUseCase = findAllTicketsPerModuleUseCase;
		this.findAllTicketsByYearAndMonthUseCase = findAllTicketsByYearAndMonthUseCase;
	}

	@Override
	public ResponseEntity<FindAllGroupedTicketsByYearAndMonthResponse> findAllTicketsByYearAndMonth(Integer month,
			Integer year) {
		final var tickets = this.findAllTicketsByYearAndMonthUseCase.execute(year, month);
		
		return ResponseEntity.ok(TicketPresenter.presentPerMonthAndYear(tickets.tickets(), tickets.clients(), tickets.modules()));
	}

	@Override
	public ResponseEntity<List<FindAllTicketsPerClientResponse>> findAllTicketsPerClient(Long clientId) {
		return ResponseEntity
				.ok(TicketPresenter.presentPerClient(this.findAllTicketsPerClientUseCase.execute(clientId)));
	}

	@Override
	public ResponseEntity<List<FindAllTicketsPerModuleResponse>> findAllTicketsPerModule(Long moduleId) {
		return ResponseEntity
				.ok(TicketPresenter.presentPerModule(this.findAllTicketsPerModuleUseCase.execute(moduleId)));
	}

	@Override
	public ResponseEntity<CreateTicketResponse> create(CreateTicketRequest createTicketRequest) {
		final var ticket = this.createTicketUseCase.execute(TicketPresenter.presentCreate(createTicketRequest));
		return ResponseEntity.ok(new CreateTicketResponse(ticket.id(), ticket.title(), ticket.clientId(),
				ticket.moduleId(), ticket.openingDate()));
	}
}
