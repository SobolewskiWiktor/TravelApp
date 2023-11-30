import java.time.LocalDateTime;

public class GovernmentFlight extends AirTravel {

    public int hirerName;

    public GovernmentFlight(LocalDateTime startTime, int duration, City startCity, City endCity, int seats, int occupiedSeats, String planeNumber) {
        super(startTime, duration, startCity, endCity, seats, occupiedSeats, planeNumber);
    }
}
