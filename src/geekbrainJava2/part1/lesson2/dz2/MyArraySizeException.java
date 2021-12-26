package geekbrainJava2.part1.lesson2.dz2;

public class MyArraySizeException extends IllegalAccessError {

    public MyArraySizeException() {
        super("Не вырный  индекс массива!");
    }
}