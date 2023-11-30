import java.time.LocalDateTime;

public class RoadTravel extends Travel{

    public String registrationNumber;

    public RoadTravel(LocalDateTime startTime, int duration, City startCity, City endCity, int seats, int occupiedSeats, String registrationNumber) {
        super(startTime, duration, startCity, endCity, seats, occupiedSeats);
        this.registrationNumber = registrationNumber;
    }
}
