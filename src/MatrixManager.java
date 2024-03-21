import java.text.DecimalFormat;
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

    public Matrix selectMatrix(int index) {
        if (index < 0 || index >= matricesArrayList.size()) {
            throw new IndexOutOfBoundsException();
        }
        return matricesArrayList.get(index);
    }

    public List<Matrix> listAllMatrices() {
        return Collections.unmodifiableList(matricesArrayList);
    }

    public void printMatrix(Matrix matrix) {
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        for (int i = 0; i < matrix.getRows(); i++) {
            for (int j = 0; j < matrix.getColumns(); j++) {
                System.out.print(decimalFormat.format(matrix.getValue(i, j)) + " ");
            }
            System.out.println();
        }
    }
}
