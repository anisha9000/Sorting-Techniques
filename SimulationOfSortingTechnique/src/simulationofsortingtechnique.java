
import java.io.IOException;
import java.util.Collections;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author anisha
 */
public class simulationofsortingtechnique {

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

        for (int iteration = 0; iteration < 5; iteration++) {
            double array[] = generateData(0);
            for (int sortType = 1; sortType <= 5; sortType++) {
                computeSorting(array, sortType);
            }

        }

    }

    private static double[] generateData(int i) {
        /* Generating data set containing uniformly distributed random Double values using ThreadLocalRandom*/

        GenSynDataSet data = new GenSynDataSet();
        ReadInput realInput = new ReadInput();
        double[] arr2 = null;
        switch (i) {
            case 0:
                /*usage: genRandom(no. of datapoints, min value, max value)*/
                arr2 = data.genRandom(50000, 1, 1000);
                return arr2;
            case 1:
                /*usage: genGaussian(no. of datapoints, mean value, variance value)*/
                arr2 = data.genGaussian(50000, 100.0, 5.0);
                return arr2;
            case 2:
                List<Double> prices = realInput.readListingFile();
                Collections.shuffle(prices);
                double[] arr = prices.stream().mapToDouble(Double::doubleValue).toArray();
                return arr2;
            //TODO
            //case 3:
        }
        return arr2;
    }

    private static long getMemory(Runtime runtime) {
        return runtime.totalMemory() - runtime.freeMemory();
    }

    private static void computeSorting(double[] array, int sortType) throws IOException {
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

        long endMeomry = getMemory(runtime);
        long endTime = System.currentTimeMillis();
        SaveOutput.writeToCSV(sortTypeStr, startTime, endTime, startMemory, endMeomry);
        
    }
}
