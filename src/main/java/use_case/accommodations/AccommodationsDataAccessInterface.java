package use_case.accommodations;

import entity.Person;

public interface AccommodationsDataAccessInterface {
    /**
     * Updates the system to record this person's accommodations.
     * @param name the name of the person whose accommodations is to be updated
     */

    boolean accommodationsByName(String name, String accommodations);

    boolean existsByName(String name);
}
