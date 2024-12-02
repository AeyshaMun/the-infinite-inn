package use_case.accommodations;

import entity.Person;

public  interface AccommodationsDataAccessInterface {
    /**
     * Updates the system to record this person's accommodations.
     * @param person the person whose accommodations is to be updated
     */

    void accommodations(Person person);

}
