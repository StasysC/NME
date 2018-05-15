package view;

public class MenuView {

    public void menuOptions() {
        System.out.println("\nChoose action:");
        System.out.println("0 - Quit application");
        System.out.println("1 - Guest check-in");
        System.out.println("2 - Guest check-out");
        System.out.println("3 - Check occupied rooms");
        System.out.println("4 - Room history and status");
    }

    public void ui(int option) {
        switch (option) {
            case 0:
                System.out.println("Please enter guest name:");
                break;
            case 1:
                System.out.println("Please enter guest surname:");
                break;
            case 2:
                System.out.println("\nSorry, there are no available rooms");
                break;
            case 3:
                System.out.println("\nGuest has been checked out");

                break;
            case 4:
                System.out.println("\nWrong guest name and surname. Please try again.");
                break;
            case 5:
                System.out.println("\nPlease select room number");
                break;
            case 6:
                System.out.println("\nWrong guest name and surname. Please try again.");
                break;
             case 7:
                System.out.println("\nGuest successfuly checked in");
                break;
        }
    }
}
