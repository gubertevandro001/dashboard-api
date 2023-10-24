package alfa.tickets.api.dashboard.infrastructure.ticket.usecases.find.module;

import java.time.LocalDate;
import java.util.List;

import alfa.tickets.api.dashboard.infrastructure.ticket.models.FindAllTicketsPerModuleResponse;

public record FindAllTicketsPerModuleOutput(
        Long id,
        String title,
        LocalDate openingDate,
        LocalDate closingDate
) {

    public static FindAllTicketsPerModuleOutput from(FindAllTicketsPerModuleResponse ticket) {
        return new FindAllTicketsPerModuleOutput(ticket.id(), ticket.title(), ticket.openingDate(), ticket.closingDate());
    }

    public static List<FindAllTicketsPerModuleOutput> from(List<FindAllTicketsPerModuleResponse> tickets) {
        return tickets.stream().map(FindAllTicketsPerModuleOutput::from).toList();
    }
}

