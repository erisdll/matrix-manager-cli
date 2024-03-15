import java.util.Scanner;

public class OperationsSubmenuHandler {
    public void startOperationsSubMenu(Matrix matrix, Scanner scanner) {
        int choice;
        do {
            printOperationsSubmenu();
            choice = scanner.nextInt();
            handleOperationsSubMenuChoice(choice, matrix, scanner);
        } while (choice != 0);
    }

    private static void printOperationsSubmenu() {
        System.out.println("Type 1 to repopulate matrix");
        System.out.println("Type 2 to change an element's value");
        System.out.println("Type 3 to find the determinant");
        System.out.println("Type 4 to invert the matrix");
        System.out.println("Type 5 to transpose matrix");
        System.out.println("Type 6 to add another matrix");
        System.out.println("Type 7 to subtract another matrix");
        System.out.println("Type 8 to multiply by scalar");
        System.out.println("Type 9 to multiply by another matrix");
        System.out.println("Type 10 to divide by scalar");
        System.out.println("Type 11 to divide by another matrix");
        System.out.println("Type 0 to return to main menu");
    }

    private void handleOperationsSubMenuChoice(int choice, Matrix matrix, Scanner scanner) {
        switch (choice) {
            case 1:
                repopulateMatrixOption(matrix, scanner);
                break;

            case 2:
                changeElementValueOption(matrix, scanner);
                break;

            case 0:
                System.out.println("Exiting program!");
                return;

            default:
                System.out.println("Invalid choice!");
        }
    }

    private void repopulateMatrixOption(Matrix matrix, Scanner scanner) {

    }

    private void changeElementValueOption(Matrix matrix, Scanner scanner) {

    }

    private static MatrixPosition getPositionFromConsole(Scanner scanner) {
        System.out.println("Insert desired position:");
        System.out.println("Row:");
        int row = scanner.nextInt() - 1;
        System.out.println("Column:");
        int column = scanner.nextInt() - 1;
        return new SimpleMatrixPosition(row, column);
    }
}
