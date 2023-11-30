import java.time.LocalDateTime;

public class NormalFlight extends AirTravel implements Reservable{

    public NormalFlight(LocalDateTime startTime, int duration, City startCity, City endCity, int seats, int occupiedSeats, String planeNumber) {
        super(startTime, duration, startCity, endCity, seats, occupiedSeats, planeNumber);
    }
    @Override
    public void reserve(int numberOfSeats) throws NoFreeSeatsException {
        if (numberOfSeats > seats - occupiedSeats) {
            throw new NoFreeSeatsException("Brak wystarczającej liczby wolnych miejsc w podróży Samolotem.");
        }
        occupiedSeats += numberOfSeats;
    }
}
