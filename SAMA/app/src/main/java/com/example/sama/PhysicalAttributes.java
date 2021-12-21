package com.example.sama;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public abstract class PhysicalAttributes {
    @PrimaryKey
    @NonNull
    public String userID;

    public String first_name;
    public String last_name;
    public int age;
    public String gender;
    public double weight;
    public double height;
}

