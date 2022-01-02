package geekbrainJava2.part1.lesson2;

class DivideByZeroException extends Exception {

    public DivideByZeroException() {
        super("Деление ноль, кастомное исключение");
    }
}