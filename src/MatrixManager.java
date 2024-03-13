import java.util.HashMap;
import java.util.Map;

public class MatrixManager {
    private Map<String, Matrix> matrices;

    public MatrixManager() {
        this.matrices = new HashMap<>();
    }

    public void createMatrix(String identifier, MatrixSize matrixSize) {
        if (identifier == null || identifier.isEmpty()) {
            throw new IllegalArgumentException("Matrix name cannot be null or empty.");
        } if (matrices.containsKey(identifier)) {
            System.out.println("Matrix with the same name already exists.");
            return;
        }

        Matrix matrix = new Matrix(matrixSize);
        matrices.put(identifier, matrix);
    }

    public Matrix getMatrix (String name) {
        return matrices.get(name);
    }

    public void deleteMatrix(String name) {
        matrices.remove(name);
    }
}
