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
                    createNewMatrix(matrixManager, scanner);
                    break;

                case 2:
                    listMatrices(matrixManager);
                    break;

                case 3:

                    break;

                case 4:

                    break;

                case 5:

                    break;

                case 6:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice!");
                    break;
            }
        } while (choice != 6);

        scanner.close();
    }

    private static void listMatrices(MatrixManager matrixManager) {
    }

    private static void printToConsole(Matrix matrix) {

    }


    private static void printMenu() {
        System.out.println("Type 1 to create a new matrix");
        System.out.println("Type 2 to print the matrix");
        System.out.println("Type 3 to observe a position in the matrix");
        System.out.println("Type 4 to change a value in the matrix");
        System.out.println("Type 5 to delete the matrix");
        System.out.println("Type 6 to exit the program");
    }

    private static void createNewMatrix(MatrixManager matrixManager, Scanner scanner) {
        System.out.println("Enter the name for the new matrix:");
        String name = scanner.next();

        System.out.println("Enter the number of rows:");
        int rows = scanner.nextInt();

        System.out.println("Enter the number of columns:");
        int columns = scanner.nextInt();

        MatrixSize matrixSize = new SimpleMatrixSize(rows, columns);
        matrixManager.createMatrix(name, matrixSize);
        System.out.println("Matrix created successfully.");
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