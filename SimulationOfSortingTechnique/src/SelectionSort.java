/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author bhagatsanchya
 */
public class SelectionSort {
    
    void sort(double[] array){
        int n = array.length;
        for(int i = 0; i < n; i++){
            for(int j = i+1; j < n; j++){
                
                if (array[i] > array[j]){
                    double temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
    }
    
}
