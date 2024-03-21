public class Matrix {
    private Integer rows;
    private Integer columns;
    private Double[][] matrix;

    public Matrix(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.matrix = new Double[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = 0.0;
            }
        }
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public void setValue(int row, int column, double value) throws IllegalArgumentException {
        if (!isValidIndex(row, column)) {
            throw new IllegalArgumentException("Invalid position!");
        }
        matrix[row][column] = value;
    }

    public double getValue(int row, int column) throws IllegalArgumentException {
        if (isValidIndex(row, column)) {
            return matrix[row][column];
        } else {
            throw new IllegalArgumentException("Invalid position!");
        }
    }

    public Matrix randomlyPopulateMatrix() {
        for (int i = 0; i < this.getRows(); i++) {
            for (int j = 0; j < this.getColumns(); j++) {
                this.setValue(i, j, Math.random() * 1000);
            }
        }
        return this;
    }

    public Matrix addMatrix(Matrix matrixB) {
        if ( this.getRows() != matrixB.getRows() || this.getColumns() != matrixB.getColumns()) {
            throw new IllegalArgumentException("Cannot add matrices of different dimensions!");
        }

        Matrix matrixC = new Matrix(this.getRows(), this.getColumns());
        for (int i = 0; i < this.getRows(); i++) {
            for (int j = 0; j < this.getColumns(); j++) {
                matrixC.setValue(i, j, this.getValue(i, j) + matrixB.getValue(i, j));
            }
        }
        return matrixC;
    }

    public Matrix subtractMatrix(Matrix matrixB) {
        if ( this.getRows() != matrixB.getRows() || this.getColumns() != matrixB.getColumns()) {
            throw new IllegalArgumentException("Cannot subtract matrices of different dimensions!");
        }

        Matrix matrixC = new Matrix(this.getRows(), this.getColumns());
        for (int i = 0; i < this.getRows(); i++) {
            for (int j = 0; j < this.getColumns(); j++) {
                matrixC.setValue(i, j, this.getValue(i, j) - matrixB.getValue(i, j));
            }
        }
        return matrixC;
    }

    public Matrix multiplyByScalar(double scalar) {
        Matrix matrix = this;
        for (int i = 0; i < matrix.getRows(); i++) {
            for (int j = 0; j < matrix.getColumns(); j++) {
                double newValue = (matrix.getValue(i, j) * scalar);
                this.setValue(i, j, newValue);
            }
        }
        return matrix;
    }

    public Matrix multiplyByMatrix(Matrix matrixB) throws IllegalArgumentException {
        if (this.getColumns() != matrixB.getRows()) {
            throw new IllegalArgumentException("Cannot multiply selected matrices!");
        }

        Matrix matrixC = new Matrix(this.getRows(), matrixB.getColumns());
        for (int i = 0; i < matrixC.getRows(); i++) {
            for (int j = 0; j < matrixC.getColumns(); j++) {
                for (int k = 0; k < this.getColumns(); k++) {
                    double value = matrixC.getValue(i,j) + (this.getValue(i, k) * matrixB.getValue(k, j));
                    matrixC.setValue(i, j, value);
                }
            }
        }
        return matrixC;
    }

    private boolean isValidIndex(int row, int column) {
        return row >= 0 && row < rows && column >= 0 && column < columns;
    }
}
