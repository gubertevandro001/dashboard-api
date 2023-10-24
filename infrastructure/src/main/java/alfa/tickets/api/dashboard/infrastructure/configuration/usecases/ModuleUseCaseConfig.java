package alfa.tickets.api.dashboard.infrastructure.configuration.usecases;

import alfa.tickets.api.dashboard.infrastructure.module.gateway.ModuleGateway;
import alfa.tickets.api.dashboard.infrastructure.module.usecases.find.DefaultFindModuleByIdUseCase;
import alfa.tickets.api.dashboard.infrastructure.module.usecases.find.FindModuleByIdUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModuleUseCaseConfig {

    private final ModuleGateway moduleGateway;

    public ModuleUseCaseConfig(ModuleGateway moduleGateway) {
        this.moduleGateway = moduleGateway;
    }

    @Bean
    public FindModuleByIdUseCase findModuleByIdUseCase() {
        return new DefaultFindModuleByIdUseCase(moduleGateway);
    }
}
