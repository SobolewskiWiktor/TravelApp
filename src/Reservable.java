public interface Reservable {
     void reserve(int numberOfSeats) throws NoFreeSeatsException;
}
