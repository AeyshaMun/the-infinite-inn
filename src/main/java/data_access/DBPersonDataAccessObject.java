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
import entity.Person;

public class DBPersonDataAccessObject {
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

        MongoCollection<Document> collection = database.getCollection("guests");

        Document document = new Document()
                .append("name", person.getName())
                .append("accommodations", person.getAccommodations());

        collection.insertOne(document);
    }

    public static boolean accommodations(Person person) {
        final MongoCollection<Document> collection = database.getCollection("guests");

        final Document filter = new Document("name", person.getName());

        final Document existingGuest = collection.find(filter).first();
        if (existingGuest != null) {
            final String currentAccommodations = existingGuest.getString("accommodations");
            final String newAccommodations = person.getAccommodations();
            final String updatedAccommodations = currentAccommodations + ", " + newAccommodations;

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
}
