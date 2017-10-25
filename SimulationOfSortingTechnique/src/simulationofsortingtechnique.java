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

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        for (int iteration = 0; iteration < 5; iteration++) {
            double array[] = generateData(0);
        }

        /* Generating data set containing uniformly distributed random Double values using ThreadLocalRandom*/
 /*usage: genRandom(no. of datapoints, min value, max value)*/
 /*usage: genGaussian(no. of datapoints, mean value, variance value)*/
        
        double arr2[] = generateData(0);
        double[] array_insertion = arr2.clone();
        double[] array_bubble = arr2.clone();
        double[] array_merge = arr2.clone();

        double[] array_selection = arr2.clone();

        MergeSort mergeSort = new MergeSort();
        QuickSort quickkSort = new QuickSort();
        SelectionSort selectSort = new SelectionSort();
        BubbleSort bubbleSort = new BubbleSort();
        InsertionSort insertionSort = new InsertionSort();

        //Merge sort 
        System.out.println("Merge sort");
        Runtime runtime = Runtime.getRuntime();
        runtime.gc();
        double memoryInit = (double) (runtime.totalMemory() - runtime.freeMemory());

        mergeSort.sort(array_merge, 0, array_merge.length - 1);

        double memoryFinal = (double) (runtime.totalMemory() - runtime.freeMemory());
        System.out.println((double) (memoryFinal - memoryInit) / MEGABYTE);

        System.out.println("Quick sort");
        memoryInit = (double) (runtime.totalMemory() - runtime.freeMemory());
        double[] array_quick = arr2.clone();
        quickkSort.sort(array_quick, 0, array_quick.length - 1);

        memoryFinal = (double) (runtime.totalMemory() - runtime.freeMemory());
        System.out.println((double) (memoryFinal - memoryInit) / MEGABYTE);

        runtime.gc();
        System.out.println("Selection sort");
        memoryInit = (double) (runtime.totalMemory() - runtime.freeMemory());

        selectSort.sort(array_selection);

        memoryFinal = (double) (runtime.totalMemory() - runtime.freeMemory());
        System.out.println((double) (memoryFinal - memoryInit) / MEGABYTE);

        runtime.gc();
        System.out.println("Bubble sort");
        memoryInit = (double) (runtime.totalMemory() - runtime.freeMemory());

        bubbleSort.sort(array_bubble);

        memoryFinal = (double) (runtime.totalMemory() - runtime.freeMemory());
        System.out.println((double) (memoryFinal - memoryInit) / MEGABYTE);

        runtime.gc();
        System.out.println("Insertion sort");
        memoryInit = (double) (runtime.totalMemory() - runtime.freeMemory());

        insertionSort.sort(array_insertion);

        memoryFinal = (double) (runtime.totalMemory() - runtime.freeMemory());
        System.out.println((double) (memoryFinal - memoryInit) / MEGABYTE);

    }

    private static double[] generateData(int i) {
        GenSynDataSet data = new GenSynDataSet();
        ReadInput realInput = new ReadInput();
        double[] arr2 = null;     
        switch (i) {
            case 0:
                arr2 = data.genRandom(50000, 1, 1000);
                return arr2;
            case 1:
                arr2 = data.genGaussian(50000, 100.0, 5.0);
                return arr2;
            case 2: 
                arr2 = realInput.readListingFile();
                return arr2;
                //TODO
            //case 3:
        }
        return arr2;
    }

}
