package service;

import model.Robot;
import model.Room;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class RobotService {

    Map<Character, Map<Character, Consumer<Robot>>> robotMovement = new HashMap<>();
    Map<Character, Map<Character, Character>> robotTurns = new HashMap<>();

    RoomService roomService = new RoomService();

    public RobotService() {
        this.robotMovement.put('F', Map.of(
                'N', robot -> robot.setYcolCoordinate(robot.getYcolCoordinate() + 1),
                'E', robot -> robot.setXrowCoordinate(robot.getXrowCoordinate() + 1),
                'S', robot -> robot.setYcolCoordinate(robot.getYcolCoordinate() - 1),
                'W', robot -> robot.setXrowCoordinate(robot.getXrowCoordinate() - 1)
        ));
        this.robotMovement.put('b', Map.of(
                'N', robot -> robot.setYcolCoordinate(robot.getYcolCoordinate() - 1),
                'E', robot -> robot.setXrowCoordinate(robot.getXrowCoordinate() - 1),
                'S', robot -> robot.setYcolCoordinate(robot.getYcolCoordinate() + 1),
                'W', robot -> robot.setXrowCoordinate(robot.getXrowCoordinate() + 1)
        ));
        this.robotTurns.put('L', Map.of(
                'N', 'W',
                'E', 'N',
                'S', 'E',
                'W', 'S'
        ));
        this.robotTurns.put('R', Map.of(
                'N', 'E',
                'E', 'S',
                'S', 'W',
                'W', 'N'
        ));
    }

    public void movement(Robot robot, char directions) {
        robotMovement.get(directions).get(robot.getHead()).accept(robot);
    }

    public void turn(Robot robot, char turnDirection) {
        char newHead = robotTurns.get(turnDirection).get(robot.getHead());
        robot.setHead(newHead);
    }

    public void checkDirection(Robot robot, String direction, Room room) throws Exception {
        for (int i = 0; i < direction.length(); i++) {
            if (direction.charAt(i) == 'L' || direction.charAt(i) == 'R') {
                turn(robot, direction.charAt(i));
            } else {
                if (roomService.checkCollision(robot.getXrowCoordinate(), robot.getYcolCoordinate(), room)) {
                    movement(robot, direction.charAt(i));
                } else {
                    throw new Exception("Invalid direction. Robot has collided with a wall. Operation is terminated. Robot temporarily unavailable while on maintenance after collision.");
                }
            }
        }

        System.out.println("Bip Bop, robot finished its movement. Current position is: " + robot.getXrowCoordinate() + " --- " + robot.getYcolCoordinate());
    }

    public boolean validateInput(String validate) {
        return validate.matches("[FBLR]+");
    }

    public void setRobotInTheRoom(Robot robot, int x, int y, char h) {
        robot.setXrowCoordinate(x);
        robot.setYcolCoordinate(y);
        robot.setHead(h);
    }

}
