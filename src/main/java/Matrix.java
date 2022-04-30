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
    private double determinant;
    private boolean flag;

    public Matrix(int size) throws IllegalArgumentException{
        if (size <= 0) throw new IllegalArgumentException("Отрицательный размер матрицы");
        this.size=size;
        matrix = new double[size*size];
        for (int i = 0; i < matrix.length; i++){
            matrix[i] = 0;
        }
        this.flag = false;
    }

    public int getSize(){
        return size;
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
        flag = false;
    }

    public double[] gaussMethod(){
        double eps = 0.000001;
        int i, j, k, l = 0;
        double r;
        double[] copyMatrix = Arrays.copyOf(matrix, matrix.length);
        i = 0; j = 0;

        while (i < size && j < size)
        {
            //Инвариант: минор матрицы в столбцах 0..j-1
            //уже приведен к ступенчатому виду, и строка
            //с индексом i-1 содержит ненулевой элемент
            //в стобце с номеромЮ меньшим чем j

            //Ищем максимальный элемент в j-м столбце
            //начиная с i-й строки
            r = 0.0;
            for (k = i; k < size; ++k)
            {
                if (Math.abs(copyMatrix[k * size + j]) > r)
                {
                    l = k; //Запомним номер строки
                    r = Math.abs(copyMatrix[k * size + j]); //и максимальный элемент
                }
            }

            if (r <= eps)
            {
                //Все элементы j-го столбца по абсолютной величине
                //не првеосходят eps.
                //Обнулим столбце, начиная с j-й строки
                for (k = i; k < size; ++k)
                {
                    copyMatrix[k * size + j] = 0.0;
                }
                ++j; // Увеличим индекс столбца
                continue; //Переходим к следующей итерации
            }

            if (l != i)
            {
                //Меняем местами i-ю и l-ю строки
                for (k = j; k < size; ++k)
                {
                    r = copyMatrix[i * size + k];
                    copyMatrix[i * size + k] = copyMatrix[l * size + k];
                    copyMatrix[l * size + k] = (-r);//Меняем знак строки
                }
            }

            //Утверждение: Math.abs(a[i*n + j]) > eps
            r = copyMatrix[i * size + j];
            assert(Math.abs(r) > eps);

            //Обнуляем j-й столбец, начиная со строки i+1,
            //применяя элементарные преобразования 2-го рода
            for (k = i + 1; k < size; ++k)
            {
                double c = (-copyMatrix[k * size + j]) / r;
                //К k-й строке прибавляем i-ю,
                //умноженную на c
                copyMatrix[k * size + j] = 0.0;
                for (l = j + 1; l < size; ++l)
                {
                    copyMatrix[k * size + l] += c * copyMatrix[i * size + l];
                }
            }

            ++i; ++j; //Переходим к следующему минору
        }
        return copyMatrix;
    }

    @Override
    public double getDeterminant() {
        if(flag == false){
            double[] m = gaussMethod();
            for (int i = 0; i < m.length; i+=size+1){
                determinant = m[i];
            }
        }
        return determinant;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Matrix matrix1 = (Matrix) o;
        return size == matrix1.size && Double.compare(matrix1.determinant, determinant) == 0 && flag == matrix1.flag && Arrays.equals(matrix, matrix1.matrix);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(size, determinant, flag);
        result = 31 * result + Arrays.hashCode(matrix);
        return result;
    }
}
