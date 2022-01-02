package geekbrainJava2.part1.lesson1.dz.obstacles;
import geekbrainJava2.part1.lesson1.dz.participants.participant;


public class Wall implements Obstacle {
    private int height;

    public Wall(int height) {
        this.height = height;
    }


    @Override
    public boolean wereAbleToOvercomeTheObstaclev(participant participant) {
        if (participant.Jump() >= this.height) {
            System.out.printf("Участник %s  смог преодолеть припятсвие, высотой %d метров", participant, this.height);
            return true;
        } else {
            System.out.printf("Участник %s  не смог преодолеть припятсвие, высотой %d метров", participant, this.height);
            return false;
        }
    }
}
