package alfa.tickets.api.dashboard.infrastructure;

public abstract class UseCaseWithTwoParams<InputOne, InputTwo,  Output> {

    public abstract Output execute(InputOne inputOne, InputTwo inputTwo);

}
