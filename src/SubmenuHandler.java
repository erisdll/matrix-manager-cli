import java.util.Scanner;

public class SubmenuHandler {

    private final Scanner scanner;
    private final MatrixManager matrixManager;

    public SubmenuHandler(MatrixManager matrixManager, Scanner scanner) {
        this.scanner = scanner;
        this.matrixManager = matrixManager;
    }
    public void startOperationsSubmenuOn(Matrix selectedMatrix) {
        int choice;
        do {
            printOperationsSubmenu();
            choice = scanner.nextInt();
            handleOperationsSubmenuChoice(choice, selectedMatrix);
        } while (choice != 0);
    }

    private static void printOperationsSubmenu() {
        System.out.println("Type 1 to repopulate matrix");
        System.out.println("Type 2 to change an element's value");
        System.out.println("Type 3 to add to another matrix");
        System.out.println("Type 4 to subtract another matrix");
        System.out.println("Type 5 to multiply matrix by scalar");
        System.out.println("Type 6 to multiply matrix by another matrix");
        System.out.println("Type 0 to return to main menu");
    }

    private void handleOperationsSubmenuChoice(int choice, Matrix matrix) {
        switch (choice) {
            case 1:
                repopulateMatrixOption(matrix);
                break;

            case 2:
                changeOneElementValueOption(matrix);
                break;

            case 3:
                addAnotherMatrixOption(matrix);
                break;

            case 4:
                subtractAnotherMatrixOption(matrix);
                break;

            case 5:
                multiplyByScalarOption(matrix);
                break;

            case 6:
                multiplyByMatrixOption(matrix);
                break;

            case 0:
                System.out.println("Exiting program!");
                return;

            default:
                System.out.println("Invalid choice!");
        }
    }

    private void repopulateMatrixOption(Matrix matrix) {
        for (int row = 0; row < matrix.getRows(); row++) {
            for (int column = 0; column < matrix.getColumns(); column++) {
                double value = loopPromptForDoubleInput("Insert value for position (" + row + ", " + column + ").");
                matrix.setValue(row, column, value);
            }
        }
        System.out.println(" ");
        matrixManager.printMatrix(matrix);
    }

    private void changeOneElementValueOption(Matrix matrix) {
        int row = loopPromptForIntInput("Insert position for element change:\nRow:") - 1;
        int column = loopPromptForIntInput("Column:") - 1;
        double value = loopPromptForDoubleInput("Insert new value:");
        matrix.setValue(row, column, value);
        matrixManager.printMatrix(matrix);
    }

    private void addAnotherMatrixOption(Matrix matrix) {
        try {
            Matrix matrixB = selectSecondMatrixForOp(1);
            Matrix matrixC = matrix.addMatrix(matrixB);
            System.out.println("Result:");
            matrixManager.printMatrix(matrixC);
        } catch (Exception exception) {
            System.out.println("Failure: " + exception.getMessage());
            scanner.nextLine();
        }
    }

    private void subtractAnotherMatrixOption(Matrix matrix) {
        try {
            Matrix matrixB = selectSecondMatrixForOp(2);
            Matrix matrixC = matrix.subtractMatrix(matrixB);
            System.out.println("Result:");
            matrixManager.printMatrix(matrixC);
        } catch (Exception exception) {
            System.out.println("Failure: " + exception.getMessage());
            scanner.nextLine();
        }
    }

    private void multiplyByScalarOption(Matrix matrix) {
        try{
            System.out.println("Please insert multiplier for scalar multiplication:");
            double scalar = scanner.nextDouble();
            Matrix matrixB = matrix.multiplyByScalar(scalar);
            System.out.println("Result:");
            matrixManager.printMatrix(matrixB);
        } catch (Exception exception) {
            System.out.println("Failure: " + exception.getMessage());
            scanner.nextLine();
        }

    }

    private void multiplyByMatrixOption(Matrix matrix) {
        try {
            Matrix matrixB = selectSecondMatrixForOp(3);
            Matrix matrixC = matrix.multiplyByMatrix(matrixB);
            System.out.println("Result:");
            matrixManager.printMatrix(matrixC);
        } catch (Exception exception) {
            System.out.println("Failure: " + exception.getMessage());
        }
    }

    private Matrix selectSecondMatrixForOp(int opcode) {
        String operationString = switch (opcode) {
            case 1 -> "add to:";
            case 2 -> "subtract from:";
            case 3 -> "multiply by:";
            default -> null;
        };

        System.out.println("Select Matrix to " + operationString);
        System.out.println("List of matrices:");

        int index = 0;
        for (Matrix matrix : matrixManager.listAllMatrices()) {
            System.out.println("\nMatrix n." + (index + 1) + ":");
            matrixManager.printMatrix(matrix);
            index++;
        }
        return matrixManager.selectMatrix(scanner.nextInt() - 1 );
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

