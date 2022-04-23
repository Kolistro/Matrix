public class Test {
    public static Matrix mat = new Matrix(3);
    public static void test(){
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
    }
}
