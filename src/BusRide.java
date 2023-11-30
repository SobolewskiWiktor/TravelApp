import java.time.LocalDateTime;

public class BusRide extends RoadTravel implements Reservable {
    public BusRide(LocalDateTime startTime, int duration, City startCity, City endCity, int seats, int occupiedSeats, String regNumber) {
        super(startTime, duration, startCity, endCity, seats, occupiedSeats, regNumber);
    }

    @Override
    public void reserve(int numberOfSeats) throws NoFreeSeatsException {
        if (numberOfSeats > seats - occupiedSeats) {
            throw new NoFreeSeatsException("Brak wystarczającej liczby wolnych miejsc w podróży Autobusem.");
        }
        occupiedSeats += numberOfSeats;
    }
}
