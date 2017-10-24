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
    
    int partition(double arr[], int low, int high)
    {
        double pivot = arr[high]; 
        int i = (low-1); 
        for (int j=low; j<high; j++)
        {
            if (arr[j] <= pivot)
            {
                i++;
                double temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
 
        double temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;
 
        return i+1;
    }
 
}
