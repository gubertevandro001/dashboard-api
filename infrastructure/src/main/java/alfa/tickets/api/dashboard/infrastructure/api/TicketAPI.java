package alfa.tickets.api.dashboard.infrastructure.api;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import alfa.tickets.api.dashboard.infrastructure.ticket.models.CreateTicketRequest;
import alfa.tickets.api.dashboard.infrastructure.ticket.models.CreateTicketResponse;
import alfa.tickets.api.dashboard.infrastructure.ticket.models.FindAllGroupedTicketsByYearAndMonthResponse;
import alfa.tickets.api.dashboard.infrastructure.ticket.models.FindAllTicketsPerClientResponse;
import alfa.tickets.api.dashboard.infrastructure.ticket.models.FindAllTicketsPerModuleResponse;

@RequestMapping(value = "tickets")
public interface TicketAPI {

    @GetMapping(value = "{month}/{year}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<FindAllGroupedTicketsByYearAndMonthResponse> findAllTicketsByYearAndMonth(@PathVariable("month") Integer month, @PathVariable("year") Integer year);

    @GetMapping(value = "client/{clientId}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<FindAllTicketsPerClientResponse>> findAllTicketsPerClient(@PathVariable("clientId") Long clientId);

    @GetMapping(value = "module/{moduleId}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<FindAllTicketsPerModuleResponse>> findAllTicketsPerModule(@PathVariable("moduleId") Long moduleId);

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<CreateTicketResponse> create(@RequestBody CreateTicketRequest createTicketRequest);
    
}
