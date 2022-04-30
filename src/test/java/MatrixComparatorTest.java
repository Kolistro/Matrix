import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class MatrixComparatorTest {
    DiagMatrix diagMatrix;
    UpTriangleMatrix upTriangleMatrix;

    @Before
    public void setUp() throws Exception {
        diagMatrix = new DiagMatrix(1, 2, 3);

        upTriangleMatrix = new UpTriangleMatrix(3);
        upTriangleMatrix.setElement(0,0,1);
        upTriangleMatrix.setElement(1,1,3);
        upTriangleMatrix.setElement(2,2,2);
        upTriangleMatrix.setElement(1,2, 5);
    }

    @Test
    public void compareTest(){
        MatrixComparator matrixComparator = new MatrixComparator();
        int result = matrixComparator.compare(diagMatrix, upTriangleMatrix);
        int expected = 0;
        assertEquals(result, expected);
    }

}
