import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);
        MatrixManager matrixManager = new MatrixManager();

        int choice;
        do {
            printMenu();
            choice = scanner.nextInt();

            switch (choice) {

                case 1:
                    createMatrixCase(matrixManager, scanner);
                    break;

                case 2:
                    listMatricesCase(matrixManager);
                    break;

                case 3:
                    populateMatrixCase(matrixManager, scanner);
                    break;

                case 4:
                    selectMatrixCase(matrixManager);
                    break;

                case 5:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice!");
                    break;
            }
        } while (choice != 6);
        scanner.close();
    }

    private static void printMenu() {
        System.out.println("Type 1 to create a new matrix");
        System.out.println("Type 2 to list exiting matrices");
        System.out.println("Type 3 to populate a matrix");
        System.out.println("Type 4 to select a matrix to operate on");
        System.out.println("Type 5 to exit program");
    }

    private static void createMatrixCase(MatrixManager matrixManager, Scanner scanner) {
        Matrix matrix = new Matrix(getMatrixSizeFromConsole(scanner));
        matrixManager.addMatrix(matrix);
        System.out.println("Matrix created");
        populateMatrixCase(matrixManager, scanner);
    }

    private static void populateMatrixCase(MatrixManager matrixManager, Scanner scanner) {
        listMatricesCase(matrixManager);
        System.out.println("Choose matrix to populate:");
        int matrixIndex = (scanner.nextInt() - 1);
        Matrix matrix = matrixManager.getMatrixByIndex(matrixIndex);

        for (int row = 0; row < matrix.getRowCount(); row++) {
            for (int column = 0; column < matrix.getColumnCount(); column++) {
                System.out.println("Insert value for position (" + (row + 1) + ", " + (column + 1) + "):");
                int value = getValueFromConsole(scanner);
                matrix.setElementValue(new SimpleMatrixPosition(row, column), value);
            }
        }
    }

    private static void listMatricesCase(MatrixManager matrixManager) {
        System.out.println("List of matrices:");
        for (int index = 0; index < matrixManager.getMatrixCount(); index++) {
            System.out.println(" ");
            Matrix matrix = matrixManager.getMatrixByIndex(index);
            matrix.printMatrix();
        }
        System.out.println(" ");
    }

    private static void selectMatrixCase(MatrixManager matrixManager) {

    }

    private static MatrixSize getMatrixSizeFromConsole(Scanner scanner) {
        System.out.println("Insert number of rows");
        int rows = scanner.nextInt();
        System.out.println("Insert number of columns");
        int columns = scanner.nextInt();
        return new SimpleMatrixSize(rows, columns) {
        };
    }

    private static MatrixPosition getPositionFromConsole(Scanner scanner) {
        System.out.println("Insert desired position:");
        System.out.println("Row:");
        int row = scanner.nextInt() - 1;
        System.out.println("Column:");
        int column = scanner.nextInt() - 1;
        return new SimpleMatrixPosition(row, column);
    }

    private static Integer getValueFromConsole(Scanner scanner) {
        System.out.println("Insert desired value:");
        return scanner.nextInt();
    }
}