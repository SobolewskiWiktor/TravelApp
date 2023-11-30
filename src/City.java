import java.sql.Time;
import java.time.ZoneId;
import java.util.TimeZone;

public class City {
    public String name;
    public String country;

    public ZoneId timeZone;

  public City(String name, String country, ZoneId timeZone)
  {
      this.name = name;
      this.country = country;
      this.timeZone = timeZone;
  }

    public boolean isTheSameCountry(City otherCity) {
        return this.country.equals(otherCity.country);
    }

    public String getName() {
      return this.name;
    }

    public boolean isTheSameTime(City otherCity) {
        return this.timeZone.equals(otherCity.timeZone);
    }
}
