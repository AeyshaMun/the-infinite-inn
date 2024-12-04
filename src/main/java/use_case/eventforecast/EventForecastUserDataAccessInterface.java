package main.java.use_case.eventforecast;

import main.java.entity.Person;

/**
 * DAO for the Event Details Use Case.
 */
public interface EventForecastUserDataAccessInterface {
    /**
     * Saves the user.
     * @param person the user to save
     */
    void savePerson(Person person);
}
