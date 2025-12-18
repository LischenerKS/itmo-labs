import items.Brick;
import items.Candlestick;
import items.Fallable;
import items.MagicBall;

import java.time.LocalDateTime;

import java.util.ArrayList;

import living.Alien;
import living.Person;

import places.flats.OwnFlat;
import places.flats.SomeoneElsesFlat;

public class Main {
    public static void main(String[] args) {
        ArrayList<Situation> situations = new ArrayList<>(2);

        Fallable[] fallingItems = new Fallable[] {new Brick(), new Candlestick(), new MagicBall()};

        situations.add(new Situation(new Alien("Олег"), fallingItems, LocalDateTime.now(), new OwnFlat()));
        situations.add(new Situation(new Person("Свистулькин"), fallingItems, LocalDateTime.now(), new SomeoneElsesFlat()));

        for(Situation situation : situations) {
            situation.runSituation();
        }

    }
}
