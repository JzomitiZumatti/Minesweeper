import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {
    private final Scanner scanner = new Scanner(System.in);
    private boolean isOn = true;
    private Field field;
    private int minesFound;
    private void newGame() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("How many mines do you want on the field? > ");
        int minesQuantity = scanner.nextInt();
        field = new Field(minesQuantity);
        field.hideMines();
        field.displayField();
    }

    public void start() {
        newGame();
        while (isOn) {
            takeTurn();
            field.displayField();
            isOn = isAllMinesFound();
        }
        System.out.println(Message.CONGRATULATIONS);
    }

    private void takeTurn() {
        int a; // column
        int b; // row
        do {
            System.out.println(Message.TURN);
            a = scanner.nextInt() + 1;
            b = scanner.nextInt() + 1;
            if (!isOutOfBounds(a) || !isOutOfBounds(b)) {
                System.err.println(Message.CELL_IS_OUT_OF_BOUNDS);
            }
        } while (!isOutOfBounds(a) || !isOutOfBounds(b));

        if (field.isCellNumber(a, b)) {
            field.setOrDeleteMark(a, b);
            System.out.println("Oh shit here we are again: a = " + a + " , b = " + b + ".");
            minesFound += (int) field.countMines(a, b);
            System.out.println(minesFound);

        } else {
            System.out.println(Message.CELL_IS_NUMBER);
        }
    }

    private boolean isOutOfBounds(int cellNumber) {
        ArrayList<Integer> allowNumbers = new ArrayList<>(List.of(2, 3, 4, 5, 6, 7, 8, 9, 10));
        return allowNumbers.stream()
                .anyMatch(el -> el == cellNumber);
    }

    private boolean isAllMinesFound() {
        return minesFound != field.getNumberOfMines();
    }
}
