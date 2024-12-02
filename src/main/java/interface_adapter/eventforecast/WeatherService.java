package interface_adapter.eventforecast;

import entity.EventForecast;

public class WeatherService {
    private final String apiKey;
    private final String apiBaseUrl;

    public WeatherService(String apiKey, String apiBaseUrl) {
        this.apiKey = apiKey;
        this.apiBaseUrl = apiBaseUrl;
    }

    public EventForecast fetchWeatherForecast(String date) throws IOException {
        // Construct API URL
        String apiUrl = apiBaseUrl + "/weather?location=Zurich&date=" + date + "&key=" + apiKey;

        // Send HTTP GET request
        String jsonResponse = sendHttpRequest(apiUrl);

        // Parse the response
        return parseWeatherResponse(jsonResponse);
    }

    private String sendHttpRequest(String apiUrl) throws IOException {
        // Simplified HTTP GET logic (use HttpClient or another library)
        URL url = new URL(apiUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            return response.toString();
        }
    }

    private EventForecast parseWeatherResponse(String response) {
        // Parse the JSON response
        JSONObject jsonResponse = new JSONObject(response);
        JSONArray days = jsonResponse.getJSONArray("days");
        JSONObject forecastDay = days.getJSONObject(0);

        // Extract relevant fields
        String description = forecastDay.getString("conditions");
        double temp = forecastDay.getDouble("temp");
        double precip = forecastDay.getDouble("precip");
        double windSpeed = forecastDay.optDouble("windspeed", 0.0); // Optional
        String source = forecastDay.getString("source");

        // Check if the forecast is estimated
        boolean isEstimated = source.equalsIgnoreCase("forecast");

        return new EventForecast(description, temp, precip, windSpeed, isEstimated);
    }
}
