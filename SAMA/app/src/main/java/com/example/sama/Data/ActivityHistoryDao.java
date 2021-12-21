package com.example.sama.Data;

import androidx.room.*;
import com.example.sama.ActivityHist;

@Dao
public interface ActivityHistoryDao {
    @Query("SELECT * FROM User where username= :username")
    default ActivityHist getHistory(String username) {
        return null;
    }

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