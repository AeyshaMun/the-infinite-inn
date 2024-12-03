package data_access;

import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class DBTest {

    public static void main(String[] args) {
        testDatabaseConnection();
    }

    public static void testDatabaseConnection() {
        MongoDatabase database = DBPersonDataAccessObject.database;

        if (database != null) {
            Document ping = new Document("ping", 1);
            Document result = database.runCommand(ping);

            if (result != null && result.get("ok") instanceof Number) {
                double okValue = ((Number) result.get("ok")).doubleValue();
                if (okValue == 1.0) {
                    System.out.println("Database connection test passed.");
                } else {
                    System.out.println("Database connection test failed.");
                }
            } else {
                System.out.println("Database connection test failed.");
            }
        } else {
            System.out.println("Database connection test failed: database is null.");
        }
    }
}