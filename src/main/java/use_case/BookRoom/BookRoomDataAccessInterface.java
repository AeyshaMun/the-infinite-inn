package use_case.BookRoom;
import entity.Person;

/**
 * DAO for the BookRoom Use Case.
 */
public interface BookRoomDataAccessInterface {

    void savePerson(Person guest);
}
