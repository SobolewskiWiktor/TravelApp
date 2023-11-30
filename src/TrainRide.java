import java.time.LocalDateTime;

public class TrainRide extends RailwayTravel implements Reservable{
    public TrainRide(LocalDateTime startTime, int duration, City startCity, City endCity, int seats, int occupiedSeats, String trainNumber) {
        super(startTime, duration, startCity, endCity, seats, occupiedSeats, trainNumber);
    }
    @Override
    public void reserve(int numberOfSeats) throws NoFreeSeatsException {
        if (numberOfSeats > seats - occupiedSeats) {
            throw new NoFreeSeatsException("Brak wystarczającej liczby wolnych miejsc w podróży Pociągiem.");
        }
        occupiedSeats += numberOfSeats;
    }
}
