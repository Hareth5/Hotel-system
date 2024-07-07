//Hareth shoman , 1230030 , section 3


package project2;

import java.util.Random;

public class Room {

    private int roomNumber;

    private int floorNumber;

    private String roomType;

    private boolean isOccupied;

    private int capacity;

    private double pricePerNight;

    private String[] customerName = new String[2];

    Random random = new Random();


    public Room() {
    }

    public Room(int rooms) {
        this.roomNumber = checkRoomNumber(rooms);
        this.floorNumber = checkFloorNumber(rooms);
        this.roomType = checkRoomType(rooms);
        this.isOccupied = false;
        this.capacity = 2;
        this.pricePerNight = random.nextInt(200);
    }


    public int getRoomNumber() {
        return roomNumber;
    }

    public String getRoomType() {
        return roomType;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public int getCapacity() {
        return capacity;
    }

    public double getPricePerNight() {
        return pricePerNight;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setPricePerNight(double pricePerNight) {
        this.pricePerNight = pricePerNight;
    }

    public void setCustomerName(String firstName, String lastName) {
        this.customerName[0] = firstName;
        this.customerName[1] = lastName;
    }

    public int checkRoomNumber(int i) { //convert the array index to room number from 101 to 510

        roomNumber = 100 * (i / 10 + 1) + (i % 10) + 1;

        return roomNumber;
    }


    public int checkFloorNumber(int i) { //convert the room number in the array to the floor number

        floorNumber = i / 10 + 1;

        return floorNumber;

    }


    public String checkRoomType(int i) { //convert  the room number in the array to the room type

        if ((i + 1) >= 1 && (i + 1) <= 20)
            roomType = "standard";

        else if ((i + 1) >= 21 && (i + 1) <= 40)
            roomType = "family";

        else
            roomType = "suite";


        return roomType;
    }


    public int roomNumberToArray(int ArrayNum) { //convert room number to the array index from 0 to 49

        ArrayNum =ArrayNum - 100 * (ArrayNum / 100) - 1 + 10 * (ArrayNum / 100 - 1);



        return ArrayNum;
    }


    public String toString(Room[] arr, int index) {

        if (arr[index].customerName[0] != null)

            return "Room{" +
                    "roomNumber=" + roomNumber +
                    " floorNumber=" + floorNumber +
                    " roomType='" + roomType + '\'' +
                    " isOccupied=" + isOccupied +
                    " capacity=" + capacity +
                    " pricePerNight=" + pricePerNight +
                    " customer Name is " + customerName[0] + " " + customerName[1] +
                    '}';

        else

            return "Room{" +
                    "roomNumber=" + roomNumber +
                    " floorNumber=" + floorNumber +
                    " roomType='" + roomType + '\'' +
                    " isOccupied=" + isOccupied +
                    " capacity=" + capacity +
                    " pricePerNight=" + pricePerNight +
                    '}';

    }

}


