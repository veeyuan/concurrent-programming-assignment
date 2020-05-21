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

    public void startGame() throws FileNotFoundException, InterruptedException, ExecutionException {
        Graph graph = new Graph();

        //create points
        List <Point> pointList = graph.createPointList(graph.getPointList(),this.pointNum);

        ExecutorService executor = Executors.newFixedThreadPool(this.threadNum);

        //create player task
        Set<Callable<Boolean>> callables = new HashSet<Callable<Boolean>>();
        for (int i=0;i<playerList.size();i++){
            callables.add(new PlayGame(playerList.get(i),graph));
        }
        List<Future<Boolean>> futures = executor.invokeAll(callables,this.time,TimeUnit.MILLISECONDS);
        for(Future<Boolean> future: futures) {
            try {
                boolean moreThan = future.get();
                System.out.println("Is more than 20? >>> "+moreThan);
                if (moreThan){
                    future.cancel(true);
                }
            } catch (ExecutionException e) {
                System.out.println("Execution Error");
            } catch (CancellationException e) {
                System.out.println("Time's Out then cancel >>>");
                future.cancel(true);
            }

        }

        executor.shutdownNow();
        while (!executor.isTerminated()){
        }

        //to determine winner - this part may need to be revised
        int highestScore=playerList.get(0).getEdgeList().size();
        int winner = 0;
        int sameHighest = 0;
        Player firstplayer = playerList.get(0);
        System.out.println("Player "+firstplayer.getPlayerId()+" gets "+firstplayer.getEdgeList().size()+" matches...");
        for (int i=1;i<playerList.size();i++){
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

        //Initialise PlotPointsFrame
        PlotPointsFrame plotPointsFrame = new PlotPointsFrame(pointList, playerList);
        plotPointsFrame.setVisible(true);
        
        printPoint(graph);
        printEdgeByPlayer(playerList);
        printResult(playerList);

    }

    public void printPoint(Graph graph) throws FileNotFoundException {
        List<String> headersList = Arrays.asList("INDEX", "x-Coordinate", "y-Coordinate", "Is Used (Matched)");
        DecimalFormat df = new DecimalFormat( "##0.0000000000000" );
        List<List<String>> rowsList = new ArrayList<>();
        for (int i=0; i<graph.pointList.size(); i++) {
            Point point = graph.getPointList().get(i);
            List<String> newList = new ArrayList<>();
            newList.add(Integer.toString(i));
            newList.add(df.format(point.getxCoor()));
            newList.add(df.format(point.getyCoor()));
            Boolean isUsed = point.isUsed();
            newList.add(isUsed.toString());
            rowsList.add(newList);
        }
        Board board = new Board(100);
        String tableString = board.setInitialBlock(new Table(board, 80, headersList, rowsList).tableToBlocks()).build().getPreview();
        PrintWriter writer =null;
        writer = new PrintWriter(new File("D:\\point.txt"));
        System.out.println("Printing pointlist>>>");
        writer.write(tableString);
        writer.flush();
        writer.close();
    }

    public void printResult(List<Player> playerList) throws FileNotFoundException {
        List<String> headersList = Arrays.asList("ID", "Name", "Edge Matches", "Elapsed time (ms)");
        List<List<String>> rowsList = new ArrayList<>();
        for (int i=0; i<playerList.size(); i++) {
            Player player = playerList.get(i);
            List<String> newList = new ArrayList<>();
            newList.add(Integer.toString(player.getPlayerId()));
            newList.add(player.getPlayerName());
            newList.add(Integer.toString(player.getEdgeList().size()));
            newList.add(Long.toString(player.getElapsedtime()));
            rowsList.add(newList);
        }
        Board board = new Board(100);
        String tableString = board.setInitialBlock(new Table(board, 80, headersList, rowsList).tableToBlocks()).build().getPreview();
        PrintWriter writer =null;
        writer = new PrintWriter(new File("D:\\result.txt"));
        System.out.println("Printing result >>>");
        writer.write(tableString);
        writer.flush();
        writer.close();
    }


    public void printEdgeByPlayer(List<Player> playerList) throws FileNotFoundException {
        List<String> headersList = Arrays.asList("INDEX", "A","x-Coordinate", "y-Coordinate","B","x-Coordinate", "y-Coordinate","Matched By");
        DecimalFormat df = new DecimalFormat( "##0.0000000000000" );
        int ind=1;
        List<List<String>> rowsList = new ArrayList<>();
        for (int i=0; i<playerList.size(); i++) {
            Player player = playerList.get(i);
            for (int y=0;y<player.getEdgeList().size();y++){
                List<String> newList = new ArrayList<>();
                Edge edge = player.getEdgeList().get(y);
                Point a = edge.getA();
                Point b = edge.getB();
                newList.add(Integer.toString(ind));
                newList.add(" A ");
                newList.add(df.format(a.getxCoor()));
                newList.add(df.format(a.getyCoor()));
                newList.add(" B ");
                newList.add(df.format(b.getxCoor()));
                newList.add(df.format(b.getyCoor()));
                newList.add(Integer.toString(player.getPlayerId()));
                rowsList.add(newList);
                ind++;

            }
        }
        Board board = new Board(150);
        String tableString = board.setInitialBlock(new Table(board, 150, headersList, rowsList).tableToBlocks()).build().getPreview();
        PrintWriter writer =null;
        writer = new PrintWriter(new File("D:\\edge.txt"));
        System.out.println("Printing edgelist>>>");
        writer.write(tableString);
        writer.flush();
        writer.close();
    }


}
