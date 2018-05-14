package controller;

import com.sun.javafx.collections.MappingChange;
import model.RoomsData;
import view.MenuView;

import java.awt.*;
import java.util.*;
import java.util.List;

public class RoomServiceController {
    RoomsData _roomsData = new RoomsData();
    MenuView _menuView = new MenuView();
    // RoomsData _roomsData ;
    //MenuView _menuView;

    Scanner _scannerInput = new Scanner(System.in);
    InputController _input = new InputController();

    public void roomServices() {
        int inputInt = _input.correctInputForService(_scannerInput);
        chooseOption(inputInt, _scannerInput);
    }

    private void chooseOption(int correctInput, Scanner scannerInput) {

        switch (correctInput) {

            case 0:
                System.exit(0);
            case 1:
                guestCheckIn(scannerInput);
                break;
            case 2:
                guestCheckOut();
                break;
            case 3:
                roomAvailability();
                break;
            case 4:
                roomStatus();
                break;
        }
    }

    private List<String> createGuest() {
        List<String> guest = new LinkedList();
        String guestName;
        String guestSurname;
        _menuView.ui(0);
        guestName = _input.correctInputForRegistration(_scannerInput);
        _menuView.ui(1);
        guestSurname = _input.correctInputForRegistration(_scannerInput);
        guest.add(guestName + " " + guestSurname);
        return guest;
    }

    private void guestCheckIn(Scanner input) {
        List<Integer> freeRoomNumbers = _roomsData.freeRooms();
        if (freeRoomNumbers == null) {
            _menuView.ui(2);
            return;
        }
        int selectedFreeRoomNumber = freeRoomNumbers.get(0);
        List<String> guestForCheckIn = createGuest();
        _roomsData.addGuestToRoom(guestForCheckIn, selectedFreeRoomNumber);
    }


    private void guestCheckOut() {
        List<String> guestForCheckOut = createGuest();
        _roomsData.removeGuestFroRoom(guestForCheckOut);
        System.out.println("Guest has been checked out");
    }

    private void roomAvailability() {
        System.out.println("Room availability");
    }

    private void roomHistory(int roomNumber) {
        System.out.println("Room history");
    }

    private void roomStatus() {

        System.out.println("Free rooms: ");
        //   Map<Integer,List<String>> z = _roomsData.getRooms();
        //  List<Integer> s = _roomsData.freeRooms();
        if (_roomsData.freeRooms() == null) {

        } else {
            for (Map.Entry<Integer, List<String>> i : _roomsData._rooms.entrySet()) {
                System.out.println("Room " + i);
            }

        }
    }


}
