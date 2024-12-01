package data_access;

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
import org.bson.Document;
import entity.Guest;

public class DBGuestDataAccessObject {
    /* connect to the database THIS CODE IS FROM MongoDB DOCUMENTATION */
    static MongoDatabase database;

    static {
        String connectionString = "mongodb+srv://olivia:infiniteinn@infiniteinn.tqufq.mongodb.net/?retryWrites=true&w=majority&appName=infiniteinn";

        ServerApi serverApi = ServerApi.builder()
                .version(ServerApiVersion.V1)
                .build();

        MongoClientSettings settings = MongoClientSettings.builder()
                .applyConnectionString(new ConnectionString(connectionString))
                .serverApi(serverApi)
                .build();

        try (MongoClient mongoClient = MongoClients.create(settings)) {
            try {
                database = mongoClient.getDatabase("admin");
                database.runCommand(new Document("ping", 1));
                System.out.println("Pinged your deployment. You successfully connected to MongoDB!");
            }
            catch (MongoException e) {
                e.printStackTrace();
            }
        }
    }

    public static void saveGuest(Guest guest){
        MongoCollection<Document> collection = database.getCollection("guests");

        Document document = new Document()
                .append("name", guest.getName())
                .append("accommodations", guest.getAccommodations());

        collection.insertOne(document);
    }
    public static void Accommodations(Person person) {
        MongoCollection<Document> collection = database.getCollection("guests");

        Document filter = new Document("name", person.getName());

        Document existingGuest = collection.find(filter).first();
        if (existingGuest != null) {
            String currentAccommodations = existingGuest.getString("accommodations");
            String newAccommodations = person.getAccommodations();
            String updatedAccommodations = currentAccommodations + ", " + newAccommodations;

            Document update = new Document("$set", new Document("accommodations", updatedAccommodations));

            try {
                collection.updateOne(filter, update);
            } catch (MongoException e) {
                e.printStackTrace();
            }
        }
    }
}
