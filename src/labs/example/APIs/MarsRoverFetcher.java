package labs.example.APIs;  // fix package to match folder path

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URI; // add this for new URL construction

public class MarsRoverFetcher {

    private static final String API_KEY = "9ocGo6KkwVjSemuihx2KAlrFITgFYegjdKCDshHa";
    private static final String API_URL = "https://api.nasa.gov/mars-photos/api/v1/rovers/curiosity/photos?sol=1000&camera=rhaz&api_key=" + API_KEY;
    private static final String OUTPUT_FILE = "src/labs/example/APIs/json/nasa.json";

    public static void main(String[] args) {
        try {
            fetchAndSaveJson();
            searchForImageUrl("mars.jpl.nasa.gov/msl-raw-images/proj/msl/redops/ods/surface/sol/01000/opgs/edr/rcam/RRB_486265291EDR_F0481570RHAZ00323M_.JPG");
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    private static void fetchAndSaveJson() throws IOException {
        URI uri = URI.create(API_URL);
        URL url = uri.toURL();  // updated to avoid deprecated warning

        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        File outputFolder = new File("src/labs/example/APIs/json");
        if (!outputFolder.exists()) {
            outputFolder.mkdirs();
        }
        BufferedWriter writer = new BufferedWriter(new FileWriter(OUTPUT_FILE));

        String line;
        while ((line = reader.readLine()) != null) {
            writer.write(line);
            writer.newLine();
        }

        writer.close();
        reader.close();
        connection.disconnect();

        System.out.println("JSON response saved to nasa.json");
    }

    private static void searchForImageUrl(String targetUrlPart) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(OUTPUT_FILE));
        String line;
        int lineNumber = 1;
        boolean found = false;

        while ((line = reader.readLine()) != null) {
            if (line.contains(targetUrlPart)) {
                System.out.println("\nNASA API Endpoint ---> Mars Rover Photos");
                System.out.println("Camera ---> Front Hazard Avoidance Camera");
                System.out.println("Found on line ---> " + lineNumber);
                found = true;
                break;
            }
            lineNumber++;
        }
        reader.close();

        if (!found) {
            System.out.println("Image URL pattern not found in the JSON.");
        }
    }
}
