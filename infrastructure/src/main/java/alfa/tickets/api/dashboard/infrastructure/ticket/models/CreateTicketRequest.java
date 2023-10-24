package alfa.tickets.api.dashboard.infrastructure.ticket.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public record CreateTicketRequest(
        @JsonProperty("title") String title,
        @JsonProperty("client_id") Long clientId,
        @JsonProperty("module_id") Long moduleId
) {
}
