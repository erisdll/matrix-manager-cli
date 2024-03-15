import java.util.Scanner;

public class MainMenuHandler {
    private final OperationsSubmenuHandler operationsSubMenuHandler;
    private final MatrixManager matrixManager;
    private final Scanner scanner;
    public MainMenuHandler(MatrixManager matrixManager, Scanner scanner) {
        this.operationsSubMenuHandler = new OperationsSubmenuHandler();
        this.matrixManager = matrixManager;
        this.scanner = scanner;
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
                createMatrixOption(matrixManager, scanner);
                break;

            case 2:
                listMatricesOption(matrixManager);
                break;

            case 3:
                selectMatrixOption(matrixManager, scanner);
                break;

            case 0:
                System.out.println("Exiting program!");
                return;

            default:
                System.out.println("Invalid choice!");
        }
    }

    private static void createMatrixOption(MatrixManager matrixManager, Scanner scanner) {
        Matrix matrix = new Matrix(getMatrixSizeFromConsole(scanner));
        matrixManager.addMatrixToList(matrix);
        for (int row = 0; row < matrix.getRowCount(); row++) {
            for (int column = 0; column < matrix.getColumnCount(); column++) {
                System.out.println("Insert value for position (" + (row + 1 + ", " + (column + 1) + "):"));
                int value = getValueFromConsole(scanner);
                matrix.setElementValue(new SimpleMatrixPosition(row, column), value);
            }
        }
        System.out.println("Matrix created successfully!");
    }

    private static void listMatricesOption(MatrixManager matrixManager) {
        System.out.println("List of matrices:");
        int index = 0;
        for (Matrix matrix : matrixManager.listMatrices()) {
            System.out.println("\nMatrix n." + (index + 1) + ":");
            matrix.printMatrix();
            index++;
        }
        System.out.println(" ");
    }

    private void selectMatrixOption(MatrixManager matrixManager, Scanner scanner) {
        System.out.println("List of available matrices:");
        int index = 0;
        for (Matrix matrix : matrixManager.listMatrices()) {
            System.out.println("\nMatrix n." + (index + 1) + ":");
            matrix.printMatrix();
            index++;
        }
        System.out.println(" ");
        System.out.println("Enter the number of the matrix you want to select:");
        int matrixChoice = scanner.nextInt();

        if (matrixChoice > 0 && matrixChoice <= matrixManager.getMatrixCount()) {
            Matrix selectedMatrix = matrixManager.getMatrixByIndex(matrixChoice -1 );
            System.out.println("Selected Matrix:");
            selectedMatrix.printMatrix();
            System.out.println(" ");

            operationsSubMenuHandler.startOperationsSubMenu(selectedMatrix, scanner);

        } else {
            System.out.println("No such matrix!");
        }
    }

    private static MatrixSize getMatrixSizeFromConsole(Scanner scanner) {
        System.out.println("Insert number of rows");
        int rows = scanner.nextInt();
        System.out.println("Insert number of columns");
        int columns = scanner.nextInt();
        return new SimpleMatrixSize(rows, columns) {
        };
    }

    private static Integer getValueFromConsole(Scanner scanner) {
        System.out.println("Insert desired value:");
        return scanner.nextInt();
    }
}