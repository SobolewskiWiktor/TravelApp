import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.time.ZoneId;

public class TravelTest {

    @Test
    void testIsNationalTravel() {
        City city1 = new City("Krakow", "Poland", ZoneId.of("Europe/Warsaw"));
        City city2 = new City("Warsaw", "Poland", ZoneId.of("Europe/Warsaw"));
        City city3 = new City("Berlin", "Germany", ZoneId.of("Europe/Berlin"));

        Travel nationalTravel = new Travel(LocalDateTime.now(), 120, city1, city2, 50, 10);
        Travel internationalTravel = new Travel(LocalDateTime.now(), 180, city1, city3, 50, 10);

        assertTrue(nationalTravel.isNationalTravel());
        assertFalse(internationalTravel.isNationalTravel());
    }

    @Test
    void testDoesChangeDate() {
        City city1 = new City("Krakow", "Poland", ZoneId.of("Europe/Warsaw"));
        City city2 = new City("Warsaw", "Poland", ZoneId.of("Europe/Warsaw"));

        Travel sameDayTravel = new Travel(LocalDateTime.now(), 120, city1, city2, 50, 10);
        Travel differentDayTravel = new Travel(LocalDateTime.now(), 180, city1, city2, 50, 10);

        assertFalse(sameDayTravel.doesChangeDate());
        assertTrue(differentDayTravel.doesChangeDate());
    }
}
