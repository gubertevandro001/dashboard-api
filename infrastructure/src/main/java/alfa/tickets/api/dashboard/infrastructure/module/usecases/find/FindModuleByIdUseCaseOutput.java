package alfa.tickets.api.dashboard.infrastructure.module.usecases.find;

import alfa.tickets.api.dashboard.infrastructure.module.persistence.Module;

public record FindModuleByIdUseCaseOutput(
        Long id,
        String name
) {

    public static FindModuleByIdUseCaseOutput from(final Module module) {
        return new FindModuleByIdUseCaseOutput (module.getId(), module.getName());
    }
}
