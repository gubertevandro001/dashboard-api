package alfa.tickets.api.dashboard.infrastructure.ticket.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

public record FindAllTicketsPerModuleResponse(
        @JsonProperty("id") Long id,
        @JsonProperty("title") String title,
        @JsonProperty("opening_date") LocalDate openingDate,
        @JsonProperty("closing_date") LocalDate closingDate
) {
}
