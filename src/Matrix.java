public class Matrix {
    private Integer rows;
    private Integer columns;
    private Integer[][] matrix;

    public Matrix(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.matrix = new Integer[this.rows][this.columns];
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public void setElementValue(int row, int column, int value) {
        if (!isValidIndex(row, column)) {
            throw new IllegalArgumentException("Invalid position!");
        }
        matrix[row][column] = value;
    }

    public Integer getElementValue(int row, int column) {
        if (isValidIndex(row, column)) {
            return matrix[row][column];
        } else {
            throw new IllegalArgumentException("Invalid position!");
        }
    }

    public void printMatrix() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    private boolean isValidIndex(int row, int column) {
        return row >= 0 && row < rows && column >= 0 && column < columns;
    }
}