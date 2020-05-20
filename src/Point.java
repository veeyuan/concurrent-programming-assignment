import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Point {
    private double xCoor;
    private double yCoor;
    private boolean used=false;

    final ReentrantLock lock = new ReentrantLock();

    public  Point (double xCoor, double yCoor){
        this.xCoor=xCoor;
        this.yCoor=yCoor;
    }

    public double getxCoor() {
        return xCoor;
    }

    public void setxCoor(double xCoor) {
        this.xCoor = xCoor;
    }

    public double getyCoor() {
        return yCoor;
    }

    public void setyCoor(double yCoor) {
        this.yCoor = yCoor;
    }

    public boolean isUsed() {
        return used;
    }

    public void setUsed(boolean used) {
        this.used = used;
    }




}
