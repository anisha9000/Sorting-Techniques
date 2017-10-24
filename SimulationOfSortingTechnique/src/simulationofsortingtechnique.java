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
        /*InsertionSort insertionSort = new InsertionSort();
        insertionSort.sort(array, 6);
        
        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.sort(array, 6);
        
        QuickSort quickkSort = new QuickSort();
        quickkSort.sort(array, 0, 5);
        
        SelectionSort selectSort = new SelectionSort();
        selectSort.sort(array,array.length);
        */
        
        /* Generating data set containing uniformly distributed random Double values using ThreadLocalRandom*/
        /*usage: genRandom(no. of datapoints, min value, max value)*/
        GenSynDataSet data = new GenSynDataSet();   
        //double[] arr = data.genRandom(600,1,1000);
        
        /*usage: genGaussian(no. of datapoints, mean value, variance value)*/
        double[] arr2 = data.genGaussian(7, 100.0, 5.0);
        
       
        MergeSort mergeSort = new MergeSort();
        mergeSort.sort(arr2,0,arr2.length-1);
        
        
                
        for(int i=0;i<arr2.length;i++) {
            System.out.print(arr2[i]+"\n");
        }
    }
    
}
