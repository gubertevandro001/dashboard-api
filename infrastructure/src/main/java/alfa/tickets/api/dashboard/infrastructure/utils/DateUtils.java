package alfa.tickets.api.dashboard.infrastructure.utils;

import java.time.LocalDate;

public class DateUtils {

    public static LocalDate getActualDate() {
        return LocalDate.of(LocalDate.now().getYear(), LocalDate.now().getMonth(), LocalDate.now().getDayOfMonth());
    }
}
