package controller;

import model.Robot;
import model.Room;
import service.RobotService;

import java.util.Scanner;

public class RobotController {
    static Scanner robotPositionInput = new Scanner(System.in);
    static Scanner movementSeq = new Scanner(System.in);
    public static RobotService robotService = new RobotService();
    static Robot robot = new Robot();
    public static boolean validInput = false;

    public static void placeRobotInTheRoom() {
        while (!validInput) {
            try {
                System.out.println("Please enter robot's starting position. " +
                        "It should be two whole numbers separated by a space and a single letter which indicates the direction " +
                        "robot is facing. Available directions - N E S W: ");
                String [] positionMatrix = robotPositionInput.nextLine().split(" ");

                if (positionMatrix.length != 3 || !positionMatrix[0].matches("[0-9]+") || !positionMatrix[1].matches("[0-9]+") || !positionMatrix[2].matches("[NESW]+")) {
                    throw new Exception();
                }

                int x = Integer.parseInt(positionMatrix[0]);
                int y = Integer.parseInt(positionMatrix[1]);
                char h = positionMatrix[2].charAt(0);

                validInput = true;

                robotService.setRobotInTheRoom(robot, x, y, Character.toUpperCase(h));

            } catch (Exception e) {
                throw new RuntimeException("Something went terribly wrong while placeRobotInTheRoom. The simulation was immediately terminated. Please try again");
            }
        }
    }

    public static void robotMovements(Room room){
        System.out.println("Please give robot movement direction where you wish robot to move. " +
                "As per our top-secret compliance navigation guide, available directions - F B L R: ");
        String robotDirections = movementSeq.next();
        try {
            if (robotService.validateInput(robotDirections.toUpperCase())){
                robotService.checkDirection(robot,robotDirections.toUpperCase(),room);
            } else {
                System.out.println("Unrecognized robot movement direction. Please try again.");
            }
        } catch (Exception e) {
            throw new RuntimeException(("Your position : " + robot.getXrowCoordinate() + " - " + robot.getYcolCoordinate() + e.getMessage()));
        } catch (Error error) {
            System.out.println("You are in the corner. Your Current position is :" + robot.getXrowCoordinate() + " - " + robot.getYcolCoordinate());
        }
    }
}
