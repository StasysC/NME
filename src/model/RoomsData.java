package model;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class RoomsData {
    int ROOMS_COUNT = 5;
    Map<String, List<String>> _rooms;
    List<String> _roomNum1;
    List<String> _roomNum2;
    List<String> _roomNum3;
    List<String> _roomNum4;
    List<String> _roomNum5;


    public List<String> getRoomNum1() {
        return _roomNum1;
    }

    public void setRoomNum1(List<String> _roomNum1) {
        this._roomNum1 = _roomNum1;
    }

    public List<String> getRoomNum2() {
        return _roomNum2;
    }

    public void setRoomNum2(List<String> _roomNum2) {
        this._roomNum2 = _roomNum2;
    }

    public List<String> getRoomNum3() {
        return _roomNum3;
    }

    public void setRoomNum3(List<String> _roomNum3) {
        this._roomNum3 = _roomNum3;
    }

    public List<String> getRoomNum4() {
        return _roomNum4;
    }

    public void setRoomNum4(List<String> _roomNum4) {
        this._roomNum4 = _roomNum4;
    }

    public List<String> getRoomNum5() {
        return _roomNum5;
    }

    public void setRoomNum5(List<String> _roomNum5) {
        this._roomNum5 = _roomNum5;
    }

    public void initRooms() {
        _roomNum1 = new LinkedList<>();
        _roomNum2 = new LinkedList<>();
        _roomNum3 = new LinkedList<>();
        _roomNum4 = new LinkedList<>();
        _roomNum5 = new LinkedList<>();
    }

    public void addGuestToRoom(List<String> guest, int roomNumber) {
        switch (roomNumber) {
            case 1:
                setRoomNum1(guest);
                break;
            case 2:
                setRoomNum2(guest);
                break;
            case 3:
                setRoomNum3(guest);
                break;
            case 4:
                setRoomNum4(guest);
                break;
            case 5:
                setRoomNum5(guest);
                break;
        }
    }

    public List<String> freeRooms() {
        List<String> freeRoom = new LinkedList();
        int room1Size;
        int room2Size;
        int room3Size;
        int room4Size;
        int room5Size;

        if (_roomNum1 != null) {
            room1Size = 1;
        } else {
            room1Size = 0;
        }
        if (_roomNum2 != null) {
            room2Size = 1;
        } else {
            room2Size = 0;
        }
        if (_roomNum3 != null) {
            room3Size = 1;
        } else {
            room3Size = 0;
        }
        if (_roomNum4 != null) {
            room4Size = 1;
        } else {
            room4Size = 0;
        }
        if (_roomNum5 != null) {
            room5Size = 1;
        } else {
            room5Size = 0;
        }


        if (room1Size == 0) {
            freeRoom.add("1");
        }
        if (room2Size == 0) {
            freeRoom.add("2");
        }
        if (room3Size == 0) {
            freeRoom.add("3");
        }
        if (room4Size == 0) {
            freeRoom.add("4");
        }
        if (room5Size == 0) {
            freeRoom.add("5");
        }

        if (room1Size != 0 && room2Size != 0 && room3Size != 0 && room4Size != 0 && room5Size != 0) {
            freeRoom.add("0");
        }
        return freeRoom;
    }
}
