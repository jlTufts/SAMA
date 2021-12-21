package com.example.sama;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class UserPass {
    @PrimaryKey
    @NonNull
    public String userID;
    public String password;

    public UserPass() {
        userID = null;
    }
}