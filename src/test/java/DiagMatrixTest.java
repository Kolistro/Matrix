import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DiagMatrixTest {
    private static DiagMatrix diagMatrix;

    @Test
    public void constructorExceptionTest(){
        try{
            DiagMatrix m1 = new DiagMatrix(-5);
        }catch (IllegalArgumentException e){
            System.err.println(e.getMessage());
        }

        try {
            DiagMatrix m2 = new DiagMatrix(0);
        }catch (IllegalArgumentException e){
            System.err.println(e.getMessage());
        }
    }

    @Before
    public void setUp(){
        try{
            diagMatrix = new DiagMatrix(1, 2, 3);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    //Выбрасывает исключение, если ввели индексы элемента ниже диагонали
    @Test
    public void setElementExceptionBelowTheDiagonalTest(){
        try {
            diagMatrix.setElement(0, 1, 25);
        }catch (Exception e){
            System.err.println(e.getMessage());
        }

        try {
            diagMatrix.setElement(0, 2, 25);
        }catch (Exception e){
            System.err.println(e.getMessage());
        }

        try {
            diagMatrix.setElement(1, 2, 25);
        }catch (Exception e){
            System.err.println(e.getMessage());
        }


        try {
            diagMatrix.setElement(1, 0, 25);
        }catch (Exception e){
            System.err.println(e.getMessage());
        }

        try {
            diagMatrix.setElement(2, 0, 25);
        }catch (Exception e){
            System.err.println(e.getMessage());
        }

        try {
            diagMatrix.setElement(2, 1, 25);
        }catch (Exception e){
            System.err.println(e.getMessage());
        }
    }

    @Test
    public void getElementBelowTheDiagonalTest(){
        double result = 45;
        try {
            result = diagMatrix.getElement(1, 0);

        }catch (Exception e){
            System.err.println(e.getMessage());
        }
        double expected = 0;
        assertEquals(expected, result, 0.00001);

    }

    @Test
    public void setAndGetElementTest(){
        try {
            diagMatrix.setElement(0, 0, 58);
            double expected = 58;
            double result = diagMatrix.getElement(0,0);
            assertEquals(expected, result, 0.1);
        }catch (Exception e){
            System.err.println(e.getMessage());
        }
    }

    @Test
    public void getDeterminantTest(){
        double expected = 6;
        double result = diagMatrix.getDeterminant();
        System.out.println(result);
        assertEquals(expected, result, 0.000001);
    }
}
