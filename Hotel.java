//Hareth shoman , 1230030 , section 3


package project2;

import java.util.*;


public class Hotel {


    public static void main(String[] args) {

        RoomManagement roomManagement = new RoomManagement();
        Scanner input = new Scanner(System.in);
        String input2;
        char choice;

        do {


            System.out.println("How we can help you?");

            System.out.println("a: Show All Rooms");
            System.out.println("b: Show Available Rooms");
            System.out.println("c: Change Room Details");
            System.out.println("d: Search by Room Type");
            System.out.println("e: Search by Capacity");
            System.out.println("f: Sort rooms by price per night");
            System.out.println("g: Reverse a specific room");
            System.out.println("h: Read room details from a file");
            System.out.println("i: Save rooms data to file");
            System.out.println("j: Quit");

            System.out.print("Select an option: ");

            input2 = input.next().toLowerCase(); //convert all entered letters to the lower case
            choice = input2.charAt(0);

            switch (choice) {
                case 'a':
                    roomManagement.showAllRooms();
                    break;

                case 'b':
                    roomManagement.showAvailableRooms();
                    break;

                case 'c':
                    try {
                        System.out.println("Enter the room number you want to change:");
                        int roomNumber = input.nextInt();

                        System.out.println("Enter the new room type: enter 1 for standard, 2 for family, and 3 for suite:");
                        int newRoomType = input.nextInt();

                        System.out.println("Enter the occupancy (1 for true and 0 for false):");
                        int newOccupancy = input.nextInt();

                        if (newOccupancy == 1) {

                            System.out.println("enter your first name");
                            String name1 = input.next();

                            System.out.println("enter your second name");
                            String name2 = input.next();

                            roomManagement.reserveSpecificRoom(roomNumber, name1, name2);

                        }

                        System.out.println("Enter the new capacity:");
                        int newCapacity = input.nextInt();

                        System.out.println("Enter the new price per night:");
                        double newPricePerNight = input.nextDouble();

                        roomManagement.changeRoomDetails(roomNumber, newRoomType, newOccupancy, newCapacity, newPricePerNight);

                    } catch (InputMismatchException ex) {
                        System.out.println(ex);

                        input.next();
                    }

                    break;

                case 'd':
                    System.out.println("enter the room type you want to search");
                    String roomTypeSearch = input.next();
                    roomManagement.searchRoomType(roomTypeSearch);

                    break;

                case 'e':
                    try {
                        System.out.println("enter the room capacity you want to search");
                        int roomCapacitySearch = input.nextInt();
                        roomManagement.searchRoomCapacity(roomCapacitySearch);
                    } catch (InputMismatchException ex) {
                        System.out.println(ex);
                        input.next();
                    }

                    break;

                case 'f':
                    roomManagement.SortByPricePerNight();
                    break;

                case 'g':
                    int roomNumberReserved = 0;
                    try {
                        System.out.println("enter the room number you want to reserve");
                        roomNumberReserved = input.nextInt();

                        System.out.println("enter your first name");
                        String name1 = input.next();

                        System.out.println("enter your second name");
                        String name2 = input.next();

                        roomManagement.reserveSpecificRoom(roomNumberReserved, name1, name2);
                    } catch (InputMismatchException ex) {
                        System.out.println(ex);
                        input.next();
                    }

                    break;

                case 'h':
                    roomManagement.updateRooms();
                    break;

                case 'i':
                    roomManagement.saveRoom();
                    break;

                case 'j':
                    System.out.println("exiting...thank you for using the program");
                    break;

                default:
                    System.out.println("Invalid option, Please try again.");
            }

        }
        while (choice != 'j'); //to exit the system if the entered letter is j
    }
}









