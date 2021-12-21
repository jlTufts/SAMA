package com.example.sama;

import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

import java.util.List;

public class StepCounter extends Activity implements SensorEventListener{
    //setup private sensorManager and access step counter sensor
    public final SensorManager sensorManager;
    public final Sensor stepCounter;
    SensorEvent event;

    // constructor
    public StepCounter(SensorManager sensorManager, Sensor stepCounter) {
        this.sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        //first check to make sure sensor exists
        List<Sensor> sensorList = sensorManager.getSensorList(Sensor.TYPE_STEP_COUNTER);
        if(sensorList.size()>0) {
            this.stepCounter = sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER);
        }
        else{
            throw new IllegalArgumentException("No sensors found or can't access Step Counter!");
        }
    }

    //resume monitoring step counter constructor
    protected void onResume () {
        super.onResume();
        sensorManager.registerListener(this, stepCounter, SensorManager.SENSOR_DELAY_FASTEST);
    }
    //pause monitoring step counter constructor
    protected void onPause () {
        super.onPause();
        sensorManager.unregisterListener(this);
    }
    public void onAccuracyChanged(Sensor sensor, int accuracy) {}
    public void onSensorChanged(SensorEvent event) {}

    //get steps
    public int getSteps() {
        int stepsTaken;
        stepsTaken = Math.round(event.values[0]);
        return stepsTaken;
    }
}