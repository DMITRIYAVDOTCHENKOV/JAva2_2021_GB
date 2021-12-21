package geekbrainJava2.part1.lesson1.dz;

import geekbrainJava2.part1.lesson1.dz.obstacles.Obstacle;
import geekbrainJava2.part1.lesson1.dz.participants.participant;

public class Tournament {
    private Obstacle[] obstacles;
    private participant[] participants;
    private final String tournametnStart;

    public Tournament(String tournametnName) {
        this.tournametnStart = tournametnName;
    }

    public void setObstacles(Obstacle ... obstacles) {
        this.obstacles = obstacles;
    }

    public void setJumpAndRuns(participant ... participants) {
        this.participants = participants;
    }
    public void startTournament(){
        System.out.printf("Соревнование %s началось!!!", this.tournametnStart);
        for (participant participant : participants) {
            boolean sucess = this.passObstacle(participant);
            if (!sucess) {
                System.out.printf("Участник %s покинул соревнования", participant);
                System.out.println();
            }else {
                System.out.printf("Участник %s прошел соревнования", participant);
            }
        }
    }
    private boolean passObstacle(participant participant){
        for (Obstacle obstacle : obstacles) {
            if (!obstacle.wereAbleToOvercomeTheObstaclev(participant)){
                return false;
            }
        }
        return true;
    }

    public void setObstacles(Object wall, Object treadmill) {
    }

    public void setJumpAndRuns(Object cat, Object human, Object robot) {
    }
}
