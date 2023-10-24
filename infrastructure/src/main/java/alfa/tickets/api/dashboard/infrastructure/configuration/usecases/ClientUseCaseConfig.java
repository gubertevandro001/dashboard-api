package alfa.tickets.api.dashboard.infrastructure.configuration.usecases;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import alfa.tickets.api.dashboard.infrastructure.client.gateway.ClientGateway;
import alfa.tickets.api.dashboard.infrastructure.client.usecases.find.DefaultFindClientByIdUseCase;
import alfa.tickets.api.dashboard.infrastructure.client.usecases.find.FindClientByIdUseCase;

@Configuration
public class ClientUseCaseConfig {

    private final ClientGateway clientGateway;


    public ClientUseCaseConfig(ClientGateway clientGateway) {
        this.clientGateway = clientGateway;
    }

    @Bean
    public FindClientByIdUseCase findClientByIdUseCase() {
        return new DefaultFindClientByIdUseCase(clientGateway);
    }
    
}
	