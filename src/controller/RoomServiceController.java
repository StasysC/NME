package controller;

import com.sun.javafx.collections.MappingChange;
import model.RoomsData;
import view.MenuView;

import java.util.*;

public class RoomServiceController {
    RoomsData _roomsData = new RoomsData();
    MenuView _menuView = new MenuView();
    Scanner _scannerInput = new Scanner(System.in);
    InputController _input = new InputController();

    public void roomServices() {
        // connections();
        int inputInt = _input.correctInputForService(_scannerInput);
        chooseOption(inputInt, _scannerInput);
    }

    /*  private void connections() {
          _roomsData = new RoomsData();
      }
  */
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
        int freeRoomNumber = Integer.parseInt(_roomsData.freeRooms().get(0));
        if (freeRoomNumber == 0) {
            _menuView.ui(2);
            return;
        }
        List<String> guestForCheckIn = createGuest();
        _roomsData.addGuestToRoom(guestForCheckIn, freeRoomNumber);
       /* for (String i : _roomsData.freeRooms()) {
            System.out.println(i);
        }
   /*     for (Map.Entry<String, String> guest : _guest.entrySet()) {
            System.out.println(guest);
        }*/
    }


    private void guestCheckOut() {
        List<String> guestForCheckOut = createGuest();
        if (_roomsData.getRoomNum1().containsAll(guestForCheckOut)) {
            _roomsData.setRoomNum1(null);
        }
        if (_roomsData.getRoomNum2().containsAll(guestForCheckOut)) {
            _roomsData.setRoomNum2(null);
        }
        if (_roomsData.getRoomNum3().containsAll(guestForCheckOut)) {
            _roomsData.setRoomNum3(null);
        }
        if (_roomsData.getRoomNum4().containsAll(guestForCheckOut)) {
            _roomsData.setRoomNum4(null);
        }
        if (_roomsData.getRoomNum5().containsAll(guestForCheckOut)) {
            _roomsData.setRoomNum5(null);
        }
        System.out.println("Guest has been checked out");
    }

    private void roomAvailability() {
        System.out.println("Room availability");
    }

    private void roomHistory(int roomNumber) {
        System.out.println("Room history");
    }

    private void roomStatus() {

        System.out.println("Room 1: " + _roomsData.getRoomNum1());
        System.out.println("Room 2: " + _roomsData.getRoomNum2());
        System.out.println("Room 3: " + _roomsData.getRoomNum3());
        System.out.println("Room 4: " + _roomsData.getRoomNum4());
        System.out.println("Room 5: " + _roomsData.getRoomNum5());
    }


}
