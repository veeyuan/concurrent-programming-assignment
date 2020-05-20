import java.util.ArrayList;
import java.util.List;

public class Player {
    private String playerName;
    private int playerId;
    List<Edge> edgeList=new ArrayList<>();
    private int attemptMatch = 0;


    public Player(String playerName, int playerId) {
        this.playerName = playerName;
        this.playerId = playerId;
    }

    public String getPlayerName() {
        return playerName;
    }

    public int getPlayerId() {
        return playerId;
    }

    public List<Edge> getEdgeList() {
        return edgeList;
    }

    public int getAttemptMatch() {
        return attemptMatch;
    }

    public void setAttemptMatch(int attemptMatch) {
        this.attemptMatch = attemptMatch;
    }

    public int getElapsedtime() {
        return 0;
    }

}
