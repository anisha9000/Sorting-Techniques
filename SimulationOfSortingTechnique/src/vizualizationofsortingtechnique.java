
import SortingAlgorithms.SelectionSort;
import SortingAlgorithms.QuickSort;
import SortingAlgorithms.InsertionSort;
import SortingAlgorithms.BubbleSort;
import SortingAlgorithms.MergeSort;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import Vizualization.LaunchFrame;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author anisha
 */
public class vizualizationofsortingtechnique {

    static final long MEGABYTE = 1024L * 1024L;

    //Object creation
    static MergeSort mergeSort = new MergeSort();
    static QuickSort quickkSort = new QuickSort();
    static SelectionSort selectSort = new SelectionSort();
    static BubbleSort bubbleSort = new BubbleSort();
    static InsertionSort insertionSort = new InsertionSort();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {

        DegSorted degSorted = new DegSorted();
        LaunchFrame sortFrame = new LaunchFrame(null, 30);
        sortFrame.launchSortFrame(30);
        
//        int dataSize = 10000;
//        for (int dataCounter = 1; dataCounter <= 5; dataCounter++) {
//            for (int iteration = 0; iteration < 5; iteration++) {
//                System.out.println("Iteration:" + iteration);
//                double array[] = generateData(3, dataSize);
//                for (int sortType = 1; sortType <= 5; sortType++) {
//                    computeSorting(array, sortType, -1);
//                }
//
//            }
//            dataSize += 10000;
//        }

//        int dataSize = 15000;
//        double degreeSortedness = 0.25;
//        for (int degreeCounter = 1; degreeCounter <= 2; degreeCounter++) {
//            for (int iteration = 0; iteration < 5; iteration++) {
//                System.out.println("Iteration:" + iteration);
//                double array[] = generateData(3, dataSize);
//                array = degSorted.partialSort(array, degreeSortedness);
//                for (int sortType = 1; sortType <= 5; sortType++) {
//                    computeSorting(array, sortType, degreeSortedness);
//                }
//            }
//            degreeSortedness *= 2;
//        }
//
//        degreeSortedness = 0;
//        for (int iteration = 0; iteration < 5; iteration++) {
//            System.out.println("Iteration:" + iteration);
//            double array[] = generateData(3, dataSize);
//            array = degSorted.reverseSort(array);
//            for (int sortType = 1; sortType <= 5; sortType++) {
//                computeSorting(array, sortType, degreeSortedness);
//            }
//        }

    }

    private static double[] generateData(int i, int dataSize) {
        /* Generating data set containing uniformly distributed random Double values using ThreadLocalRandom*/

        GenSynDataSet data = new GenSynDataSet();
        ReadInput realInput = new ReadInput();
        double[] arr2 = null;
        switch (i) {
            case 0:
                /*usage: genRandom(no. of datapoints, min value, max value)*/
                arr2 = data.genRandom(dataSize, 1, 1000);
                return arr2;
            case 1:
                /*usage: genGaussian(no. of datapoints, mean value, variance value)*/
                arr2 = data.genGaussian(dataSize, 100.0, 5.0);
                return arr2;
            case 2:
                List<Double> records = realInput.readHealthFile(dataSize);
                Collections.shuffle(records);
                arr2 = records.stream().mapToDouble(Double::doubleValue).toArray();
                return arr2;
            case 3:
                records = realInput.readComplaintFile(dataSize);
                Collections.shuffle(records);
                arr2 = records.stream().mapToDouble(Double::doubleValue).toArray();
                return arr2;
        }
        return arr2;
    }

    private static long getMemory(Runtime runtime) {
        return runtime.totalMemory() - runtime.freeMemory();
    }

    private static void computeSorting(double[] array, int sortType, 
            double degreeSortedness) throws IOException {
        long startTime = System.currentTimeMillis();
        Runtime runtime = Runtime.getRuntime();
        runtime.gc();
        long startMemory = getMemory(runtime);
        String sortTypeStr = null;
        double[] array_temp = array.clone();

        switch (sortType) {
            case 1:
                //Bubble Sort
                sortTypeStr = "Bubble";
                bubbleSort.sort(array_temp);
                break;
            case 2:
                //Merge Sort
                sortTypeStr = "Merge";
                mergeSort.sort(array_temp, 0, array_temp.length - 1);
                break;
            case 3:
                // Quick Sort
                sortTypeStr = "Quick";
                quickkSort.sort(array_temp, 0, array_temp.length - 1);
                break;
            case 4:
                // Selection Sort
                sortTypeStr = "Selection";
                selectSort.sort(array_temp);
                break;
            case 5:
                //Insertion Sort
                sortTypeStr = "Insertion";
                insertionSort.sort(array_temp);
                break;
        }

        System.out.println("SortType computed:" + sortTypeStr);
        long endMeomry = getMemory(runtime);
        long endTime = System.currentTimeMillis();
        if(degreeSortedness == -1) {
            SaveOutput.writeToCSV(sortTypeStr, String.valueOf(array.length), startTime, endTime, startMemory, endMeomry);
        } else if(degreeSortedness == 0.25) {
            SaveOutput.writeToCSV(sortTypeStr, "25%", startTime, endTime, startMemory, endMeomry);
        } else if(degreeSortedness == 0.50) {
            SaveOutput.writeToCSV(sortTypeStr, "50%", startTime, endTime, startMemory, endMeomry);
        } else {
            SaveOutput.writeToCSV(sortTypeStr, "Reversed", startTime, endTime, startMemory, endMeomry);
        }
        
    }
}
