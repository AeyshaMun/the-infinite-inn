package main.java.entity;

public interface ForecastFactory {
    Forecast createForecast(String description, double temperature, double precipitation, double windSpeed, boolean isEstimated);
}
