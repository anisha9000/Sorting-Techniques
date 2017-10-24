/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author anisha
 */
public class BubbleSort {
    private static int sort(double[] a, int n) {
        int swapCount = 0;
        for(int i=0;i<n;i++) {
            for(int j=0; j<n-1; j++) {
                if(a[j]> a[j+1]) {
                    double temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                    swapCount++;
                }
            }
        }
        return swapCount;
    }
}
