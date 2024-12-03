package main.java.use_case.BookRoom;
import main.java.entity.Person;

/**
 * DAO for the BookRoom Use Case.
 */
public interface BookRoomDataAccessInterface {

    void savePerson(Person guest);
}
