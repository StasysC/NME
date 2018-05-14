package model;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class RoomsData {
    int ROOMS_IN_HOTEL = 5;
    // public Map<Integer, List<String>> _rooms = new LinkedHashMap();
    public Map<Integer, List<String>> _rooms;

    public Map<Integer, List<String>> getRooms() {
        return _rooms;
    }

    public void setRooms(Map<Integer, List<String>> _rooms) {
        this._rooms = _rooms;
    }

    public RoomsData() {
        initRooms();
    }

    public void initRooms() {
        _rooms = new LinkedHashMap();
        Map<Integer, List<String>> temp = new LinkedHashMap<>();
        for (int i = 1; i <= ROOMS_IN_HOTEL; i++) {
            // temp.put(i, null);
            _rooms.put(i, null);
            // setRooms(temp);
        }
    }

    public void addGuestToRoom(List<String> guest, int roomNumber) {
        _rooms.put(roomNumber, guest);
    }

    public void removeGuestFroRoom(List<String> guest) {
        for (Map.Entry<Integer, List<String>> i : _rooms.entrySet()) {
            if (i.getValue() != null) {
                if (i.getValue().equals(guest)) {
                    _rooms.replace(i.getKey(), null);
                }
            }
        }

    }

    public List<Integer> freeRooms() {
        List<Integer> freeRoom = new LinkedList();
        List<Integer> freeRoomReturn = new LinkedList();
        for (Map.Entry<Integer, List<String>> i : _rooms.entrySet()) {
            if (i.getValue() == null) {
                freeRoom.add(i.getKey());
            }
        }
        if (freeRoom.size() > 0) {
            freeRoomReturn = freeRoom;
        } else {
            freeRoomReturn = null;
        }
        return freeRoomReturn;
    }
}

