/**
 *
 */
package eapli.base;

/**
 * A "global" static class with the application registry of well known objects
 *
 * @author Paulo Gandra Sousa
 *
 */
public class
Application {

    public static final String VERSION = "5.0.0";
    public static final String COPYRIGHT = "(4P) 2020 - 2021, LAPR4 Group 1";

    private static final AppSettings SETTINGS = new AppSettings();

    public static AppSettings settings() {
        return SETTINGS;
    }

    private Application() {
        // private visibility to ensure singleton & utility
    }
}
