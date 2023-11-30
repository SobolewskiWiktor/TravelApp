import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void printAllTravels(Travel[] travels) {
        Arrays.sort(travels, Comparator.comparing(t -> {
            if (t.startTime.isAfter(LocalDateTime.now())) {
                return 1; // jeszcze nie rozpoczęta
            } else if (t.startTime.plusMinutes(t.duration).isBefore(LocalDateTime.now())) {
                return -1; // zakończona
            } else {
                return 0; // w trakcie
            }
        }));

        System.out.println("Podróże zakończone:");
        printTravelsByStatus(travels, -1);

        System.out.println("\nPodróże w trakcie:");
        printTravelsByStatus(travels, 0);

        System.out.println("\nPodróże jeszcze nie rozpoczęte:");
        printTravelsByStatus(travels, 1);
    }

    private static void printTravelsByStatus(Travel[] travels, int status) {
        for (Travel travel : travels) {
            int travelStatus;
            if (travel.startTime.isAfter(LocalDateTime.now())) {
                travelStatus = 1; // jeszcze nie rozpoczęta
            } else if (travel.startTime.plusMinutes(travel.duration).isBefore(LocalDateTime.now())) {
                travelStatus = -1; // zakończona
            } else {
                travelStatus = 0; // w trakcie
            }

            if (travelStatus == status) {
                System.out.println("Podróż z " + travel.startCity.name + " do " + travel.endCity.name +
                        " - Status: " + getStatusString(travelStatus));
            }
        }
    }

    private static String getStatusString(int status) {
        switch (status) {
            case -1:
                return "Zakończona";
            case 0:
                return "W trakcie";
            case 1:
                return "Jeszcze nie rozpoczęta";
            default:
                return "Nieznany status";
        }
    }
    public static void main(String[] args) {


            City[] cities = new City[5];
            cities[0] = new City("Krakow", "Poland", ZoneId.of("Europe/Warsaw"));
            cities[1] = new City("Warsaw", "Poland", ZoneId.of("Europe/Warsaw"));
            cities[2] = new City("Berlin", "Germany", ZoneId.of("Europe/Berlin"));
            cities[3] = new City("Moskwa", "Russia", ZoneId.of("Europe/Moscow"));
            cities[4] = new City("Rejkiawik", "Iceland", ZoneId.of("Iceland"));

            Travel[] travels = new Travel[5];
            LocalDateTime now = LocalDateTime.now();
            travels[0] = new BusRide(now.plusHours(1), 120, cities[0], cities[1], 60, 10, "EL99999");
            travels[1] = new CarRide(now.minusMonths(1), 390, cities[0], cities[1], 5, 5, "WW88888");
            travels[2] = new GovernmentFlight(now.minusMinutes(10), 165, cities[0], cities[1], 0, 0, "F123");
            travels[3] = new NormalFlight(now.minusMinutes(30), 240, cities[0], cities[1], 200, 0, "F456");
            travels[4] = new TrainRide(now.plusHours(2), 1200, cities[3], cities[2], 1000, 10, "T2365");

        printAllTravels(travels);
        for (int i = 0; i < travels.length; i++) {
            if (travels[i] instanceof Reservable) {
                try {
                    ((Reservable) travels[i]).reserve(10);
                } catch (NoFreeSeatsException e) {
                    System.out.println("Błąd rezerwacji: " + e.getMessage());
                }
            }
        }
        ((Rentable) travels[2]).rent("Kowalski");

        System.out.println("The same country ("+cities[2].getName()+","+cities[1].getName()+"): "+cities[2].isTheSameCountry(cities[1]));
        System.out.println("The same time ("+cities[2].getName()+","+cities[1].getName()+"): "+cities[2].isTheSameTime(cities[1]));

        printAllTravels(travels);

        System.out.println("The date change - train ride: "+travels[4].doesChangeDate());
        System.out.println("National - bus ride: "+travels[0].isNational());

    }
}