package use_case.eventforecast;

import entity.Person;

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
