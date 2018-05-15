package model;

import java.io.*;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class RoomsData implements java.io.Serializable {

    int ROOMS_IN_HOTEL = 5;
    Map<Integer, List<String>> _rooms;
    Map<Integer, List<String>> _roomHistory;

    public int getROOMS_IN_HOTEL() {
        return ROOMS_IN_HOTEL;
    }

    public Map<Integer, List<String>> getRoomHistory() {
        return _roomHistory;
    }

    public void setRoomHistory(Integer roomNum, List<String> guest) {
        _roomHistory.put(roomNum, guest);
    }

    public Map<Integer, List<String>> getRooms() {
        return _rooms;
    }

    public RoomsData() {
        initRooms();
    }

    public void initRooms() {
        _rooms = new LinkedHashMap();
        _roomHistory = new LinkedHashMap();
        for (int i = 1; i <= ROOMS_IN_HOTEL; i++) {
            _rooms.put(i, null);
        }

    }

    public void addGuestToRoom(List<String> guest, int roomNumber) {
        _rooms.put(roomNumber, guest);
    }

    public boolean removeGuestFromRoom(List<String> guest) {
        boolean guestRemoved = false;
        for (Map.Entry<Integer, List<String>> i : _rooms.entrySet()) {
            if (i.getValue() != null) {
                if (i.getValue().equals(guest)) {
                    _rooms.replace(i.getKey(), null);
                    guestRemoved = true;
                }
            }
        }
        return guestRemoved;
    }

    public List<Integer> freeRooms() {
        List<Integer> freeRoom = new LinkedList();
        List<Integer> freeRoomReturn;
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

    public void createDataFile() {

        try {
            FileOutputStream roomDataFile = new FileOutputStream("RoomData.ser");
            ObjectOutputStream roomDataFileObj = new ObjectOutputStream(roomDataFile);
            roomDataFileObj.writeObject(_rooms);
            FileOutputStream roomHistoryDataFile = new FileOutputStream("RoomHistoryData.ser");
            ObjectOutputStream roomHistoryDataFileObj = new ObjectOutputStream(roomHistoryDataFile);
            roomHistoryDataFileObj.writeObject(_roomHistory);

            roomDataFile.close();
            roomDataFileObj.close();
            roomHistoryDataFile.close();
            roomHistoryDataFileObj.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void readDataFile() {
        try {
            FileInputStream roomsDataFile = new FileInputStream("RoomData.ser");
            ObjectInputStream roomsDataFileObj = new ObjectInputStream(roomsDataFile);
            FileInputStream roomsHistoryDataFile = new FileInputStream("RoomHistoryData.ser");
            ObjectInputStream roomsHistoryDataFileObj = new ObjectInputStream(roomsHistoryDataFile);
            _rooms = (Map<Integer, List<String>>) roomsDataFileObj.readObject();
            _roomHistory = (Map<Integer, List<String>>) roomsHistoryDataFileObj.readObject();
            roomsDataFile.close();
            roomsDataFileObj.close();
            roomsHistoryDataFile.close();
            roomsHistoryDataFileObj.close();
        } catch (IOException e) {
            System.out.println("No file found. Please check file name.");
            return;
        } catch (ClassNotFoundException e) {
            System.out.println("_room or _roomHistory not found");
            e.printStackTrace();
            return;
        }
    }
}

