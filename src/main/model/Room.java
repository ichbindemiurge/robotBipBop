package model;

public class Room {

    public int roomRow;
    public int roomCol;
    int[][] roomMatrix;

    public Room(int roomRow, int roomCol, int[][] roomMatrix) {
        this.roomRow = roomRow;
        this.roomCol = roomCol;
        this.roomMatrix = roomMatrix;
    }

    public int getRoomRow() {
        return roomRow;
    }

    public void setRoomRow(int roomRow) {
        this.roomRow = roomRow;
    }

    public int getRoomCol() {
        return roomCol;
    }

    public void setRoomCol(int roomCol) {
        this.roomCol = roomCol;
    }

    public int[][] getRoomMatrix() {
        return roomMatrix;
    }

    public void setRoomMatrix(int[][] roomMatrix) {
        this.roomMatrix = roomMatrix;
    }
}
