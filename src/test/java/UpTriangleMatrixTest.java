import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class UpTriangleMatrixTest {
    private  static UpTriangleMatrix upTriangleMatrix;
    @Test
    public void constructorExceptionTest(){
        try{
            UpTriangleMatrix m1 = new UpTriangleMatrix(-5);
        }catch (IllegalArgumentException e){
            System.err.println(e.getMessage());
        }

        try {
            UpTriangleMatrix m2 = new UpTriangleMatrix(0);
        }catch (IllegalArgumentException e){
            System.err.println(e.getMessage());
        }
    }

    @Test
    public void getIndexDiagTest(){
        UpTriangleMatrix matrix = new UpTriangleMatrix(3);
        int[] result = matrix.getIndexDiag();
        int[] expected = {0, 4, 8};
        assertEquals(true, Arrays.equals(result, expected));
    }

    @Before
    public void setUp(){
        upTriangleMatrix = new UpTriangleMatrix(3);
    }

    //Выбрасывает исключение, если ввели индексы элемента ниже диагонали
    @Test
    public void setElementExceptionBelowTheDiagonalTest(){
        try {
            upTriangleMatrix.setElement(1, 0, 25);
        }catch (Exception e){
            System.err.println(e.getMessage());
        }

        try {
            upTriangleMatrix.setElement(2, 0, 25);
        }catch (Exception e){
            System.err.println(e.getMessage());
        }

        try {
            upTriangleMatrix.setElement(2, 1, 25);
        }catch (Exception e){
            System.err.println(e.getMessage());
        }
    }

    //Выбрасывает исключение, если подан отрицательный индекс
    @Test
    public void setElementIllegalAccessExceptionTest(){
        try {
            upTriangleMatrix.setElement(-1, 0, 2);
        }catch (Exception e){
            System.err.println(e.getMessage());
        }

        try {
            upTriangleMatrix.setElement(2, -5, 2.3);
        }catch (Exception e){
            System.err.println(e.getMessage());
        }
    }

    //Выбрасывает исключение, если вышли за пределы массива
    @Test
    public void setElementIndexOutOfBoundsExceptionTest(){
        try {
            upTriangleMatrix.setElement(3, 2, 3);
        }catch (Exception e){
            System.err.println(e.getMessage());
        }

        try {
            upTriangleMatrix.setElement(2, 6, 2.3);
        }catch (Exception e){
            System.err.println(e.getMessage());
        }
    }

    @Test
    public void getElementBelowTheDiagonalTest(){
        double result = 45;
        try {
            result = upTriangleMatrix.getElement(1, 0);

        }catch (Exception e){
            System.err.println(e.getMessage());
        }
        double expected = 0;
        assertEquals(expected, result, 0.00001);

    }

    @Test
    public void getElementIllegalAccessExceptionTest(){
        try {
            upTriangleMatrix.getElement(-1, 0);
        }catch (Exception e){
            System.err.println(e.getMessage());
        }

        try {
            upTriangleMatrix.getElement(2, -5);
        }catch (Exception e){
            System.err.println(e.getMessage());
        }
    }

    @Test
    public void getElementIndexOutOfBoundsExceptionTest(){
        try {
            upTriangleMatrix.getElement(3, 2);
        }catch (Exception e){
            System.err.println(e.getMessage());
        }

        try {
            upTriangleMatrix.getElement(2, 6);
        }catch (Exception e){
            System.err.println(e.getMessage());
        }
    }

    @Test
    public void setAndGetElementTest(){
        try {
            upTriangleMatrix.setElement(0, 0, 58);
            double expected = 58;
            double result = upTriangleMatrix.getElement(0,0);
            assertEquals(expected, result, 0.1);
        }catch (Exception e){
            System.err.println(e.getMessage());
        }
    }

    @Test
    public void getDeterminantTest(){
        try {
            upTriangleMatrix.setElement(0,0, 1);
            upTriangleMatrix.setElement(0,1, 2);
            upTriangleMatrix.setElement(0,2, 3);
            upTriangleMatrix.setElement(1,1, 5);
            upTriangleMatrix.setElement(1,2, 6);
            upTriangleMatrix.setElement(2,2, 9);
            upTriangleMatrix.getDeterminant();
        }catch (Exception e){
            System.err.println(e.getMessage());
        }

        double expected = 45;
        double result = upTriangleMatrix.getDeterminant();
        System.out.println(result);
        assertEquals(expected, result, 0.000001);
    }

}