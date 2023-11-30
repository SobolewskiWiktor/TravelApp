import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class Travel {
        public LocalDateTime startTime;
        public int duration;
        public City startCity;
        public City endCity;
        public int seats;
        public int occupiedSeats;

        public TravelStatus status;

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
        public void printTravelDetails() {
                System.out.println("Podróż z " + startCity.name + " do " + endCity.name);

                ZoneId startZone = ZoneId.of(startCity.timeZone.toString());
                ZoneId endZone = ZoneId.of(endCity.timeZone.toString());

                LocalDateTime arrivalTime = startTime.plusMinutes(duration)
                        .atZone(startZone)
                        .withZoneSameInstant(endZone)
                        .toLocalDateTime();

                System.out.println("Godzina przyjazdu: " + formatLocalDateTime(arrivalTime));

                if (!startZone.equals(endZone)) {
                        System.out.println("Godzina przyjazdu w strefie wyjazdowej: " + formatLocalDateTime(startTime));
                }
        }

        private String formatLocalDateTime(LocalDateTime dateTime) {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                return dateTime.format(formatter);
        }


        public boolean isNational() {
                return startCity.country.equals(endCity.country);
        }
}
