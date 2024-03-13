public class Matrix {
    private Integer rows;
    private Integer columns;
    private Integer[][] matrix;

    public Matrix(MatrixSize matrixSize) {
        this.rows = matrixSize.getRows();
        this.columns = matrixSize.getColumns();
        this.matrix = new Integer[this.rows][this.columns];
    }

    public int getRowCount() {
        return rows;
    }

    public int getColumnCount() {
        return columns;
    }

    public void setElementValue(MatrixPosition matrixPosition, int value) {
        int row = matrixPosition.getRow();
        int column = matrixPosition.getColumn();
        if (!isValidIndex(matrixPosition)) {
            throw new IllegalArgumentException("Invalid position!");
        }
        matrix[row][column] = value;
    }

    public Integer getElementValue(MatrixPosition matrixPosition) {
        int row = matrixPosition.getRow();
        int column = matrixPosition.getColumn();
        if (isValidIndex(matrixPosition)) {
            return matrix[row][column];
        } else {
            throw new IllegalArgumentException("Invalid position!");
        }
    }

    public void print() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    private boolean isValidIndex(MatrixPosition matrixPosition) {
        int row = matrixPosition.getRow();
        int column = matrixPosition.getColumn();
        return row >= 0 && row < rows && column >= 0 && column < columns;
    }
}