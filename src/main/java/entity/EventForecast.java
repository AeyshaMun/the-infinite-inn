package entity;

public class EventForecast {
    private final String description;
    private final double temperature;
    private final double precipitation;
    private final double windSpeed;
    private final boolean isEstimated;

    public EventForecast(String description, double temperature, double precipitation, double windSpeed, boolean isEstimated) {
        this.description = description;
        this.temperature = temperature;
        this.precipitation = precipitation;
        this.windSpeed = windSpeed;
        this.isEstimated = isEstimated;
    }

    public boolean isEstimated() {
        return isEstimated;
    }

    public String getDescription() {
        return description;
    }

    public double getTemperature() {
        return temperature;
    }

    public double getPrecipitation() {
        return precipitation;
    }

    public double getWindSpeed() {
        return windSpeed;
    }

    public boolean isUnsuitableForOutdoor() {
        return precipitation > 1.0 ||
                temperature < 10.0 || temperature > 35.0 ||
                windSpeed > 20.0 ||
                description.contains("Thunderstorm") || description.contains("Snow");
    }

}

