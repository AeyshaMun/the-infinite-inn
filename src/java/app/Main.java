package app;

import javax.swing.JFrame;

/**
 * The Main class of our application.
 */
public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // Instantiate AppBuilder
            AppBuilder appBuilder = new AppBuilder();
            // Initialize views and build the application
            JFrame application = appBuilder.initializeViews().build();
            // Set the application frame visible
            application.setVisible(true);
        });
    }
}
