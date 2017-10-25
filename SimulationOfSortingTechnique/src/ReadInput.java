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

    public static ArrayList<Double> readCSV(String fileName, 
            String[] FileHeaderMapping, String colName, int dataSize) {
        
        FileReader fileReader = null;
        CSVParser csvFileParser = null;

        //Create the CSVFormat object with the header mapping
        CSVFormat csvFileFormat = CSVFormat.DEFAULT.withHeader(FileHeaderMapping);

        ArrayList<Double> records = new ArrayList();
        try {
            
            fileReader = new FileReader(fileName);
            csvFileParser = new CSVParser(fileReader, csvFileFormat);
            List csvRecords = csvFileParser.getRecords();

            System.out.println(csvRecords.size());
            
            for (int i = 1; i <= dataSize; i++) {
                CSVRecord record = (CSVRecord) csvRecords.get(i);
                records.add(Double.parseDouble(record.get(colName)));
            }

            
            System.out.println(records.size());
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
        
        
        return records;
    }
    
    public static ArrayList<Double> readHealthFile(int dataSize) {
        
        String fileName = new File("").getAbsolutePath()+"/src/Better_Health.csv";
        String[] fileHeaderMapping = {"Data_Value"};
        return readCSV(fileName, fileHeaderMapping, "Data_Value", dataSize);
    }
    
    public static ArrayList<Double> readComplaintFile(int dataSize) {
        
        String fileName = new File("").getAbsolutePath()+"/src/Consumer_Complaints.csv";
        String[] fileHeaderMapping = {"Data_Value"};
        return readCSV(fileName, fileHeaderMapping, "Data_Value", dataSize);
    }

    
}
