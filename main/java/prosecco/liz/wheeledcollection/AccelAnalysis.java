package prosecco.liz.wheeledcollection;

/**
 * Created by liz on 8/17/2018.
 */

public class AccelAnalysis {

    private static int bufferSize = 200; //size of buffer
    private static float[][] accelData = new float[bufferSize][3];
    private int counter = 0;

    public int push(float[] data){
        accelData[counter] = data;
        counter = (counter + 1) % bufferSize;
        return counter;
    }

    public int getBufferSize(){
        return bufferSize;
    }
}