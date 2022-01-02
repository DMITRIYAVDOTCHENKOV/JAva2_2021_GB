package geekbrainJava2.part1.lesson1.dz.participants;

public class Robot implements participant {
    private final String name;
    private final int JumpHeight;
    private final int runningDuration;

    public Robot(String name, int jumpHeight, int runningDuration) {
        this.name = name;
        JumpHeight = jumpHeight;
        this.runningDuration = runningDuration;
    }

    @Override
    public int Jump() {
        System.out.printf("Робот: %s способен прыгнуть на высоту: %d", this.name, this.JumpHeight);
        return Jump();
    }

    @Override
    public int Run() {
        System.out.printf("Робот: %s способен пробежать: %d метров", this.name, this.runningDuration);
        return Run();
    }

    @Override
    public String toString() {
        return "Robot{" +
                "name='" + name + '\'' +
                ", JumpHeight=" + JumpHeight +
                ", runningDuration=" + runningDuration +
                '}';
    }
}
