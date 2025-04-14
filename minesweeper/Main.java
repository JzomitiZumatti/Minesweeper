import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Field newField = new Field();
        System.out.print("How many mines do you want on the field? > ");
        newField.setNumberOfMines(scanner.nextInt());
        newField.createBattleField();
        newField.showBattleField();
    }
}
