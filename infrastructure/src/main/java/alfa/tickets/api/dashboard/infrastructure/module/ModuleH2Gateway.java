package alfa.tickets.api.dashboard.infrastructure.module;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import alfa.tickets.api.dashboard.infrastructure.module.gateway.ModuleGateway;
import alfa.tickets.api.dashboard.infrastructure.module.persistence.Module;
import alfa.tickets.api.dashboard.infrastructure.module.persistence.ModuleRepository;

@Component
public class ModuleH2Gateway implements ModuleGateway {

    private final ModuleRepository moduleRepository;

    public ModuleH2Gateway(ModuleRepository moduleRepository) {
        this.moduleRepository = moduleRepository;
    }

    @Override
    public Optional<Module> findById(Long moduleId) {
        return this.moduleRepository.findById(moduleId).map(Module::with);
    }

	@Override
	public List<Module> findModulesByIds(List<Long> moduleIds) {
		return this.moduleRepository.findAllById(moduleIds);
	}
}
