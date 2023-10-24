package alfa.tickets.api.dashboard.infrastructure;

public abstract class UseCase<Input, Output> {

    public abstract Output execute(Input input);


}
