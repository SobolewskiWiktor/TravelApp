import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.time.ZoneId;

public class TravelTest {

    @Test
    void testReserveSufficientSeats() throws NoFreeSeatsException {
        City city1 = new City("Krakow", "Poland", ZoneId.of("Europe/Warsaw"));
        City city2 = new City("Warsaw", "Poland", ZoneId.of("Europe/Warsaw"));

        Travel travel = new Travel(LocalDateTime.now(), 120, city1, city2, 50, 10);

        // Próbujemy zarezerwować wystarczającą ilość miejsc
        travel.reserve(20);

        // Oczekujemy, że liczba zajętych miejsc po rezerwacji wyniesie 30
        assertEquals(30, travel.occupiedSeats);
    }

    @Test
    void testReserveNotEnoughSeats() {
        City city1 = new City("Krakow", "Poland", ZoneId.of("Europe/Warsaw"));
        City city2 = new City("Warsaw", "Poland", ZoneId.of("Europe/Warsaw"));

        Travel travel = new Travel(LocalDateTime.now(), 120, city1, city2, 50, 10);

        // Próbujemy zarezerwować więcej miejsc, niż jest dostępnych
        assertThrows(NoFreeSeatsException.class, () -> travel.reserve(60));
    }

    @Test
    void testReserveZeroSeats() {
        City city1 = new City("Krakow", "Poland", ZoneId.of("Europe/Warsaw"));
        City city2 = new City("Warsaw", "Poland", ZoneId.of("Europe/Warsaw"));

        Travel travel = new Travel(LocalDateTime.now(), 120, city1, city2, 50, 10);

        // Próbujemy zarezerwować 0 miejsc
        assertDoesNotThrow(() -> travel.reserve(0));

        // Oczekujemy, że liczba zajętych miejsc nie zmieni się
        assertEquals(10, travel.occupiedSeats);
    }
}
