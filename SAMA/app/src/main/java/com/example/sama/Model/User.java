package com.example.sama.Model;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import org.jetbrains.annotations.NotNull;

import java.io.Serializable;

@Entity
public class User implements Serializable {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    private String userID; //username
    private String username; //name
    private String password;

    public User(@NotNull String userID, String userName, String password) {
        this.userID = userID;
        this.username = userName;
        this.password = password;
    }

    @NonNull
    public String getId() {
        return userID;
    }

    public void setId(@NonNull String userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return username;
    }

    public void setUserName(String userName) {
        this.username = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + userID +
                ", userName='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
