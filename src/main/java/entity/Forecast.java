package main.java.entity;

public interface Forecast {
    boolean isEstimated();

    String getDescription();

    double getTemperature();

    double getPrecipitation();

    double getWindSpeed();

    boolean isUnsuitableForOutdoor();
}
