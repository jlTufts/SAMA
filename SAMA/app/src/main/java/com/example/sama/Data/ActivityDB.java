package com.example.sama.Data;

import androidx.room.RoomDatabase;
import com.example.sama.Activity.ActivityMonitor;
import com.example.sama.ActivityHist;
import com.example.sama.Model.User;
import com.example.sama.PhysicalAttributes;

@androidx.room.Database(entities = {ActivityMonitor.class, ActivityHist.class, User.class,
        PhysicalAttributes.class}, version = 1)

public abstract class ActivityDB extends RoomDatabase {

    public abstract ActivityHistoryDao getHistoryDao(); //makes entire connection to userDao methods (query, insert, etc.)

    public abstract PhysicalInfoDao getInfoDao();
}

