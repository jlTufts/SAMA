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

    public int getDay2() {
        return day2;
    }

    public void setDay2(int day2) {
        this.day2 = day2;
    }

    public int getDay3() {
        return day3;
    }

    public void setDay3(int day3) {
        this.day3 = day3;
    }

    public int getDay4() {
        return day4;
    }

    public void setDay4(int day4) {
        this.day4 = day4;
    }

    public int getDay5() {
        return day5;
    }

    public void setDay5(int day5) {
        this.day5 = day5;
    }
}
