import java.util.Random;
import java.util.ArrayList;
import java.util.List;

public class Field {
    private final int SIZE = 12;
    private final int numberOfMines;
    private final char[][] arr = new char[SIZE][SIZE];
    public List<int[]> mineCoordinates = new ArrayList<>();

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

        int counter = 0;
        for (int i = 0; i <= 1; i++) {
            for (int j = 2; j < SIZE - 1; j++) {
                counter++;
                if (counter <= 9) {
                    arr[i][j] = String.valueOf(counter).charAt(0);
                } else {
                    arr[i][j] = '-';
                }
            }
        }
        arr[0][0] = ' ';
        arr[1][0] = '-';
        arr[0][1] = '|';
        arr[1][1] = '|';
        counter = 0;
        int counter2 = 0;
        for (int i = 2; i < SIZE - 1; i++) {
            counter2++;
            counter++;
            for (int j = 0; j <= 1; j++) {
                if (counter <= 9 && counter2 % 2 == 0) {
                    arr[i][j] = String.valueOf(counter).charAt(0);
                    counter2++;
                } else {
                    arr[i][j] = '|';
                }
            }
        }

        for (int i = SIZE - 1; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                arr[i][j] = '-';
            }
        }

        arr[2][0] = '1';
        arr[SIZE - 1][1] = '|';

        for (int i = 0; i < SIZE; i++) {
            for (int j = SIZE - 1; j < SIZE; j++) {
                arr[i][j] = '|';
            }
        }
    }

    private void placeMines() {
        Random random = new Random();
        int minePlaced = 0;
        while (minePlaced < numberOfMines) {
            int row = random.nextInt(10 - 2 + 1) + 2;
            int col = random.nextInt(10 - 2 + 1) + 2;
            if (arr[row][col] != 'X') {
                arr[row][col] = 'X';
                minePlaced++;
            }
        }
    }

    private void calculateNumbers() {
        for (int i = 2; i < SIZE - 1; i++) {
            for (int j = 2; j < SIZE - 1; j++) {
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

    public void hideMines() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (arr[i][j] == 'X') {
                    mineCoordinates.add(new int[]{i - 1, j - 1});
                    arr[i][j] = '.';
                }
            }
        }
    }

    public boolean isCellNumber(int a, int b) {
        return arr[b][a] == '.' || arr[b][a] == '*';
    }

    public void setOrDeleteMark(int a, int b) {
        if (isCellNumber(a, b) && arr[b][a] != '*') {
            arr[b][a] = '*';
        } else {
            arr[b][a] = '.';
        }
    }

    public long countMines(int a, int b) {
        return mineCoordinates.stream()
                .filter(coord -> coord[0] == b - 1 && coord[1] == a - 1)
                .count();
    }

    public int getNumberOfMines() {
        return numberOfMines;
    }
}