package main.java.entity.eventbooking;

public interface ForecastFactory {
    Forecast createForecast(String description, double temperature, double precipitation, double windSpeed, boolean isEstimated);
}
