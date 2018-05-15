package controller;

import model.RoomsData;

import java.util.Scanner;

public class InputController {
    int OPTIONS_COUNT = 4;
    RoomsData _roomsData = new RoomsData();

    public int inputForServiceOptions(Scanner input) {
        boolean correctFormat = false;
        int output = 0;
        do {
            try {
                output = Integer.parseInt(input.next());
                input.nextLine();
                correctFormat = true;
                if (output > OPTIONS_COUNT) {
                    correctFormat = false;
                    System.out.println("Please choose between 0 and " + OPTIONS_COUNT + " options.");
                }
            } catch (NumberFormatException e) {
                System.out.println("You typed wrong selection format. Please select correct option.");
                correctFormat = false;
            }

        } while (!correctFormat);
        return output;
    }

    public int inputForRoomHistory(Scanner input) {
        boolean correctFormat = false;
        int output = 0;
        do {
            try {
                output = Integer.parseInt(input.next());
                input.nextLine();
                correctFormat = true;
            } catch (NumberFormatException e) {
                System.out.println("You typed not a room number. Please type room number.");
                correctFormat = false;
            }
            int roomsInHotel = _roomsData.getROOMS_IN_HOTEL();
            if (output > roomsInHotel) {
                correctFormat = false;
                System.out.println("Please select existing room number.");
            }
        } while (!correctFormat);
        return output;
    }

    public String inputForGuest(Scanner input) {
        //   boolean correctFormat = false;
        // String output = "";
        //   do {
        //    try {
        String output = input.next();
        input.nextLine();
        //         correctFormat = true;
        //    } catch (NumberFormatException e) {
        //        System.out.println("You chosen incorrect option.Please select correct option.");
        //        correctFormat = false;
        //    }
        //  } while (!correctFormat);
        return output;
    }
}
