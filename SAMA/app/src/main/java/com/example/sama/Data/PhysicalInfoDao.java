package com.example.sama.Data;

import androidx.room.*;
import com.example.sama.PhysicalAttributes;

@Dao
public interface PhysicalInfoDao {
    @Query("SELECT * FROM User where username= :username")
    PhysicalInfoDao getInfoDB(String username);

    @Insert
    void insert(PhysicalAttributes userInformation);

    @Update
    void update(PhysicalAttributes userInformation);

    @Delete
    void delete(PhysicalAttributes userInformation);
}
