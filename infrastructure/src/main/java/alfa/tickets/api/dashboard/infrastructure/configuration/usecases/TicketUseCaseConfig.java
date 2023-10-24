package alfa.tickets.api.dashboard.infrastructure.configuration.usecases;

import alfa.tickets.api.dashboard.infrastructure.client.gateway.ClientGateway;
import alfa.tickets.api.dashboard.infrastructure.module.gateway.ModuleGateway;
import alfa.tickets.api.dashboard.infrastructure.ticket.gateway.TicketGateway;
import alfa.tickets.api.dashboard.infrastructure.ticket.usecases.create.CreateTicketUseCase;
import alfa.tickets.api.dashboard.infrastructure.ticket.usecases.create.DefaultCreateTicketUseCase;
import alfa.tickets.api.dashboard.infrastructure.ticket.usecases.find.client.DefaultFindAllTicketsPerClientUseCase;
import alfa.tickets.api.dashboard.infrastructure.ticket.usecases.find.client.FindAllTicketsPerClientUseCase;
import alfa.tickets.api.dashboard.infrastructure.ticket.usecases.find.module.DefaultFindAllTicketsPerModuleUseCase;
import alfa.tickets.api.dashboard.infrastructure.ticket.usecases.find.module.FindAllTicketsPerModuleUseCase;
import alfa.tickets.api.dashboard.infrastructure.ticket.usecases.find.month_and_year.DefaultFindAllTicketsByYearAndMonthUseCase;
import alfa.tickets.api.dashboard.infrastructure.ticket.usecases.find.month_and_year.FindAllTicketsByYearAndMonthUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TicketUseCaseConfig {

    private final ClientGateway clientGateway;
    private final ModuleGateway moduleGateway;
    private final TicketGateway ticketGateway;


    public TicketUseCaseConfig(ClientGateway clientGateway, ModuleGateway moduleGateway, TicketGateway ticketGateway) {
        this.clientGateway = clientGateway;
        this.moduleGateway = moduleGateway;
        this.ticketGateway = ticketGateway;
    }

    @Bean
    public CreateTicketUseCase createTicketUseCase() {
        return new DefaultCreateTicketUseCase(ticketGateway, clientGateway, moduleGateway);
    }

    @Bean
    public FindAllTicketsPerClientUseCase findAllTicketsPerClientUseCase() {
        return new DefaultFindAllTicketsPerClientUseCase(ticketGateway);
    }

    @Bean
    public FindAllTicketsPerModuleUseCase findAllTicketsPerModuleUseCase() {
        return new DefaultFindAllTicketsPerModuleUseCase(ticketGateway);
    }

    @Bean
    public FindAllTicketsByYearAndMonthUseCase findAllTicketsByYearAndMonthUseCase() {
        return new DefaultFindAllTicketsByYearAndMonthUseCase(ticketGateway, clientGateway, moduleGateway);
    }
}
