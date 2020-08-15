package exception;

public class InvalidCityException extends Exception{
    public InvalidCityException(String cityName) {
        super("Unable to geocode the city with name" + cityName);
    }
}
