package main.java.entity;

public class EventForecastFactory implements ForecastFactory {
    @Override
    public Forecast createForecast(String description, double temperature, double precipitation, double windSpeed, boolean isEstimated) {
        return new EventForecast(description, temperature, precipitation, windSpeed, isEstimated);
    }
}
