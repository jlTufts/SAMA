package com.example.sama.Activity;

public class ActivityTarget extends ActivityMonitor {
    double age;

    public void ActivityTarget() {
        //TODO: implement when we can get age value from User DAO Interface
//        age = UserDao.getAge();


    }

    //Recommendations from www.firstquotehealth.com
    public int calcTarget() {
        if (age>3 && age<7)        targetLevel.set(10000);
        else if (age>5 && age<12)  targetLevel.set(12000);
        else if (age>11 && age<20) targetLevel.set(10000);
        else if (age>19 && age<66) targetLevel.set(7000);
        else if (age>65)           targetLevel.set(3000);
        return (int) targetLevel.get();
    }
}
