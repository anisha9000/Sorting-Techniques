/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author anisha
 */
public class InsertionSort {

    void sort(double[] array, int n) {
        int i, j, k;
        double temp;
        for (i = 1; i < n; i++) {
            temp = array[i];
            j = i - 1;
            while (temp < array[j] && j >= 0) {
                array[j + 1] = array[j];
                j--;
            }
            if (temp > array[j]) {
                array[j + 1] = temp;
            }
        }
    }
}
