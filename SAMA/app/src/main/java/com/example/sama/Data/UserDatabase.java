package com.example.sama.Data;

import android.content.Context;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import com.example.sama.Model.User;

@androidx.room.Database(entities = {User.class}, version = 1)
public abstract class UserDatabase extends RoomDatabase {

    public abstract UserDao getUserDao(); //makes entire connection to userDao methods (query, insert,  etc.)
    private static UserDatabase userDatabase;

    //handles for if the db context doesn't exist
    public RoomDatabase getUserDatabase(Context context) {
        if(userDatabase == null) {
            userDatabase = Room.databaseBuilder(context, UserDatabase.class, "user")
                    .fallbackToDestructiveMigration().build();
        }
        return userDatabase;
    }
}

