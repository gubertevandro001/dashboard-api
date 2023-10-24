package alfa.tickets.api.dashboard.infrastructure.module.usecases.find;

import alfa.tickets.api.dashboard.infrastructure.module.gateway.ModuleGateway;

public class DefaultFindModuleByIdUseCase extends FindModuleByIdUseCase {

    private final ModuleGateway moduleGateway;

    public DefaultFindModuleByIdUseCase(ModuleGateway moduleGateway) {
        this.moduleGateway = moduleGateway;
    }

    @Override
    public FindModuleByIdUseCaseOutput execute(Long moduleId) {
        return this.moduleGateway.findById(moduleId).map(FindModuleByIdUseCaseOutput::from).orElse(null);
    }
}
