package jmDNS;

import java.io.IOException;
import java.net.InetAddress;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;

public class CinemaServiceRegistration {

    public static void main(String[] args) throws InterruptedException {

        // Configure logging to show only specific details
        Logger jmdnsLogger = Logger.getLogger("javax.jmdns");
        ConsoleHandler consoleHandler = new ConsoleHandler();
        consoleHandler.setLevel(Level.WARNING); // Change to WARNING to suppress DEBUG logs
        jmdnsLogger.addHandler(consoleHandler);
        jmdnsLogger.setLevel(Level.WARNING); // Change to WARNING to suppress DEBUG logs

        try {
            // Create a JmDNS instance
            JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());
            System.out.println("JmDNS instance created");

            // Register Movie Booking Service
            ServiceInfo bookingServiceInfo = ServiceInfo.create(
                    "_moviebooking._tcp.local.", "Movie Booking Service", 50051, "path=/booking");
            jmdns.registerService(bookingServiceInfo);
            System.out.println("Movie Booking Service registered");

            // Register Cinema Service
            ServiceInfo cinemaServiceInfo = ServiceInfo.create(
                    "_cinemaservice._tcp.local.", "Cinema Service", 50052, "path=/cinema");
            jmdns.registerService(cinemaServiceInfo);
            System.out.println("Cinema Service registered");

            // Register Food and Drinks Service
            ServiceInfo foodServiceInfo = ServiceInfo.create(
                    "_foodanddrinks._tcp.local.", "Food and Drinks Service", 50053, "path=/food");
            jmdns.registerService(foodServiceInfo);
            System.out.println("Food and Drinks Service registered");

            System.out.println("Services are registered. Press enter to exit.");
            System.in.read();

            // Unregister all services
            jmdns.unregisterAllServices();

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
