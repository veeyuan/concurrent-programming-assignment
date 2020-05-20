import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.*;
import java.util.concurrent.*;

public class Game {

    private int pointNum;
    private int threadNum;
    private int time;
    private List<Player> playerList;

    public Game(int pointNum, int threadNum,int time, List<Player> playerList){
        this.pointNum=pointNum;
        this.threadNum=threadNum;
        this.time=time; //in MilliSeconds
        this.playerList = playerList;


    }

    public void startGame() throws  InterruptedException {
        Graph graph = new Graph();

        //create points
        graph.createPointList(graph.getPointList(),this.pointNum);

        ExecutorService executor = Executors.newFixedThreadPool(this.threadNum);

        //create player task
        Set<Callable<Boolean>> callables = new HashSet<Callable<Boolean>>();
        for (int i=0;i<playerList.size();i++){
            callables.add(new PlayGame(playerList.get(i),graph));
        }
         executor.invokeAll(callables);

        executor.shutdownNow();
        while (!executor.isTerminated()){
        }

        //to determine winner - this part need to be revised
        int highestScore=playerList.get(0).getEdgeList().size();
        int winner = 0;
        int sameHighest = 0;
        for (int i=0;i<playerList.size();i++){
            Player player = playerList.get(i);
            System.out.println("Player "+player.getPlayerId()+" gets "+player.getEdgeList().size()+" matches...");
            if (player.getEdgeList().size()>highestScore){
                highestScore=player.getEdgeList().size();
                winner=i;
                sameHighest=0;
            }else if (player.getEdgeList().size()==highestScore){
                sameHighest++;
            }
        }
        if (sameHighest>0){
            System.out.println("No winner - more than one match the same highest");
        }else{
            System.out.println("The winner is: Player "+playerList.get(winner).getPlayerId());
        }


    }


    public int getThreadNum() {
        return threadNum;
    }

    public void setThreadNum(int threadNum) {
        this.threadNum = threadNum;
    }

    public int getPointNum() {
        return pointNum;
    }

    public void setPointNum(int pointNum) {
        this.pointNum = pointNum;
    }

    public double getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public List<Player> getPlayerList() {
        return playerList;
    }
}
