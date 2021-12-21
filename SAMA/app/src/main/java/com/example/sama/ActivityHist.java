package com.example.sama;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class ActivityHist {
    @PrimaryKey
    @NonNull
    public String userID;

    @ColumnInfo(name = "D1")
    private int day1;
    @ColumnInfo(name = "D2")
    private int day2;
    @ColumnInfo(name = "D3")
    private int day3;
    @ColumnInfo(name = "D4")
    private int day4;
    @ColumnInfo(name = "D5")
    private int day5;

    public ActivityHist(int day2) {
        this.day2 = day2;
    }

    public int getDay1() {
        return day1;
    }

    public void setDay1(int day1) {
        this.day1 = day1;
    }
}
