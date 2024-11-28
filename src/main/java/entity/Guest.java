package entity;


import data_access.DBGuestDataAccessObject;

public class Guest {
    // note to self: make these protected attributes
    protected String name;
    protected String email;
    protected String accommodations;

    public Guest(String name, String email) {
        this.name = name;
        this.email = email;
        this.accommodations = "";

        DBGuestDataAccessObject.saveGuest(this);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAccommodations() {
        return accommodations;
    }

    public void setAccommodations(String accommodations) {
        this.accommodations = accommodations;
    }

    }


/* Pseudocode for planning
    full name, email, phone number
    both classes will need to potentially have an invoice associated or food service associated
child class innGuest
    foodservice(?), accommodations, room number,

child class eventGuest
 -

 Meeting Notes:

 EventGuest
 event
 invoice
 party number


*/

