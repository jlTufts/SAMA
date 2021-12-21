package com.example.sama.Data;

import androidx.room.*;
import com.example.sama.Model.User;

@Dao
public interface UserDao {
    @Query("SELECT * FROM User WHERE username= :username")
    User getUser(String username, String password);

    @Insert
    void insert(User user);

    @Update
    void update(User user);

    @Delete
    void delete(User user);
}