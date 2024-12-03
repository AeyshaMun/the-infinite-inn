package main.java.use_case.BookRoom;
import main.java.entity.Suite;

/**
 * DAO for the BookRoom Use Case.
 */
public interface BookRoomDataAccessInterface {

    void save(Suite suite);
}
