
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Game game = new Game(6);
        game.randomize();
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println("X ?");
            int x = scanner.nextInt();
            System.out.println("Y ?");
            int y = scanner.nextInt();

            game.toggle(x,y);

            System.out.println(game);}

    }
}
