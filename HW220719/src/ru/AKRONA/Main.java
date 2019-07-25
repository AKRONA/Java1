/*Есть строка вида: "1 3 1 2\n2 3 2 2\n5 6 7 1\n3 3 1 0"; (другими словами матрица 4x4)
1 3 1 2
2 3 2 2
5 6 7 1
3 3 1 0

Написать метод, на вход которого подаётся такая строка, метод должен преобразовать строку в двумерный массив типа String[][];

Преобразовать все элементы массива в числа типа int, просуммировать, поделить полученную сумму на 2, и вернуть результат;

Ваши методы должны бросить исключения с собственными названиями в случаях:
Если размер матрицы, полученной из строки, не равен 4x4;
Если в одной из ячеек полученной матрицы не число; (например символ или слово)

В методе main необходимо вызвать полученный метод, обработать возможные исключения и вывести результат расчета.
 */

public class Main {
    private final static String EXAMPLE_A =  "1 3 1 2\n2 3 2 2\n5 6 7 1\n3 3 1 0";
    private final static String EXAMPLE_B =  "1 1 1 1\n1 1 1 1\n1 1 1 0\n1 1 1 10";
    private final static String EXAMPLE_C =  "1 1 1 1\n1 1 1 1\n1 1 1 1\n1 1 1 1 1";
    private final static String EXAMPLE_D =  "1 1 1 1\n1 1 1 1\n1 1 1 1\n1 1 1 1 \n 1 1 1 1";
    private final static String EXAMPLE_E =  "1 1 1 1 \n1 1 1 1\n1 1 1 1\n1 1 1 a";
    private final static String EXAMPLE_F =  "1 1 1 1\n1 1 1 1\n1 1 1 1\n1 1 1 ";
    private final static int Matrix_border = 4;
    private static final class OutOfMatrixException extends RuntimeException {
        OutOfMatrixException(String message) {
            super("Out of Matrix exception: " + message);
        }
    }

    private static final class NotANumberException extends RuntimeException {
        NotANumberException(String message) {
            super("Not a Number exception: " + message);
        }
    }


    private static String[][] strToMatrix(String s){
        String[] rows = s.split("\n");
        if(rows.length != Matrix_border)
            throw new OutOfMatrixException("number of rows = " + rows.length);
        String[][] matrix = new String[Matrix_border][Matrix_border];
        for(int i = 0; i < rows.length; i++){
            matrix[i] = rows[i].split(" ");
            if(matrix[i].length != Matrix_border)
                throw new OutOfMatrixException("the number of characters in a row(" + (i + 1) + ") = " + matrix[i].length);
        }
        return matrix;
    }

    private static void matrixSum(String[][] matrix){
        int sum = 0;
        for(int i = 0; i < Matrix_border ; i++){
            for(int j = 0; j < Matrix_border ; j++){
                try {
                    sum += Integer.parseInt(matrix[i][j]);
                }catch (NumberFormatException e){
                    throw new NotANumberException("[" + matrix[i][j] + "]");
                }
            }
        }
        System.out.println("Result = " + sum / 2f + "\n");
    }

    private static void writeMatrix(String[][] matrix){
        for(int i = 0; i < Matrix_border ; i++){
            for(int j = 0; j < Matrix_border ; j++){
                    System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }


    public static void main(String[] args){
        try{
            String[][] matrix = strToMatrix(EXAMPLE_A);
            matrixSum(matrix);
            writeMatrix(matrix);
        }catch (OutOfMatrixException e){
              System.out.println(e.getMessage());
        }catch (NotANumberException e){
              System.out.println(e.getMessage());
        }
    }
}
