import java.util.Random;

public class Field {
    Random random = new Random();
    private final int SIZE = 9;
    private int numberOfMines;
    private final char[][] arr = new char[SIZE][SIZE];

    public void createBattleField() {
        int counter = 0;
        int numbOfMines = getNumberOfMines();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                arr[i][j] = '.';
            }
        }
        for (int i = 0; i < numbOfMines; i++) {
            int tempA = random.nextInt(SIZE);
            int tempB = random.nextInt(SIZE);
            if (arr[tempA][tempB] != 'X' && counter <= getNumberOfMines()) {
                arr[tempA][tempB] = 'X';
                counter++;
            } else {
                numberOfMines += 1;
            }
        }
    }

    public void showBattleField() {
        for (char[] chars : arr) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(chars[j]);
            }
            System.out.println();
        }
    }

    public int getNumberOfMines() {
        return numberOfMines;
    }

    public void setNumberOfMines(int numberOfMines) {
        this.numberOfMines = numberOfMines;
    }
}