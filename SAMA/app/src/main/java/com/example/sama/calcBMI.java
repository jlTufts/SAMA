package com.example.sama;

public class calcBMI{
    /*
    Calculates Body Mass Index which is a measure of body fat based on height and weight that applies to men and women.
    - underweight =< 18.5
    - normal weight = 18.5-24.9
    - overweight = 25-29.9
    - obesity = BMI of 30 or greater
    - formula is BMI = Kg/m^2
     */
    //first lets set up some variables
    double heightM = 0;
    double weightKg = 0;
    //accessible from attributes list
    double height;
    double weight;
    double BMI = 0;
    //get set for values
    public double getHeight() {
        return height;
    }
    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }
    public void setWeight(double weight) {
        this.weight = weight;
    }

    //now convert if not in metric but if it is metric then calculate BMI
    public double calcMetricHeight(double height) {
        //convert height to metric
        heightM = height * 0.3048;
        return heightM;
    }
    //convert weight
    public double calcMetricWeight(double weight){
        //convert weight to metric
        weightKg = weight * 0.453592;
        return weightKg;
    }
    //now calculate BMI
    public double getBMI() {
        weightKg = calcMetricWeight(weight);
        heightM = calcMetricHeight(height);
        BMI = weightKg / (heightM*heightM);
        //if height is 0 throw Arithmetic exception
        if(BMI == Float.POSITIVE_INFINITY) {
            throw new ArithmeticException("Infinite BMI! (height is zero)");
        }
        //if BMI is negative throw illegal argument exception
        else if(BMI <= 0){
            throw new IllegalArgumentException("BMI is less than or equal to zero");
        }
        else{
            return BMI;
        }
    }
}