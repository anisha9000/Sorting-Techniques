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

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        double array[] = {5,3,7,1,8,2};
        /*
        
        QuickSort quickkSort = new QuickSort();
        quickkSort.sort(array, 0, 5);
        
        
        */
        
        /* Generating data set containing uniformly distributed random Double values using ThreadLocalRandom*/
        /*usage: genRandom(no. of datapoints, min value, max value)*/
        GenSynDataSet data = new GenSynDataSet();   
        //double[] arr = data.genRandom(10000,1,1000);
        
        /*usage: genGaussian(no. of datapoints, mean value, variance value)*/
        double[] arr2 = data.genGaussian(10000, 100.0, 5.0);
        
        double[] array_insertion = arr2.clone();
        double[] array_bubble = arr2.clone();
        double[] array_merge = arr2.clone();
        double[] array_quick = arr2.clone();
        double[] array_selection = arr2.clone();
        
        MergeSort mergeSort = new MergeSort();
        mergeSort.sort(array_merge,0,array_merge.length-1);
        
        QuickSort quickkSort = new QuickSort();
        quickkSort.sort(array_quick, 0, array_quick.length-1);
        
        SelectionSort selectSort = new SelectionSort();
        selectSort.sort(array_selection,array_selection.length);
         
        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.sort(array_bubble,array_bubble.length);
        
        InsertionSort insertionSort = new InsertionSort();
        insertionSort.sort(array_insertion);
        
        
//        for(int i=0;i<arr2.length;i++) {
//            System.out.print(arr2[i]+"\n");
//        }
    }
    
}
