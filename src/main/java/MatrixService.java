import java.util.Arrays;

public class MatrixService {
    public static void arrangeMatrices(Matrix[] matrices, MatrixComparator matrixComparator){
        Arrays.sort(matrices, matrixComparator);
    }
}
