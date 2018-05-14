

import controller.RoomServiceController;
import model.RoomsData;
import view.MenuView;

public class Application {
    public static void main(String[] args) {
        Application obj = new Application();
        obj.runProgram();
    }

    void runProgram() {
        MenuView menu = new MenuView();
        //RoomsData roomsData = new RoomsData();
        RoomServiceController roomService = new RoomServiceController();
        //roomsData.initRooms();

        do {
            menu.menuOptions();
            roomService.roomServices();
        } while (true);
    }
}
