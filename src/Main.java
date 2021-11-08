
public class Main {

    public static void main(String[] args) {
        Game game = new Game(6);
        System.out.println(game);
        game.calculateSteps();
        for (int[] step : game.getBestSteps()) {
            System.out.println("X " + step[0] + ",Y " + step[1]);
        }
        System.out.println(game.getBestSteps().size());
    }
}

