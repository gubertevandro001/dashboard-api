package alfa.tickets.api.dashboard.infrastructure.client;

import alfa.tickets.api.dashboard.infrastructure.client.gateway.ClientGateway;
import alfa.tickets.api.dashboard.infrastructure.client.persistence.Client;
import alfa.tickets.api.dashboard.infrastructure.client.persistence.ClientRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ClientH2Gateway implements ClientGateway {

    private final ClientRepository clientRepository;

    public ClientH2Gateway(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public Optional<Client> findById(Long clientId) {
        return this.clientRepository.findById(clientId).map(Client::with);
    }

	@Override
	public List<Client> findClientsByIds(List<Long> clientIds) {
		return this.clientRepository.findAllById(clientIds);
	}
}


