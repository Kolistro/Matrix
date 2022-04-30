import java.util.Arrays;

public class UpTriangleMatrix extends Matrix{
    protected int[] indexDiag;


    public UpTriangleMatrix(int size) throws IllegalArgumentException {
        super(size);

        indexDiag=new int[size];
        int index = 0;
        for (int i=0; i<indexDiag.length; i++){
            indexDiag[i] = index;
            index+=size+1;
        }
    }

    public int[] getIndexDiag(){
        return indexDiag;
    }

    @Override
    public void setElement(int indexLine, int indexColumn, double element) throws Exception{
        for(int i = 1; i < indexDiag.length; i++){
            for (int j=1; j<=i; j++){
                if((indexLine * indexDiag.length + indexColumn) == indexDiag[i]-j){
                    throw new IllegalArgumentException("Нельзя изменить элемент ниже диагонали");
                }
            }
        }
        super.setElement(indexLine, indexColumn, element);
        flag = false;
    }

    @Override
    public double getElement(int indexLine, int indexColumn) throws Exception{
        for(int i = 1; i < indexDiag.length; i++){
            for (int j=1; j<=i; j++){
                if((indexLine * indexDiag.length + indexColumn) == indexDiag[i]-j){
                    throw new IllegalArgumentException("Нельзя изменить элемент ниже диагонали");
                }
            }
        }
        return super.getElement(indexLine, indexColumn);
    }

    @Override
    public double getDeterminant() {
        if(flag==false){
            determinant = 1;
            for(int i = 0; i< indexDiag.length; i++){
                determinant = determinant * matrix[indexDiag[i]];
            }
        }
        return determinant;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        UpTriangleMatrix matrix = (UpTriangleMatrix) o;
        return Arrays.equals(indexDiag, matrix.indexDiag);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Arrays.hashCode(indexDiag);
        return result;
    }
}
