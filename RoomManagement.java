//Hareth shoman , 1230030 , section 3


package project2;


import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class RoomManagement {


    public RoomManagement() {
    }


    Room[] roomsFrom1To50 = new Room[50]; //array of object


    {
        for (int rooms = 0; rooms < roomsFrom1To50.length; rooms++) { //the 50 rooms is objects

            Room room = new Room(rooms);
            roomsFrom1To50[rooms] = room;
        }
    }


    Room room2 = new Room();


    public void showAllRooms() {

        for (int rooms = 0; rooms < 50; rooms++) {

            System.out.println(roomsFrom1To50[rooms].toString(roomsFrom1To50, rooms));  //prints available rooms
        }
        System.out.println();
    }


    public void showAvailableRooms() {

        for (int rooms = 0; rooms < 50; rooms++) {
            if (roomsFrom1To50[rooms].isOccupied() == false) {

                System.out.println(roomsFrom1To50[rooms].toString(roomsFrom1To50, rooms));
            }
        }
        System.out.println();
    }


    public void changeRoomDetails(int roomNumber, int roomType, int isOccupied, int capacity, double pricePernight) {

        if ((roomNumber >= 101 && roomNumber <= 110) || (roomNumber >= 201 && roomNumber <= 210) || (roomNumber >= 301 && roomNumber <= 310) || (roomNumber >= 401 && roomNumber <= 410) || (roomNumber >= 501 && roomNumber <= 510)) {

            int arrayNumber = room2.roomNumberToArray(roomNumber); //convert room number to the room number in the array from 0 to 49

            if ((roomType == 1 || roomType == 2 || roomType == 3) && (isOccupied == 1 || isOccupied == 0) && (capacity >= 2 && capacity <= 10) && pricePernight >= 0.0) {


                roomsFrom1To50[arrayNumber].setRoomType((roomType == 1) ? "standard" : (roomType == 2) ? "family" : "suite"); //check if the room type is exist

                roomsFrom1To50[arrayNumber].setOccupied(isOccupied == 1);  //check if it occupied or not

                roomsFrom1To50[arrayNumber].setCapacity(capacity);

                roomsFrom1To50[arrayNumber].setPricePerNight(pricePernight);

                System.out.println("details has been changed");

            } else
                System.out.println("the details you entered is incorrect");

        } else
            System.out.println("the room number you entered is incorrect");
    }


    public void searchRoomType(String roomSearch) {

        if ("standard".equals(roomSearch) || "family".equals(roomSearch) || "suite".equals(roomSearch)) { //check if the room type is exist

            System.out.println("the " + roomSearch + " rooms are: ");

            for (int rooms = 0; rooms < roomsFrom1To50.length; rooms++) {
                if (roomSearch.equals(roomsFrom1To50[rooms].getRoomType())) {

                    System.out.println(roomsFrom1To50[rooms].toString(roomsFrom1To50, rooms));
                }
            }
            System.out.println();
        } else
            System.out.println("there is no rooms with this type");
    }


    public void searchRoomCapacity(int capacity) {

        int temp = 0;

        if (capacity >= 2 && capacity <= 10) {

            System.out.println("the rooms with capacity = " + capacity + " are: ");

            for (int rooms = 0; rooms < roomsFrom1To50.length; rooms++) {
                if (capacity == roomsFrom1To50[rooms].getCapacity()) {

                    System.out.println(roomsFrom1To50[rooms].toString(roomsFrom1To50, rooms));

                    temp++; //to check if there are rooms with entered capacity or not
                }
            }
            if (temp == 0)
                System.out.println("there is no rooms with this capacity");
            System.out.println();
        } else
            System.out.println("there is no rooms with this capacity");
    }


    public void SortByPricePerNight() {
        Room temp;

        Room[] arr = new Room[50];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = roomsFrom1To50[i];
        }

        System.out.println();

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i].getPricePerNight() < arr[j].getPricePerNight()) {
                    temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i].toString(arr, i));
        }
    }


    public void reserveSpecificRoom(int roomNumber, String name1, String name2) {


        if ((roomNumber >= 101 && roomNumber <= 110) || (roomNumber >= 201 && roomNumber <= 210) || (roomNumber >= 301 && roomNumber <= 310) || (roomNumber >= 401 && roomNumber <= 410) || (roomNumber >= 501 && roomNumber <= 510)) {

            int room = room2.roomNumberToArray(roomNumber);

            if (!roomsFrom1To50[room].isOccupied()) {

                roomsFrom1To50[room].setOccupied(true);
                roomsFrom1To50[room].setCustomerName(name1, name2);
                System.out.println("this room is reserved for you");

            } else
                System.out.println("this room is reversed");

        } else
            System.out.println("there is no room with this number");
    }


    public void updateRooms() {

        File file = new File("file.txt");

        try (Scanner scan = new Scanner(file)) {

                scan.useDelimiter(" |\n");
                while (scan.hasNext()) {
                    int index = room2.roomNumberToArray(scan.nextInt());
                    roomsFrom1To50[index].setRoomType(scan.next());
                    roomsFrom1To50[index].setOccupied(scan.nextBoolean());
                    roomsFrom1To50[index].setCapacity(scan.nextInt());
                    roomsFrom1To50[index].setPricePerNight(scan.nextDouble());
                }
                System.out.println("done");

        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        }
    }


    public void saveRoom() {

        File file = new File("file.txt");
        try (PrintWriter pr = new PrintWriter(file)) {

            for (int rooms = 0; rooms < roomsFrom1To50.length; rooms++) {


                pr.print(roomsFrom1To50[rooms].getRoomNumber() + " " + roomsFrom1To50[rooms].getRoomType() + " "
                        + roomsFrom1To50[rooms].isOccupied() + " " + +roomsFrom1To50[rooms].getCapacity() + " "
                        + (int) (roomsFrom1To50[rooms].getPricePerNight()) + "\n");

            }
            System.out.println("done");

        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        }
    }
}











