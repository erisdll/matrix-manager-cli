import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MatrixManager {
    private List<Matrix> matricesArrayList;

    public MatrixManager() {
        this.matricesArrayList = new ArrayList<>();
    }

    public void addMatrixToList(Matrix matrix) {
        matricesArrayList.add(matrix);
    }

    public Matrix getMatrixByIndex(int index) {
        if (index < 0 || index >= matricesArrayList.size()) {
            throw new IndexOutOfBoundsException("Invalid matrix index: " + index);
        }
        return matricesArrayList.get(index);
    }
    public List<Matrix> listMatrices() {
        return Collections.unmodifiableList(matricesArrayList);
    }
    public int getMatrixCount() {
        return matricesArrayList.size();
    }
}
