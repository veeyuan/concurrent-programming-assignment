public class Edge {

    private Point A;
    private Point B;
    private int playerId;

    //for overall
    public Edge (Point pointA, Point pointB, int playerId){
        this.A=pointA;
        this.B=pointB;
        this.playerId=playerId;
    }
    // for player
    public Edge (Point pointA, Point pointB){
        this.A=pointA;
        this.B=pointB;
    }

    public void setA(Point A) {
        this.A = A;
    }

    public Point getA() {
        return A;
    }

    public void setB(Point B) {
        this.B = B;
    }

    public Point getB() {
        return B;
    }
    
}
