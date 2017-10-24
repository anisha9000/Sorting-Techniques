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
        if(low >= high) {
            return;
        }
        int pivot = partition(array, low, high);
        sort(array, low, pivot-1);
        sort(array, pivot+1, high);
    }
    
    int partition(double[] array, int low, int high) {
        int i = low;
        int j = high;
        int pivotIndex = (high - low)/2;
        double pivot = array[pivotIndex];
        while(i<j) {
            while(array[i] < pivot) {
                i++;
            }
            
            while(array[j] > pivot) {
                j--;
            }
            
            if(i<j) {
                double temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        return i;
    }
}
