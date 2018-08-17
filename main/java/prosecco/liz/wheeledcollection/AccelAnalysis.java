package prosecco.liz.wheeledcollection;

/**
 * Created by liz on 8/17/2018.
 */

public class AccelAnalysis {

    private static int bufferSize = 200; //size of buffer
    private static float[][] accelData = new float[bufferSize][3];
    private int counter = 0;

    //start with one dimension for now...
    private double mean = 0.0;
    private double meanSquareDistance = 0.0;
    private double variance = 0.0;

    public int push(float[] data){
        accelData[counter] = data;
        counter = (counter + 1);
        updateStandardDeviation(data[0]); //whatever coordinate for now...
        if (counter == bufferSize){
            //get variance
            variance = calculateNoise();
            counter = 0;
        }
        return counter;
    }

    public double getVariance(){
        return variance;
    }

    public int getBufferSize(){
        return bufferSize;
    }

    //incrementally update standard deviation
    private void updateStandardDeviation(double newValue){
        double delta = newValue - mean;
        mean = mean + delta / (double)counter;
        double delta2 = newValue - mean;
        meanSquareDistance = meanSquareDistance + delta*delta2;
    }

    private double calculateNoise(){
        double variance = meanSquareDistance / bufferSize;
        return  variance; //variance is proportional to noise and doesn't require sqrt
    }
}