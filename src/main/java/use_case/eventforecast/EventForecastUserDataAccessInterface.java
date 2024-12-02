package main.java.use_case.eventforecast;

import main.java.entity.EventBooking;

/**
 * DAO for the Event Details Use Case.
 */
public interface EventForecastUserDataAccessInterface {
    /**
     * Saves the user.
     * @param eventBooking the user to save
     */
    void save(EventBooking eventBooking);
}
