import java.util.Random;

public class Field {
    Random random = new Random();
    private final int SIZE = 9;
    private final char[][] arr = new char[SIZE][SIZE];

    public void createBattleField() {
        int counter = 0;
        int dest = 10;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                arr[i][j] = '.';
            }
        }
        for (int i = 0; i < dest; i++) {
            int tempA = random.nextInt(9);
            int tempB = random.nextInt(9);
            if (arr[tempA][tempB] != 'X' && counter < 10) {
                arr[tempA][tempB] = 'X';
                counter++;
            } else {
                dest += 1;
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
}