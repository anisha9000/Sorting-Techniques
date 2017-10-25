/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.File;
import java.util.*;
import java.io.FileReader;
import java.io.IOException;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

/**
 *
 * @author anisha
 */
public class ReadInput {

    public static void main(String[] args) {
        System.out.println("\nRead CSV file:");
        
    }

    public static double[] readListingFile() {
        
        String fileName = new File("").getAbsolutePath()+"/src/listings.csv";

        FileReader fileReader = null;
        CSVParser csvFileParser = null;

        String[] FILE_HEADER_MAPPING = {"price"};

        //Create the CSVFormat object with the header mapping
        CSVFormat csvFileFormat = CSVFormat.DEFAULT.withHeader(FILE_HEADER_MAPPING);

        ArrayList<Double> prices = new ArrayList();
        try {
            
            fileReader = new FileReader(fileName);
            csvFileParser = new CSVParser(fileReader, csvFileFormat);
            List csvRecords = csvFileParser.getRecords();

            System.out.println(csvRecords.size());
            
            for (int i = 1; i < csvRecords.size(); i++) {
                CSVRecord record = (CSVRecord) csvRecords.get(i);
                prices.add(Double.parseDouble(record.get("price")));
            }

            
            System.out.println(prices.size());
        } catch (Exception e) {
            System.out.println("Error in CsvFileReader !!!");
            e.printStackTrace();
        } finally {
            try {
                fileReader.close();
                csvFileParser.close();
            } catch (IOException e) {
                System.out.println("Error while closing fileReader/csvFileParser !!!");
                e.printStackTrace();
            }
        }
        double[] arr = prices.stream().mapToDouble(Double::doubleValue).toArray();
        return arr;
    }

}
