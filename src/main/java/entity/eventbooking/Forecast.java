package main.java.entity.eventbooking;

public interface Forecast {
    boolean isEstimated();

    String getDescription();

    double getTemperature();

    double getPrecipitation();

    double getWindSpeed();
}
