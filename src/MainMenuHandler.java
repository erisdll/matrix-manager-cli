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
        int rows = loopPromptForIntInput("Insert number of rows:");
        int columns = loopPromptForIntInput("Insert number of columns:");

        Matrix matrix = new Matrix(rows, columns);
        matrixManager.addMatrixToList(matrix);

        System.out.println("Type 1 to auto populate the matrix.");
        System.out.println("Type 2 to manually populate the matrix.");

        int choice;
        do {
            System.out.println("Invalid choice! Enter either 1 or 2.");
            choice = scanner.nextInt();
        } while (choice != 1 && choice != 2);

        if (choice == 1) {
            matrix.randomlyPopulateMatrix();
        } else {
            manuallyPopulateMatrix(matrix);
        }

        System.out.println("Matrix created successfully!");
    }

    private void manuallyPopulateMatrix(Matrix matrix) {
        for (int i = 0; i < matrix.getRows(); i++) {
            for (int j = 0; j < matrix.getColumns(); j++) {
                String message = "Insert value for position (" + (i + 1) + ", " + (j + 1) + "):";
                double value = loopPromptForDoubleInput(message);
                matrix.setValue(i, j, value);
            }
        }
    }

    private void listMatricesOption() {
        printMatrixListToConsole();
    }

    private void selectMatrixOption() {
        printMatrixListToConsole();
        try {
            int selection = loopPromptForIntInput("Enter the number of the matrix you want to select:") - 1;
            Matrix selectedMatrix = matrixManager.getMatrixFromList(selection);
            System.out.println("Selected Matrix:");
            matrixManager.printMatrix(selectedMatrix);
            subMenuHandler.startOperationsSubmenuOn(selectedMatrix);
        } catch (Exception exception) {
            System.out.println("Failure: " + exception.getMessage());
        }
    }

    private void printMatrixListToConsole() {
        System.out.println("List of matrices:");
        int index = 0;
        for (Matrix matrix : matrixManager.getAllMatrices()) {
            System.out.println("\nMatrix n." + (index + 1) + ":");
            matrixManager.printMatrix(matrix);
            index++;
        }
        System.out.println(" ");
    }

    private int loopPromptForIntInput(String message) {
        System.out.println(message);
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter an integer:");
            scanner.next();
        }
        return scanner.nextInt();
    }

    private double loopPromptForDoubleInput(String message) {
        System.out.println(message);
        while (!scanner.hasNextDouble()) {
            System.out.println("Invalid input. Please enter a number:");
            scanner.next();
        }
        return scanner.nextDouble();
    }
}