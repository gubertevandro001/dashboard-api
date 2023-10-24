package alfa.tickets.api.dashboard.infrastructure.client.usecases.find;

import alfa.tickets.api.dashboard.infrastructure.client.gateway.ClientGateway;

public class DefaultFindClientByIdUseCase extends FindClientByIdUseCase {

    private final ClientGateway clientGateway;

    public DefaultFindClientByIdUseCase(ClientGateway clientGateway) {
        this.clientGateway = clientGateway;
    }

    @Override
    public FindClientByIdOutput execute(Long clientId) {
        return this.clientGateway.findById(clientId).map(FindClientByIdOutput::from).orElse(null);
    }
}
