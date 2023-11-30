import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.time.ZoneId;

public class CityTest {

    @Test
    void testIsTheSameCountry() {
        City city1 = new City("Krakow", "Poland", ZoneId.of("Europe/Warsaw"));
        City city2 = new City("Warsaw", "Poland", ZoneId.of("Europe/Warsaw"));
        City city3 = new City("Berlin", "Germany", ZoneId.of("Europe/Berlin"));

        assertTrue(city1.isTheSameCountry(city2));
        assertFalse(city1.isTheSameCountry(city3));
    }

    @Test
    void testIsTheSameTime() {
        City city1 = new City("Krakow", "Poland", ZoneId.of("Europe/Warsaw"));
        City city2 = new City("Warsaw", "Poland", ZoneId.of("Europe/Warsaw"));
        City city3 = new City("Berlin", "Germany", ZoneId.of("Europe/Berlin"));

        assertTrue(city1.isTheSameTime(city2));
        assertFalse(city1.isTheSameTime(city3));
    }
}
