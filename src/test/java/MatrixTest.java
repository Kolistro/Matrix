import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MatrixTest {
    /*
        IllegalArgumentException in constructor

        constructor

        IllegalAccessException in getElement
        IndexOutOfBoundsException in getElement
        getElement

        IllegalAccessException in setElement
        IndexOutOfBoundsException in setElement
        setElement

        determinant
    */
    private static Matrix mat;

    @Test
    public void constructorExceptionTest(){
        try{
            Matrix m1 = new Matrix(-5);
        }catch (IllegalArgumentException e){
            System.err.println(e.getMessage());
        }

        try {
            Matrix m2 = new Matrix(0);
        }catch (IllegalArgumentException e){
            System.err.println(e.getMessage());
        }
    }

    @Before
    public void constructor(){
        mat = new Matrix(3);
    }

    @Test
    public void setElementIllegalAccessExceptionTest(){
        try {
            mat.setElement(-1, 0, 2);
        }catch (Exception e){
            System.err.println(e.getMessage());
        }

        try {
            mat.setElement(2, -5, 2.3);
        }catch (Exception e){
            System.err.println(e.getMessage());
        }
    }

    @Test
    public void setElementIndexOutOfBoundsExceptionTest(){
        try {
            mat.setElement(3, 2, 3);
        }catch (Exception e){
            System.err.println(e.getMessage());
        }

        try {
            mat.setElement(2, 6, 2.3);
        }catch (Exception e){
            System.err.println(e.getMessage());
        }
    }

    @Test
    public void getElementIllegalAccessExceptionTest(){
        try {
            mat.getElement(-1, 0);
        }catch (Exception e){
            System.err.println(e.getMessage());
        }

        try {
            mat.getElement(2, -5);
        }catch (Exception e){
            System.err.println(e.getMessage());
        }
    }

    @Test
    public void getElementIndexOutOfBoundsExceptionTest(){
        try {
            mat.getElement(3, 2);
        }catch (Exception e){
            System.err.println(e.getMessage());
        }

        try {
            mat.getElement(2, 6);
        }catch (Exception e){
            System.err.println(e.getMessage());
        }
    }

    @Test
    public void setAndGetElementTest(){
        try {
            mat.setElement(0, 0, 58);
            double expected = 58;
            double result = mat.getElement(0,0);
            assertEquals(expected, result, 0.1);
        }catch (Exception e){
            System.err.println(e.getMessage());
        }
    }



    @Test
    public void gaussMethodMatrixHasNotChangedTest(){
            try {
                mat.setElement(0,0, 1);
                mat.setElement(0,1, 2);
                mat.setElement(0,2, 3);
                mat.setElement(1,0, 4);
                mat.setElement(1,1, 5);
                mat.setElement(1,2, 6);
                mat.setElement(2,0, 7);
                mat.setElement(2,1, 8);
                mat.setElement(2,2, 9);
                mat.getDeterminant();
            }catch (Exception e){
                System.err.println(e.getMessage());
            }

        try {
            System.out.println(mat.getElement(0, 0) + " " +
                    mat.getElement(0, 1) + " " +
                    mat.getElement(0, 2));
            System.out.println(mat.getElement(1, 0) + " " +
                    mat.getElement(1, 1) + " " +
                    mat.getElement(1, 2));
            System.out.println(mat.getElement(2, 0) + " " +
                    mat.getElement(2, 1) + " " +
                    mat.getElement(2, 2));

        }catch (Exception e){
            System.err.println(e.getMessage());
        }
        System.out.println(mat.getDeterminant());
    }

    @Test
    public void gaussMethod(){
        try {
            mat.setElement(0,0, 1);
            mat.setElement(0,1, 2);
            mat.setElement(0,2, 3);
            mat.setElement(1,0, 4);
            mat.setElement(1,1, 5);
            mat.setElement(1,2, 6);
            mat.setElement(2,0, 7);
            mat.setElement(2,1, 8);
            mat.setElement(2,2, 9);
            mat.getDeterminant();
        }catch (Exception e){
            System.err.println(e.getMessage());
        }
        double[] mat1 = mat.gaussMethod();
        int k = 0;
        for(double m: mat1){
            System.out.print(m);
            k++;
            if(k % mat.getSize() == 0){
                System.out.println();
            }
        }
    }

    @Test
    public void getDeterminantTest(){
        try {
            mat.setElement(0,0, 1);
            mat.setElement(0,1, 2);
            mat.setElement(0,2, 3);
            mat.setElement(1,0, 4);
            mat.setElement(1,1, 5);
            mat.setElement(1,2, 6);
            mat.setElement(2,0, 7);
            mat.setElement(2,1, 8);
            mat.setElement(2,2, 9);
            mat.getDeterminant();
        }catch (Exception e){
            System.err.println(e.getMessage());
        }

        double expected = 0;
        double result = mat.getDeterminant();
        System.out.println(result);
        assertEquals(expected, result, 0.000001);
    }


}
