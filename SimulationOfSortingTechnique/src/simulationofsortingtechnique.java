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
        MergeSort mergeSort = new MergeSort();
        mergeSort.sort(array,0,array.length-1);
                
        for(int i=0;i<6;i++) {
            System.out.print(array[i]+" ");
        }
    }
    
}
