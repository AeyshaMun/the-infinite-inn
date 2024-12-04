package entity;

import java.util.ArrayList;

public class ClientFactory implements ClientFactoryInterface {
    /**
     * Creates a new Client with the given name.
     * @param name the name of the client
     * @return a new Client instance
     */
    @Override
    public Person createClient(String name, String accommodations, ArrayList<Integer> order, EventBooking eventBooking) {
        return new Client(name, accommodations, order, eventBooking);
    }
}