package UseCase.signup;

import Entity.Guest;

/**
 * DAO for the Signup Use Case.
 */

public interface SignupUserDataAccessInterface {
    /**
     * Checks if the given username exists.
     * @param username the username to look for
     * @return true if a user with the given username exists; false otherwise
     */
    boolean existsByName(String username);
    void save(Guest username);
}
