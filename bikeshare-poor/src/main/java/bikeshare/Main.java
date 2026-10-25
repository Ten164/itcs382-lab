package bikeshare;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static Map<String, Integer> stations = new HashMap<>();
    public static Map<String, String> rentedBikes = new HashMap<>();

    public static void main(String[] args) {
        stations.put("Library", 2);
        stations.put("Canteen", 2);
        stations.put("Dorm", 2);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Commands: rent <memberId> <type:1=student,2=staff> <station>, return <station> <minutes>, quit");

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine().trim();
            if (line.equalsIgnoreCase("quit")) {
                break;
            }
            String[] parts = line.split(" ");
            if (parts[0].equalsIgnoreCase("rent") && parts.length == 4) {
                String memberId = parts[1];
                int type = Integer.parseInt(parts[2]);
                String station = parts[3];
                processBikeAction(true, memberId, type, station, 0);
            } else if (parts[0].equalsIgnoreCase("return") && parts.length == 3) {
                String station = parts[1];
                int minutes = Integer.parseInt(parts[2]);
                processBikeAction(false, parts.length > 3 ? parts[3] : "unknown", 1, station, minutes);
            }
        }
        scanner.close();
    }

    public static void processBikeAction(boolean isRent, String memberId, int type, String station, int minutes) {
        if (isRent) {
            int bikes = stations.getOrDefault(station, 0);
            if (bikes > 0) {
                stations.put(station, bikes - 1);
                rentedBikes.put(memberId, station);
                System.out.println("Rented bike at " + station);
            } else {
                System.out.println("No bikes available at " + station);
            }
        } else {
            int bikes = stations.getOrDefault(station, 0);
            stations.put(station, bikes + 1);
            double fee = minutes * (type == 1 ? 2.0 : 3.0);
            System.out.println("Receipt: Station " + station + ", Minutes: " + minutes + ", Fee: " + fee + " baht");
            
            try (FileWriter writer = new FileWriter("rides.csv", true)) {
                writer.write(station + "," + minutes + "," + fee + "\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}