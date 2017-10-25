
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author anisha
 */
public class SaveOutput {
    
    private static final String OUTPUT_CSV_FILE = "./output.csv";
    
    public static void writeToCSV(String sortType, long startTime, long endTime, long startMemory, long endMemory) throws IOException {
        try (
            BufferedWriter writer = Files.newBufferedWriter(Paths.get(OUTPUT_CSV_FILE));

            CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT
                    .withHeader("Sorting Type", "Start Time", "End Time", "Duration", "Start Memory", "End Memory", "Memory Used"));
        ) {
            csvPrinter.printRecord(sortType, startTime, endTime, endTime- startTime, startMemory, endMemory, endMemory-startMemory);
            csvPrinter.flush();            
        }
    }
    
}
