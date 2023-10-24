package alfa.tickets.api.dashboard.infrastructure.ticket.models;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;

public record FindAllTicketsByYearAndMonthResponse(
		@JsonProperty("id") Long id,
		@JsonProperty("title") String title,
		@JsonProperty("client_id") Long clientId,
		@JsonProperty("module_id") Long moduleId,
		@JsonProperty("opening_date") LocalDate openingDate,
		@JsonProperty("closing_date") LocalDate closingDate
       ) {
}
