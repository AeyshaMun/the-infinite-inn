package entity;

public class ClientFactory {
    /**
     * Creates a new Client with the given name.
     * @param name the name of the client
     * @return a new Client instance
     */
    public Client create(String name) {
        return new Client(name);
    }
}
