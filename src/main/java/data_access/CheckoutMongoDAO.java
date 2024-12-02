package data_access;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import org.bson.Document;
import use_case.checkout.CheckoutUserDAI;

public class CheckoutMongoDAO implements CheckoutUserDAI {
    private MongoCollection<Document> guestsCollection;
    private MongoCollection<Document> clientsCollection;

    public CheckoutMongoDAO() {
        // Use the existing database connection from DBGuestDataAccessObject
        this.guestsCollection = DBGuestDataAccessObject.database.getCollection("guests");
        this.clientsCollection = DBGuestDataAccessObject.database.getCollection("clients");
    }

    @Override
    public boolean findUserByNameAndRoom(String name, int roomNumber, boolean isEventHall) {
        if (isEventHall) {
            // Check if client exists with this event hall
            Document client = clientsCollection.find(
                    Filters.and(
                            Filters.eq("name", name),
                            Filters.eq("eventHall", roomNumber)
                    )
            ).first();
            return client != null;
        } else {
            // Check if guest exists with this room number
            Document guest = guestsCollection.find(
                    Filters.and(
                            Filters.eq("name", name),
                            Filters.eq("accommodations.roomNumber", roomNumber)
                    )
            ).first();
            return guest != null;
        }
    }

    @Override
    public boolean removeUserAndRoom(String name, int roomNumber, boolean isEventHall) {
        try {
            if (isEventHall) {
                // Remove client information for event hall
                long deletedCount = clientsCollection.deleteOne(
                        Filters.and(
                                Filters.eq("name", name),
                                Filters.eq("eventHall", roomNumber)
                        )
                ).getDeletedCount();

                return deletedCount > 0;
            } else {
                // Remove guest information and room association
                long deletedCount = guestsCollection.deleteOne(
                        Filters.and(
                                Filters.eq("name", name),
                                Filters.eq("accommodations.roomNumber", roomNumber)
                        )
                ).getDeletedCount();

                return deletedCount > 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}

//not sure DAO