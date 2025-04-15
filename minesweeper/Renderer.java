public class Renderer {
    public static void printField(char[][] field, boolean[][] revealed, boolean[][] marks) {
        int rows = field.length;
        int cols = field[0].length;

        System.out.print(" |");
        for (int i = 0; i < cols; i++) {
            System.out.printf("%d", i + 1);
        }
        System.out.println("|");

        System.out.print("-|");
        for (int i = 0; i < cols; i++) {
            System.out.print("-");
        }
        System.out.println("|");

        for (int i = 0; i < rows; i++) {
            System.out.printf("%d|", i + 1);
            for (int j = 0; j < cols; j++) {
                if (marks[i][j]) {
                    System.out.print("*");
                } else if (!revealed[i][j]) {
                    System.out.print(".");
                } else {
                    if (field[i][j] == ' ') {
                        System.out.print("/");
                    } else {
                        System.out.printf("%c", field[i][j]);
                    }
                }
            }
            System.out.println("|");
        }

        System.out.print("-|");
        for (int i = 0; i < cols; i++) {
            System.out.print("-");
        }
        System.out.println("|");
    }
}
