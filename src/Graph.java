import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Graph {
    List<Point> pointList= new ArrayList<>();
    private static boolean gameEnd = false; //win
    static int matchedPointNum=0;

    public Graph(){ }

    public List<Point> getPointList(){
        return  pointList;
    }


    public int getPointListSize(){
        return pointList.size();
    }

    public Point createPoints(List<Point> pointList){
        Random randGenerator = new Random();
        double xCoor = randGenerator.nextDouble();
        double yCoor = randGenerator.nextDouble();
        Point newPoint = new Point(xCoor,yCoor);
        //to avoid duplicate points are created - no two points are overlapped
        if (pointList.contains(newPoint)){
            return createPoints(pointList);
        }
        return  newPoint;
    }

    public List<Point> createPointList(List<Point> pointList, int PointNum) {
        for (int i=0; i<PointNum; i++){
            Point newPoint = createPoints(pointList);
            pointList.add(newPoint);
        }
        return pointList;
    }


    public Point pickPoint () throws InterruptedException{

        List<Point> pointList = getPointList();
        Random randGenerator = new Random();
        int pickPointIndex = randGenerator.nextInt(getPointListSize());
        Point point = pointList.get(pickPointIndex);
        boolean isSuccessfullyLocked = point.lock.tryLock();
        if (!isSuccessfullyLocked){
            //point is being accessed by another thread hence fail to lock
            System.out.println("Fails to lock -> pick another points");
            return pickPoint();
        }
        return point;
    }

        public boolean match(Point a, Point b){
            if (!a.isUsed() && !b.isUsed()){
                a.setUsed(true);
                b.setUsed(true);
                //System.out.println("Point A ("+a.getxCoor()+","+a.getyCoor()+") and Point B ("+b.getxCoor()+","+b.getyCoor()+") are paired.");
                matchedPointNum=matchedPointNum+2;
                //System.out.println("Matched points>>>>>>"+matchedPointNum);
                if (matchedPointNum>=pointList.size()){
                    setGameEnd(true);
                    System.out.println("-------------------------- All points are paired -------------------------");
                }
                a.lock.unlock();
                b.lock.unlock();
                return true;
            }

        a.lock.unlock();
        b.lock.unlock();
        return false;

    }


    public boolean isGameEnd() {
        return gameEnd;
    }

    public void setGameEnd(boolean gameEnd) {
        this.gameEnd = gameEnd;
    }
}
