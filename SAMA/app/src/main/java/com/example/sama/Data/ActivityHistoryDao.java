package com.example.sama.Data;

import androidx.room.*;
import com.example.sama.ActivityHist;

@Dao
public interface ActivityHistoryDao {
    @Query("SELECT * FROM User where username= :username")
    ActivityHist getHistory(String username);

    /**
     * @param userHistory
     */
    @Insert
    void insert(ActivityHist userHistory);

    @Update
    void update(ActivityHist userHistory);

    @Delete
    void delete(ActivityHist userHistory);
}