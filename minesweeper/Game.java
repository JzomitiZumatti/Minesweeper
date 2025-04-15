import java.util.Scanner;

public class Game {
    private final Scanner scanner = new Scanner(System.in);
    private boolean isOn = true;
    private final Field field;

    public Game(int mines) {
        this.field = new Field(mines);
    }

    public void start() {
        Renderer.printField(field.getField(), field.getRevealed(), field.getMarks());

        while (isOn) {
            System.out.print(Message.TURN);
            int col = scanner.nextInt() - 1;
            int row = scanner.nextInt() - 1;
            String choice = scanner.next();

            if (!isValidMove(row, col)) {
                System.out.println(Message.CELL_IS_OUT_OF_BOUNDS);
                continue;
            }

            if (field.isFirstMove() && choice.equalsIgnoreCase("free")) {
                field.firstMove(row, col);
            } else if (field.ifMineIsHere(row, col) && choice.equalsIgnoreCase("free")) {
                field.revealAllMines();
                Renderer.printField(field.getField(), field.getRevealed(), field.getMarks());
                System.out.println(Message.MINE_STEPPED);
                isOn = false;
                break;
            } else {
                field.move(row, col, choice);
                if (field.isAllMinesFound() || field.isWin()) {
                    Renderer.printField(field.getField(), field.getRevealed(), field.getMarks());
                    System.out.println(Message.CONGRATULATIONS);
                    isOn = false;
                    break;
                }
            }
            Renderer.printField(field.getField(), field.getRevealed(), field.getMarks());
        }
    }

    private boolean isValidMove(int row, int col) {
        return row >= 0 && row < 9 && col >= 0 && col < 9;
    }
}
