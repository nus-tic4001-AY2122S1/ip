import javafx.application.Application;

/**
 * A Launcher class to workaround classpath issues.
 */
public class Launcher {
    /**
     * The program to start Duke
     * @param args the supplied command-line arguments as an array of String objects
     */
    public static void main(String[] args) {

        Application.launch(Main.class, args);
    }
}
