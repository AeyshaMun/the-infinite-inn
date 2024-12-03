package use_case.login;

import entity.Guest;

/**
 * DAO for the Login Use Case.
 */
public interface LoginDataAccessInterface {

    /**
     * Checks if the given name exists.
     * @param name the name to look for
     * @return true if a guest with the given name exists; false otherwise
     */
    boolean existsByName(String name);

    /**
     * Saves the guest.
     * @param guest the guest to save
     */
    void save(Guest guest);

    /**
     * Returns the guest with the given name.
     * @param roomNumber
     * @return the guest with the given room number
     */

    boolean roomExists(int roomNumber);

    void setCurrentGuest(String name);

    String getName(int roomNumber);
}
