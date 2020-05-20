import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException, ExecutionException, InterruptedException {
        //to accept input - number of threads
        Scanner in = new Scanner(System.in);
        System.out.print("Number of players you would like to create: ");
        int playerNum = Integer.parseInt(in.nextLine());
        List<Player> playerList = new ArrayList<>(playerNum);
        for (int i=1; i<=playerNum; i++){
            System.out.print("Player "+i+": ");
            String playername = in.nextLine();
            Player newPlayer = new Player(playername,i);
            playerList.add(newPlayer);
        }
        System.out.println("Number of players created :"+playerNum);

        System.out.print("Number of points you would like to create: ");
        int pointNum = in.nextInt();
        while (pointNum<=playerNum){
            System.out.println("You should create more points than player number!");
            System.out.print("Number of points you would like to create: ");
            pointNum = in.nextInt();
        }
        System.out.println("Number of points created :"+pointNum);

        System.out.print("Time (in ms) for game execution: ");
        int time = in.nextInt();
        System.out.println("-----------------------------------");

        Game game = new Game(pointNum,playerNum,time,playerList);
        game.startGame();


    }
}
