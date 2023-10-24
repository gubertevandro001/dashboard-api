package alfa.tickets.api.dashboard.infrastructure.ticket.usecases.find.client;

import java.time.LocalDate;
import java.util.List;

import alfa.tickets.api.dashboard.infrastructure.ticket.models.FindAllTicketsPerClientResponse;

public record FindAllTicketsPerClientOutput(
        Long id,
        String title,
        Long moduleId,
        LocalDate openingDate,
        LocalDate closingDate
) {

    public static FindAllTicketsPerClientOutput from(FindAllTicketsPerClientResponse ticket) {
        return new FindAllTicketsPerClientOutput(ticket.id(), ticket.title(), ticket.moduleId(), ticket.openingDate(), ticket.closingDate());
    }

    public static List<FindAllTicketsPerClientOutput> from(List<FindAllTicketsPerClientResponse> tickets) {
        return tickets.stream().map(FindAllTicketsPerClientOutput::from).toList();
    }
}
