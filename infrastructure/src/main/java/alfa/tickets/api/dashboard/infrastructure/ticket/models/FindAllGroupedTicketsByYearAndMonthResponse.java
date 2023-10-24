package alfa.tickets.api.dashboard.infrastructure.ticket.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import alfa.tickets.api.dashboard.infrastructure.client.models.ClientsByIdsResponse;
import alfa.tickets.api.dashboard.infrastructure.module.models.ModulesByIdsResponse;

public record FindAllGroupedTicketsByYearAndMonthResponse(
		@JsonProperty("tickets") List<FindAllTicketsByYearAndMonthResponse> tickets,
		@JsonProperty("clients") List<ClientsByIdsResponse> clients,
		@JsonProperty("modules") List<ModulesByIdsResponse> modules
       ) 
{}

