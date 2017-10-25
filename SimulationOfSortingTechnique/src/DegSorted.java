/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author bhagatsanchya
 */
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
public class DegSorted {
    
    public double[] partialSort(double[] input, double partial){
        
        int n = input.length;
        int n_partial = (int)(partial * n);
        
        // Sort input array
        double a1_sort[] = input.clone();
        Arrays.sort(a1_sort);
        
        // Create an array to store shuffled elements
        double[] shuffle = new double[n - n_partial];
        
        // Array to store the result
        double[] result = new double[n];
        
        // Store elements to be shuffled (elements after partially sorted 
        // sub-array) to a temporary array
        int j = 0;
        for (int i = n_partial; i < n; i++) {
            shuffle[j] = a1_sort[i];
            j++;
        }
  
        // Shuffle the temporary array
        shuffle_array(shuffle);
        
        // Store the sorted sub-array in result
        for (int i = 0; i < n_partial; i++) {
            result[i] = a1_sort[i];
        }
        
        // Store the shuffled sub array in result
        j = 0;
        for (int i = n_partial; i < n; i++) {
            result[i] = shuffle[j];
            j++;
        }
        
        return result;
    }
    
    private void shuffle_array(double[] shuffle) {
        Random rnd = ThreadLocalRandom.current();
        for (int i = shuffle.length - 1; i > 0; i--)
        {
          int index = rnd.nextInt(i + 1);
          // Simple swap
          double a = shuffle[index];
          shuffle[index] = shuffle[i];
          shuffle[i] = a;
        }
    }
    
    public double[] reverseSort(double[] input){
        double[] a_sort = input.clone();
        double[] result = new double[input.length];
        Arrays.sort(a_sort);

        for (int i = 0, j = input.length - 1; i < input.length; i++, j--) {
            result[i] = a_sort[j];
        }
        
        return result;
    }
}

