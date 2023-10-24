package alfa.tickets.api.dashboard.infrastructure.ticket.usecases.find.month_and_year;

import java.time.LocalDate;

public record FindAllTicketsByYearAndMonthOutput(
		Long id,
        String title,
        Long clientId,
        Long moduleId,
        LocalDate openingDate,
        LocalDate closingDate) {

}
