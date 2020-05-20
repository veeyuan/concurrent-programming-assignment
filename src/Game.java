import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game {

    private int pointNum;
    private int playerNum;
    private List<Point> point = new ArrayList<>();
    private List<Player> player = new ArrayList<>();
    Random rand = new Random();

    public Game(int pointNum, int playerNum) {
        this.pointNum = pointNum;
        this.playerNum = playerNum;
    }

    public void startGame() {
        // generate points
        for (int i = 0; i < pointNum; i++) {
            Point temp = createPoints(point);
            temp.setID(i + 1);
            point.add(temp);
        }

        // generate players
        for (int i = 0; i < playerNum; i++) {
            player.add(new Player(i + 1));
        }

        int count = 0;
        while (pointNum / 2 != count) {
            Player p = player.get(rand.nextInt(playerNum));
            Point a = point.get(rand.nextInt(pointNum));
            Point b = point.get(rand.nextInt(pointNum));
            if (a != b) {
                if (!a.isUsed() && !b.isUsed()) {
                    p.addEdge(new Edge(a, b));
                    System.out.println(count + " : " + a.getID() + " - " + b.getID());
                    count++;
                }
            }
        }

        for (int i = 0; i < playerNum; i++) {
            System.out.println(player.get(i).getID() + " - " + player.get(i).getSuccessPair());
        }
    }

    public Point createPoints(List<Point> pointList) {
        double x = rand.nextDouble();
        double y = rand.nextDouble();
        Point newPoint = new Point(x, y);
        if (pointList.contains(newPoint)) {
            return createPoints(pointList);
        }
        return newPoint;
    }
}
