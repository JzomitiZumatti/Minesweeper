import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(Message.HOW_MANY_MINES);
        int mines = scanner.nextInt();
        Game game = new Game(mines);
        game.start();
    }
}
