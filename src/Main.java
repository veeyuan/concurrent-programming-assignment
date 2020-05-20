public class Main {
    //you may delete this
    public static void main(String[] args) {        
        //to accept input - number of threads
        Scanner in = new Scanner(System.in);
        System.out.print("Number of players you would like to create: ");
        int playerNum = in.nextInt();
        System.out.println("Number of players created :" + playerNum);

        System.out.print("Number of points you would like to create: ");
        int pointNum = in.nextInt();
        while (pointNum <= playerNum) {
            System.out.println("You should create more than thread number!");
            System.out.print("Number of points you would like to create: ");
            pointNum = in.nextInt();
        }
        System.out.println("Number of points created :" + pointNum);
        System.out.println("-----------------------------------");

        Game game = new Game(pointNum, playerNum);
        game.startGame();
    }
}
