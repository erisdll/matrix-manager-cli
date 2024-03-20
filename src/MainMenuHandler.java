import java.util.Scanner;

public class MainMenuHandler {
    private final Scanner scanner;
    private final MatrixManager matrixManager;
    private final SubmenuHandler subMenuHandler;
    public MainMenuHandler(MatrixManager matrixManager, Scanner scanner) {
        this.scanner = scanner;
        this.matrixManager = matrixManager;
        this.subMenuHandler = new SubmenuHandler(matrixManager, scanner);
    }

    public void startMainMenu() {
        int choice;
        do {
            printMainMenu();
            choice = scanner.nextInt();
            handleMainMenuChoice(choice);
        } while (choice != 0);
    }

    private static void printMainMenu() {
        System.out.println("Type 1 to create a new matrix");
        System.out.println("Type 2 to list exiting matrices");
        System.out.println("Type 3 to select a matrix");
        System.out.println("Type 0 to exit program");
    }

    private void handleMainMenuChoice(int choice) {
        switch (choice) {
            case 1:
                createMatrixOption();
                break;

            case 2:
                listMatricesOption();
                break;

            case 3:
                selectMatrixOption();
                break;

            case 0:
                System.out.println("Exiting program!");
                return;

            default:
                System.out.println("Invalid choice!");
        }
    }

    private void createMatrixOption() {
        System.out.println("Insert number of rows");
        int rows = scanner.nextInt();
        System.out.println("Insert number of columns");
        int columns = scanner.nextInt();

        Matrix matrix = new Matrix(rows, columns);
        matrixManager.addMatrixToList(matrix);

        for (int row = 0; row < matrix.getRows(); row++) {
            for (int column = 0; column < matrix.getColumns(); column++) {
                System.out.println("Insert value for position (" + (row + 1 + ", " + (column + 1) + "):"));
                double value = getValueFromConsole(scanner);
                matrix.setValue(row, column, value);
            }
        }
        System.out.println("Matrix created successfully!");
    }

    private void listMatricesOption() {
        System.out.println("List of matrices:");
        int index = 0;
        for (Matrix matrix : matrixManager.listAllMatrices()) {
            System.out.println("\nMatrix n." + (index + 1) + ":");
            matrix.printMatrix();
            index++;
        }
        System.out.println(" ");
    }

    private void selectMatrixOption() {
        System.out.println("List of available matrices:");

        int index = 0;
        for (Matrix matrix : matrixManager.listAllMatrices()) {
            System.out.println("\nMatrix n." + (index + 1) + ":");
            matrix.printMatrix();
            index++;
        }

        try {
            System.out.println("Enter the number of the matrix you want to select:");
            Matrix selectedMatrix = matrixManager.selectMatrix(scanner.nextInt() - 1 );
            System.out.println("Selected Matrix:");
            selectedMatrix.printMatrix();
            System.out.println(" ");
            subMenuHandler.startOperationsSubmenuOnMatrix(selectedMatrix);
        } catch (Exception e) {
            System.out.println("No Such Matrix!");
        }
    }

    private static double getValueFromConsole(Scanner scanner) {
        System.out.println("Insert desired value:");
        return scanner.nextDouble();
    }
}