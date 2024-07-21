package model;

public class Robot {

    char head ;

    int XrowCoordinate;
    int YcolCoordinate;

    public Robot(char head, int xrowCoordinate, int ycolCoordinate) {
        this.head = head;
        XrowCoordinate = xrowCoordinate;
        YcolCoordinate = ycolCoordinate;
    }

    public Robot(){

    }

    public char getHead() {
        return head;
    }

    public void setHead(char head) {
        this.head = head;
    }

    public int getXrowCoordinate() {
        return XrowCoordinate;
    }

    public void setXrowCoordinate(int xrowCoordinate) {
        XrowCoordinate = xrowCoordinate;
    }

    public int getYcolCoordinate() {
        return YcolCoordinate;
    }

    public void setYcolCoordinate(int ycolCoordinate) {
        YcolCoordinate = ycolCoordinate;
    }
}
