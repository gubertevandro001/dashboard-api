package alfa.tickets.api.dashboard.infrastructure.ticket.usecases.create;

import java.time.LocalDate;

public record CreateTicketOutput(
        Long id,
        String title,
        Long clientId,
        Long moduleId,
        LocalDate openingDate
) {

}
