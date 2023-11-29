import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Travel {
        public LocalDateTime startTime;
        public int duration;
        public City startCity;
        public City endCity;
        public int seats;
        public int occupiedSeats;

        public Travel (LocalDateTime startTime, int duration, City startCity, City endCity, int seats, int occupiedSeats)
        {
                this.startTime = startTime;
                this.startCity = startCity;
                this.endCity = endCity;
                this.duration = duration;
                this.seats = seats;
                this.occupiedSeats = occupiedSeats;
        }

        public boolean isNationalTravel()
        {
                if(startCity.country == endCity.country)
                {
                        return true;
                }
                else
                {
                        return false;
                }
        }

        public boolean doesChangeDate()
        {
                LocalDateTime start = startTime;
                LocalDateTime end = startTime.plusMinutes(this.duration);

                if(start.getDayOfMonth() == end.getDayOfMonth())
                {
                        if(start.getMonth() == end.getMonth())
                        {
                                return true;
                        }
                        else
                        {
                                return false;
                        }
                }
                else
                {
                        return false;
                }

        }

        

}
