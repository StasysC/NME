package controller;

import view.MenuView;

public class Application {
    public static void main(String[] args) {
        Application obj = new Application();
        obj.runProgram();
    }

    void runProgram() {
        MenuView menu = new MenuView();
        RoomServiceController roomService = new RoomServiceController();
        do {
            menu.menuOptions();
            roomService.roomServices();
        } while (true);
    }
}
