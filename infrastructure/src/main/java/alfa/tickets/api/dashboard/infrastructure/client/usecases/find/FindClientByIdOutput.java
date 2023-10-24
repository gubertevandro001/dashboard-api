package alfa.tickets.api.dashboard.infrastructure.client.usecases.find;

import alfa.tickets.api.dashboard.infrastructure.client.persistence.Client;

public record FindClientByIdOutput(
        Long id,
        String name
) {

    public static FindClientByIdOutput from(final Client client) {
        return new FindClientByIdOutput(client.getId(), client.getName());
    }
}
