package alfa.tickets.api.dashboard.infrastructure.module.usecases.find_all_by_ids;

import alfa.tickets.api.dashboard.infrastructure.module.persistence.Module;

public record FindModulesByIdsOutput(
		Long id,
		String name) {
	
	public static FindModulesByIdsOutput from(Module module) {
		return new FindModulesByIdsOutput(module.getId(), module.getName());
	}
}

