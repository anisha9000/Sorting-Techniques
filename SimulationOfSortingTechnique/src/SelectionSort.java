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
    
    void sort(double[] a,int n ){
        
        for(int i = 0; i < n; i++){
            for(int j = i+1; j < n; j++){
                
                if (a[i] > a[j]){
                    double temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        }
    }
    
}
