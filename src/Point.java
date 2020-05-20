public class Point {
    private int id;
    private double x;
    private double y;
    private boolean used = false;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
    
    public Point(int id, double x, double y) {
        this.id = id;
        this.x = x;
        this.y = y;
    }
    
    public void setID(int id){
        this.id = id;
    }
    
    public int getID(){
        return id;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public boolean isUsed() {
        return used;
    }

    public void hasUsed() {
        this.used = true;
    }
    
    public String toString(){
        return "(" + x + ", " + y + ")";
    }
}
