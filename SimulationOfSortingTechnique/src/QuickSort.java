/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author anisha
 */
class QuickSort {
    void QuickSort(T[] array, int low, int high) {
        if(low == high) {
            return;
        }
        int pivot = (high-low)/2;
        sortBasedOnPivot(array, low, high, pivot);
        QuickSort(array, low, pivot-1);
        QuickSort(array, pivot+1, high);
    }
    
    void sortBasedOnPivot(T[] array, int low, int high, int pivot) {
        int i = low;
        int j = high;
        while(i<j) {
            while(array[i] < array[pivot]) {
                i++;
            }
            
            while(array[j] > array[pivot]) {
                j--;
            }
            
            if(i<j) {
                T temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
    }
}
