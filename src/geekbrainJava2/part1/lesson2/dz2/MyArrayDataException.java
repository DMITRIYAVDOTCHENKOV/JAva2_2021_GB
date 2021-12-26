package geekbrainJava2.part1.lesson2.dz2;

public class MyArrayDataException extends RuntimeException {

    public MyArrayDataException(String cellValue, int row, int col) {
        super(String.format("Неверное значение '%s' в ячейки [%d][%d]", cellValue, row, col));
    }

}
