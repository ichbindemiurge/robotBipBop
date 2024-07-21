package service;

import model.Room;

import java.util.InputMismatchException;
import java.util.Scanner;

public class RoomService {

    Scanner roomSc = new Scanner(System.in);
    Room roomSize;

    int matrixRow;
    int matrixCol;
    boolean validInput = false;


    public Room createNewRoom () {

        while(!validInput) {
            System.out.println("In order to start the robot simulation please enter a room size. Note: the room size should be 2 whole numbers separated with a space.");
            try {
                String [] roomMatrix = roomSc.nextLine().split(" ");

                if (roomMatrix.length != 2 || roomMatrix[0] == null || roomMatrix[1] == null || !roomMatrix[0].matches("^[0-9]+$") || !roomMatrix[1].matches("^[0-9]+$")) {
                    throw new InputMismatchException();
                }

                matrixRow = Integer.parseInt(roomMatrix[0]);
                matrixCol = Integer.parseInt(roomMatrix[1]);

                validInput = true;

                roomSize = new Room(matrixRow, matrixCol, new int[matrixRow][matrixCol]);

            } catch (InputMismatchException inputMismatchException) {
                System.out.println("You have to enter 2 whole number separated by space");
            } catch (Exception e) {
                throw new RuntimeException("Something went terribly wrong while createNewRoom. The simulation was immediately terminated. Please try again" + e);
            }
        }

        return roomSize;
    }

    public boolean checkCollision(int x, int y, Room room){
        int mtrxY = room.getRoomCol();
        int mtrxX = room.getRoomRow();
        return x <= mtrxX && x >= 0 && y <= mtrxY && y >= 0;
    }

}
