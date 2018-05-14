package controller;

import java.util.Scanner;

public class InputController {
    public int correctInputForService(Scanner input) {
        boolean correctFormat = false;
        int output = 0;
        do {
            try {
                output = Integer.parseInt(input.next());
                input.nextLine();
                correctFormat = true;
            } catch (NumberFormatException e) {
                System.out.println("You chosen incorrect option.Please select correct option.");
                correctFormat = false;
            }
            if (output > 4) {
                correctFormat = false;
                System.out.println("Please choose between 0 and 4 options.");
            }
        } while (!correctFormat);
        return output;
    }

    public String correctInputForRegistration(Scanner input) {
        boolean correctFormat = false;
        String output = "";
        do {
            try {
                output = input.next();
                input.nextLine();
                correctFormat = true;
            } catch (NumberFormatException e) {
                System.out.println("You chosen incorrect option.Please select correct option.");
                correctFormat = false;
            }
        } while (!correctFormat);
        return output;
    }
}
