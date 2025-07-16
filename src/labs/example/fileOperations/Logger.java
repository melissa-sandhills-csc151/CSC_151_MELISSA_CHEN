package labs.example.fileOperations;

import java.io.*;
import java.util.ArrayList;

public class Logger {

    private static final String LOG_FILE_PATH = "src/labs/example/fileOperations/logs/api_error.log";

    public static void main(String[] args) { //reads the file twices for different purposes (closes before reopening)
        try {
            // 1 & 2: Open file and get BufferedReader
            BufferedReader file1 = openErrorLog();

            // 3 & 4: Count log levels
            getCountOfErrorTypes(file1);
            file1.close();

            // 5: Re-open file
            BufferedReader file2 = openErrorLog();

            // 6: Count "memory limit exceeded" messages and endpoints
            getMemoryLimitExceededCount(file2);
            file2.close();

        } catch (IOException e) { //prints error message if something's wrong with file handling
            System.out.println("An error occurred: " + e.getMessage());
        }
    }

    // Opens the log file and returns a BufferedReader
    public static BufferedReader openErrorLog() throws FileNotFoundException {
        File logFile = new File(LOG_FILE_PATH);
        return new BufferedReader(new FileReader(logFile));
    }

    //  Count log types [ERROR], [WARN], [INFO], [DEBUG]
    public static void getCountOfErrorTypes(BufferedReader reader) throws IOException {
        int errorCount = 0, warnCount = 0, infoCount = 0, debugCount = 0; // initializing 
        String line;

        while ((line = reader.readLine()) != null) {
            if (line.contains("[ERROR]")) errorCount++;
            if (line.contains("[WARN]")) warnCount++;
            if (line.contains("[INFO]")) infoCount++;
            if (line.contains("[DEBUG]")) debugCount++;
        }

        //display final counts
        System.out.println("Log Level Counts:");
        System.out.println("ERROR: " + errorCount);
        System.out.println("WARN: " + warnCount);
        System.out.println("INFO: " + infoCount);
        System.out.println("DEBUG: " + debugCount);
        System.out.println();
    }

    // Count memory limit exceeded errors and show endpoints
    private static void getMemoryLimitExceededCount(BufferedReader reader) throws IOException {
        ArrayList<String> endpoints = new ArrayList<>(); // Stores endpoints that triggered memory errors
        int count = 0;
        String line;

        while ((line = reader.readLine()) != null) {
            if (line.toLowerCase().contains("memory limit exceeded")) {
                count++; // add total count of memory limit errors

                // Extract the endpoint (text after "| Endpoint:")
                int pipeIndex = line.indexOf("| Endpoint:");
                if (pipeIndex != -1) {
                    String endpoint = line.substring(pipeIndex + 11).trim();
                    endpoints.add(endpoint);
                }
            }
        }

        //shows result
        System.out.println("Memory Limit Exceeded Count: " + count);
        System.out.println("Affected Endpoints:");
        for (String endpoint : endpoints) {
            System.out.println(" - " + endpoint);
        }
    }
}
