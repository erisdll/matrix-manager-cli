import java.util.Scanner;

public class SubmenuHandler {

    private final Scanner scanner;
    private final MatrixManager matrixManager;

    public SubmenuHandler(MatrixManager matrixManager, Scanner scanner) {
        this.scanner = scanner;
        this.matrixManager = matrixManager;
    }
    public void startOperationsSubmenuOnMatrix(Matrix selectedMatrix) {
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
        System.out.println("Type 5 to multiply matrix");
        System.out.println("Type 6 to divide matrix");
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
                multiplyMatrixOption(matrix);
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
                System.out.println("Insert value for position (" + row + ", " + column + ").");
                matrix.setValue(row, column, scanner.nextDouble());
            }
        }
        System.out.println(" ");
        matrix.printMatrix();
    }

    private void changeOneElementValueOption(Matrix matrix) {
        System.out.println("Insert position for element change:\nRow:");
        int row = (scanner.nextInt() - 1);

        System.out.println("Column:");
        int column = (scanner.nextInt() - 1);

        System.out.println("Insert new value:");
        double value = scanner.nextDouble();

        matrix.setValue(row, column, value);
        matrix.printMatrix();
    }

    private void addAnotherMatrixOption(Matrix matrixA) {
        Matrix matrixB = selectSecondMatrixForOp("addition");

        if ( matrixA.getRows() != matrixB.getRows() || matrixA.getColumns() != matrixB.getColumns()) {
            System.out.println("Cannot add matrices of different dimensions!");
        } else {
            for (int row = 0; row < matrixA.getRows(); row++) {
                for (int column = 0; column < matrixA.getColumns(); column++) {
                    double valueA = matrixA.getValue(row, column);
                    double valueB = matrixB.getValue(row, column);
                    double finalValue = valueA + valueB;
                    matrixA.setValue(row, column, finalValue);
                }
            }
            System.out.println("Result:");
            matrixA.printMatrix();
        }
    }

    private void subtractAnotherMatrixOption(Matrix matrixA) {
        Matrix matrixB = selectSecondMatrixForOp("subtraction");

        if ( matrixA.getRows() != matrixB.getRows() || matrixA.getColumns() != matrixB.getColumns()) {
            System.out.println("Cannot subtract matrices of different dimensions!");
        } else {
            for (int row = 0; row < matrixA.getRows(); row++) {
                for (int column = 0; column < matrixA.getColumns(); column++) {
                    double valueA = matrixA.getValue(row, column);
                    double valueB = matrixB.getValue(row, column);
                    double finalValue = valueA - valueB;
                    matrixA.setValue(row, column, finalValue);
                }
            }
            System.out.println("Result:");
            matrixA.printMatrix();
        }
    }

    private void multiplyMatrixOption(Matrix matrix) {
        System.out.println("Type 1 for scalar multiplication.");
        System.out.println("Type 2 for matrix multiplication.");
        System.out.println("Type 3 to cancel operation.");

        switch (scanner.nextInt()) {
            case 1: multiplyByScalar(matrix);
                break;

            case 2: multiplyByMatrix(matrix);
                break;

            case 3:
                return;

            default:
                System.out.println("Invalid option!");
        }
    }

    private void multiplyByScalar(Matrix matrixA) {
        System.out.println("Please insert multiplier for scalar multiplication:");
        double scalar = scanner.nextDouble();

        Matrix matrixB = new Matrix(matrixA.getRows(), matrixA.getColumns());

        for (int i = 0; i < matrixA.getRows(); i++) {
            for (int j = 0; j < matrixA.getColumns(); j++) {
                double newValue = (matrixA.getValue(i, j) * scalar);
                matrixB.setValue(i, j, newValue);
            }
        }
        matrixManager.printMatrix(matrixB);
    }

    private void multiplyByMatrix(Matrix matrixA) {
        Matrix matrixB = selectSecondMatrixForOp("multiplication");

        if (matrixA.getColumns() != matrixB.getRows()) {
            System.out.println("Cannot multiply selected matrices!");
            System.out.println("The number of columns in matrix A must be equal to the number of rows in matrix B.");
        } else {

            Matrix matrixC = new Matrix(matrixA.getRows(), matrixB.getColumns());

            for (int i = 0; i < matrixC.getRows(); i++) {
                for (int j = 0; j < matrixC.getColumns(); j++) {
                    for (int k = 0; k < matrixA.getColumns(); k++) {
                        double value = matrixC.getValue(i,j) + (matrixA.getValue(i, k) * matrixB.getValue(k, j));
                        matrixC.setValue(i, j, value);
                    }
                }
            }
            matrixManager.printMatrix(matrixC);
        }
    }

    private Matrix selectSecondMatrixForOp(String operation) {
        String operationString = switch (operation) {
            case "addition" -> "add to:";
            case "subtraction" -> "subtract from:";
            case "multiplication" -> "multiply by:";
            case "division" -> "divide by: ";
            default -> null;
        };

        System.out.println("Select Matrix to " + operationString);
        System.out.println("List of matrices:");

        int index = 0;
        for (Matrix matrices : matrixManager.listAllMatrices()) {
            System.out.println("\nMatrix n." + (index + 1) + ":");
            matrices.printMatrix();
            index++;
        }

        return matrixManager.selectMatrix(scanner.nextInt() - 1 );
    }
}

