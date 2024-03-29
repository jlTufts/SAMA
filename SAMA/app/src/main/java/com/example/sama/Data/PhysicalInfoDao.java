package com.example.sama.Data;

import androidx.room.*;
import com.example.sama.PhysicalAttributes;

@Dao
public abstract class PhysicalInfoDao {
    public PhysicalInfoDao(){}

    @Query("SELECT * FROM User where username= :username")
    PhysicalInfoDao getUserName(String username) {
        return null;
    }

    @Insert
    public abstract void insert(PhysicalAttributes userInformation);

    @Update
    public abstract void update(PhysicalAttributes userInformation);

    @Delete
    public abstract void delete(PhysicalAttributes userInformation);
}
