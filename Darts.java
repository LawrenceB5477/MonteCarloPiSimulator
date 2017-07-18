/**
 * Name: Lars Beutlich 
 * Date: 11/16/2016
 * Purpose: To find the value of pi using a dart board simulation 
 */

import java.util.Scanner; 
public class Darts
{
   
    //Find how many times out a dart lands on a dart board out of all times thrown 
    public static int dartHits(long dartThrows)
    {
        int hits = 0;
        int radius = 1;
        double xval = 0;
        double yval = 0; 
        for(int i = 0; i < dartThrows; i++)
        {
            xval = Math.random(); 
            yval = Math.random(); 
            if (Math.pow(xval,2) + Math.pow(yval,2) <= 1)
            {
                hits ++; 
            }
        }
        return hits; 
    }
    
    //Calculate pi based on the number of times the dart hits 
    public static double piCalc(int hits, long dartThrows)
    {
        double pi = 4 * ((double)hits / (double)dartThrows);
        return pi; 
    }
    
    //find pi values for all trials 
    public static double[] trialCalc(int trials, long dartThrows)
    {
        double[] piVals = new double[trials];
        int hitNum = 0; 
        for (int i = 0; i < trials; i++)
        {
            hitNum = dartHits(dartThrows);
            piVals[i] = piCalc(hitNum, dartThrows); 
        }
        return piVals;
    }
   
    //Get the average of the trials 
    public static double getAverage(double[] results)
    {
        double total = 0; 
        for(double count : results)
        {
            total += count; 
        }
        total /= results.length; 
        return total; 
    }
    
    //Print the results to the screen 
    public static void output(double[] results, double average)
    {
        System.out.printf("\n"); 
        System.out.printf("%-8s%-8s\n", "        ", "Results:");
        for (int i = 0; i < results.length; i++)
        {
            System.out.printf("%-7s%-1d%-8s%-5f\n", "Trial [" ,i+1, "]: pi = ", results[i]);
        }
        System.out.printf("%-15s%-5f", "Estimate of pi = ", average);
    }
    
    //Main Method
    public static void main(String[] args)
    {
        //Input 
        Scanner in = new Scanner(System.in); 
        System.out.print("How many trials would you like to conduct?: ");
        int trials = in.nextInt();
        System.out.print("How many dart throws per trial should there be?: ");
        long dartThrows = in.nextInt();
        
        //Processing to find results of trials and avergae of trials  
        double[] results = trialCalc(trials, dartThrows);
        double average = getAverage(results); 
        output(results, average);
    }
}
