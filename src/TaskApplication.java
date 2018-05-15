

import controller.RoomServiceController;
import model.RoomsData;
import view.MenuView;

public class TaskApplication {
    public static void main(String[] args) {
        TaskApplication obj = new TaskApplication();
        obj.runProgram();
    }


    void runProgram() {
        MenuView menu = new MenuView();
        RoomServiceController roomService = new RoomServiceController();
        RoomsData roomsData = roomService.getRoomsData();
        roomsData.readDataFile();
        boolean runAgain ;
        do {
            menu.menuOptions();
            roomService.roomServices();
            runAgain = roomService.isRunProgram();
        } while (runAgain);
        roomsData.createDataFile();
    }
}
