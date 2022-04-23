/*
    1. Реализовать интерфейс IMatrix (квадратная матрица вещественных чисел), содержащий
    методы:
    - получить элемент с заданными индексами,
    - изменить элемент с заданными индексами,
    - вычислить определитель матрицы (лучше методом Гаусса).
*/
public interface IMatrix {
    public double getElement(int indexLine, int indexColumn) throws Exception;
    public void setElement(int indexLine, int indexColumn, double element) throws Exception;
    public double getDeterminant();
}
