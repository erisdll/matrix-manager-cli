import java.util.Scanner;

public class OperationsSubmenuHandler {

    private final Scanner scanner;
    private final MatrixManager matrixManager;

    public OperationsSubmenuHandler(MatrixManager matrixManager, Scanner scanner) {
        this.scanner = scanner;
        this.matrixManager = matrixManager;
    }
    public void startOperationsSubmenuOnMatrix(Matrix matrix) {
        int choice;
        do {
            printOperationsSubmenu();
            choice = scanner.nextInt();
            handleOperationsSubmenuChoice(choice, matrix);
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
                matrix.setElementValue(new SimpleMatrixPosition(row, column), scanner.nextInt());
            }
        }
        System.out.println(" ");
        matrix.printMatrix();
    }

    private void changeOneElementValueOption(Matrix matrix) {
        matrix.setElementValue(getPositionFromConsole(), getValueFromConsole());
        matrix.printMatrix();
        System.out.println(" ");
    }

    private void addAnotherMatrixOption(Matrix matrix) {
        Matrix secondMatrix = selectSecondMatrixForOperation("addition");

        if ( matrix.getRows() != secondMatrix.getRows() || matrix.getColumns() != secondMatrix.getColumns()) {
            System.out.println("Cannot add matrices of different dimensions!");
        } else {
            for (int row = 0; row < matrix.getRows(); row++) {
                for (int column = 0; column < matrix.getColumns(); column++) {
                    MatrixPosition pos = new SimpleMatrixPosition(row, column);
                    matrix.setElementValue(pos, matrix.getElementValue(pos) + secondMatrix.getElementValue(pos));
                }
            }
            System.out.println("Result:");
            matrix.printMatrix();
        }
    }

    private void subtractAnotherMatrixOption(Matrix matrix) {
        Matrix secondMatrix = selectSecondMatrixForOperation("subtraction");

        if ( matrix.getRows() != secondMatrix.getRows() || matrix.getColumns() != secondMatrix.getColumns()) {
            System.out.println("Cannot subtract matrices of different dimensions!");
        } else {
            for (int row = 0; row < matrix.getRows(); row++) {
                for (int column = 0; column < matrix.getColumns(); column++) {
                    MatrixPosition pos = new SimpleMatrixPosition(row, column);
                    matrix.setElementValue(pos, matrix.getElementValue(pos) - secondMatrix.getElementValue(pos));
                }
            }
            System.out.println("Result:");
            matrix.printMatrix();
        }
    }

    private Matrix selectSecondMatrixForOperation(String operation) {

        String operationString = switch (operation) {
            case "addition" -> "add to:";
            case "subtraction" -> "subtract:";
            case "multiplication" -> "multiply by:";
            case "division" -> "divide by";
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

    private MatrixPosition getPositionFromConsole() {
        System.out.println("Insert desired position:");
        System.out.println("Row:");
        int row = scanner.nextInt() - 1;
        System.out.println("Column:");
        int column = scanner.nextInt() - 1;
        return new SimpleMatrixPosition(row, column);
    }

    private Integer getValueFromConsole() {
        System.out.println("Insert desired value:");
        return scanner.nextInt();
    }
}

