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
public class Steps {
    private String nextStep = "";

    /**Accessor for next step variable
     * @return the nextStep
     */
    public String getNextStep() {
        return nextStep;
    }

    /**
     * @param nextStep the nextStep to set
     */
    public void setNextStep(String nextStep) {
        this.nextStep = nextStep;
    }

    /**
     *empty constructor
     */
    public Steps(){
        //empty constructor
    }

    /**
     *
     * @param nextStep
     */
    public Steps(String nextStep) {
        this.nextStep = nextStep;
    }

    /**
     *Method for adding step when called by the recipe class
     * @return
     */
    public Steps newStep() {
        String newNextStep = "";

        Scanner scnr = new Scanner(System.in);

        System.out.println("What is the next step?");
        newNextStep = scnr.nextLine();

        Steps addNewStep = new Steps(newNextStep);

        return addNewStep;
    }
}
