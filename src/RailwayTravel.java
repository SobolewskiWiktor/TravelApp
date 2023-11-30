import java.time.LocalDateTime;

public class RailwayTravel  extends Travel{
    public String trainNumber;

    public RailwayTravel(LocalDateTime startTime, int duration, City startCity, City endCity, int seats, int occupiedSeats, String trainNumber) {
        super(startTime, duration, startCity, endCity, seats, occupiedSeats);
        this.trainNumber = trainNumber;
    }
}
