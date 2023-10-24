package alfa.tickets.api.dashboard.infrastructure.client.usecases.find_all_by_ids;

import java.util.List;

import alfa.tickets.api.dashboard.infrastructure.client.gateway.ClientGateway;

public class DefaultFindClientsByIdsUseCase extends FindClientsByIdsUseCase {
	
	private final ClientGateway clientGateway;
	
	public DefaultFindClientsByIdsUseCase(ClientGateway clientGateway) {
		this.clientGateway = clientGateway;
	}

	@Override
	public List<FindClientByIdsOutput> execute(List<Long> input) {
		return this.clientGateway.findClientsByIds(input).stream().map(FindClientByIdsOutput::from).toList();
	}
	
	

}
