
import java.sql.SQLOutput;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Game game = new Game(6);
        game.randomize();
        Scanner scanner = new Scanner(System.in);
        while (!game.isSolved()) {
            try {
                System.out.println("X ?");
                int x = scanner.nextInt();
                System.out.println("Y ?");
                int y = scanner.nextInt();
                game.toggle(x, y);
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("please give a right number");
            } catch (InputMismatchException e) {
                System.out.println("please use number");
                scanner.next();
            }
            System.out.println(game);
        }
    }
}

