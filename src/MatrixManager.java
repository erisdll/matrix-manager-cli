import java.util.*;

public class MatrixManager {
    private List<Matrix> matricesArrayList;

    public MatrixManager() {
        this.matricesArrayList = new ArrayList<>();
    }

    public void addMatrix(Matrix matrix) {
        matricesArrayList.add(matrix);
    }

    public Matrix getMatrixByIndex(int index) {
        if (index < 0 || index >= matricesArrayList.size()) {
            throw new IndexOutOfBoundsException("Invalid matrix index: " + index);
        }
        return matricesArrayList.get(index);
    }
    public int getMatrixCount() {
        return matricesArrayList.size();
    }
}
