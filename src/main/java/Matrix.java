import java.util.Arrays;
import java.util.Objects;

/*
    Напишите класс Matrix (квадратная матрица произвольного вида). Размерность
    матрицы N задается при создании объекта и в дальнейшем не меняется. Матрицу хранить в виде
    одномерного массива длины NxN. В классе сделайте конструктор по размерности, добавьте
    методы equals и hashCode.
*/
public class Matrix implements IMatrix{
    private int size;
    private double[] matrix;

    public Matrix(int size) throws IllegalArgumentException{
        if (size <= 0) throw new IllegalArgumentException("Отрицательный размер матрицы");
        this.size=size;
        matrix = new double[size*size];
        for (int i = 0; i < matrix.length; i++){
            matrix[i] = 0;
        }
    }

    @Override
    public double getElement(int indexLine, int indexColumn) throws Exception{
        if (indexLine < 0 || indexColumn < 0) throw new IllegalAccessException("Подан отрицательный индекс");
        if (indexLine >= size || indexColumn >= size) throw new IndexOutOfBoundsException("Выход за пределы массива");
        return matrix[indexLine*size + indexColumn];
    }

    @Override
    public void setElement(int indexLine, int indexColumn, double element) throws Exception{
        if (indexLine < 0 || indexColumn < 0) throw new IllegalAccessException("Подан отрицательный индекс");
        if (indexLine > size || indexColumn > size) throw new IndexOutOfBoundsException("Выход за пределы массива");
        matrix[indexLine*size + indexColumn] = element;
    }

    @Override
    public double getDeterminant() {
        double determinant = 0;
        for (int j = 0; j < size; j++){
            int k = 0;
            for(int i = 1; i < size; i = i+1+k){
                matrix[(i+1)*size+j] = matrix[(i+1)*size+j]+(matrix[(i+1)*size+j]/matrix[i*size+j]*(-1)*matrix[i*size+j]);

            }
            k++;
            //determinant += matrix[j*size+j];
        }


        /*for(int i = 0; i < matrix.length; i=i*size+i){
            determinant += matrix[i];
        }*/
        return determinant;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Matrix matrix1 = (Matrix) o;
        return size == matrix1.size && Arrays.equals(matrix, matrix1.matrix);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(size);
        result = 31 * result + Arrays.hashCode(matrix);
        return result;
    }
}
