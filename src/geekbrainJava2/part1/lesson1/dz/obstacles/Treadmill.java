package geekbrainJava2.part1.lesson1.dz.obstacles;


import geekbrainJava2.part1.lesson1.dz.participants.participant;

public class Treadmill implements Obstacle {
    private final int distances;

    public Treadmill(int distances) {
        this.distances = distances;
    }

    @Override
    public boolean wereAbleToOvercomeTheObstaclev(participant participant) {
        if (participant.Run() >= this.distances) {
            System.out.printf("Участник %s  смог преодолеть припятсвие, длиной %d метров", participant, this.distances);
            return true;
        } else {
            System.out.printf("Участник %s  не смог преодолеть припятсвие, длиной %d метров", participant,
                    this.distances);
            return false;
        }
    }
}
