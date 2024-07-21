package main.service;

import model.Room;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class RoomServiceTest {
    Room room;


    @BeforeEach
    public void roomServiceSetup(){
        int[][]tmp = new int[3][5];
        room = new Room(3,5,tmp);
    }


    @Test
    void createNewRoom() {
        Assertions.assertEquals(room.roomRow, 3);
        Assertions.assertEquals(room.roomCol, 5);
    }

    @Test
    void checkCollision() {
        int x = 6;
        int y = 6;
        Assertions.assertFalse(x <= room.getRoomRow() && x >= 0 && y <= room.getRoomCol() && y >= 0);
    }
}