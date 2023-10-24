package alfa.tickets.api.dashboard.infrastructure.client.usecases.find_all_by_ids;

import alfa.tickets.api.dashboard.infrastructure.client.persistence.Client;

public record FindClientByIdsOutput(
		Long id,
		String name
		) {
	
	public static FindClientByIdsOutput from(Client client) {
		return new FindClientByIdsOutput(client.getId(), client.getName());
	}
	
}
