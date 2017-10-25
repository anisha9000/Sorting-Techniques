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
        readListingFile();
    }

    public static void readListingFile() {
        
        String fileName = new File("").getAbsolutePath()+"/src/nsn.csv";

        FileReader fileReader = null;
        CSVParser csvFileParser = null;

        String[] FILE_HEADER_MAPPING = {"Price"};

        //Create the CSVFormat object with the header mapping
        CSVFormat csvFileFormat = CSVFormat.DEFAULT.withHeader(FILE_HEADER_MAPPING);

        try {
            ArrayList<Double> prices = new ArrayList();
            fileReader = new FileReader(fileName);
            csvFileParser = new CSVParser(fileReader, csvFileFormat);
            List csvRecords = csvFileParser.getRecords();

            System.out.println(csvRecords.size());
            
            for (int i = 1; i < csvRecords.size(); i++) {
                CSVRecord record = (CSVRecord) csvRecords.get(i);
                prices.add(Double.parseDouble(record.get("Price")));
            }

            //Print the new student list
            /*for (Double price : prices) {
                System.out.println(price);
            }*/
            
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

    }

}
