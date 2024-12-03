package use_case.eventdetails;

import entity.Person;

/**
 * DAO for the Event Details Use Case.
 */
public interface EventDetailsUserDataAccessInterface {
    /**
     * Checks if the given client name exists.
     * @param name the name to look for
     * @return true if a client with the given name exists; false otherwise
     */
    boolean existsByName(String name);
}
