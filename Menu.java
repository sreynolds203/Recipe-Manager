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
 * @version 1.0
 */

public class Menu {
    private ArrayList<Recipe> listOfRecipes;//array to store recipes

    /**
     * Produces the elements of the listOfRecipes arrayList
     *
     * @return listOfRecipes
     */
    public ArrayList<Recipe> getListOfRecipes() {

        return listOfRecipes;//method to get array
    }

    /**
     * @param listOfRecipes
     */
    public void setListOfRecipes(ArrayList<Recipe> listOfRecipes) {

        this.listOfRecipes = listOfRecipes;
    }

    /**
     * constructor for the ArrayList
     */
    public Menu() {

        this.listOfRecipes = new ArrayList<>();
    }//constructor for class

    /**
     * Constructor for the ArrayList
     *
     * @param listOfRecipes
     */
    public Menu(ArrayList<Recipe> listOfRecipes) {

        this.listOfRecipes = listOfRecipes;
    }//constructor for class

    /**
     * Method for printing all recipes and details when called by the user.
     */
    public void printAllRecipeDetails() {//prints all recipes and their details
        System.out.println("\nPrinting Recipes: ");
        for (int i = 0; i < listOfRecipes.size(); i++) {//loop to iterate and print recipes
            Recipe newRecipe = listOfRecipes.get(i);//new object for each recipe in the arraylist
            newRecipe.printRecipe();//calls printRecipe method for the recipe objects in teh arrayList
        }
        System.out.println(" ");
    }

    /**
     * Method for printing all recipe names in teh arrayList
     */
    public void printAllRecipeNames() {//only prints the names of the recipes
        System.out.println("\nSaved Recipes: ");
        for (int i = 0; i < listOfRecipes.size(); i++) {//loop for iterate and print recipe names
            Recipe newRecipe = listOfRecipes.get(i);//new object for each recipe in arrayList
            String nextRecipe = newRecipe.getRecipeName();//calls recipe name for current recipe
            System.out.println(nextRecipe);//prints recipe name
            System.out.println(" ");
        }
    }

    /**
     * Method for adding a new recipe to the arrayList
     */
    public void addRecipe() {//allows the user to add a recipe to array
        Recipe newRecipe = new Recipe();//creates new recipe
        listOfRecipes.add(newRecipe.createNewRecipe());//adds new recipe to the array
    }

    /**
     * Method for removing selected recipe from the arrayList
     */
    public void deleteRecipe() {
        Scanner scnr = new Scanner(System.in);
        for (int j = 0; j < listOfRecipes.size(); j++) { //iterates through arrayList to show recipe names
            System.out.println((j + 1) + ": " + listOfRecipes.get(j).getRecipeName());
        }
        System.out.println("\nSelect the recipe from above to delete. (Enter the line number)");
        int delete = scnr.nextInt();//index number selected by user
        for (int h = 0; h <= listOfRecipes.size(); h++) {
            if (h == delete) {//iterates through list to find the user selected recipe
                listOfRecipes.remove(h - 1);//removes selected recipe from list
                System.out.println("\nDeleted");
            }
        }
    }

    /**
     * Method for printing a specific recipe and its details
     */
    public void printSelectedRecipe() {
        Scanner scnr = new Scanner(System.in);
        for (int j = 0; j < listOfRecipes.size(); j++) { //iterates through arrayList to show all recipes
            System.out.println((j + 1) + ": " + listOfRecipes.get(j).getRecipeName());
        }
        System.out.println("\nSelect the recipe from above to print. (Enter the line number)");
        int print = scnr.nextInt();
        for (int h = 0; h <= listOfRecipes.size(); h++) {//loop to find the user selected recipe
            if (h == print) {
                listOfRecipes.get(h - 1).printRecipe();//prints the selected recipe
            }
        }
    }

    /**
     * Method for editing selected recipes in the arrayList
     */
    public void editRecipe() {//FIX ME not fully functional
        Scanner scnr = new Scanner(System.in);
        System.out.println("Recipes:");
        for (int j = 0; j < listOfRecipes.size(); j++) { //loop for iterating the recipes in the arrayList
            System.out.println((j + 1) + ": " + listOfRecipes.get(j).getRecipeName());
        }
        System.out.println("\nWhich recipe do you want to edit? (Enter the line number)");
        int edit = scnr.nextInt();

        System.out.println("Edit Options:\n" + "1. Recipe name\n" + "2. Serving size\n" + "3. Ingredients\n" + "4. Recipe steps\n" + "\nSelect an option.");
        while (scnr.hasNextInt()) {
            int option = scnr.nextInt();
            if (option == 1) {
                System.out.println("What is the new recipe name?");
                String newName = scnr.nextLine();
                for (int e = 0; e < listOfRecipes.size(); e++) {
                    if (e == edit) {
                        listOfRecipes.get(e - 1).setRecipeName(newName);
                        listOfRecipes.get(e - 1).printRecipe();
                    }//follows all steps until for loop.
                }    //allows user to enter name but does not change it
            }        //returns to the main menu
            else if (option == 2) {
                System.out.println("What is the new serving size?");
                int newServing = scnr.nextInt();
                for (int s = 0; s < listOfRecipes.size(); s++) {
                    if (s == edit) {
                        listOfRecipes.get(s - 1).setServings(newServing);
                        listOfRecipes.get(s - 1).printRecipe();
                    }//follows all steps until for loop
                }    //allows user to enter servings but does not change it
            }        //program stops producing new content
            else if (option == 3) {
                //print list of ingredients
                //print menu for add, delete, or edit ingredient
                //if edit: replace with new ingredient
                //if delete: remove ingredient
                //if add: make new ingredient
                //  Print new list of ingredients
                //  allow user to select an ingredient and move up one index
                //      use Collections utility to move ingredient until user ends
            } else if (option == 4) {
                //follow steps in option 3 but for Steps class
            }
        }
    }

    /**
     * Main method to run the program
     *
     * @param args
     */

    public static void main(String[] args) {
        ArrayList<Recipe> listOfRecipes = new ArrayList();//local array variable
        Menu myRecipeBox = new Menu(listOfRecipes);
        Scanner menuScnr = new Scanner(System.in);

        System.out.println("Menu\n" + "1. Add Recipe\n" + "2. Print All Recipe Details\n" +
                "3. Print All Recipe Names\n" + "4. Print Recipe\n" + "5. Delete Recipe\n" + "6. Edit Recipe\n" + "\nPlease select a menu item:");
        while (menuScnr.hasNextInt() || menuScnr.hasNextLine()) {
            int input = menuScnr.nextInt();

            if (input == 1) {//add recipe option
                myRecipeBox.addRecipe();
            } else if (input == 2) {//print details option
                myRecipeBox.printAllRecipeDetails();
            } else if (input == 3) {//print names option
                myRecipeBox.printAllRecipeNames();
            } else if (input == 4) {//print selcted recipe option
                myRecipeBox.printSelectedRecipe();
            } else if (input == 5) {//delete recipe option
                myRecipeBox.deleteRecipe();
            } else if (input == 6) {//edit recipe option
                myRecipeBox.editRecipe();
            } else {
                System.out.println("\nMenu\n" + "1. Add Recipe\n" + "2. Print Recipe\n" +
                        "3. Adjust Recipe Servings\n" + "4. Print Recipe\n" + "5. Delete Recipe\n" + "6. Edit Recipe\n" + "\nPlease select a menu item:");
            }

            System.out.println("Menu\n" + "1. Add Recipe\n" + "2. Print All Recipe Details\n" +
                    "3. Print All Recipe Names\n" + "4. Print Recipe\n" + "5. Delete Recipe\n" + "6. Edit Recipe\n" + "\nPlease select a menu item:");//allows for menu to show after action is complete

        }
    }
}