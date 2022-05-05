import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class MatrixServiceTest {
    Matrix[] matrices;
    MatrixComparator matrixComparator = new MatrixComparator();
    Matrix matrix;
    UpTriangleMatrix upTriangleMatrix;
    DiagMatrix diagMatrix;

    @Before
    public void setUp() throws Exception {
        matrices = new Matrix[3];

        diagMatrix = new DiagMatrix(1, 2, 3);

        upTriangleMatrix = new UpTriangleMatrix(3);
        upTriangleMatrix.setElement(0,0, 1);
        upTriangleMatrix.setElement(0,1, 2);
        upTriangleMatrix.setElement(0,2, 3);
        upTriangleMatrix.setElement(1,1, 5);
        upTriangleMatrix.setElement(1,2, 6);
        upTriangleMatrix.setElement(2,2, 9);

        matrix = new Matrix(3);
        matrix.setElement(0,0, 1);
        matrix.setElement(0,1, 2);
        matrix.setElement(0,2, 3);
        matrix.setElement(1,0, 4);
        matrix.setElement(1,1, 5);
        matrix.setElement(1,2, 6);
        matrix.setElement(2,0, 7);
        matrix.setElement(2,1, 8);
        matrix.setElement(2,2, 9);

        matrices[0] = upTriangleMatrix;
        matrices[1] = matrix;
        matrices[2] = diagMatrix;
    }

    @Test
    public  void arrangeMatricesTest(){
        MatrixService.arrangeMatrices(matrices, matrixComparator);

        Matrix[] matricesRes = new Matrix[3];
        matricesRes[0]= matrix;
        matricesRes[1]= diagMatrix;
        matricesRes[2]= upTriangleMatrix;

        assertEquals(true, Arrays.equals(matrices, matricesRes));
    }


}
