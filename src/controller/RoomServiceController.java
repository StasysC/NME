package controller;

import model.RoomsData;
import view.MenuView;

import java.util.*;
import java.util.List;

public class RoomServiceController {
    RoomsData _roomsData = new RoomsData();
    MenuView _menuView = new MenuView();
    Scanner _scannerInput = new Scanner(System.in);
    InputController _input = new InputController();

    public void roomServices() {
        int inputInt = _input.inputForServiceOptions(_scannerInput);

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
                checkOccupiedRooms();
                break;
            case 4:
                roomHistory();
                break;
        }
    }

    private List<String> createGuest() {
        List<String> guest = new LinkedList();
        String guestName;
        String guestSurname;
        _menuView.ui(0);
        guestName = _input.inputForGuest(_scannerInput);
        _menuView.ui(1);
        guestSurname = _input.inputForGuest(_scannerInput);
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
        createHistoryRecord(selectedFreeRoomNumber, guestForCheckIn);
    }

    private void createHistoryRecord(int roomNum, List<String> guest) {

        List<String> oldGuest = _roomsData.getRoomHistory().get(roomNum);
        if (oldGuest == null) {
            oldGuest = new LinkedList<>(guest);
        } else {
            oldGuest.addAll(guest);
        }
        _roomsData.setRoomHistory(roomNum, oldGuest);
    }

    private void guestCheckOut() {
        List<String> guestForCheckOut = createGuest();
        boolean guestRemoved = _roomsData.removeGuestFromRoom(guestForCheckOut);
        if (guestRemoved) {
            _menuView.ui(3);
        } else {
            _menuView.ui(4);
        }
    }

    private void checkOccupiedRooms() {
        for (Map.Entry<Integer, List<String>> i : _roomsData.getRooms().entrySet()) {
            if (i.getValue() != null) {
                System.out.println("Room: " + i.getKey() + " Guest: " + i.getValue());
            }
        }
    }

    private void roomHistory() {
        _menuView.ui(5);
        int selectedRoomInput = _input.inputForRoomHistory(_scannerInput);
        Map<Integer, List<String>> roomsHistory = _roomsData.getRoomHistory();
        System.out.println("Room: " + selectedRoomInput + " Guests history: " + roomsHistory.get(selectedRoomInput));
        roomStatus(selectedRoomInput);
    }

    private void roomStatus(int selectedRoom) {
        if (_roomsData.getRooms().get(selectedRoom) != null) {
            System.out.println("Room " + selectedRoom + " - Occupied");
        } else {
            System.out.println("Room " + selectedRoom + " - Free");
        }
    }


}
