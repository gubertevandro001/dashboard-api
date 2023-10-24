package alfa.tickets.api.dashboard.infrastructure.ticket.usecases.create;

public record CreateTicketInput(
        String title,
        Long clientId,
        Long moduleId
) {
}
