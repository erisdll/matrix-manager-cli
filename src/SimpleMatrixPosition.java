public class SimpleMatrixPosition implements MatrixPosition{
    private final int row;
    private final int column;

    public SimpleMatrixPosition(int row, int column) {
        this.row = row;
        this.column = column;
    }

    @Override
    public int getRow() {
        return row;
    }

    @Override
    public int getColumn() {
        return column;
    }
}
