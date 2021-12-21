package com.example.sama.Activity;

import android.hardware.Sensor;
import android.hardware.SensorManager;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import com.example.sama.StepCounter;

/*
 * ActivityMonitor provides the user with activity advice based on their levels.
 */
@Entity
public class ActivityMonitor{
    @PrimaryKey
    public int  currentLevel;
    private int targetLevel;
    public int level;
    public String advice;

    public static SensorManager sensorManager = null;
    public static final Sensor stepCounter = null;
    public ActivityMonitor() {
        //Get activity target from ActivityTarget class
        ActivityTarget target = new ActivityTarget();
        int level = target.calcTarget();
        
        //Get current activity level from StepCounter class
        StepCounter counter = new StepCounter(getSensorManager(), stepCounter);
        currentLevel = counter.getSteps();
    }

    //Update current step count and compare to the target count
    private void evaluateLevel() {
        StepCounter counter = new StepCounter(getSensorManager(),stepCounter);
        currentLevel = counter.getSteps();

        if (currentLevel < getTargetLevel()) advice = "You haven't reached your goal yet. Keep trying!";
        else                            advice = "You've reached your goal! Great job!";
    }

    public int getTargetLevel() {
        return targetLevel;
    }

    public void setTargetLevel(int targetLevel) {
        this.targetLevel = targetLevel;
    }

    public SensorManager getSensorManager() {
        return sensorManager;
    }

    public void setSensorManager(SensorManager sensorManager) {
        this.sensorManager = sensorManager;
    }
}
