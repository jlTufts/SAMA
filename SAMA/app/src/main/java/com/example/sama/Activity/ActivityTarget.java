package com.example.sama.Activity;

public class ActivityTarget extends ActivityMonitor {
    double age;

    public void ActivityTarget() {
        //TODO: implement when we can get age value from User DAO Interface
        //age = UserDao.getAge();


    }

    //Recommendations from www.firstquotehealth.com
    public int calcTarget() {
      //  if (age>3 && age<7)        getTargetLevel().set(10000);
        //else if (age>5 && age<12)  getTargetLevel().set(12000);
        //else if (age>11 && age<20) getTargetLevel().set(10000);
        //else if (age>19 && age<66) getTargetLevel().set(7000);
        //else if (age>65)           getTargetLevel().set(3000);
        //hard code goal in just need to get it working
        int targetLevel = getTargetLevel();
        {return targetLevel;}
    }
}
