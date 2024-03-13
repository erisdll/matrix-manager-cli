public class SimpleMatrixSize implements MatrixSize{
    private final int rows;
    private final int columns;

    public SimpleMatrixSize(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
    }

    @Override
    public int getRows() {
        return rows;
    }

    @Override
    public int getColumns() {
        return columns;
    }
}
