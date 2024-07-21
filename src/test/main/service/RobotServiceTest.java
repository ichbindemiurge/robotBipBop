package main.service;

import model.Robot;
import model.Room;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import service.RobotService;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class RobotServiceTest {

    private Robot robot;
    private Room room;
    private RobotService robotService;

    Map<Character, Map<Character, Consumer<Robot>>> robotMovement = new HashMap<>();
    Map<Character, Map<Character, Character>> robotTurning = new HashMap<>();

    @BeforeEach
    public void testCarService(){
        room = Mockito.mock(Room.class);
        robotService = new RobotService();
        robot = new Robot();
        robot.setXrowCoordinate(3);
        robot.setYcolCoordinate(5);
        robot.setHead('N');

        this.robotMovement.put('F', Map.of(
                'N', c -> c.setYcolCoordinate(c.getYcolCoordinate()+1),
                'E', c -> c.setXrowCoordinate(c.getXrowCoordinate()+1),
                'S', c -> c.setYcolCoordinate(c.getYcolCoordinate()-1),
                'W', c -> c.setXrowCoordinate(c.getXrowCoordinate()-1)
        ));

        this.robotTurning.put('L', Map.of(
                'N', 'W',
                'W', 'S',
                'S', 'E',
                'E', 'N'
        ));
    }

    @Test
    void setCarOnField() {
        robot.setXrowCoordinate(10);
        System.out.println(robot.getXrowCoordinate());
        Assertions.assertEquals(robot.getXrowCoordinate(), 10);
    }

    @Test
    void movementForward() {
        char dir = 'F';
//        Car newCar = new Car();
//        newCar.setXrowCoordinate(3);
//        newCar.setYcolCoordinate(5);
        robotMovement.get(dir).get(robot.getHead()).accept(robot);
//        System.out.println(car.getYcolCoordinate());
//        System.out.println(newCar.getYcolCoordinate());
        Assertions.assertEquals(robot.getYcolCoordinate(), 6);
    }

    @Test
    void turnLeft() {
        char newHead = robotTurning.get('L').get(robot.getHead());
        robot.setHead(newHead);
        Assertions.assertEquals(robot.getHead(), 'W');
    }

    @Test
    void validateInputTrue() {
        String userCommand = "FFF";
        Assertions.assertTrue(userCommand.matches("[FBLR]+"));
    }


}
