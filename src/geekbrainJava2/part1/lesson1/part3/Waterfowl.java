package geekbrainJava2.part1.lesson1.part3;

public interface Waterfowl {

    int DEFAULT_SWIM_LENGTH = 50;

    int swim();

    default void printSomeInfo() {
        System.out.println("some info");
    }
}