package prosecco.liz.wheeledcollection;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by liz on 8/17/2018.
 */

public class AccelAnalysisTest {

    //input data
    private float[] xyz = new float[3];

    @Before
    public void setUp() {
        //create array of random noise
        for (int i = 0; i < xyz.length; i++) {
            xyz[i] = (float)Math.random();
        }
    }

    //basic test to see if buffer goes up when data is pushed to class
    @Test
    public void fills_buffer() throws Exception{
        AccelAnalysis aa = new AccelAnalysis();
        int bufferSize = aa.getBufferSize();
        for (int i = 0; i < bufferSize * 2; i++){
            Assert.assertEquals((i + 1) % bufferSize, aa.push(xyz));
        }
    }

    //tests if it can return values proportional to noise range
    @Test
    public void classifies_noise() throws Exception{
        //low noise
        AccelAnalysis aa = new AccelAnalysis();
        int bufferSize = aa.getBufferSize();
        for (int i = 0; i < bufferSize; i++){
            for (int i = 0; i < xyz.length; i++) {
                xyz[i] = (float)(Math.random()*0.1);
            }
        }
        double lowValue = aa.classifyNoise();
        for (int i = 0; i < bufferSize; i++){
            for (int i = 0; i < xyz.length; i++) {
                xyz[i] = (float)(Math.random()*0.5);
            }
        }
        double mediumValue = aa.classifyNoise();
        for (int i = 0; i < bufferSize; i++){
            for (int i = 0; i < xyz.length; i++) {
                xyz[i] = (float)(Math.random()*1.0);
            }
        }
        double highValue = aa.classifyNoise();
        Assert.assertTrue(lowValue < mediumValue);
        Assert.assertTrue(mediumValue < highValue);
    }

    //test for wheelie gesture
    @Test
    public void classifies_wheelie(){
        //TODO: wheelie sample data, clean

        //TODO: wheelie sample data with added noise

        //TODO: False data
    }
}
