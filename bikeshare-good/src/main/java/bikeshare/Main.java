package bikeshare;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

enum MemberType { STUDENT, STAFF }

interface RideRepository {
    void saveRide(String station, int minutes, double fee);
}

class CsvRideRepository implements RideRepository {
    @Override
    public void saveRide(String station, int minutes, double fee) {
        try (FileWriter writer = new FileWriter("rides.csv", true)) {
            writer.write(station + "," + minutes + "," + fee + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class StationManager {
    private Map<String, Integer> stations = new HashMap<>();

    public StationManager() {
        stations.put("Library", 2);
        stations.put("Canteen", 2);
        stations.put("Dorm", 2);
    }

    public boolean rentBike(String station) {
        int bikes = stations.getOrDefault(station, 0);
        if (bikes > 0) {
            stations.put(station, bikes - 1);
            return true;
        }
        return false;
    }

    public void returnBike(String station) {
        int bikes = stations.getOrDefault(station, 0);
        stations.put(station, bikes + 1);
    }
}

class FeeCalculator {
    public static double calculate(MemberType type, int minutes) {
        return minutes * (type == MemberType.STUDENT ? 2.0 : 3.0);
    }
}

public class Main {
    public static void main(String[] args) {
        StationManager manager = new StationManager();
        RideRepository repository = new CsvRideRepository();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Commands: rent <memberId> <type: STUDENT/STAFF> <station>, return <station> <minutes>, quit");

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine().trim();
            if (line.equalsIgnoreCase("quit")) break;

            String[] parts = line.split(" ");
            if (parts[0].equalsIgnoreCase("rent") && parts.length == 4) {
                boolean success = manager.rentBike(parts[3]);
                System.out.println(success ? "Rented bike at " + parts[3] : "No bikes available");
            } else if (parts[0].equalsIgnoreCase("return") && parts.length == 3) {
                String station = parts[1];
                int minutes = Integer.parseInt(parts[2]);
                manager.returnBike(station);
                double fee = FeeCalculator.calculate(MemberType.STUDENT, minutes);
                System.out.println("Receipt: Station " + station + ", Minutes: " + minutes + ", Fee: " + fee + " baht");
                repository.saveRide(station, minutes, fee);
            }
        }
        scanner.close();
    }
}