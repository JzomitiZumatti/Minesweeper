import java.util.Random;
import java.util.ArrayList;
import java.util.List;

public class Field {
    private final int SIZE = 9;
    private static final char MINE = 'X';
    private static final char EMPTY = ' ';

    private final char[][] field;
    private final boolean[][] revealed;
    private final boolean[][] marks;
    private final List<int[]> mineCoordinates = new ArrayList<>();
    private final int mines;
    private boolean firstMove = true;
    private final Random random = new Random();

    public Field(int mines) {
        this.mines = mines;
        this.field = new char[SIZE][SIZE];
        this.revealed = new boolean[SIZE][SIZE];
        this.marks = new boolean[SIZE][SIZE];
        initializeField();
    }

    private void initializeField() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                char HIDDEN = '.';
                field[i][j] = HIDDEN;
            }
        }
    }

    public void firstMove(int row, int col) {
        if (firstMove) {
            firstMove = false;
            placeMines(row, col);
            calculateNumbers();
        }
        reveal(row, col);
    }

    public boolean isFirstMove() {
        return firstMove;
    }

    public void move(int row, int col, String choice) {
        if (choice.equalsIgnoreCase("free") && !ifMineIsHere(row, col)) {
            reveal(row, col);
        } else if (choice.equalsIgnoreCase("mine")) {
            setOrDeleteMark(row, col);
        }
    }

    private void placeMines(int safeRow, int safeCol) {
        int placedMines = 0;
        while (placedMines < mines) {
            int row = random.nextInt(SIZE);
            int col = random.nextInt(SIZE);
            if (field[row][col] == MINE || (row == safeRow && col == safeCol)) {
                continue;
            }
            field[row][col] = MINE;
            mineCoordinates.add(new int[]{row, col});
            placedMines++;
        }
    }

    private void calculateNumbers() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (field[i][j] == MINE) continue;
                int count = countMinesAround(i, j);
                field[i][j] = count == 0 ? EMPTY : (char) ('0' + count);
            }
        }
    }

    private int countMinesAround(int row, int col) {
        int counter = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                int newRow = row + i;
                int newCol = col + j;
                if (isValid(newRow, newCol) && field[newRow][newCol] == MINE) {
                    counter++;
                }
            }
        }
        return counter;
    }

    private void reveal(int row, int col) {
        if (!isValid(row, col) || revealed[row][col]) return;

        if (marks[row][col]) {
            marks[row][col] = false;
        }

        revealed[row][col] = true;

        if (field[row][col] == EMPTY) {
            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    if (i != 0 || j != 0) {
                        reveal(row + i, col + j);
                    }
                }
            }
        }
    }

    private boolean isValid(int row, int col) {
        return row >= 0 && row < SIZE && col >= 0 && col < SIZE;
    }

    public void setOrDeleteMark(int row, int col) {
        marks[row][col] = !marks[row][col];
    }

    public boolean isAllMinesFound() {
        if (firstMove) {
            return false;
        }
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                if (field[row][col] == ('X') && !marks[row][col]) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isWin() {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                if (field[i][j] != '*' && !revealed[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    public void revealAllMines() {
        for (int[] coords : mineCoordinates) {
            int row = coords[0];
            int col = coords[1];
            revealed[row][col] = true;
        }
    }

    public boolean ifMineIsHere(int row, int col) {
        return field[row][col] == MINE;
    }

    public boolean[][] getMarks() {
        return marks;
    }

    public char[][] getField() {
        return field;
    }

    public boolean[][] getRevealed() {
        return revealed;
    }
}