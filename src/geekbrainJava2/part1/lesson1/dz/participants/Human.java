package geekbrainJava2.part1.lesson1.dz.participants;

public class Human implements participant {

    private final String name;
    private final int JumpHeight;
    private final int runningDuration;

    public Human(String name, int jumpHeight, int runningDuration) {
        this.name = name;
        JumpHeight = jumpHeight;
        this.runningDuration = runningDuration;
    }

    @Override
    public int Jump() {
        System.out.printf("Человек: %s способен прыгнуть на высоту: %d", this.name, this.JumpHeight);
        return Jump();
    }

    @Override
    public int Run() {
        System.out.printf("Человек: %s способен пробежать: %d метров", this.name, this.runningDuration);
        return Run();
    }

    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                ", JumpHeight=" + JumpHeight +
                ", runningDuration=" + runningDuration +
                '}';
    }
}
