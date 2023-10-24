package alfa.tickets.api.dashboard.infrastructure.module.usecases.find_all_by_ids;

import java.util.List;

import alfa.tickets.api.dashboard.infrastructure.module.gateway.ModuleGateway;

public class DefaultFindModulesByIdUseCase extends FindModulesByIdsUseCase {
	
	private final ModuleGateway moduleGateway;
	
	public DefaultFindModulesByIdUseCase(ModuleGateway moduleGateway) {
		this.moduleGateway = moduleGateway;
	}

	@Override
	public List<FindModulesByIdsOutput> execute(List<Long> input) {
		return this.moduleGateway.findModulesByIds(input).stream().map(FindModulesByIdsOutput::from).toList();
	}

}
