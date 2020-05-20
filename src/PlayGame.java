import java.util.concurrent.Callable;

import static java.lang.Thread.sleep;

public class PlayGame implements Callable<Boolean> {
    Player player;
    Graph graph;
    Point A;
    Point B;

    public PlayGame(Player player, Graph graph) {
        this.player = player;
        this.graph = graph;
    }

    @Override
    public Boolean call() throws Exception {

        while (!graph.isGameEnd() ){
            try {
                if (player.getAttemptMatch()>20 ){
                    System.out.println( "Player "+player.getPlayerId() +" stop matching >>> "+player.getEdgeList().size()+" matched...");
                    return true;
                }else{
                    A = graph.pickPoint();
                    B = graph.pickPoint();
                    boolean success = graph.match(A,B);
                    if (success){
                        Edge playerEdge = new Edge(A,B);
                        player.getEdgeList().add(playerEdge);
/*                        Edge newEdge = new Edge(A,B,player.getPlayerId());
                        graph.edgeList.add(newEdge);*/
                        try {
                            sleep(300);
                        }catch (InterruptedException e){
                            System.out.println("Interrupted >>>");
                        }
                        if (graph.isGameEnd()){
                            return false;
                        }
                    }else{
                        player.setAttemptMatch(player.getAttemptMatch()+1);
                    }

                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        return false;
    }

}
