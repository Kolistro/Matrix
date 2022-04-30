public class DiagMatrix extends UpTriangleMatrix{

    public DiagMatrix(int size) throws IllegalArgumentException {
        super(size);
    }


    public DiagMatrix(double ... elements)throws Exception{
        super(elements.length);

        int i = 0;
        for (double element: elements){
            matrix[indexDiag[i]] = element;
            i++;
        }
    }

    @Override
    public void setElement(int indexLine, int indexColumn, double element) throws Exception{
        int k = indexDiag.length-1;
        for(int i = 0; i < indexDiag.length-1; i++){
            for (int j=1; j<=k; j++){
                if((indexLine * indexDiag.length + indexColumn) == indexDiag[i]+j){
                    throw new IllegalArgumentException("Нельзя изменить элемент выше диагонали");
                }
            }
            k--;
        }
        super.setElement(indexLine, indexColumn, element);
    }

    @Override
    public double getElement(int indexLine, int indexColumn) throws Exception{
        int k = indexDiag.length-1;
        for(int i = 0; i < indexDiag.length-1; i++){
            for (int j=1; j<=k; j++){
                if((indexLine * indexDiag.length + indexColumn) == indexDiag[i]+j){
                    return 0;
                }
            }
            k--;
        }
        return super.getElement(indexLine, indexColumn);
    }

    @Override
    public double getDeterminant() {
        return super.getDeterminant();
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

}
