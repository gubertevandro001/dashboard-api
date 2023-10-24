package alfa.tickets.api.dashboard.infrastructure.ticket.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

public record CreateTicketResponse(
        @JsonProperty("id") Long id,
        @JsonProperty("title") String title,
        @JsonProperty("client_id") Long clientId,
        @JsonProperty("module_id") Long moduleId,
        @JsonProperty("opening_date") LocalDate openingDate
) {
}
