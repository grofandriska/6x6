
public class Main {

    public static void main(String[] args) {
        Game game = new Game(3);
        System.out.println(game);
        game.calculateSteps();
        for (int[] step : game.getBestSteps()) {
            System.out.println("X " + step[0] + ",Y " + step[1]);
        }
        System.out.println("\n");
        System.out.println("End-state can be reached in : " + game.getBestSteps().size() + " steps");
        System.out.println("\n");
        System.out.println("\n");
        System.out.println("the game checked : " + game.possibilities + " possibility");

    }
}

