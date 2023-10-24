package alfa.tickets.api.dashboard.infrastructure.client.gateway;

import java.util.List;
import java.util.Optional;

import alfa.tickets.api.dashboard.infrastructure.client.persistence.Client;

public interface ClientGateway {

    Optional<Client> findById(Long id);
    
    List<Client> findClientsByIds(List<Long> clientIds);

}
