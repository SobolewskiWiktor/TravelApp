import java.time.LocalDateTime;

public class CarRide extends RoadTravel implements Reservable{
    public String hirerName;

    public CarRide(LocalDateTime startTime, int duration, City startCity, City endCity, int seats, int occupiedSeats, String registrationNumber) {
        super(startTime, duration, startCity, endCity, seats, occupiedSeats, registrationNumber);
    }

    @Override
    public void reserve(int numberOfSeats) throws NoFreeSeatsException {
        if (numberOfSeats > seats - occupiedSeats) {
            throw new NoFreeSeatsException("Brak wystarczającej liczby wolnych miejsc w podróży Samochodem.");
        }
        occupiedSeats += numberOfSeats;
    }
}
