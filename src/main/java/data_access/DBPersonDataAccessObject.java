package data_access;

import org.bson.Document;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.MongoException;
import com.mongodb.ServerApi;
import com.mongodb.ServerApiVersion;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import entity.*;
import org.bson.Document;
import use_case.BookRoom.BookRoomDataAccessInterface;
import use_case.accommodations.AccommodationsDataAccessInterface;
import use_case.checkout.CheckoutUserDataAccessInterface;
import use_case.eventdetails.EventDetailsUserDataAccessInterface;
import use_case.eventforecast.EventForecastUserDataAccessInterface;
import use_case.login.LoginDataAccessInterface;
import use_case.place_order.PlaceOrderDataAccessInterface;

import java.util.ArrayList;

public class DBPersonDataAccessObject implements AccommodationsDataAccessInterface, BookRoomDataAccessInterface, CheckoutUserDataAccessInterface, EventDetailsUserDataAccessInterface, EventForecastUserDataAccessInterface, PlaceOrderDataAccessInterface, LoginDataAccessInterface {
    /**
     * Connects to the database.
     * this code is from MongoDB's documentation.
     * **/

    static MongoDatabase database;
    static MongoClient mongoClient;
    static {
        String connectionString =
                "mongodb+srv://olivia:infiniteinn@infiniteinn.tqufq.mongodb.net/?retryWrites="
                        +
                        "true&w=majority&appName=infiniteinn";

        ServerApi serverApi = ServerApi.builder()
                .version(ServerApiVersion.V1)
                .build();

        MongoClientSettings settings = MongoClientSettings.builder()
                .applyConnectionString(new ConnectionString(connectionString))
                .serverApi(serverApi)
                .build();

        mongoClient = MongoClients.create(settings);
        try {
            database = mongoClient.getDatabase("admin");
            database.runCommand(new Document("ping", 1));
            System.out.println("Pinged your deployment. You successfully connected to MongoDB!");
        }
        catch (MongoException e) {
            e.printStackTrace();
        }
    }
    /**
     * Saves a person to the database.
     * @param person the person to be saved
     */

    public static void savePerson(Person person) {

    @Override
    public boolean existsByName(String name) {
        // Get the MongoDB collection
        MongoCollection<Document> collection = database.getCollection("guests");

        // Create a filter to find a person by their unique fields
        Document filter = new Document("name", name);

        // Query the database for a matching document
        Document existingPerson = collection.find(filter).first();

        // Return true if a match is found, otherwise false
        return existingPerson != null;
    }

    @Override
    public void save(Guest guest) {

    }

    @Override
    public boolean roomExists(int roomNumber) {
        // Get the MongoDB collection
        MongoCollection<Document> collection = database.getCollection("guests");

        // Create a filter to find a person by their unique fields
        Document filter = new Document("room number", roomNumber);

        // Query the database for a matching document
        Document existingRoom = collection.find(filter).first();

        // Return true if a match is found, otherwise false
        return existingRoom != null;
    }

    @Override
    public void setCurrentGuest(String name) {

    }

    @Override
    public String getName(int roomNumber) {
        // Get the MongoDB collection
        MongoCollection<Document> collection = database.getCollection("guests");

        // Create a filter to find the user by roomNumber
        Document filter = new Document("room number", roomNumber);

        // Query the database for the first matching document
        Document document = collection.find(filter).first();

        // Return the name if the document exists, otherwise null
        if (document != null) {
                return document.getString("name");
        }
        return null; // Return null if no document is found
    }

    @Override
    public void savePerson(Person person){
        MongoCollection<Document> collection = database.getCollection("guests");

        // Create the base document with common fields
        Document document = new Document()
                .append("name", person.getName())
                .append("accommodations", person.getAccommodations())
                .append("order", person.getOrder())
                .append("amount due", person.getPrice())
                .append("room number", person.getRoomNumber());

        // Check the type of the person and append additional information
        if (person instanceof Guest) {
            Guest guest = (Guest) person;
            document.append("person type", "guest")
                    .append("room type", guest.getRoomType());
        } else if (person instanceof Client) {
            Client client = (Client) person;

            String location;

            if (client.isIndoor()) {
                location = "Indoors";
            }
            else {
                location = "Outdoors";
            }

            document.append("person type", "client")
                    .append("event date", client.getEventDate()) // Example field for Client
                    .append("party size", client.getPartySize())
                    .append("indoors/outdoors", location); // Example field for Client
        }

        collection.insertOne(document);
    }

    @Override
    public boolean accommodationsByName(String name, String accommodations) {
        MongoCollection<Document> collection = database.getCollection("guests");

        Document filter = new Document("name", name);

        final Document existingGuest = collection.find(filter).first();
        if (existingGuest != null) {
            String currentAccommodations = existingGuest.getString("accommodations");
            String newAccommodations = accommodations;
            String updatedAccommodations = currentAccommodations + ", " + newAccommodations;

            final Document update = new Document("$set", new Document("accommodations", updatedAccommodations));

            try {
                collection.updateOne(filter, update);
                return true;
            }
            catch (MongoException exception) {
                exception.printStackTrace();
            }
        }
        return false;
    }


    @Override
    public void save(Room suite) {

    }

    @Override
    public boolean removeUser(String name, int roomNumber) {
        // Get the MongoDB collection
        MongoCollection<Document> collection = database.getCollection("guests");

        // Create a filter to match by name or roomNumber
        Document filter = new Document();
        filter.append("name", name)
                .append("roomNumber", roomNumber);

        // Delete the user and get the result
        long deletedCount = collection.deleteOne(filter).getDeletedCount();

        // Return true if a document was deleted, otherwise false
        return deletedCount > 0;
    }

    @Override
    public boolean saveOrder(ArrayList<Integer> items, int room) {
        MongoCollection<Document> collection = database.getCollection("guests");

        Document filter = new Document("room", room);

        Document existingRoom = collection.find(filter).first();
        if (existingRoom != null) {
            String currentOrder = existingRoom.getString("order");
            ArrayList<Integer> order = items;

            Document update = new Document("$set", new Document("order", order));

            try {
                collection.updateOne(filter, update);
                return true;
            } catch (MongoException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public ArrayList<Integer> getOrder(int room) {
        // Get the MongoDB collection
        MongoCollection<Document> collection = database.getCollection("guests");

        // Create a filter to find the user by roomNumber
        Document filter = new Document("order", room);

        // Query the database for the first matching document
        Document document = collection.find(filter).first();

        // Return the name if the document exists, otherwise null
        if (document != null) {
            ArrayList<Integer> result = convertStringToArrayList(document.getString("order"), ",");
            return result;
        }
        return null; // Return null if no document is found
    }

    public static ArrayList<Integer> convertStringToArrayList(String str, String delimiter) {
        ArrayList<Integer> result = new ArrayList<>();

        // Split the string into an array of substrings using the delimiter
        String[] parts = str.split(delimiter);

        // Convert each substring to an Integer and add to the ArrayList
        for (String part : parts) {
            try {
                result.add(Integer.parseInt(part.trim())); // Trim and parse to avoid errors
            } catch (NumberFormatException e) {
                System.out.println("Invalid number: " + part);
            }
        }

        return result;
    }
}
