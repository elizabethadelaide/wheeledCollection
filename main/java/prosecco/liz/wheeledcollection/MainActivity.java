package prosecco.liz.wheeledcollection;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity  implements SensorEventListener {

    /*
    Main Activity will later be moved, but will do the following

    Record and classify gestures from accelerometer:
    Wheelie (True, False), and Bumpyness (0-9).

    Use computer vision to record and classify the sidewalk:

    a. Reduce to only narrow strip
    b. Use edge detection
    c. Count intensity, or net closeness to classify

    Report data, and location to firebase database.

     */

    //sensor managers for accelerometer
    private SensorManager mSensorManager;
    private Sensor mAccel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //manager sensors
        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        mAccel = null;

        if (mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER) != null){
            mAccel = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        }
        else{
            //No Accelerometers available
        }
    }

    @Override
    public final void onAccuracyChanged(Sensor sensor, int accuracy) {
        // Do something here if sensor accuracy changes.
    }


    @Override
    public final void onSensorChanged(SensorEvent event){
        //register accelerometer event
        float x = event.values[0];
        float y = event.values[1];
        float z = event.values[2];

        //do analysis or add to buffer
    }

    @Override
    protected void onResume() {
        super.onResume();
        mSensorManager.registerListener(this, mAccel, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onPause() {
        super.onPause();
        mSensorManager.unregisterListener(this);
    }

}
