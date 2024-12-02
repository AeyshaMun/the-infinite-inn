package entity;

/**
 * Factory for creating Client objects.
 */
public class ClientFactory implements PersonFactory {

    @Override
    public Person create(String name) {
        return new Client(name);
    }
}
