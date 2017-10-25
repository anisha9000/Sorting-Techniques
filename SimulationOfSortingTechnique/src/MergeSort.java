/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author bhagatsanchya
 */
public class MergeSort {
     
    
    void merge(double arr[], int l, int mid, int r)
    {
        // Find sizes of two subarrays to be merged
        int len1 = mid - l + 1;
        int len2 = r - mid;
 
        double Left[] = new double [len1];
        double Right[] = new double [len2];
 
        /*Copy data to temporary arrays*/
        for (int i=0; i<len1; ++i)
            Left[i] = arr[l + i];
        for (int j=0; j<len2; ++j)
            Right[j] = arr[mid + 1+ j];
 
 
        /* Merge the temp arrays */
 
        // Initial indexes of first and second subarrays
        int i = 0, j = 0;
 
        // Initial index of merged subarry array
        int k = l;
        while (i < len1 && j < len2)
        {
            if (Left[i] <= Right[j])
            {
                arr[k] = Left[i];
                i++;
            }
            else
            {
                arr[k] = Right[j];
                j++;
            }
            k++;
        }
 
        /* Copy remaining elements of L[] if any */
        while (i < len1)
        {
            arr[k] = Left[i];
            i++;
            k++;
        }
 
        /* Copy remaining elements of R[] if any */
        while (j < len2)
        {
            arr[k] = Right[j];
            j++;
            k++;
        }
    }
    
    void sort(double[] a, int l, int r){
    //      startTime  = startTime + System.currentTimeMillis();
          if (l < r)
        {
            // Find the middle 
            int mid = (l+r)/2;
 
            sort(a, l, mid);
            sort(a , mid+1, r);
 
            // Merge the sorted halves
            merge(a, l, mid, r);
      //     long stopTime = System.currentTimeMillis();
        //   System.out.println("Time elapsed = "+ (stopTime - startTime));
           
        }
          
    
    }
}
