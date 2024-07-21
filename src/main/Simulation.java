import controller.RobotController;
import model.Room;
import service.RoomService;

public class Simulation {
    public static RoomService roomService = new RoomService();
    public static RobotController robotController = new RobotController();


    public static void main(String[] args) {
        Room newRoom = roomService.createNewRoom();
        robotController.placeRobotInTheRoom();
        robotController.robotMovements(newRoom);
    }
}
