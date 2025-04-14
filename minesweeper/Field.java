import java.util.Random;

public class Field {
    private final int SIZE = 9;
    private final int numberOfMines;
    private final char[][] arr = new char[SIZE][SIZE];

    public Field(int numberOfMines) {
        this.numberOfMines = numberOfMines;
        initializeField();
        placeMines();
        calculateNumbers();
    }

    private void initializeField() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                arr[i][j] = '.';
            }
        }
    }

    private void placeMines() {
        Random random = new Random();
        int minePlaced = 0;
        while (minePlaced < numberOfMines) {
            int row = random.nextInt(SIZE);
            int col = random.nextInt(SIZE);
            if (arr[row][col] != 'X') {
                arr[row][col] = 'X';
                minePlaced++;
            }
        }
    }

    private void calculateNumbers() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (arr[i][j] != 'X') {
                    int counter = countAdjacentMines(i, j);
                    if (counter > 0) {
                        arr[i][j] = String.valueOf(counter).charAt(0);
                    }
                }
            }
        }
    }

    private int countAdjacentMines(int row, int col) {
        int counter = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                int newRow = row + i;
                int newCol = col + j;
                if (newRow >= 0 && newRow < SIZE && newCol >= 0 && newCol < SIZE && arr[newRow][newCol] == 'X') {
                    counter++;
                }
            }
        }
        return counter;
    }

    public void displayField() {
        for (char[] chars : arr) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(chars[j]);
            }
            System.out.println();
        }
    }
}