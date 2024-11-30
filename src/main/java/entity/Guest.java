package entity;

import data_access.DBGuestDataAccessObject;

public class Guest implements Person {
    // note to self: make these protected attributes
    private final String name;
    private final String accommodations;

    public Guest(String name, String email) {
        this.name = name;
        this.accommodations = "";

        DBGuestDataAccessObject.saveGuest(this);
    }

    public String getName() {
        return name;
    }


    public String getAccommodations() {
        return accommodations;
    }

}


