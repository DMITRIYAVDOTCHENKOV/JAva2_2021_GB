package geekbrainJava2.part1.lesson1.dz;

import geekbrainJava2.part1.lesson1.dz.obstacles.Obstacle;
import geekbrainJava2.part1.lesson1.dz.obstacles.Treadmill;
import geekbrainJava2.part1.lesson1.dz.obstacles.Wall;
import geekbrainJava2.part1.lesson1.dz.participants.Cat;
import geekbrainJava2.part1.lesson1.dz.participants.Human;
import geekbrainJava2.part1.lesson1.dz.participants.participant;
import geekbrainJava2.part1.lesson1.dz.participants.Robot;

import java.util.Random;

public class DzTest {
    private static Object Treadmill;
    private static Object Wall;
    private static Object Cat;
    private static Object Human;
    private static Object Robot;

    public static void main(String[] args) {

    }

    private static Tournament creatingAtournamentWithParticipantsAndObstacles(){
        participant robot = new Robot("Бамбелби",40,500);
        participant human = new Human("Димка",5,150);
        participant cat = new Cat("Барсик",3,400);

        Random random = new Random();

        Obstacle wall = new Wall(random.nextInt(7));
        Obstacle treadMill = new Treadmill(random.nextInt(400));

        Tournament tournament = new Tournament("Олимпиада");
        tournament.setObstacles(Wall,Treadmill);
        tournament.setJumpAndRuns(Cat, Human, Robot);
        return tournament;

        
    }

}
