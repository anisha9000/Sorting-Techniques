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
    void sort(double[] array, int low, int high) {
        if(low == high) {
            return;
        }
        int pivot = (high-low)/2;
        partition(array, low, high, pivot);
        sort(array, low, pivot-1);
        sort(array, pivot+1, high);
    }
    
    void partition(double[] array, int low, int high, int pivot) {
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
                double temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
    }
}
