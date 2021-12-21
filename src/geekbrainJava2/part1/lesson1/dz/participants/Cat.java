package geekbrainJava2.part1.lesson1.dz.participants;

public class Cat implements participant {
    private final String name;
    private final int JumpHeight;
    private final int runningDuration;

    public Cat(String name, int jumpHeight, int runningDuration) {
        this.name = name;
        this.JumpHeight = jumpHeight;
        this.runningDuration = runningDuration;
    }

    @Override
    public int Jump() {
        System.out.printf("Кот: %s способен прыгнуть на высоту: %d", this.name, this.JumpHeight);
        System.out.println();
        return Jump();
    }


    @Override

    public int Run() {
        System.out.printf("Кот: %s способен пробежать: %d метров", this.name, this.runningDuration);
        System.out.println();
        return Run();
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", JumpHeight=" + JumpHeight +
                ", runningDuration=" + runningDuration +
                '}';
    }
}
