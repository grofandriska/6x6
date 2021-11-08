import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Game game = new Game(3);
        game.chasingTheLights();
        game.calculateSteps();
        System.out.println(game);

        Scanner scanner = new Scanner(System.in);
          try {
                System.out.println(game);
                System.out.println("X ?");
                int x = scanner.nextInt();

                System.out.println("Y ?");
                int y = scanner.nextInt();

                game.toggleCell(x, y);
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Please use a right number between 0 and " + (game.getGrid().length - 1));
            } catch (InputMismatchException e) {
                System.out.println("Please use a right number between 0 and " + (game.getGrid().length - 1));
                scanner.next();
                scanner.close();
            }


    }
}

