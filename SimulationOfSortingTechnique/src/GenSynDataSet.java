/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author bhagatsanchya
 */
import java.util.Random;


import java.util.concurrent.ThreadLocalRandom;
public class GenSynDataSet {
    
    private Random rand = new Random();
    /* Generate a list of pseudo-random floating point values, with an 
        approximately Uniform distribution. */
    public double[] genRandom(int size,int min, int max){
        // Initialize an array that will contain the dataset. Size here referes to the number of values required to be generated
        double[] arr = new double[size];
        
        for (int i=0; i<size; i++){
            /*Returns a pseudorandom, uniformly distributed long value between min (inclusive) and max (exclusive)*/
            double random = ThreadLocalRandom.current().nextDouble(min, max);
            arr[i] = random;
        }
    return arr;
    }
    
     
     /* Generate a list of pseudo-random floating point values, with an 
        approximately Gaussian or normal distribution. */

    double[] genGaussian(int size,double theMean, double theVariance){
        double[] arr = new double[size];
        
        for(int i=0; i<size;i++){
            
            arr[i] = (theMean + (rand.nextGaussian())*theVariance);
        }
        return arr;
    }
    
}
