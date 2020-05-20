import java.util.ArrayList;
import java.util.List;

public class Player {

    private List<Edge> edge = new ArrayList<>();
    private int id;

    public Player(int id) {
        this.id = id;
    }

    public int getID() {
        return id;
    }

    public String getSuccessPair() {
        return edge.toString();
    }

    public void addEdge(Edge temp) {
        temp.getA().hasUsed();
        temp.getB().hasUsed();
        edge.add(temp);
    }
}
