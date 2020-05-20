public class Edge {

    private Point A;
    private Point B;

    public Edge(Point A, Point B) {
        this.A = A;
        this.B = B;
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
    
    public String toString(){
        return A.getID() + "-" + B.getID();
    }
}
