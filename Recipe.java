/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Scanner;
import java.util.ArrayList;

/**
 *
 * @author skylar
 */
public class Recipe {
    //set variables that are not accessed by the user (private)
    //variables are set to respective types identified in rubric
    private String recipeName;
    private int servings;
    private ArrayList<Ingredient> recipeIngredients;
    private ArrayList<Steps> recipeSteps;
    private double totalRecipeCalories;
    /**
     * Accessor for the recipe name variable
     * @return recipeName
     */
    public String getRecipeName() {

        return recipeName;
    }
    /**
     *
     * @param recipeName
     */
    public void setRecipeName(String recipeName) {

        this.recipeName = recipeName;
    }
    /**
     * Accessor for the servings variable
     * @return servings
     */
    public int getServings() {

        return servings;
    }
    /**
     *
     * @param servings
     */
    public void setServings(int servings) {

        this.servings = servings;
    }
    /**
     * Accessor for the recipe ingredients variable
     * @return recipeIngredients
     */
    public ArrayList<Ingredient> getRecipeIngredients() {

        return recipeIngredients;
    }
    /**
     *
     * @param recipeIngredients
     */
    public void setRecipeIngredients(ArrayList<Ingredient> recipeIngredients) {
        this.recipeIngredients = recipeIngredients;
    }

    /**
     *Accessor for the recipe steps arrayList
     * @return
     */
    public ArrayList<Steps> getRecipeSteps() {

        return recipeSteps;
    }

    /**
     *
     * @param recipeSteps
     */
    public void setRecipeSteps(ArrayList<Steps> recipeSteps) {

        this.recipeSteps = recipeSteps;
    }
    /**
     * Accessor for the total recipe calories variable
     * @return totalRecipeCalories
     */
    public double getTotalRecipeCalories() {

        return totalRecipeCalories;
    }
    /**
     *
     * @param totalRecipeCalories
     */
    public void setTotalRecipeCalories(double totalRecipeCalories) {

        this.totalRecipeCalories = totalRecipeCalories;
    }

    /**
     *Constructor to initialize variables
     */
    public Recipe() {
        this.recipeName = "";
        this.servings = 0;
        this.recipeIngredients = new ArrayList<>();
        this.recipeSteps = new ArrayList<>();
        this.totalRecipeCalories = 0.0;
        //constructor to initialize variable values
    }
    /**
     *
     * @param recipeName
     * @param servings
     * @param recipeIngredients
     * @param recipeSteps
     * @param totalRecipeCalories
     */
    public Recipe(String recipeName, int servings, ArrayList<Ingredient> recipeIngredients, ArrayList<Steps> recipeSteps,
                  double totalRecipeCalories) {
        this.recipeName = recipeName;
        this.servings = servings;
        this.recipeIngredients = recipeIngredients;
        this.recipeSteps = recipeSteps;
        this.totalRecipeCalories = totalRecipeCalories;
    }//constructor for the stated values

    /**
     *Method to print the recipe and its details
     */
    public void printRecipe() {
        double singleServingCalories;

        singleServingCalories = totalRecipeCalories / servings;
        //new lines added for better readability of output
        System.out.println("\nRecipe: " + getRecipeName());//shows recipe name
        System.out.println("Serves: " + getServings());//shows serving amounts
        System.out.println("Each serving has " + singleServingCalories + " Calories.");//shows calories per serving
        System.out.println("\nIngredients: ");//shows all ingredients in array
        for (int i = 0; i < recipeIngredients.size(); i++) {//loop for getting ingredients from array
            Ingredient newIngredient = recipeIngredients.get(i);
            String nextIngredient = newIngredient.getNameOfIngredient();
            float nextAmount = newIngredient.getMeasurementAmount();
            String nextMeasurementType = newIngredient.getMeasuremntType();
            System.out.println(nextAmount + " " + nextMeasurementType + " " + nextIngredient );
            //shows the amount, amount type, and name of ingredient
        }
        System.out.println(" ");
        System.out.println("Steps: ");
        for (int s = 0; s < recipeSteps.size(); s++) {
            Steps newStep = recipeSteps.get(s);
            String nextStep = newStep.getNextStep();
            System.out.println("~~" + nextStep);
            System.out.println(" ");
        }
    }//print method for the recipe

    /**
     * Method for creating a new recipe when called by the menu class
     * @return addRecipe
     */
    public Recipe createNewRecipe() {//method called in main expression
        //initializes needed variables
        String input = "";
        double totalRecipeCalories = 0.0;
        ArrayList<Ingredient> recipeIngredients = new ArrayList();
        ArrayList<Steps> recipeSteps = new ArrayList();
        boolean addNewIngredients = true;
        boolean addNewStep = true;
        Scanner scnr = new Scanner(System.in);

        System.out.println("Please enter the recipe name: ");
        String recipeName = scnr.nextLine();//accepts recipe name from user

        System.out.println("Please enter the number of servings: ");
        int servings = scnr.nextInt();//sets the servings for recipe

        do {
            System.out.println("Would you like to enter ingredients? (type 'yes' to enter or 'end' to quit)");
            input = scnr.next();//reads input from user to begin if statement

            if (input.toLowerCase().equals("end")) {
                addNewIngredients = false;//ends if statement
            } else {
                Ingredient nextIngredient = new Ingredient();//creates new ingredient object

                recipeIngredients.add(nextIngredient.newIngredient());//adds new ingredient object to array


            }
        } while (addNewIngredients) ;//continues do statement while true

        for (int i = 0; i < recipeIngredients.size(); i++) {//loop to calculate calories
            Ingredient newIngredient = recipeIngredients.get(i);
            float ingredientAmount = newIngredient.getMeasurementAmount();
            int ingredientCalories = newIngredient.getCaloriesPerMA();
            double ingredientTotalCalories = ingredientAmount * ingredientCalories;
            totalRecipeCalories = totalRecipeCalories + ingredientTotalCalories;
        }
        do {
            System.out.println("Would you like to enter steps? (type 'yes' to enter or 'end' to quit)");
            input = scnr.next();

            if (input.toLowerCase().equals("end")) {
                addNewStep = false;
            }
            else {
                Steps nextStep = new Steps();//creates new steps object

                recipeSteps.add(nextStep.newStep());//adds step to the steps arrayList
            }
        } while (addNewStep);

        for (int s = 0; s < recipeSteps.size(); s++) {//loop to get all recipe steps
            Steps newStep = recipeSteps.get(s);
            String nextStep = newStep.getNextStep();

        }

        Recipe addRecipe = new Recipe(recipeName, servings, recipeIngredients, recipeSteps, totalRecipeCalories);
        addRecipe.printRecipe();//assigns input to new recipe object
        return addRecipe;//returns the object
    }
}
