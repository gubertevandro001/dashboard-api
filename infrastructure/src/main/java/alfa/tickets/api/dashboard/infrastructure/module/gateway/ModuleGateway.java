package alfa.tickets.api.dashboard.infrastructure.module.gateway;

import java.util.List;
import java.util.Optional;

import alfa.tickets.api.dashboard.infrastructure.module.persistence.Module;

public interface ModuleGateway {

    Optional<Module> findById(Long id);
    
    List<Module> findModulesByIds(List<Long> moduleIds);
}
