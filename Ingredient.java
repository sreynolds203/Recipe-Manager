/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Scanner;

/**
 *
 * @author skylar
 */
public class Ingredient {

    //set variables that are not accessed by the user (private)
    //variables are set to respective types identified in rubric
    private String nameOfIngredient = "";
    private String measurementType = "";
    private float measurementAmount = 0;
    private int caloriesPerMA = 0;//MA stands for measurement amount
    private double totCalories = 0.0;
    /**
     * Accessor for name of ingredient variable
     * @return nameOfIngredient
     */
    public String getNameOfIngredient() {
        return nameOfIngredient; //returns the name entered by user
    }
    /**
     * Accessor for measurement type variable
     * @return measurementType
     */
    public String getMeasuremntType() {
        return measurementType; //returns measurement name entered by user
    }
    /**
     * Accessor for the measurement amount variable
     * @return measurementAmount
     */
    public float getMeasurementAmount() {
        return measurementAmount; //returns measurement amount entered by user
    }
    /**
     * Accessor for the calories per measurement amount variable
     * @return caloriesPerMA
     */
    public int getCaloriesPerMA() {
        return caloriesPerMA; //returns calories per measurement amount
    }
    /**
     *Accessor for the total calories variable
     * @return totCalories
     */
    public double getTotCalories() {
        return totCalories; //returns total calories calculated by amounts entered
    }
    /**
     *
     * @param nameOfIngredient
     */
    public void setNameOfIngredient(String nameOfIngredient) {
        this.nameOfIngredient = nameOfIngredient; //sets the stated variable
    }
    /**
     *
     * @param measurementType
     */
    public void setMeasurementType(String measurementType) {
        this.measurementType = measurementType; //sets the stated variable
    }
    /**
     *
     * @param measurementAmount
     */
    public void setMeasurementAmount(float measurementAmount) {
        this.measurementAmount = measurementAmount; //sets the stated variable
    }
    /**
     *
     * @param caloriesPerMA
     */
    public void setCaloriesPerMA(int caloriesPerMA) {
        this.caloriesPerMA = caloriesPerMA; //sets the stated variable
    }
    /**
     *
     * @param totCalories
     */
    public void setTotCalories(double totCalories) {
        this.totCalories = totCalories; //sets the stated variable
    }

    /**
     *Empty constructor
     */
    public Ingredient() {
        //empty constructor
    }

    /**
     *
     * @param nameOfIngredient
     * @param measurementType
     * @param measurementAmount
     * @param caloriesPerMA
     * @param totCalories
     */
    public Ingredient(String nameOfIngredient, String measurementType,
                      float measurementAmount, int caloriesPerMA, double totCalories) {
        this.nameOfIngredient = nameOfIngredient;
        this.measurementType = measurementType;
        this.measurementAmount = measurementAmount;
        this.caloriesPerMA = caloriesPerMA;
        this.totCalories = totCalories;
    } //constructor for the stated variables

    /**
     * Method for adding new ingredient when called by the recipe class
     * @return addNewIngredient
     */
    public Ingredient newIngredient() { //method called in main expression
        String nextNameOfIngredient;
        String nextMeasurementType;
        float nextMeasurementAmount;
        int nextCaloriesPerMA;
        double nextTotCalories;
        Scanner scnr = new Scanner(System.in);

        System.out.println("What is the name of the ingredient?");
        nextNameOfIngredient = scnr.nextLine(); //accepts user input for name
        if (nextNameOfIngredient.length() > 2) { //checks for valid name length
            System.out.println("Name entered!");
        }
        else {
            System.out.println("Enter a valid name.");
            nextNameOfIngredient = scnr.nextLine(); //if invalid, asks for valid input
        }

        System.out.println("What is the unit of measure?");
        nextMeasurementType = scnr.next(); //user states measurement type
        System.out.println("Unit of measure defined!");

        System.out.println("How many " + nextMeasurementType + "(s) will be needed?");
        if (scnr.hasNextFloat()) { //checks for number entry. accepts decimals
            nextMeasurementAmount = scnr.nextFloat();
            System.out.println("Amount added!");
        }
        else {
            System.out.println("Enter a valid number.");
            nextMeasurementAmount = scnr.nextFloat(); //if invalid, second request.
            System.out.println("Amount added!");
        }

        System.out.println("How many calories are in 1 " + nextMeasurementType + "?");
        nextCaloriesPerMA = scnr.nextInt(); //assigns user input to variable
        if (nextCaloriesPerMA >= 0) { //checks for input of number
            System.out.println("Calories entered!");
        }
        else {
            System.out.println("Invalid number.");
            nextCaloriesPerMA = scnr.nextInt(); //second attempt to get number
        }

        nextTotCalories = nextMeasurementAmount * nextCaloriesPerMA; //sets variable after multiply

        //output of entered information
        System.out.println("Name: " + nextNameOfIngredient);
        System.out.println("Amount: " + nextMeasurementAmount + " " + nextMeasurementType + "(s)");
        System.out.println("Calories: " + nextTotCalories);

        Ingredient addNewIngredient = new Ingredient(nextNameOfIngredient, nextMeasurementType,nextMeasurementAmount, nextCaloriesPerMA, nextTotCalories); //adds information to new object


        return addNewIngredient; //returns the new obejct.
    }
}