/*
 * Неизвестно, то ли от удара по голове кирпичом, то ли по какой другой причине,
 * но на Свистулькина напала страшная сонливость, и он проспал весь день, всю ночь
 * и почти все следующее утро.
 *
 * Точнее говоря, он заснул в десять часов утра, а проснулся
 * на следующий день в одиннадцать, проспав, таким образом, двадцать пять часов подряд,
 * то есть целые сутки и еще час в придачу.
 *
 * Если бы Свистулькин заснул в своей квартире,
 * где его могли сразу найти, то ничего особенного не случилось бы, но он спал в чужом
 * помещении, где никто не думал его искать, и из-за этого произошел большой переполох.
 */

import living.Alien;
import living.Person;
import places.flats.OwnFlat;
import places.flats.SomeoneElsesFlat;
import sleepiness.SleepinessReason;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Situation> situations = new ArrayList<>(2);

        SleepinessReason[] sleepinessReasons = {SleepinessReason.UNKNOWN_REASON, SleepinessReason.BRICK_TO_HEAD_HIT};
        situations.add(new Situation(new Alien("Олег"), sleepinessReasons, 9, new OwnFlat()));
        situations.add(new Situation(new Person("Свистулькин"), sleepinessReasons, 19, new SomeoneElsesFlat()));

        for (Situation situation : situations) {
            situation.runSituation();
        }


    }
}